package com.petlab.petlab.services;
import com.petlab.petlab.models.UserModel;
import com.petlab.petlab.repositories.IuserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService implements IuserService {

    private IuserRepository userRepository;

    @Autowired
    public UserService(IuserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<UserModel> obtenerUser() {
        return userRepository.findAll();
    }

    @Override
    public UserModel obtenerById(Long id) {
        return userRepository.findById(id).orElse(null);
    }

    @Override
    public void guardarUser(UserModel user) {
    userRepository.save(user);
    }

    @Override
    public void detailUser(Long id) {
        userRepository.deleteById(id);
    }

    @Override
    public void updateUser(Long id, UserModel editUser) {
        UserModel userExist = userRepository.findById(id).orElse(null);
        if (userExist != null){
            userExist.setNombre(userExist.getNombre());
            userExist.setCorreo(userExist.getCorreo());
            userExist.setTelefono(userExist.getTelefono());
            userExist.setContrasena(userExist.getContrasena());
            userRepository.save(userExist);
        }else {
            throw new RuntimeException("¡¡¡Usuario agregado exitosamente!!!");
        }
    }
}
