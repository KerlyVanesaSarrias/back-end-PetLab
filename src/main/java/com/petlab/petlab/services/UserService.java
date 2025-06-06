package com.petlab.petlab.services;
import com.petlab.petlab.models.UserModel;
import com.petlab.petlab.repositories.IuserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService implements IuserService {

    @Autowired
    private PasswordEncoder passwordEncoder;

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


    public UserModel guardarUser(UserModel user) {
        UserModel users = new UserModel();
        users.setNombre(user.getNombre());
        users.setCorreo(user.getCorreo());
        users.setTelefono(user.getTelefono());
        users.setContrasena(passwordEncoder.encode(user.getContrasena()));
        return userRepository.save(users);
    }


    @Override
    public void detailUser(Long id) {
        userRepository.deleteById(id);
    }

    @Override
    public void updateUser(Long id, UserModel editUser) {
        UserModel userExist = userRepository.findById(id).orElse(null);
        if (userExist != null){
            userExist.setNombre(editUser.getNombre());
            userExist.setCorreo(editUser.getCorreo());
            userExist.setTelefono(editUser.getTelefono());
            //ENCRIPTAR CONTRASEÑA CON PASSWORDENCODER.ENCODE
            userExist.setContrasena(editUser.getContrasena());
            userRepository.save(userExist);
        }else {
            throw new RuntimeException("Usuario no encontrado con ID: " + id);
        }
    }

    public UserDetails findByCorreoOrNombre(String correo, String nombre) throws UsernameNotFoundException {
        UserModel user = userRepository.findByCorreoOrNombre(correo, nombre);
        if (user == null) {
            throw new UsernameNotFoundException("Usuario no encontrado");
        }
        return new org.springframework.security.core.userdetails.User(user.getNombre(), user.getContrasena(), new ArrayList<>());
    }


}
