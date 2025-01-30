package com.wktecnologyteste.wkteste.dto;

import com.wktecnologyteste.wkteste.entity.enums.Sexo;

public record IMCPorGenero(
        Sexo sexo,
        Double percentualObesos) {
}
