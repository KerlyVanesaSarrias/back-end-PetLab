import com.petlab.petlab.models.Venta;
import com.petlab.petlab.repositories.IventaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class VentaService {
    @Autowired
    private IventaRepository ventaRepository;

    public Venta getByPedidoId(Long pedidoId) {
        return ventaRepository.findAll().stream()
                .filter(f -> f.getPedido().getId().equals(pedidoId))
                .findFirst()
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }
}
