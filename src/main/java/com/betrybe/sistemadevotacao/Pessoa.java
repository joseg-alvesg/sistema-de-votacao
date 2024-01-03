package com.betrybe.sistemadevotacao;

/**
 * Classe abstrata que representa uma pessoa.
 */
public abstract class Pessoa {
  private String nome;

  public Pessoa() {
  }

  public Pessoa(String nome) {
    this.nome = nome;
  }

  public String getNome() {
    return nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }
}
