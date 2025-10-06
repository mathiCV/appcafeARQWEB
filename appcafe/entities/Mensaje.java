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
@Table(name = "mensaje")
public class Mensaje {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "mensajeid", nullable = false)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "chatid", nullable = false)
    private Chat chatid;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "remitenteid", nullable = false, referencedColumnName = "usuarioid")
    private Consumidor remitenteid;

    @Column(name = "contenido", nullable = false, length = 1000)
    private String contenido;

    @ColumnDefault("now()")
    @Column(name = "fechaenvio", nullable = false)
    private OffsetDateTime fechaenvio;

}