package com.example.service;

public class Service {
  private String privateMessage() {
    return "Hello World!";
  }

  public static String staticMessage() {
    return "Hello World!";
  }

  public final String finalMessage() {
    return "Hello World!";
  }
}