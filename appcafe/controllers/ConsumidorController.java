package com.upc.appcafe.controllers;

import com.upc.appcafe.dtos.AdministradorDTO;
import com.upc.appcafe.dtos.ConsumidorDTO;
import com.upc.appcafe.services.AdministradorService;
import com.upc.appcafe.services.ConsumidorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
@RestController
@RequestMapping("/api")
public class ConsumidorController {

    @Autowired
    private ConsumidorService consumidorService;

    @PostMapping("/consumidor")
    public ConsumidorDTO crearConsumidor(@RequestBody ConsumidorDTO consumidorDTO){
        return consumidorService.crearConsumidor(consumidorDTO);
    }
    @PutMapping("/consumidor")
    public ConsumidorDTO actualizarConsumidor(@RequestBody ConsumidorDTO consumidorDTO){
        int id = consumidorDTO.getId();
        return consumidorService.actualizarConsumidor(id, consumidorDTO);
    }
    @DeleteMapping("/consumidor/{id}")
    public void eliminarConsumidor(@PathVariable int id){
        consumidorService.eliminarConsumidor(id);
    }
    @GetMapping("/consumidor/{id}")
    public ConsumidorDTO obtenerConsumidor(@PathVariable int id){
        return consumidorService.obtenerConsumidor(id);
    }
}
