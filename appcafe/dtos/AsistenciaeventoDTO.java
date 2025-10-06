package com.upc.appcafe.dtos;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;

import java.time.OffsetDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class AsistenciaeventoDTO {
    private Long id;
    private EventoDTO eventoid;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "consumidorid", nullable = false, referencedColumnName = "usuarioid")
    private ConsumidorDTO consumidorid;

    @ColumnDefault("now()")
    @Column(name = "fecharegistro", nullable = false)
    private OffsetDateTime fecharegistro;

}