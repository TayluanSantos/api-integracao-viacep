package com.example.api_cep_integracao.controller;

import com.example.api_cep_integracao.dto.Cep;
import com.example.api_cep_integracao.service.CepService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class CepController {
    private final CepService service;

    public CepController(CepService service){
        this.service = service;
    }

    @GetMapping(value = "/cep/{cep}/{formato}")
    public Cep buscarPorCep (@PathVariable(value = "cep") String cep,
                             @PathVariable(value = "formato") String formato){
        return service.buscarPorCep(cep,formato);
    }

    @GetMapping(value = "/endereco/{uf}/{cidade}/{logradouro}/{formato}")
    public List<Cep> buscarPorEndereco(@PathVariable String uf,
                                       @PathVariable String cidade,
                                       @PathVariable String logradouro,
                                       @PathVariable String formato){
        return service.buscarPorEndereco(uf,cidade,logradouro,formato);
    }
}
