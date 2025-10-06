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
@Table(name = "megustacafeteria")
public class Megustacafeteria {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "likeid", nullable = false)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "cafeteriaid", nullable = false)
    private Cafeteria cafeteriaid;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "consumidorid", nullable = false, referencedColumnName = "usuarioid")
    private Consumidor consumidorid;

    @Column(name = "calificacion", length = 20)
    private String calificacion;

    @Column(name = "comentario", length = 300)
    private String comentario;

    @ColumnDefault("now()")
    @Column(name = "fecha", nullable = false)
    private OffsetDateTime fecha;

    public void setFecharegistro(OffsetDateTime now) {
    }
}