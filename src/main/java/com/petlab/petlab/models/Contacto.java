package com.petlab.petlab.models;

import jakarta.persistence.*;
import java.util.Date;

@Entity
public class Contacto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_contacto;
    @Column(nullable = false, length = 100)
    private String nombres;
    @Column(nullable = false, length = 100)
    private String apellidos;
    @Column(nullable = false, length = 150)
    private String correo;
    @Column(nullable = false, length = 50)
    private String tipo_contacto;
    @Column(nullable = false, length = 1000)
    private String mensaje;
    @Column(length = 50)
    private String numero_orden;
    @Column(nullable = false)
    private Date fecha_envio;

    // Relación con entidad Usuario
    @ManyToOne
    @JoinColumn(name = "fk_id_usuarios", referencedColumnName = "id_user", nullable = false)
    private UserModel usuario;

    public Contacto() {
    }

    public Contacto(Long id_contacto, String nombres, String apellidos, String correo, String tipo_contacto, String mensaje, String numero_orden, Date fecha_envio, UserModel usuario) {
        this.id_contacto = id_contacto;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.correo = correo;
        this.tipo_contacto = tipo_contacto;
        this.mensaje = mensaje;
        this.numero_orden = numero_orden;
        this.fecha_envio = fecha_envio;
        this.usuario = usuario;
    }

    public Long getId_contacto() {
        return id_contacto;
    }

    public void setId_contacto(Long id_contacto) {
        this.id_contacto = id_contacto;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getTipo_contacto() {
        return tipo_contacto;
    }

    public void setTipo_contacto(String tipo_contacto) {
        this.tipo_contacto = tipo_contacto;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public String getNumero_orden() {
        return numero_orden;
    }

    public void setNumero_orden(String numero_orden) {
        this.numero_orden = numero_orden;
    }

    public Date getFecha_envio() {
        return fecha_envio;
    }

    public void setFecha_envio(Date fecha_envio) {
        this.fecha_envio = fecha_envio;
    }

    public UserModel getUsuario() {
        return usuario;
    }

    public void setUsuario(UserModel usuario) {
        this.usuario = usuario;
    }
}
