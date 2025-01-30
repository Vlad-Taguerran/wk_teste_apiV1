package com.wktecnologyteste.wkteste.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.UUID;

@Data
@Entity
@Table(name = "enderecos")
public class Enderecos {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id", nullable = false)
    private UUID id;
    @Column(name = "cep")
    private String cep;
    @Column(name = "endereco")
    private String endereco;
    @Column(name = "bairro")
    private String bairro;
    @Column(name = "cidade")
    private String cidade;
    @Column(name = "estado", length = 2)
    private String estado;
    @OneToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private Users user;
    @OneToOne
    @JoinColumn(name = "doador_id", referencedColumnName = "id")
    private Doadores doador;
}