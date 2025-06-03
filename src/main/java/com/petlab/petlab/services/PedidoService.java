import com.petlab.petlab.dto.PedidoItem;
import com.petlab.petlab.dto.PedidoRequest;
import com.petlab.petlab.models.DetallePedido;
import com.petlab.petlab.models.Pedido;
import com.petlab.petlab.models.UserModel;
import com.petlab.petlab.models.Venta;
import com.petlab.petlab.repositories.IdetallePedidoRepository;
import com.petlab.petlab.repositories.IpedidoRepository;
import com.petlab.petlab.repositories.IventaRepository;
import com.petlab.petlab.repositories.UserRepository;
import com.petlab.petlab.services.IpedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.math.BigDecimal;

@Service
public class PedidoService implements IpedidoService {

    @Autowired
    IpedidoRepository pedidoRepository;
    @Autowired
    IdetallePedidoRepository detalleRepository;
    @Autowired
    IventaRepository ventaRepository;
    @Autowired
    UserRepository userRepository;
    @Autowired IproductsRepository productoRepository;
    @Autowired IservicioRepository servicioRepository;

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
                Producto producto = productoRepository.findById(item.getProductoId())
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
}
