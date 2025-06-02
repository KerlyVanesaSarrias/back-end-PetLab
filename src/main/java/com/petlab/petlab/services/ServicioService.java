package com.petlab.petlab.services;

import com.petlab.petlab.models.Servicio;
import com.petlab.petlab.repositories.IservicioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ServicioService implements IservicioService{

    private final IservicioRepository servicioRepository;

    @Autowired
    public ServicioService(IservicioRepository servicioRepository) {
        this.servicioRepository = servicioRepository;
    }

    @Override
    public List<Servicio> obtenerTodos() {
        return servicioRepository.findAll();
    }

    @Override
    public Servicio obtenerPorId(Long id) {
        return servicioRepository.findById(id).orElse(null);
    }

    @Override
    public void guardarServicio(Servicio servicio) {
        servicioRepository.save(servicio);
    }

    @Override
    public void eliminarServicio(Long id) {
        servicioRepository.deleteById(id);
    }

    @Override
    public void editarServicio(Long id, Servicio servicioActualizado) {
        //saber si existe
        Servicio servicioExiste = servicioRepository.findById(id).orElse(null);
        //
        if (servicioExiste != null){
            //Actualizar los campos
            servicioExiste.setNombre(servicioActualizado.getNombre());
            servicioExiste.setDescripcion(servicioActualizado.getDescripcion());
            servicioExiste.setDuracion(servicioActualizado.getDuracion());
            servicioExiste.setImagen(servicioActualizado.getImagen());
            servicioExiste.setPrecio(servicioActualizado.getPrecio());
            servicioExiste.setCaracteristicas(servicioActualizado.getCaracteristicas());
            servicioExiste.setAgenda(servicioActualizado.getAgenda());
            servicioExiste.setRecomendaciones(servicioActualizado.getRecomendaciones());
            servicioExiste.setCategoria(servicioActualizado.getCategoria());
            //guardar el post
            servicioRepository.save(servicioExiste);
        }else {
            throw new RuntimeException("El servicio, NO fue encontrado con el Id: "+"#"+id);
        }
    }
}
