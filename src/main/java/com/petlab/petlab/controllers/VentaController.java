package com.petlab.petlab.controllers;

import com.petlab.petlab.models.Venta;
import com.petlab.petlab.services.VentaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/venta")
public class VentaController {
    @Autowired
    VentaService ventaService;

    @GetMapping("/{pedidoId}")
    public Venta getByPedidoId(@PathVariable Long pedidoId) {
        return ventaService.getByPedidoId(pedidoId);
    }
}