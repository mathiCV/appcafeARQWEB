package com.upc.appcafe.services;

import com.upc.appcafe.dtos.CafeteriaDTO;

public interface CafeteriaService {
    CafeteriaDTO crearCafeteria(CafeteriaDTO cafeteriaDTO);
    CafeteriaDTO actualizarCafeteria(int cafeteriaId,CafeteriaDTO cafeteriaDTO);
    void eliminarCafeteria(int cafeteriaId);
    CafeteriaDTO obtenerCafeteria(int cafeteriaId);
}
