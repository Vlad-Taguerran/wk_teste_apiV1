package com.wktecnologyteste.wkteste.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.wktecnologyteste.wkteste.entity.enums.Sexo;
import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;
import java.util.UUID;

@Data
@Entity
public class Doadores {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id", nullable = false)
    private UUID id;
    @Column(name = "nome", nullable = false)
    private String nome;
    @Column(name = "cpf", unique = true, nullable = false)
    private String cpf;
    @Column(name = "rg", nullable = false, unique = true)
    private String rg;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
    @Column(name = "data_nasc", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date data_nasc;
    @Column(name = "sexo")
    @Enumerated(EnumType.STRING)
    private Sexo sexo;
    @Column(name = "mae")
    private String mae;
    @Column(name = "pai")
    private String pai;
    @Column(name ="email", unique = true)
    private String email;
    @Column(name = "celular")
    private String celular;
    @Column(name = "telefone_fixo")
    private String telefone_fixo;
    @Column(name = "tipo_sanguineo")
    private String tipo_sanguineo;
    @Column(name = "altura")
    private Double altura;
    @Column(name = "peso")
    private Double peso;

    @OneToOne(mappedBy = "doador", optional = false)
    private Enderecos enderecos;

}
