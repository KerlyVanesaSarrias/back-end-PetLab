package com.petlab.petlab.controllers;

import com.petlab.petlab.dto.PedidoRequest;
import com.petlab.petlab.models.Pedido;
import com.petlab.petlab.services.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pedidos")
public class PedidoController {

    private  final PedidoService pedidoService;

    @Autowired
    public PedidoController(PedidoService pedidoService) {
        this.pedidoService = pedidoService;
    }



    @PostMapping
    public ResponseEntity<?> crearPedido(@RequestBody PedidoRequest request) {
        Pedido pedido = pedidoService.crearPedido(request);
        return ResponseEntity.ok(pedido);
    }
    @GetMapping()
    public List<Pedido> listarPedidos() {
        return pedidoService.listarPedidos();
    }
}
