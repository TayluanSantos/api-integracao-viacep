package com.example.api_cep_integracao.client;

import com.example.api_cep_integracao.dto.Cep;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "viaCepClient",url = "https://viacep.com.br/ws/")
public interface ViaCepClient {
    @GetMapping("{cep}/{formato}")
    public Cep buscarPorCep(@PathVariable String cep,@PathVariable String formato);
    @GetMapping("{uf}/{cidade}/{logradouro}/{formato}")
    public List<Cep> buscarPorEndereco(@PathVariable String uf,
                                       @PathVariable String cidade,
                                       @PathVariable String logradouro,
                                       @PathVariable String formato);

}
