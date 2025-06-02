package com.petlab.petlab.services;

import com.petlab.petlab.models.Products;

import java.util.List;

public interface IproductsService {

    List<Products> obtenerTodos();
    Products obtenerPorId(Long id);
    void  guardarProduct(Products products);
    void  deleteProduct(Long id);
    void editProduct(Long id, Products productsActualizado);
}
