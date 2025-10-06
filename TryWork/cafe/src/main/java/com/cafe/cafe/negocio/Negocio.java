package com.cafe.cafe.negocio;

import com.cafe.cafe.entidades.Administrador;
import com.cafe.cafe.entidades.Consumidor;
import com.cafe.cafe.entidades.Usuario;
import com.cafe.cafe.repository.AdministradorRepository;
import com.cafe.cafe.repository.ConsumidorRepository;
import com.cafe.cafe.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
public class Negocio {
    @Autowired
    private ConsumidorRepository consumidorRepository;
    @Autowired
    private UsuarioRepository usuarioRepository;
    private AdministradorRepository administradorRepository;
    @Transactional
    public Usuario registrarUsuario(Usuario usuario){
        return  usuarioRepository.save(usuario);
    }
    public Consumidor registrarConsumidor(Consumidor consumidor){
        return  consumidorRepository.save(consumidor);
    }
    public Administrador registrarAdministrador(Administrador administrador){
        return administradorRepository.save(administrador);
    }

    public List<Usuario> listarUsuarios(){
        return usuarioRepository.findAll();
    }
    public List<Consumidor> listarConsumidores(){
        return consumidorRepository.findAll();
    }
    public List<Administrador> listarAdministradores(){
        return administradorRepository.findAll();
    }

    public Usuario actualizarUsuario(Usuario usuario){
        if (usuario.getId()!=null){
            return  usuarioRepository.save(usuario);
        }
        return null;
    }
    public Consumidor actualizarConsumidor(Consumidor consumidor){
        if (consumidor.getId()!=null){
            return  consumidorRepository.save(consumidor);
        }
        return null;
    }
    public Administrador actualizarAdministrador(Administrador administrador){
        if (administrador.getId()!=null){
            return  administradorRepository.save(administrador);
        }
        return null;
    }
    public void eliminarUsuario(int id) {
        usuarioRepository.deleteById(id);
    }

    public void eliminarConsumidor(int id) {
        consumidorRepository.deleteById(id);
    }

    public void eliminarAdministrador(int id) {
        administradorRepository.deleteById(id);
    }


}
