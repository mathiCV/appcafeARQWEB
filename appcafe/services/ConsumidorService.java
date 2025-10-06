package com.upc.appcafe.services;

import com.upc.appcafe.dtos.ConsumidorDTO;

public interface ConsumidorService {
    ConsumidorDTO crearConsumidor(ConsumidorDTO consumidorDTO);
    ConsumidorDTO actualizarConsumidor(int consumidorId,ConsumidorDTO consumidorDTO);
    void eliminarConsumidor(int consumidorId);
    ConsumidorDTO obtenerConsumidor(int consumidorId);
}
