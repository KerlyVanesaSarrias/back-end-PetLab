package com.petlab.petlab.repositories;

import com.petlab.petlab.models.Servicio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IservicioRepository extends JpaRepository<Servicio, Long>{
}
