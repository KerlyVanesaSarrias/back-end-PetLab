package com.petlab.petlab.controllers;


import com.petlab.petlab.JwtUtil;
import com.petlab.petlab.models.UserModel;
import com.petlab.petlab.services.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/auth")
public class UserController {
    private final UserService userService;

    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public List<UserModel>listaUsuarios(){
        return userService.obtenerUser();
    }

    @GetMapping("/{id}")
    public UserModel userById(@PathVariable Long id){
        return userService.obtenerById(id);
    }

    @PostMapping("/register")
    public ResponseEntity<String>addUser(@RequestBody @Valid UserModel user){
        userService.guardarUser((user));
        return ResponseEntity.ok("Usuario agregado con exito");
    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<String>deleteUser(@PathVariable Long id){
        userService.detailUser(id);
        return ResponseEntity.ok("Usuario eliminado");
    }

    @PutMapping("/editar/{id}")
    public ResponseEntity<String>updateUser(@PathVariable Long id, @RequestBody UserModel editUser){
        userService.updateUser(id, editUser);
        return ResponseEntity.ok("Usuario Actualizado");
    }

    @PostMapping("/login")
    public ResponseEntity<?>loginUser(@RequestBody UserModel loginData){
        UserDetails user = userService.findByCorreoOrNombre(loginData.getCorreo(), loginData.getNombre());

        if (user != null && passwordEncoder.matches(loginData.getContrasena(), user.getPassword())){
            String token = jwtUtil.generateToken(user.getUsername(), loginData.getCorreo());
            return ResponseEntity.ok().body(Map.of(
                    "token", token,
                    "nombre", user.getUsername()
            ));
        }else {
            return ResponseEntity.status(401).body("Credenciales invalidas");
        }
    }

    @GetMapping("/resource")
    @PreAuthorize("isAuthenticated()")
    public ResponseEntity<String> getProtectedResource() {
        return ResponseEntity.ok("Este es un recurso protegido!");
    }
}
