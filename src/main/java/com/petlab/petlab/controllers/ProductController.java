package com.petlab.petlab.controllers;


import com.petlab.petlab.models.Products;
import com.petlab.petlab.services.ProductsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/productos")
public class ProductController {
    private  final ProductsService productsService;

    @Autowired
    public ProductController(ProductsService productsService) {
        this.productsService = productsService;
    }

    @GetMapping()
    public List<Products> listaProductos(){
        return productsService.obtenerTodos();
    }

    @GetMapping("/{id}")
    public  Products obtenrerPorId (@PathVariable Long id){
        return productsService.obtenerPorId(id);
    }

    @PostMapping()
    @PreAuthorize("isAuthenticated()")

    public ResponseEntity<String> guardarProducto(@RequestBody Products products){
        productsService.guardarProduct(products);
        return  ResponseEntity.ok("Producto agregado con exito");
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("isAuthenticated()")

    public  ResponseEntity<Map<String, String>>  deleteBlog(@PathVariable Long id){
        productsService.deleteProduct(id);
        return ResponseEntity.ok(Map.of("message", "Producto borrado con éxito"));
    }


    @PutMapping("/{id}")
    @PreAuthorize("isAuthenticated()")
    public  ResponseEntity<Map<String, String>>  editarBlog(
            @PathVariable Long id,
            @RequestBody Products productoActualizado){
        productsService.editProduct(id, productoActualizado);
        return ResponseEntity.ok(Map.of("message", "Producto actualizado con éxito"));
    }


}
