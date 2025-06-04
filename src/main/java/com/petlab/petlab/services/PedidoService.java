package com.petlab.petlab.services;
import com.petlab.petlab.dto.PedidoItem;
import com.petlab.petlab.dto.PedidoRequest;
import com.petlab.petlab.models.*;
import com.petlab.petlab.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.math.BigDecimal;
import java.util.List;

@Service
public class PedidoService implements IpedidoService {

    private final IpedidoRepository pedidoRepository;

    @Autowired
    public PedidoService(IpedidoRepository pedidoRepository) {
        this.pedidoRepository = pedidoRepository;
    }

    @Autowired IdetallePedidoRepository detalleRepository;
    @Autowired IventaRepository ventaRepository;
    @Autowired IuserRepository userRepository;
    @Autowired IproductsRepository productoRepository;
    @Autowired IservicioRepository servicioRepository;

    @Override
    public Pedido crearPedido(PedidoRequest request) {
        UserModel user = userRepository.findById(request.getUserId())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Usuario no encontrado"));

        Pedido pedido = new Pedido();
        pedido.setUser(user);

        pedido = pedidoRepository.save(pedido);

        BigDecimal subtotal = BigDecimal.ZERO;

        for (PedidoItem item : request.getItems()) {
            DetallePedido detalle = new DetallePedido();
            detalle.setPedido(pedido);
            detalle.setCantidad(item.getCantidad());
            detalle.setPrecioUnitario(item.getPrecioUnitario());

            if (item.getProductoId() != null) {
                Products producto = productoRepository.findById(item.getProductoId())
                        .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Producto no encontrado"));
                detalle.setProducto(producto);
            }

            if (item.getServicioId() != null) {
                Servicio servicio = servicioRepository.findById(item.getServicioId())
                        .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Servicio no encontrado"));
                detalle.setServicio(servicio);
            }

            detalleRepository.save(detalle);
            subtotal = subtotal.add(item.getPrecioUnitario().multiply(BigDecimal.valueOf(item.getCantidad())));
        }

        Venta venta = new Venta();
        venta.setPedido(pedido);
        venta.setSubtotal(subtotal);
        venta.setTotal(subtotal);
        ventaRepository.save(venta);

        return pedido;
    }

    @Override
    public List<Pedido> listarPedidos() {
        return pedidoRepository.findAll();
    }


}
