package com.upc.appcafe.entities;

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
@Entity
@Table(name = "asistenciaevento")
public class Asistenciaevento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "asistenciaid", nullable = false)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "eventoid", nullable = false)
    private Evento eventoid;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "consumidorid", nullable = false, referencedColumnName = "usuarioid")
    private Consumidor consumidorid;

    @ColumnDefault("now()")
    @Column(name = "fecharegistro", nullable = false)
    private OffsetDateTime fecharegistro;

}