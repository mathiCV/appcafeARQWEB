package com.cafe.cafe.controllers;

import com.cafe.cafe.entidades.Administrador;
import com.cafe.cafe.entidades.Consumidor;
import com.cafe.cafe.entidades.Usuario;
import com.cafe.cafe.negocio.Negocio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class UsuarioConsumidorAdministradorController {
    @Autowired
    private Negocio negocio;
    /*
    @PostMapping("/usuario")
    public Usuario registrarUsuario(@RequestBody Usuario usuario){
        return negocio.registrarUsuario(usuario);
    }*/
    @PostMapping("/consumidor")
    public Consumidor registrarConsumidor(@RequestBody Consumidor consumidor){
        return negocio.registrarConsumidor(consumidor);
    }
    @PostMapping("/administrador")
    public Administrador registrarAdministrador(@RequestBody Administrador administrador){
        return  negocio.registrarAdministrador(administrador);
    }

    @GetMapping("/usuarios")
    public List<Usuario> listarUsuarios(){
        return  negocio.listarUsuarios();
    }
    @GetMapping("/consumidores")
    public List<Consumidor> listarConsumidores(){
        return  negocio.listarConsumidores();
    }
    @GetMapping("/administradores")
    public List<Administrador> listarAdministradores(){
        return negocio.listarAdministradores();
    }

    @PutMapping("/usuario")
    public Usuario actualizarUsuario(@RequestBody Usuario usuario){
        return  negocio.actualizarUsuario(usuario);
    }
    @PutMapping("/consumidor")
    public Consumidor actualizarConsumidor(@RequestBody Consumidor consumidor){
        return  negocio.actualizarConsumidor(consumidor);
    }
    @PutMapping("/administrador")
    public  Administrador actualizarAdministrador(@RequestBody Administrador administrador){
        return  negocio.actualizarAdministrador(administrador);
    }
    
    @DeleteMapping("/usuario/{id}")
    public void eliminarUsuario(@PathVariable int id) {
        negocio.eliminarUsuario(id);
    }
    @DeleteMapping("/consumidor/{id}")
    public void eliminarConsumidor(@PathVariable int id) {
        negocio.eliminarConsumidor(id);
    }
    @DeleteMapping("/administrador/{id}")
    public void eliminarAdministrador(@PathVariable int id) {
        negocio.eliminarAdministrador(id);
    }
}
