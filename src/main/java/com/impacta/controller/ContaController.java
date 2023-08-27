package com.impacta.controller;

import com.impacta.domain.Conta;
import com.impacta.service.ContaService;
import com.impacta.util.DataUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("coding-java")
@Log4j2
@RequiredArgsConstructor
public class ContaController {

    private final DataUtil dataUtil;
    private final ContaService contaService;

    @GetMapping("listar-todas-contas")
    public ResponseEntity<List<Conta>> list() {
        return new ResponseEntity<>(contaService.listAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Conta> findById(@PathVariable long id) {
        log.info(dataUtil.formatarDataLocal(LocalDateTime.now()));
        return  ResponseEntity.ok(contaService.findById(id));
    }

    @PostMapping("inserindo-conta")
    public ResponseEntity<Conta> save(@RequestBody Conta conta) {
        log.info(dataUtil.formatarDataLocal(LocalDateTime.now()));
        return new ResponseEntity<>(contaService.save(conta), HttpStatus.CREATED);

    }

    @PutMapping("/{idConta}")
    public ResponseEntity<Conta> replace(@RequestBody Conta conta) {
        log.info(dataUtil.formatarDataLocal(LocalDateTime.now()));
        contaService.replace(conta);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Conta> delete(@PathVariable long id) {
        log.info(dataUtil.formatarDataLocal(LocalDateTime.now()));
        contaService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }



}
