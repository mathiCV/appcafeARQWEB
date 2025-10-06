package com.upc.appcafe.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

public class ConsumidorDTO {
    private Integer id;
    private UsuarioDTO usuarioid;
    private String apellidos;
    private String edad;
    private String sexo;
    private String frecuenciaconsumocafe;

}