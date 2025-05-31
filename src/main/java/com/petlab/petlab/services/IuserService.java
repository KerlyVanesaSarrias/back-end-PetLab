package com.petlab.petlab.services;

import com.petlab.petlab.models.UserModel;

import java.util.List;

public interface IuserService {
    List<UserModel>obtenerUser();
    UserModel obtenerById(Long id);

}
