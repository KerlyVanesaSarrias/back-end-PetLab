package com.petlab.petlab.repositories;

import com.petlab.petlab.models.Venta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface IventaRepository extends JpaRepository<Venta, Long> {
}
