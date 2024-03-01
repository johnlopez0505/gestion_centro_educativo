package com.example.john.gestion_centro_educativo.modelos;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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
    @Column(length =100)
    private String email;
    private boolean enabled;
    @ManyToOne
    @JoinColumn(name = "rol_id")
    private Rol rol;
}
