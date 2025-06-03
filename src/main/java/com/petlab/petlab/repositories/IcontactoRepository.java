package com.petlab.petlab.repositories;

import com.petlab.petlab.models.Contacto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IcontactoRepository extends JpaRepository<Contacto, Long> {
}
