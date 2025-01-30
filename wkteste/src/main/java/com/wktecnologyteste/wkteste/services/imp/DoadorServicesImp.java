package com.wktecnologyteste.wkteste.services.imp;

import com.wktecnologyteste.wkteste.dto.*;
import com.wktecnologyteste.wkteste.entity.Doadores;
import com.wktecnologyteste.wkteste.entity.Enderecos;
import com.wktecnologyteste.wkteste.repository.DoadoresRepository;
import com.wktecnologyteste.wkteste.repository.EnderecosRepository;
import com.wktecnologyteste.wkteste.services.DoadorServices;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DoadorServicesImp  implements DoadorServices {
    @Autowired
    EnderecosRepository enderecosRepository;
    @Autowired
    private DoadoresRepository repository;
    @Override
    @Transactional
    public ResponseEntity register(List<DoadorRequestDto> doadores) {

        try {
            for (DoadorRequestDto doador : doadores) {
              Doadores doadorSave = repository.save(doador.toDoadorEntity());
                Enderecos endereco = doador.toEnderecoEntity(doadorSave);
                enderecosRepository.save(endereco);
            }
            return ResponseEntity.ok("okay");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public ResponseEntity totalCandidatos() {
        return ResponseEntity.ok(repository.count());
    }

    @Override
    public ResponseEntity<List<CandidatosPorEstadoDTO>> listCandidatosPorEstado() {
        List<CandidatosPorEstadoDTO> candidados = repository.contarCandidatosPorEstado();
        return ResponseEntity.ok(candidados);
    }
//calcular total por idade e sexo
    @Override
    public ResponseEntity<IMCObesidadeResultadoDTO> listIMCObesidadeResultado() {
        List<IMCFaixaEtariaDTO> imcPorFaixaEtaria = repository.calcularIMCMedioPorFaixaEtaria();
        List<IMCPorGenero> IMCPorGenero = repository.calcularImcPorSexo();
        IMCObesidadeResultadoDTO resultadoDTO = new IMCObesidadeResultadoDTO(imcPorFaixaEtaria, IMCPorGenero);
        return ResponseEntity.ok(resultadoDTO);
    }

    @Override
    public ResponseEntity<List<IMCFaixaEtariaDTO>> listImcFaixaEtaria() {
        List<IMCFaixaEtariaDTO> listImcFaixaEtaria = repository.calcularIMCMedioPorFaixaEtaria();
        return ResponseEntity.ok(listImcFaixaEtaria);
    }

    @Override
    public ResponseEntity<List<IMCPorGenero>> ListImcPorGenero() {
        List<IMCPorGenero> imcPorGeneros = repository.calcularImcPorSexo();
        return ResponseEntity.ok(imcPorGeneros);
    }

    @Override
    public ResponseEntity<List<MediaIdadeTipoSanguineoDTO>> mediaIdadeTipoSanguineo() {
        List<MediaIdadeTipoSanguineoDTO> media = repository.calcularMediaIdadePorTipoSanguineo();
        return ResponseEntity.ok(media);
    }

    @Override
    public ResponseEntity<List<CalcularQuantidadeDoadoresDTO>> calcularQuantidadeDoadores() {
        List<CalcularQuantidadeDoadoresDTO> quantidadeDoadores = repository.calcularQuantidadeDoadores();
        return ResponseEntity.ok(quantidadeDoadores);
    }
}
