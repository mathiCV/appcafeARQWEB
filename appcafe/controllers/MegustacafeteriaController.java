package com.upc.appcafe.controllers;

import com.upc.appcafe.dtos.MegustacafeteriaDTO;
import com.upc.appcafe.services.MegustacafeteriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/megustacafeteria")

public class MegustacafeteriaController {
    @Autowired
    private MegustacafeteriaService megustacafeteriaService;


    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public MegustacafeteriaDTO darLike(@RequestBody MegustacafeteriaDTO dto) {
        return megustacafeteriaService.darLike(dto);
    }


    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void quitarLike(@PathVariable int id) {
        megustacafeteriaService.quitarLike(id);
    }


    @GetMapping("/cafeteria/{cafeteriaId}/count")
    public long contarLikes(@PathVariable int cafeteriaId) {
        return megustacafeteriaService.contarLikes(cafeteriaId);
    }


    @GetMapping("/consumidor/{consumidorId}")
    public List<MegustacafeteriaDTO> listarLikesConsumidor(@PathVariable int consumidorId) {
        return megustacafeteriaService.listarLikesPorConsumidor(consumidorId);
    }

}
