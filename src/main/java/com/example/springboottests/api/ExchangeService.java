package com.example.springboottests.api;

public interface ExchangeService<T> {

  String exchange(T transaction);
}
