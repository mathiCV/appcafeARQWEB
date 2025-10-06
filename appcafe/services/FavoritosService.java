package com.upc.appcafe.services;

import com.upc.appcafe.dtos.CafeteriaDTO;

import java.util.List;

public interface FavoritosService {
    void marcarFavorito(Integer cafeteriaid, Integer consumidorUsuarioId);
    void quitarFavorito(Integer cafeteriaid, Integer consumidorUsuarioId);
    List<CafeteriaDTO> listarFavoritos(Integer consumidorUsuarioId);
}
