package com.upc.appcafe.controllers;
import com.upc.appcafe.dtos.CafeteriaDTO;
import com.upc.appcafe.services.FavoritosService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/favoritos")
public class FavoritosController {

    private final FavoritosService svc;

    public FavoritosController(FavoritosService svc) {
        this.svc = svc;
    }


    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void marcar(@RequestParam Integer cafeteriaid,
                       @RequestParam Integer consumidorUsuarioId) {
        svc.marcarFavorito(cafeteriaid, consumidorUsuarioId);
    }

    @GetMapping
    public List<CafeteriaDTO> listar(@RequestParam Integer consumidorUsuarioId) {
        return svc.listarFavoritos(consumidorUsuarioId);
    }

    @DeleteMapping
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void quitar(@RequestParam Integer cafeteriaid,
                       @RequestParam Integer consumidorUsuarioId) {
        svc.quitarFavorito(cafeteriaid, consumidorUsuarioId);
    }
}