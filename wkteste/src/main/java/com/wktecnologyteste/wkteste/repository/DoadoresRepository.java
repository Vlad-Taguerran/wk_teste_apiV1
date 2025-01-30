package com.wktecnologyteste.wkteste.repository;

import com.wktecnologyteste.wkteste.dto.*;
import com.wktecnologyteste.wkteste.entity.Doadores;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.UUID;

public interface DoadoresRepository extends JpaRepository<Doadores, UUID> {
    @Query("""

            SELECT new com.wktecnologyteste.wkteste.dto.IMCFaixaEtariaDTO(
                      FLOOR((YEAR(CURDATE()) - YEAR(d.data_nasc)) / 10) * 10,\s
                       ROUND(AVG(d.peso / (d.altura * d.altura)), 2)
                  )
            FROM Doadores d
            WHERE d.altura IS NOT NULL AND d.peso IS NOT NULL
            GROUP BY FLOOR((YEAR(CURDATE()) - YEAR(d.data_nasc)) / 10) * 10
            ORDER BY FLOOR((YEAR(CURDATE()) - YEAR(d.data_nasc)) / 10) * 10
          """)
    List<IMCFaixaEtariaDTO> calcularIMCMedioPorFaixaEtaria();
    @Query("""
    SELECT new com.wktecnologyteste.wkteste.dto.IMCPorGenero(
        d.sexo,
            (COUNT(CASE WHEN (d.peso / (d.altura * d.altura)) > 30 THEN 1 END) * 100.0) / COUNT(d.id) AS percentualObesos
    )
    FROM Doadores d
    WHERE d.altura IS NOT NULL AND d.peso IS NOT NULL
    GROUP BY d.sexo
""")
    List<IMCPorGenero> calcularImcPorSexo();
    @Query("""
    SELECT new com.wktecnologyteste.wkteste.dto.CandidatosPorEstadoDTO(
        d.enderecos.estado,
        COUNT(d.id)
    )
    FROM Doadores d
    GROUP BY d.enderecos.estado
    ORDER BY COUNT(d.id) DESC
""")
    List<CandidatosPorEstadoDTO> contarCandidatosPorEstado();

    @Query("""
    SELECT new com.wktecnologyteste.wkteste.dto.MediaIdadeTipoSanguineoDTO(
        d.tipo_sanguineo, 
        ROUND(AVG(YEAR(CURDATE()) - YEAR(d.data_nasc)), 0)
    )
    FROM Doadores d
    WHERE d.data_nasc IS NOT NULL
    GROUP BY d.tipo_sanguineo
    ORDER BY d.tipo_sanguineo
""")
    List<MediaIdadeTipoSanguineoDTO> calcularMediaIdadePorTipoSanguineo();

    @Query("""
    SELECT new com.wktecnologyteste.wkteste.dto.CalcularQuantidadeDoadoresDTO(
        d.tipo_sanguineo, 
        COUNT(d) AS quantidadeDoadores
    )
    FROM Doadores d
    WHERE 
        (YEAR(CURDATE()) - YEAR(d.data_nasc)) BETWEEN 16 AND 69 
        AND d.peso > 50
        AND (
            (d.tipo_sanguineo = 'A+' AND d.tipo_sanguineo IN ('A+', 'AB+')) OR
            (d.tipo_sanguineo = 'A-' AND d.tipo_sanguineo IN ('A+', 'A-', 'AB+', 'AB-')) OR
            (d.tipo_sanguineo = 'B+' AND d.tipo_sanguineo IN ('B+', 'AB+')) OR
            (d.tipo_sanguineo = 'B-' AND d.tipo_sanguineo IN ('B+', 'B-', 'AB+', 'AB-')) OR
            (d.tipo_sanguineo = 'AB+' AND d.tipo_sanguineo IN ('AB+')) OR
            (d.tipo_sanguineo = 'AB-' AND d.tipo_sanguineo IN ('AB+', 'AB-')) OR
            (d.tipo_sanguineo = 'O+' AND d.tipo_sanguineo IN ('A+', 'B+', 'O+', 'AB+')) OR
            (d.tipo_sanguineo = 'O-' AND d.tipo_sanguineo IN ('A+', 'B+', 'O+', 'AB+', 'A-', 'B-', 'O-', 'AB-'))
        )
    GROUP BY d.tipo_sanguineo
""")
    List<CalcularQuantidadeDoadoresDTO> calcularQuantidadeDoadores();

}
