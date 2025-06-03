package com.petlab.petlab.services;

import com.petlab.petlab.models.Contacto;
import com.petlab.petlab.repositories.IcontactoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ContactoService implements IcontactoService{

    private final IcontactoRepository contactoRepository;

    @Autowired
    public ContactoService(IcontactoRepository contactoRepository) {
        this.contactoRepository = contactoRepository;
    }

    @Override
    public List<Contacto> obtenerTodos() {
        return contactoRepository.findAll();
    }

    @Override
    public Contacto obtenerPorId(Long id) {
        return contactoRepository.findById(id).orElse(null);
    }

    @Override
    public void guardarContacto(Contacto contacto) {
        contactoRepository.save(contacto);
    }
}
