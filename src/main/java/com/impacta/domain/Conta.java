package com.impacta.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
public class Conta {

    private Long id;
    private String nome;
    private String nomeSocial;
    private String dataNascimento;
    private long rg;
    private long cpf;
    private String email;




    private List<Endereco> enderecos = new ArrayList<>();

}
