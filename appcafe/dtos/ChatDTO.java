package com.upc.appcafe.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.OffsetDateTime;
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ChatDTO {
    private Long id;
    private CafeteriaDTO cafeteriaid;
    private ConsumidorDTO participante1id;
    private ConsumidorDTO participante2id;
    private OffsetDateTime fechacreacion;
    private String estado;
}