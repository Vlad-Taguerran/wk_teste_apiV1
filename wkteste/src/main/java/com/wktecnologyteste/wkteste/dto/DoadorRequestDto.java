package com.wktecnologyteste.wkteste.dto;

import com.wktecnologyteste.wkteste.entity.Doadores;
import com.wktecnologyteste.wkteste.entity.Enderecos;
import com.wktecnologyteste.wkteste.entity.enums.Sexo;

import java.text.SimpleDateFormat;
import java.util.Date;

public record DoadorRequestDto(
        String nome,
        String cpf,
        String rg,
        String data_nasc,
        Sexo sexo,
        String mae,
        String pai,
        String email,
        String celular,
        String telefone_fixo,
        String tipo_sanguineo,
        Double altura,
        Double peso,
        String cep,
        String endereco,
        Integer numero,
        String bairro,
        String cidade,
        String estado
) {
    public Doadores toDoadorEntity() {
        Doadores doador = new Doadores();
        doador.setNome(this.nome);
        doador.setCpf(this.cpf);
        doador.setRg(this.rg);
        doador.setSexo(this.sexo);
        doador.setMae(this.mae);
        doador.setPai(this.pai);
        doador.setEmail(this.email);
        doador.setCelular(this.celular);
        doador.setTelefone_fixo(this.telefone_fixo);
        doador.setTipo_sanguineo(this.tipo_sanguineo);
        doador.setAltura(this.altura);
        doador.setPeso(this.peso);


        try {
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            Date parsedDate = sdf.parse(this.data_nasc);
            doador.setData_nasc(parsedDate);
        } catch (Exception e) {
            throw new RuntimeException("Formato de data inválido! Use dd/MM/yyyy.");
        }

        return doador;
    }

    public Enderecos toEnderecoEntity(Doadores doador) {
        Enderecos endereco = new Enderecos();
        endereco.setDoador(doador);
        endereco.setCep(this.cep);
        endereco.setEndereco(this.endereco);
        endereco.setBairro(this.bairro);
        endereco.setCidade(this.cidade);
        endereco.setEstado(this.estado);
        return endereco;
    }
}
