package com.petlab.petlab.models;

import jakarta.persistence.*;

@Entity
public class Servicio {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_servicio;
    @Column(nullable = false, length = 100)
    private String nombre;
    @Column(nullable = false, length = 1000)
    private String descripcion;
    @Column(nullable = false)
    private int duracion; // en minutos
    @Column(length = 255)
    private String imagen; // URL de la imagen
    @Column(nullable = false)
    private double precio;
    @Column(length = 1000)
    private String caracteristicas;
    @Column(length = 500)
    private String agenda;
    @Column(length = 1000)
    private String recomendaciones;
    @Column(length = 100)
    private String categoria;

    public Servicio() {
    }

    public Servicio(Long id_servicio, String nombre, String descripcion, int duracion, String imagen, double precio, String caracteristicas, String agenda, String recomendaciones, String categoria) {
        this.id_servicio = id_servicio;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.duracion = duracion;
        this.imagen = imagen;
        this.precio = precio;
        this.caracteristicas = caracteristicas;
        this.agenda = agenda;
        this.recomendaciones = recomendaciones;
        this.categoria = categoria;
    }

    public Long getId_servicio() {
        return id_servicio;
    }

    public void setId_servicio(Long id_servicio) {
        this.id_servicio = id_servicio;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getDuracion() {
        return duracion;
    }

    public void setDuracion(int duracion) {
        this.duracion = duracion;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public String getCaracteristicas() {
        return caracteristicas;
    }

    public void setCaracteristicas(String caracteristicas) {
        this.caracteristicas = caracteristicas;
    }

    public String getAgenda() {
        return agenda;
    }

    public void setAgenda(String agenda) {
        this.agenda = agenda;
    }

    public String getRecomendaciones() {
        return recomendaciones;
    }

    public void setRecomendaciones(String recomendaciones) {
        this.recomendaciones = recomendaciones;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }
}
