package com.example.springboottests.controller;

import com.example.springboottests.api.ExchangeService;
import com.example.springboottests.model.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/exchange")
public class ExchangeController {

  private final ExchangeService<Transaction> exchangeService;

  @Autowired
  public ExchangeController(ExchangeService<Transaction> exchangeService) {
    this.exchangeService = exchangeService;
  }

  @PostMapping
  public ResponseEntity<String> exchange(Transaction transaction) {
    return new ResponseEntity<>(exchangeService.exchange(transaction), HttpStatus.ACCEPTED);
  }
}
