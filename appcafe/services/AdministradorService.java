package com.upc.appcafe.services;

import com.upc.appcafe.dtos.AdministradorDTO;
import com.upc.appcafe.dtos.ConsumidorDTO;

public interface AdministradorService {
    AdministradorDTO crearAdministrador(AdministradorDTO administrador);
    AdministradorDTO actualizarAdministrador(int administradorId ,AdministradorDTO administradorDTO);
    void eliminarAdministrador(int administradorId);
    AdministradorDTO obtenerAdministrador(int administradorId);
}
