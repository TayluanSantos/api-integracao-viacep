package com.example.api_cep_integracao.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Cep {
    private String complemento;
    private String logradouro;
    private String bairro;
    private String localidade;
    private String uf;
}
