package com.example.springboottests.controller;

import com.example.springboottests.api.ExchangeService;
import com.example.springboottests.model.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/exchange")
public class ExchangeController implements ExchangeService<Transaction>{

  private final ExchangeService<Transaction> exchangeService;

  @Autowired
  public ExchangeController(ExchangeService<Transaction> exchangeService) {
    this.exchangeService = exchangeService;
  }

  @Override
  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  public String exchange(Transaction transaction) {
    return exchangeService.exchange(transaction);
  }
}
