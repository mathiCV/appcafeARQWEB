package com.upc.appcafe.services;

import com.upc.appcafe.dtos.UsuarioDTO;

public interface UsuarioService{
    UsuarioDTO crearUsuario(UsuarioDTO usuarioDTO);
    UsuarioDTO actualizarUsuario(int usuarioId,UsuarioDTO usuarioDTO);
    void eliminarUsuario(int usuarioId);
    UsuarioDTO obtenerUsuario(int  usuarioId);
}
