package com.petlab.petlab.services;

import com.petlab.petlab.models.Contacto;
import java.util.List;

public interface IcontactoService {
    List<Contacto> obtenerTodos();
    Contacto obtenerPorId(Long id);
    void guardarContacto(Contacto contacto);
}
