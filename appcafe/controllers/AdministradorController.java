package com.upc.appcafe.controllers;

import com.upc.appcafe.dtos.AdministradorDTO;
import com.upc.appcafe.dtos.UsuarioDTO;
import com.upc.appcafe.services.AdministradorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class AdministradorController {

    @Autowired
    private AdministradorService administradorService;

    @PostMapping("/administrador")
    public AdministradorDTO crearAdministrador(@RequestBody AdministradorDTO administradorDTO){
        return administradorService.crearAdministrador(administradorDTO);
    }
    @PutMapping("/administrador")
    public AdministradorDTO actualizarAdministrador(@RequestBody AdministradorDTO administradorDTO){
        int id = administradorDTO.getId();
        return administradorService.actualizarAdministrador(id, administradorDTO);
    }
    @DeleteMapping("/administrador/{id}")
    public void eliminarAdministrador(@PathVariable int id){
        administradorService.eliminarAdministrador(id);
    }
    @GetMapping("/administrador/{id}")
    public AdministradorDTO obtenerAdministrador(@PathVariable int id){
        return administradorService.obtenerAdministrador(id);
    }
}
