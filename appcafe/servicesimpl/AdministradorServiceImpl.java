package com.upc.appcafe.servicesimpl;

import com.upc.appcafe.dtos.AdministradorDTO;
import com.upc.appcafe.entities.Administrador;
import com.upc.appcafe.repositories.AdministradorRepository;
import com.upc.appcafe.services.AdministradorService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdministradorServiceImpl implements AdministradorService {
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private AdministradorRepository administradorRepository;

    @Override
    public AdministradorDTO crearAdministrador(AdministradorDTO administradorDTO) {
        Administrador admin =  modelMapper.map(administradorDTO, Administrador.class);
        admin = administradorRepository.save(admin);
        return modelMapper.map(admin, AdministradorDTO.class);
    }
    @Override
    public AdministradorDTO actualizarAdministrador(int administradorId, AdministradorDTO administradorDTO) {
        Administrador existe =  administradorRepository.findById(administradorId).orElseThrow(() -> new RuntimeException("Administador no encontrado"));
        modelMapper.map(administradorDTO, existe);
        existe =  administradorRepository.save(existe);
        return modelMapper.map(existe, AdministradorDTO.class);
    }

    @Override
    public void eliminarAdministrador(int administradorId) {
        administradorRepository.deleteById(administradorId);
    }

    @Override
    public AdministradorDTO obtenerAdministrador(int administradorId) {
        return administradorRepository.findById(administradorId)
                .map(a  -> modelMapper.map(a, AdministradorDTO.class))
                .orElseThrow(() -> new RuntimeException("Administrador no encontrado"));
    }
}
