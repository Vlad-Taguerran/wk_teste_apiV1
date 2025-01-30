package com.wktecnologyteste.wkteste.services;

import com.wktecnologyteste.wkteste.dto.*;

import org.springframework.http.ResponseEntity;

import java.util.List;

public interface DoadorServices {
    public ResponseEntity register(List<DoadorRequestDto> doadores);

    public ResponseEntity totalCandidatos();

    public ResponseEntity<List<CandidatosPorEstadoDTO>> listCandidatosPorEstado();

    public ResponseEntity<IMCObesidadeResultadoDTO> listIMCObesidadeResultado();

    public ResponseEntity<List<IMCFaixaEtariaDTO>> listImcFaixaEtaria();

    public ResponseEntity<List<IMCPorGenero>> ListImcPorGenero();

    public ResponseEntity<List<MediaIdadeTipoSanguineoDTO>> mediaIdadeTipoSanguineo();

    public ResponseEntity<List<CalcularQuantidadeDoadoresDTO>> calcularQuantidadeDoadores();
}
