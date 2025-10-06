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
public class MensajeDTO {
    private Long id;
    private ChatDTO chatid;
    private ConsumidorDTO remitenteid;
    private String contenido;
    private OffsetDateTime fechaenvio;

}