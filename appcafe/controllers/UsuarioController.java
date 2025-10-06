package com.upc.appcafe.controllers;

import com.upc.appcafe.dtos.UsuarioDTO;
import com.upc.appcafe.entities.Usuario;
import com.upc.appcafe.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class UsuarioController {
    @Autowired
    private UsuarioService usuarioService;
    @PostMapping("/usuario")
    public UsuarioDTO crearUsuario(@RequestBody UsuarioDTO usuarioDTO){
        return usuarioService.crearUsuario(usuarioDTO);
    }
    @PutMapping("/usuario")
    public UsuarioDTO actualizarUsuario(@RequestBody UsuarioDTO usuarioDTO){
        int id = usuarioDTO.getId();
        return usuarioService.actualizarUsuario(id, usuarioDTO);
    }
    @DeleteMapping("/usuario/{id}")
    public void eliminarUsuario(@PathVariable int id){
        usuarioService.eliminarUsuario(id);
    }
    @GetMapping("/usuario/{id}")
    public UsuarioDTO obtenerUsuario(@PathVariable int id){
        return usuarioService.obtenerUsuario(id);
    }



}
