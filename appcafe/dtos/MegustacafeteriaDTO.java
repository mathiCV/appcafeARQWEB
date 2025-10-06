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
public class MegustacafeteriaDTO {
    private Long id;
    private CafeteriaDTO cafeteriaid;
    private ConsumidorDTO consumidorid;
    private String calificacion;
    private String comentario;
    private OffsetDateTime fecha;

}