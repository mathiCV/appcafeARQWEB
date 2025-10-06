package com.upc.appcafe.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class AdministradorDTO {
    private Integer id;
    private UsuarioDTO usuarioid;
    private String ruc;

}