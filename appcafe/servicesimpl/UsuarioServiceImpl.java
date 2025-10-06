package com.upc.appcafe.servicesimpl;

import com.upc.appcafe.dtos.UsuarioDTO;
import com.upc.appcafe.entities.Usuario;
import com.upc.appcafe.repositories.UsuarioRepository;
import com.upc.appcafe.services.UsuarioService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner;
import org.springframework.stereotype.Service;


@Service
public class UsuarioServiceImpl implements UsuarioService {
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private UsuarioRepository usuarioRepository;
    @Override
    public UsuarioDTO crearUsuario(UsuarioDTO usuarioDTO) {
        Usuario usuario = modelMapper.map(usuarioDTO, Usuario.class);
        usuarioRepository.save(usuario);
        return modelMapper.map(usuario, UsuarioDTO.class);
    }

    @Override
    public UsuarioDTO actualizarUsuario(int usuarioId, UsuarioDTO usuarioDTO) {
        Usuario existe =  usuarioRepository.findById(usuarioId).orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
        modelMapper.map(usuarioDTO, existe);
        existe = modelMapper.map(existe, Usuario.class);
        return modelMapper.map(usuarioRepository.save(existe), UsuarioDTO.class);
    }

    @Override
    public void eliminarUsuario(int usuarioId) {
        usuarioRepository.deleteById(usuarioId);
    }

    @Override
    public UsuarioDTO obtenerUsuario(int usuarioId) {
        return usuarioRepository.findById(usuarioId)
                .map( u -> modelMapper.map(u, UsuarioDTO.class))
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
    }
}
