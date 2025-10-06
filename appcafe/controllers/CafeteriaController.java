package com.upc.appcafe.controllers;

import com.upc.appcafe.services.AdministradorService;
import com.upc.appcafe.services.CafeteriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class CafeteriaController {
    @Autowired
    private CafeteriaService cafeteriaService;

}
