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
@Table(name = "mensaje")
public class Mensaje {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "mensajeid", nullable = false)
    private Long id;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "chatid", nullable = false)
    private Chat chatid;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "remitenteid", nullable = false)
    private Consumidor remitenteid;

    @Size(max = 1000)
    @NotNull
    @Column(name = "contenido", nullable = false, length = 1000)
    private String contenido;

    @NotNull
    @ColumnDefault("now()")
    @Column(name = "fechaenvio", nullable = false)
    private OffsetDateTime fechaenvio;

}