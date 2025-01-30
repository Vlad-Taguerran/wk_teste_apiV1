package com.wktecnologyteste.wkteste.dto;

import java.util.List;

public record IMCObesidadeResultadoDTO(
        List<IMCFaixaEtariaDTO> imcPorFaixaEtaria,
        List<IMCPorGenero> imcPorGeneros
) {
}
