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
@Table(name = "chat")
public class Chat {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "chatid", nullable = false)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "cafeteriaid", nullable = false)
    private Cafeteria cafeteriaid;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "participante1id", nullable = false, referencedColumnName = "usuarioid")
    private Consumidor participante1id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "participante2id", nullable = false, referencedColumnName = "usuarioid")
    private Consumidor participante2id;

    @ColumnDefault("now()")
    @Column(name = "fechacreacion", nullable = false)
    private OffsetDateTime fechacreacion;

    @ColumnDefault("'ABIERTO'")
    @Column(name = "estado", nullable = false, length = 20)
    private String estado;

}