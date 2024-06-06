package com.example.api_cep_integracao.service;

import com.example.api_cep_integracao.client.ViaCepClient;
import com.example.api_cep_integracao.dto.Cep;
import com.example.api_cep_integracao.exception.exceptions.CepInvalidoException;
import com.example.api_cep_integracao.utils.CepUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@Slf4j
public class CepService {
    private final ViaCepClient client;

    public CepService(ViaCepClient client){
        this.client = client;
    }

    public Cep buscarPorCep(String cep,String formato) {

        log.info("Buscando por CEP");
        try {
            CepUtil.validarCep(cep);
        } catch (CepInvalidoException ex) {
           log.error("CEP inválido: " + cep);
           throw ex;
        }
        return client.buscarPorCep(cep, formato);
    }

    public List<Cep> buscarPorEndereco(String uf, String cidade, String logradouro,String formato){

        log.info("Buscando por endereço");

        try {
            CepUtil.validarEndereco(cidade,logradouro);
        } catch (CepInvalidoException ex) {
            log.error("Endereço inválido.");
            throw ex;
        }

        return client.buscarPorEndereco(uf,cidade,logradouro,formato);
    }
}
