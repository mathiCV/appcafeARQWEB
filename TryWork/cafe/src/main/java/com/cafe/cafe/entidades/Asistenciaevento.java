package com.cafe.cafe.entidades;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;

import java.time.OffsetDateTime;

@Getter
@Setter
@Entity
@Table(name = "asistenciaevento")
public class Asistenciaevento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "asistenciaid", nullable = false)
    private Long id;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "eventoid", nullable = false)
    private Evento eventoid;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "consumidorid", nullable = false)
    private Consumidor consumidorid;

    @NotNull
    @ColumnDefault("now()")
    @Column(name = "fecharegistro", nullable = false)
    private OffsetDateTime fecharegistro;

}