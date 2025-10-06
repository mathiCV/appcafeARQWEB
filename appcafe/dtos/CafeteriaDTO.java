package com.upc.appcafe.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

public class CafeteriaDTO {
    private Integer id;

    private AdministradorDTO administradorid;
    private String nombre;
    private String descripcion;
    private String direccion;
    private BigDecimal latitud;
    private BigDecimal longitud;
    private Boolean activo = false;

}