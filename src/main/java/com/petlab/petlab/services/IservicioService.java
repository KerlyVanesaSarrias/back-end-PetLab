package com.petlab.petlab.services;

import com.petlab.petlab.models.Servicio;
import java.util.List;

public interface IservicioService {
    List<Servicio> obtenerTodos();
    Servicio obtenerPorId(Long id);
    void guardarServicio(Servicio servicio);
    void eliminarServicio(Long id);
    void editarServicio(Long id, Servicio servicioActualizado);
}
