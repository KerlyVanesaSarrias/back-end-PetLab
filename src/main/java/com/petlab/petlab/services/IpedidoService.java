package com.petlab.petlab.services;

import com.petlab.petlab.dto.PedidoRequest;
import com.petlab.petlab.models.Pedido;

public interface IpedidoService {

    Pedido crearPedido(PedidoRequest request);
}
