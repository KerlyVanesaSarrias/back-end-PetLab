package com.petlab.petlab.models;

import jakarta.persistence.*;
import org.apache.catalina.User;
import java.time.LocalDateTime;

@Entity
public class Pedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private User user;

    private LocalDateTime fecha = LocalDateTime.now();

    public Pedido() {
    }

    public Pedido(Long id, User user, LocalDateTime fecha) {
        this.id = id;
        this.user = user;
        this.fecha = fecha;
    }

    public Long getId() {

        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public LocalDateTime getFecha() {
        return fecha;
    }

    public void setFecha(LocalDateTime fecha) {
        this.fecha = fecha;
    }
}
