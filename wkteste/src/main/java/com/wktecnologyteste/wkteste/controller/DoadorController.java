package com.wktecnologyteste.wkteste.controller;

import com.wktecnologyteste.wkteste.dto.*;
import com.wktecnologyteste.wkteste.services.DoadorServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/candidatos")
@RestController
public class DoadorController {
    @Autowired
    private DoadorServices doadorServices;

    @PostMapping()
    public ResponseEntity createDoador(@RequestBody List<DoadorRequestDto> doadores) {
        return doadorServices.register(doadores);
    }

    @GetMapping()
    public ResponseEntity<List<CandidatosPorEstadoDTO>> candidatosPorEstado(){
        return doadorServices.listCandidatosPorEstado();
    }

    @GetMapping("/total")
    public ResponseEntity totalCandidatos(){
        return doadorServices.totalCandidatos();
    }
    @GetMapping("/imc-genero")
    public ResponseEntity<List<IMCPorGenero>> imc(){
        return doadorServices.ListImcPorGenero();
    }

    @GetMapping("/imc-faixaetaria")
    public ResponseEntity<List<IMCFaixaEtariaDTO>> imcFaixaEtaria(){
        return doadorServices.listImcFaixaEtaria();
    }

    @GetMapping("/imc/resultado")
    public ResponseEntity<IMCObesidadeResultadoDTO> resultadoIMC(){

        return doadorServices.listIMCObesidadeResultado();
    }


    @GetMapping("/media-idade-tipo-sanguineo")
    public ResponseEntity<List<MediaIdadeTipoSanguineoDTO>> mediaIdadeTipoSanguineo(){
        return doadorServices.mediaIdadeTipoSanguineo();
    }

    @GetMapping("/quantidade-doadores")
    public ResponseEntity<List<CalcularQuantidadeDoadoresDTO>> quantidadeDoadores(){
        return doadorServices.calcularQuantidadeDoadores();
    }
}
