package com.upc.appcafe.servicesimpl;

import com.upc.appcafe.dtos.AdministradorDTO;
import com.upc.appcafe.dtos.CafeteriaDTO;
import com.upc.appcafe.entities.Cafeteria;
import com.upc.appcafe.repositories.CafeteriaRepository;
import com.upc.appcafe.services.CafeteriaService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class CafeteriaServiceImpl implements CafeteriaService {
    @Autowired
    private CafeteriaRepository cafeteriaRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public CafeteriaDTO crearCafeteria(CafeteriaDTO cafeteriaDTO) {
        Cafeteria cafeteria = modelMapper.map(cafeteriaDTO, Cafeteria.class);
        cafeteria = cafeteriaRepository.save(cafeteria);
        return modelMapper.map(cafeteria, CafeteriaDTO.class);
    }
    @Override
    public CafeteriaDTO actualizarCafeteria(int cafeteriaId, CafeteriaDTO cafeteriaDTO) {
        Cafeteria existe = cafeteriaRepository.findById(cafeteriaId).orElseThrow(() -> new RuntimeException("Cafeteria no encontrado"));
        modelMapper.map(cafeteriaDTO, existe);
        existe =  cafeteriaRepository.save(existe);
        return  modelMapper.map(existe, CafeteriaDTO.class);
    }

    @Override
    public void eliminarCafeteria(int cafeteriaId) {
        cafeteriaRepository.deleteById(cafeteriaId);
    }

    @Override
    public CafeteriaDTO obtenerCafeteria(int cafeteriaId) {
        return cafeteriaRepository.findById(cafeteriaId)
                .map(a  -> modelMapper.map(a, CafeteriaDTO.class))
                .orElseThrow(() -> new RuntimeException("Cafeteria no encontrada"));
    }
}
