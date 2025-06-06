package com.petlab.petlab.services;

import com.petlab.petlab.models.UserModel;

import java.util.List;

public interface IuserService {
    List<UserModel>obtenerUser();
    UserModel obtenerById(Long id);
    UserModel guardarUser(UserModel user);
    void detailUser(Long id);
    void updateUser(Long id, UserModel editUser);
}


//void guardarUser(UserModel user);