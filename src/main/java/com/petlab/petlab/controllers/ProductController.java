package com.petlab.petlab.controllers;


import com.petlab.petlab.models.Products;
import com.petlab.petlab.services.ProductsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    public ResponseEntity<String> guardarProducto(@RequestBody Products products){
        productsService.guardarProduct(products);
        return  ResponseEntity.ok("Producto agregado con exito");
    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<String> deleteBlog(@PathVariable Long id){
        productsService.deleteProduct(id);
        return  ResponseEntity.ok(("Producto borrado con éxito"));
    }


    @PutMapping("/editar/{id}")
    public ResponseEntity<String> editarBlog(
            @PathVariable Long id,
            @RequestBody Products productoActualizado){
        productsService.editProduct(id, productoActualizado);
        return ResponseEntity.ok("Producto actualizado con éxito");
    }


}
