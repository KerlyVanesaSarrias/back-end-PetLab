package com.petlab.petlab.controllers;

import com.petlab.petlab.models.Contacto;
import com.petlab.petlab.services.ContactoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/contacto")
public class ContactoController {
    private final ContactoService contactoService;

    @Autowired
    public ContactoController(ContactoService contactoService) {
        this.contactoService = contactoService;
    }

    @GetMapping // traer a todos los contacto
    public List<Contacto> listaContacto(){
        return contactoService.obtenerTodos();
    }

    @GetMapping("/{id}") // "/{id}" pad variable
    public Contacto obtenerPorId(@PathVariable Long id){
        return contactoService.obtenerPorId(id);
    }

    @PostMapping
    public ResponseEntity<String> guardarContacto(@RequestBody Contacto contacto) {
        contactoService.guardarContacto(contacto);
        return ResponseEntity.ok("Contacto agregado con éxito");
    }
}
