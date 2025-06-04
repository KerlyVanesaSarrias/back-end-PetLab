package com.petlab.petlab.repositories;

import com.petlab.petlab.models.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IpedidoRepository extends JpaRepository<Pedido, Long> {
}

