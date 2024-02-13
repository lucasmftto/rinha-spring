package br.com.rinha.controller;

import br.com.rinha.controller.resource.TransactionResource;
import br.com.rinha.domain.*;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/clientes")
public class TransactionController {

    @PostMapping(path = "/{id}/transacoes", consumes = "application/json", produces = "application/json")
    public ResponseEntity<TransactionCarried> newTransaction(@PathVariable Integer id,
                                                             @RequestBody @Valid TransactionResource transactionResource) {

        TransactionCarried body = new TransactionCarried();
        body.setLimite(2314);
        body.setSaldo(543);

        System.out.println("Thread: " + Thread.currentThread().getName() + " - " + LocalDateTime.now());
        return ResponseEntity.status(HttpStatus.OK).body(body);
    }

    @GetMapping(path = "/{id}/extrato", produces = "application/json")
    public ResponseEntity<Statement> statement(@PathVariable Integer id) {
        Statement statement = new Statement();
        Balance saldo = new Balance();
        saldo.setData_extrato(LocalDateTime.now());
        saldo.setLimite(1000);
        saldo.setTotal(9999);
        statement.setSaldo(saldo);
        Transaction e1 = new Transaction();
        e1.setDescricao("Compra de pão");
        e1.setValor(10);
        e1.setTipo(TransactionType.c);
        e1.setRealizada_em(LocalDateTime.now());

        statement.setUltimas_transacoes(List.of(e1));

        System.out.println("Thread: " + Thread.currentThread().getName() + " - " + LocalDateTime.now());

        return ResponseEntity.status(HttpStatus.OK).body(statement);
    }
}
