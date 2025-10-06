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
@Table(name = "evento")
public class Evento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "eventoid", nullable = false)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "cafeteriaid", nullable = false)
    private Cafeteria cafeteriaid;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "administradorid", nullable = false, referencedColumnName = "usuarioid")
    private Administrador administradorid;

    @Column(name = "titulo", nullable = false, length = 150)
    private String titulo;

    @Column(name = "descripcion", length = 500)
    private String descripcion;

    @Column(name = "fechainicio", nullable = false)
    private OffsetDateTime fechainicio;

    @Column(name = "fechafin")
    private OffsetDateTime fechafin;

    @Column(name = "aforo")
    private Integer aforo;

    @ColumnDefault("'PROGRAMADO'")
    @Column(name = "estado", nullable = false, length = 20)
    private String estado;

}