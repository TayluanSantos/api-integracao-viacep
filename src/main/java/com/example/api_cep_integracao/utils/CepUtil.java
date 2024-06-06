package com.example.api_cep_integracao.utils;

import com.example.api_cep_integracao.exception.exceptions.CepInvalidoException;
import com.example.api_cep_integracao.exception.exceptions.EnderecoInvalidoException;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CepUtil {
    public static void validarCep(String cep) {

        String regex = "^\\d{8}$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(cep);

        if (!matcher.matches()) {
            throw new CepInvalidoException("CEP inválido. Deve conter 8 dígitos e não pode conter caracteres alfanuméricos ou espaços.");
        }
    }

    public static void validarEndereco(String cidade, String logradouro) {

        String regexCidade = ".{3,}";
        Pattern patternCidade = Pattern.compile(regexCidade);
        Matcher matcherCidade = patternCidade.matcher(cidade);

        String regexLogradouro = ".{3,}";
        Pattern patternLogradouro = Pattern.compile(regexLogradouro);
        Matcher matcherLogradouro = patternLogradouro.matcher(logradouro);

        if (!matcherCidade.matches() || !matcherLogradouro.matches()) {
            throw new EnderecoInvalidoException("A cidade e o logradouro devem conter no mínimo 3 caracteres.");
        }
    }
}
