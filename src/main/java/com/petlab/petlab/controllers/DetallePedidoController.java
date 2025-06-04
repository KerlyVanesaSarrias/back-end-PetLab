package com.petlab.petlab.controllers;

import com.petlab.petlab.models.DetallePedido;
import com.petlab.petlab.repositories.IdetallePedidoRepository;
import com.petlab.petlab.services.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping("/detalle")
public class DetallePedidoController {

    @Autowired
    private IdetallePedidoRepository detalleRepository;

    @GetMapping("/{id}/detalles")
    public List<DetallePedido> obtenerDetallesPorPedido(@PathVariable Long id) {
        return detalleRepository.findAll().stream()
                .filter(d -> d.getPedido().getId().equals(id))
                .toList();
    }
}
