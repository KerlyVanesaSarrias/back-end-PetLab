package com.petlab.petlab.controllers;

import com.petlab.petlab.models.Servicio;
import com.petlab.petlab.services.ServicioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/servicios")
public class ServicioController {
    private final ServicioService servicioService;

    @Autowired

    public ServicioController(ServicioService servicioService) {
        this.servicioService = servicioService;
    }

    @GetMapping // traer a todos los servicios
    public List<Servicio> listaServicos(){
        return servicioService.obtenerTodos();
    }

    @GetMapping("/{id}") // "/{id}" pad variable
    public Servicio obtenerPorId(@PathVariable Long id){
        return servicioService.obtenerPorId(id);
    }

    @PostMapping
    public ResponseEntity<String> guardarServicio(@RequestBody Servicio servicio) {
        servicioService.guardarServicio(servicio);
        return ResponseEntity.ok("Servicio agregado con éxito");
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("isAuthenticated()")
    public  ResponseEntity<Map<String, String>> eliminarServicio(@PathVariable Long id){
        servicioService.eliminarServicio(id);
        return ResponseEntity.ok(Map.of("message","Servicio eliminado exitosamente"));
    }

    @PutMapping("/{id}")
    @PreAuthorize("isAuthenticated()")
    public  ResponseEntity<Map<String, String>> editarServicio(@PathVariable Long id, @RequestBody Servicio servicio){
        servicioService.editarServicio(id,servicio);
        return ResponseEntity.ok(Map.of("message","Servicio editado exitosamente"));
    }
}
