package com.petlab.petlab.controllers;

import com.petlab.petlab.models.Servicio;
import com.petlab.petlab.services.ServicioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

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

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<String> eliminarServicio(@PathVariable Long id){
        servicioService.eliminarServicio(id);
        return  ResponseEntity.ok("Servicio eliminado exitosamente");
    }

    @PutMapping("/editar/{id}")
    public ResponseEntity<String> editarServicio(@PathVariable Long id, @RequestBody Servicio servicio){
        servicioService.editarServicio(id,servicio);
        return  ResponseEntity.ok("Servicio editado exitosamente");
    }
}
