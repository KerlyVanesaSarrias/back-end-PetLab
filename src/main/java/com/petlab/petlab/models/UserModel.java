package com.petlab.petlab.models;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

@Entity
public class UserModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_user;

    @NotBlank(message = "Campo obligatorio")
    @Column(nullable = false)
    private String nombre;

    @NotBlank(message = "Campo obligatorio")
    @Column(nullable = false)
    private String correo;

    @NotBlank(message = "Campo obligatorio")
    @Column(nullable = false)
    private String telefono;

    @NotBlank(message = "Campo obligatorio")
    @Column(nullable = false)
    private String contrasena;

    public UserModel() {
    }

    public UserModel(Long id_user, String nombre, String correo, String telefono, String contrasena) {
        this.id_user = id_user;
        this.nombre = nombre;
        this.correo = correo;
        this.telefono = telefono;
        this.contrasena = contrasena;
    }

    public Long getId_user() {
        return id_user;
    }

    public void setId_user(Long id_user) {
        this.id_user = id_user;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }
}
