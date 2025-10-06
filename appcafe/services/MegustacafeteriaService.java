package com.upc.appcafe.services;

import com.upc.appcafe.dtos.MegustacafeteriaDTO;

import java.util.List;

public interface MegustacafeteriaService {
    MegustacafeteriaDTO crearMegustacafeteria(MegustacafeteriaDTO megustacafeteriaDTO);
    MegustacafeteriaDTO actualizarMegustacafeteria(int megustacafeteriaId,MegustacafeteriaDTO megustacafeteriaDTO);
    void eliminarMegustacafeteria(int megustacafeteriaId);
    MegustacafeteriaDTO obtenerMegustacafeteria(int megustacafeteriaId);

    MegustacafeteriaDTO darLike(MegustacafeteriaDTO dto);

    void quitarLike(int id);

    long contarLikes(int cafeteriaId);

    List<MegustacafeteriaDTO> listarLikesPorConsumidor(int consumidorId);
}
