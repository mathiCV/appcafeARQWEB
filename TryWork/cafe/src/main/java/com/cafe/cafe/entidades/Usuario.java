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
@Table(name = "usuario")
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "usuarioid", nullable = false)
    private Integer id;

    @Size(max = 50)
    @NotNull
    @Column(name = "nombreusuario", nullable = false, length = 50)
    private String nombreusuario;

    @Size(max = 120)
    @NotNull
    @Column(name = "email", nullable = false, length = 120)
    private String email;

    @Size(max = 200)
    @NotNull
    @Column(name = "contrasenahash", nullable = false, length = 200)
    private String contrasenahash;

    @Size(max = 12)
    @NotNull
    @Column(name = "rol", nullable = false, length = 12)
    private String rol;

    @NotNull
    @ColumnDefault("now()")
    @Column(name = "fecharegistro", nullable = false)
    private OffsetDateTime fecharegistro;

    @Size(max = 20)
    @NotNull
    @ColumnDefault("'ACTIVO'")
    @Column(name = "estado", nullable = false, length = 20)
    private String estado;

}