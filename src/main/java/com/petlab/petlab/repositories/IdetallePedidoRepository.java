package com.petlab.petlab.repositories;

import com.petlab.petlab.models.DetallePedido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IdetallePedidoRepository extends JpaRepository<DetallePedido, Long> {
}
