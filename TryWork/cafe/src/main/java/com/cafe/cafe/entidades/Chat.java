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
@Table(name = "chat")
public class Chat {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "chatid", nullable = false)
    private Long id;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "cafeteriaid", nullable = false)
    private Cafeteria cafeteriaid;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "participante1id", nullable = false)
    private Consumidor participante1id;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "participante2id", nullable = false)
    private Consumidor participante2id;

    @NotNull
    @ColumnDefault("now()")
    @Column(name = "fechacreacion", nullable = false)
    private OffsetDateTime fechacreacion;

    @Size(max = 20)
    @NotNull
    @ColumnDefault("'ABIERTO'")
    @Column(name = "estado", nullable = false, length = 20)
    private String estado;

}