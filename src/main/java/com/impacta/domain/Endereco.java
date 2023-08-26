package com.impacta.domain;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Endereco {

    private String nomeRua;
//    private int numero;
//    private String cep;
//    private String cidade;
//    private String estado;
//    private String pais;

    @JsonIgnore
    private Conta conta;


    }





