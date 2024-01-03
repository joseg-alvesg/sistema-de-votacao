package com.betrybe.sistemadevotacao;

import java.util.Scanner;

/**
 * Classe que representa o gerenciamento da votação.
 */
public class Principal {
  private static GerenciamentoVotacao gerenciamentoVotacao = new GerenciamentoVotacao();
  private static Scanner scanner = new Scanner(System.in);

  /**
   * Método principal.
   */
  public static void main(String[] args) {
    int opcao = cadastrarCandidato();
    while (opcao != 2) {
      opcao = cadastrarCandidato();
    }
    opcao = cadastrarEleitor();
    while (opcao != 2) {
      opcao = cadastrarEleitor();
    }
    while (opcao != 3) {
      opcao = votacao();
    }
  }

  /**
   * Método que verifica se o número da pessoa candidata é válido.
   */
  public static int cadastrarCandidato() {
    System.out.println("Cadastrar pessoa candidata?");
    System.out.println("1 - Sim");
    System.out.println("2 - Não");
    System.out.println("Entre com o número da opção desejada: ");
    int opcao = scanner.nextInt();
    if (opcao == 1) {
      System.out.println("Entre com o nome da pessoa candidata: ");
      String nome = scanner.next();
      System.out.println("Entre com o número da pessoa candidata: ");
      int numero = scanner.nextInt();
      gerenciamentoVotacao.cadastrarPessoaCandidata(nome, numero);
      return opcao;
    }
    return opcao;
  }

  /**
   * Método que verifica se o cpf da pessoa eleitora é válido.
   */
  public static int cadastrarEleitor() {
    System.out.println("Cadastrar pessoa eleitora?");
    System.out.println("1 - Sim");
    System.out.println("2 - Não");
    System.out.println("Entre com o número da opção desejada: ");
    int opcao = scanner.nextInt();
    if (opcao == 1) {
      System.out.println("Entre com o nome da pessoa eleitora: ");
      String nome = scanner.next();
      System.out.println("Entre com o cpf da pessoa eleitora: ");
      String cpf = scanner.next();
      gerenciamentoVotacao.cadastrarPessoaEleitora(nome, cpf);
      return opcao;
    }
    return opcao;
  }

  /**
   * Método que verifica se o cpf da pessoa eleitora é válido.
   */
  public static int votacao() {
    System.out.println("Entre com o número correspondente a opção desejada:");
    System.out.println("1 - Votar");
    System.out.println("2 - Resultado Parcial");
    System.out.println("3 - Finalizar votação");
    int opcao = scanner.nextInt();
    switch (opcao) {
      case 1:
        System.out.println("Entre com o cpf da pessoa eleitora: ");
        String cpf = scanner.next();
        System.out.println("Entre com o número da pessoa candidata: ");
        int numero = scanner.nextInt();
        gerenciamentoVotacao.votar(cpf, numero);
        return opcao;
      case 2:
        gerenciamentoVotacao.mostrarResultado();
        return opcao;
      case 3:
        gerenciamentoVotacao.mostrarResultado();
        return opcao;
      default:
        System.out.println("Opção inválida!");
        break;
    }
    return opcao;
  }
}
