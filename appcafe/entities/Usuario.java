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
@Table(name = "usuario")
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "usuarioid", nullable = false)
    private Integer id;

    @Column(name = "nombreusuario", nullable = false, length = 120)
    private String nombreusuario;

    @Column(name = "email", nullable = false, length = 120)
    private String email;

    @Column(name = "contrasenahash", nullable = false, length = 200)
    private String contrasenahash;

    @ColumnDefault("now()")
    @Column(name = "fecharegistro", nullable = false)
    private OffsetDateTime fecharegistro;

    @ColumnDefault("'ACTIVO'")
    @Column(name = "estado", nullable = false, length = 20)
    private String estado;
}