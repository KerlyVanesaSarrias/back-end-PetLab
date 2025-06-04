package com.petlab.petlab.repositories;

import com.petlab.petlab.models.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface IuserRepository extends JpaRepository<UserModel, Long> {

/*    Optional<UserModel> findByCorreo(String correo);
    boolean existByCorreo(String correo);
    List<UserModel> findByNombreContaingIgnoreCase(String nombre);*/

}
