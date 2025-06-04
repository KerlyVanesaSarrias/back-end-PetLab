package com.petlab.petlab.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;

import java.math.BigDecimal;

@Entity
public class Products {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_Product;


    @NotBlank(message = "El nombre es obligatorio")
    @Size(max = 100, message = "El nombre no puede tener más de 100 caracteres")
    private String nombre;

    @NotBlank(message = "La categoría es obligatoria")
    @Size(max = 1000, message = "La categoría no puede tener más de 1000 caracteres")
    private String categoria;

    @NotBlank(message = "La descripción es obligatoria")
    @Lob // Para permitir texto largo
    private String descripcion;

    @NotBlank(message = "La imagen es obligatoria")
    @Size(max = 255, message = "La URL de la imagen no puede tener más de 255 caracteres")
    private String imagen;

    @NotNull(message = "El precio es obligatorio")
    @Digits(integer = 8, fraction = 2, message = "El precio debe tener hasta 8 dígitos enteros y 2 decimales")
    private BigDecimal precio;

    @NotBlank(message = "Las características son obligatorias")
    @Size(max = 1000, message = "Las características no pueden tener más de 1000 caracteres")
    private String caracteristicas;

    @NotNull(message = "El stock es obligatorio")
    @Min(value = 0, message = "El stock no puede ser negativo")
    private Integer stock = 0;

  public Products() {
  }

  public Products(Long id_Product, String nombre, String categoria, String descripcion, String imagen, BigDecimal precio, String caracteristicas, Integer stock) {
    this.id_Product = id_Product;
    this.nombre = nombre;
    this.categoria = categoria;
    this.descripcion = descripcion;
    this.imagen = imagen;
    this.precio = precio;
    this.caracteristicas = caracteristicas;
    this.stock = stock;
  }

  public Long getId_Product() {
    return id_Product;
  }

  public void setId_Product(Long id_Product) {
    this.id_Product = id_Product;
  }

  public String getNombre() {
    return nombre;
  }

  public void setNombre(String nombre) {
    this.nombre = nombre;
  }

  public String getCategoria() {
    return categoria;
  }

  public void setCategoria(String categoria) {
    this.categoria = categoria;
  }

  public String getDescripcion() {
    return descripcion;
  }

  public void setDescripcion(String descripcion) {
    this.descripcion = descripcion;
  }

  public String getImagen() {
    return imagen;
  }

  public void setImagen(String imagen) {
    this.imagen = imagen;
  }

  public BigDecimal getPrecio() {
    return precio;
  }

  public void setPrecio(BigDecimal precio) {
    this.precio = precio;
  }

  public String getCaracteristicas() {
    return caracteristicas;
  }

  public void setCaracteristicas(String caracteristicas) {
    this.caracteristicas = caracteristicas;
  }

  public Integer getStock() {
    return stock;
  }

  public void setStock(Integer stock) {
    this.stock = stock;
  }
}
