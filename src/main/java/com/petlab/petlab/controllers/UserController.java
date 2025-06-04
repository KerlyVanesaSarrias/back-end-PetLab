package com.petlab.petlab.controllers;


import com.petlab.petlab.models.UserModel;
import com.petlab.petlab.services.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    private final UserService userService;

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

    @PostMapping
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
    public ResponseEntity<String>updateUser(@PathVariable Long id, @RequestBody UserModel userUpdate){
        userService.updateUser(id, userUpdate);
        return ResponseEntity.ok("Usuario Actualizado");
    }

}
