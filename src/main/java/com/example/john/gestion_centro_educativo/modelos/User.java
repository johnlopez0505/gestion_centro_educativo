package com.example.john.gestion_centro_educativo.modelos;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(length = 100)
    private String username;
    @Column(length = 100)
    private String password;

    @OneToOne
    private Alumno alumno;

    @OneToOne
    private Profesor profesor;

    private boolean enabled;
    
    @ManyToOne
    private Rol rol;
}
