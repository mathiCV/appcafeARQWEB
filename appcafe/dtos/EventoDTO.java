package com.upc.appcafe.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.OffsetDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class EventoDTO {
    private Integer id;
    private CafeteriaDTO cafeteriaid;
    private AdministradorDTO administradorid;
    private String titulo;
    private String descripcion;
    private OffsetDateTime fechainicio;
    private OffsetDateTime fechafin;
    private Integer aforo;
    private String estado;

}