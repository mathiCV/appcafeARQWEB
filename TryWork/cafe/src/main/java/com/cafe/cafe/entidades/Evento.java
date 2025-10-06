package com.cafe.cafe.entidades;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;

import java.time.OffsetDateTime;

@Getter
@Setter
@Entity
@Table(name = "evento")
public class Evento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "eventoid", nullable = false)
    private Integer id;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "cafeteriaid", nullable = false)
    private Cafeteria cafeteriaid;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "administradorid", nullable = false)
    private Administrador administradorid;

    @Size(max = 150)
    @NotNull
    @Column(name = "titulo", nullable = false, length = 150)
    private String titulo;

    @Size(max = 500)
    @Column(name = "descripcion", length = 500)
    private String descripcion;

    @NotNull
    @Column(name = "fechainicio", nullable = false)
    private OffsetDateTime fechainicio;

    @Column(name = "fechafin")
    private OffsetDateTime fechafin;

    @Column(name = "aforo")
    private Integer aforo;

    @Size(max = 20)
    @NotNull
    @ColumnDefault("'PROGRAMADO'")
    @Column(name = "estado", nullable = false, length = 20)
    private String estado;

}