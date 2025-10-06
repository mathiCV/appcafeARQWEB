package com.upc.appcafe.servicesimpl;

import com.upc.appcafe.dtos.CafeteriaDTO;
import com.upc.appcafe.dtos.ConsumidorDTO;
import com.upc.appcafe.entities.Cafeteria;
import com.upc.appcafe.entities.Consumidor;
import com.upc.appcafe.repositories.CafeteriaRepository;
import com.upc.appcafe.repositories.ConsumidorRepository;
import com.upc.appcafe.services.ConsumidorService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ConsumidorServiceImpl implements ConsumidorService {
    @Autowired
    private ConsumidorRepository consumidorRepository;

    @Autowired
    private ModelMapper modelMapper;
    @Override
    public ConsumidorDTO crearConsumidor(ConsumidorDTO consumidorDTO) {
        Consumidor consumidor = modelMapper.map(consumidorDTO, Consumidor.class);
        consumidor = consumidorRepository.save(consumidor);
        return modelMapper.map(consumidor, ConsumidorDTO.class);
    }

    @Override
    public ConsumidorDTO actualizarConsumidor(int consumidorId, ConsumidorDTO consumidorDTO) {
        Consumidor existe = consumidorRepository.findById(consumidorId).orElseThrow(() -> new RuntimeException("Consumidor no encontrado"));
        modelMapper.map(consumidorDTO, existe);
        existe =  consumidorRepository.save(existe);
        return modelMapper.map(existe, ConsumidorDTO.class);
    }

    @Override
    public void eliminarConsumidor(int consumidorId) {
        consumidorRepository.deleteById(consumidorId);
    }

    @Override
    public ConsumidorDTO obtenerConsumidor(int consumidorId) {
        return consumidorRepository.findById(consumidorId)
                .map(c -> modelMapper.map(c, ConsumidorDTO.class))
                .orElseThrow(() -> new RuntimeException("Consumidor no encontrado"));
    }
}
