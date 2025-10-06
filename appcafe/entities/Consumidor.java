package com.upc.appcafe.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "consumidor")
public class Consumidor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "consumidorid", nullable = false)
    private Integer id;

    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "usuarioid", nullable = false)
    private Usuario usuarioid;

    @Column(name = "apellidos", length = 100)
    private String apellidos;

    @Column(name = "edad", nullable = false, length = 150)
    private String edad;

    @Column(name = "sexo", nullable = false, length = 20)
    private String sexo;

    @Column(name = "frecuenciaconsumocafe", nullable = false, length = 100)
    private String frecuenciaconsumocafe;

}