package com.impacta.service;

import com.impacta.domain.Conta;
import com.impacta.domain.Endereco;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

@Service
public class ContaService {

    private static List<Conta> contas;

    private static List<Endereco> enderecos;

//    static{
//        contas = new ArrayList<>(List.of(new Conta(1L, "Renato Lessa", "Renato",
//                "2023-10-08", 3030303030L, 93939399393L, "renato.lessa@gmail.com", enderecos)));
//
//    }

    static {
        contas = new ArrayList<>(List.of(new Conta(1L, "Renato Lessa", "Renato",
                "2023-10-08", 3030303030L, 93939399393L, "renato.lessa@gmail.com", enderecos)));
        // address = new ArrayList<>(List.of(new Address(1)));
    }

    public List<Conta> listAll() {
        return contas;
    }

    public Conta findById(long id) {
        return contas.stream()
                .filter(account -> account.getId().equals(id))
                .findFirst()
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "Conta não encontrada!"));
    }

    public Conta save(Conta conta) {
        conta.setId(ThreadLocalRandom.current().nextLong(3, 100000));
        contas.add(conta);
        return conta;
    }

    public void delete(long id) {
        contas.remove((findById(id)));
    }

    public void replace(Conta conta) {
        delete(conta.getId());
        contas.add(conta);
    }


}
