package com.petlab.petlab.repositories;

import com.petlab.petlab.models.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IuserRepository extends JpaRepository<UserModel, Long> {
      UserModel findByCorreoOrNombre(String correo, String nombre);

}
