package br.com.rinha.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/status")
public class StatusController {

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<String> status() {

        return ResponseEntity.status(HttpStatus.OK)
                .body("Status");
    }
}
