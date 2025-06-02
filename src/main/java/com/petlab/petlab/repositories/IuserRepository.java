package com.petlab.petlab.repositories;

import com.petlab.petlab.models.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface IuserRepository extends JpaRepository<UserModel, Long> {
    Optional<UserModel> findByCorreo(String correo);
    boolean existByCorreo(String correo);
    List<UserModel> findByNombreContaingIgnoreCase(String nombre);
}
