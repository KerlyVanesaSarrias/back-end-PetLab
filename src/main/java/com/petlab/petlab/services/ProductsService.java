package com.petlab.petlab.services;


import com.petlab.petlab.models.Products;
import com.petlab.petlab.repositories.IproductsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductsService implements IproductsService {

    private final IproductsRepository productRepository;

        @Autowired
        public ProductsService(IproductsRepository productRepository) {
            this.productRepository = productRepository;
        }

    @Override
    public List<Products> obtenerTodos() {
        return productRepository.findAll();
    }

    @Override
    public Products obtenerPorId(Long id) {
        return productRepository.findById(id).orElse(null);
    }

    @Override
    public void guardarProduct(Products products) {
        productRepository.save(products);
    }

    @Override
    public void deleteProduct(Long id) {
        productRepository.deleteById(id);

    }

    @Override
    public void editProduct(Long id, Products productsActualizado) {
        Products productExistente = productRepository.findById(id).orElse(null);
        if (productExistente != null){
            productExistente.setNombre(productsActualizado.getNombre());
            productExistente.setCategoria(productsActualizado.getCategoria());
            productExistente.setDescripcion(productsActualizado.getDescripcion());
            productExistente.setImagen(productsActualizado.getImagen());
            productExistente.setPrecio(productsActualizado.getPrecio());
            productExistente.setCaracteristicas(productsActualizado.getCaracteristicas());
            productExistente.setStock(productsActualizado.getStock());
            productRepository.save(productExistente);
        } else  {
            throw new RuntimeException("Producto no encontrado con el id: " + id);

        }
    }
}
