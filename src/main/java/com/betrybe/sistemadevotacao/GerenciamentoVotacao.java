package com.betrybe.sistemadevotacao;

import java.util.ArrayList;

/**
 * Classe que representa o gerenciamento da votação.
 */
public class GerenciamentoVotacao implements GerenciamentoVotacaoInterface {
  private ArrayList<PessoaCandidata> pessoasCandidatas = new ArrayList<PessoaCandidata>();
  private ArrayList<PessoaEleitora> pessoasEleitoras = new ArrayList<PessoaEleitora>();
  private ArrayList<String> cpfsComputados = new ArrayList<String>();

  public GerenciamentoVotacao() {
  }

  @Override
  public void cadastrarPessoaCandidata(String nome, int numero) {
    if (this.pessoasCandidatas.size() == 0) {
      pessoasCandidatas.add(new PessoaCandidata(nome, numero));
      return;
    }
    if (numeroCandidatoValido(numero)) {
      System.out.println("Número da pessoa candidata já utilizado!");
      return;
    }
    pessoasCandidatas.add(new PessoaCandidata(nome, numero));
  }

  @Override
  public void cadastrarPessoaEleitora(String nome, String cpf) {
    if (this.pessoasEleitoras.size() == 0) {
      pessoasEleitoras.add(new PessoaEleitora(nome, cpf));
      return;
    }
    if (cpfCadastrado(cpf)) {
      System.out.println("Pessoa eleitora já cadastrada!");
      return;
    }
    pessoasEleitoras.add(new PessoaEleitora(nome, cpf));
  }

  @Override
  public void votar(String cpfPessoaEleitora, int numeroPessoaCandidata) {
    if (cpfComputado(cpfPessoaEleitora)) {
      System.out.println("Pessoa eleitora já votou!");
      return;
    }
    for (PessoaCandidata pessoaCandidata : pessoasCandidatas) {
      if (pessoaCandidata.getNumero() == numeroPessoaCandidata) {
        pessoaCandidata.receberVoto();
        cpfsComputados.add(cpfPessoaEleitora);
        return;
      }
    }
  }

  @Override
  public void mostrarResultado() {
    if (this.cpfsComputados.size() == 0) {
      System.out.println("É preciso ter pelo menos um voto para mostrar o resultado.");
      return;
    }
    for (PessoaCandidata pessoaCandidata : pessoasCandidatas) {
      float percentualVotos = (float) pessoaCandidata.getVotos() / this.cpfsComputados.size()
          * 100;
      System.out.println(
          "Nome: " + pessoaCandidata.getNome() + " - " + pessoaCandidata.getVotos()
              + " votos " + "( " + Math.round(percentualVotos) + "% )");
    }
    System.out.println("Total de votos: " + this.cpfsComputados.size());
  }

  private boolean numeroCandidatoValido(int numero) {
    for (PessoaCandidata pessoaCandidata : pessoasCandidatas) {
      if (pessoaCandidata.getNumero() == numero) {
        return true;
      }
    }
    return false;
  }

  private boolean cpfCadastrado(String cpf) {
    for (PessoaEleitora pessoaEleitora : pessoasEleitoras) {
      if (pessoaEleitora.getCpf().equals(cpf)) {
        return true;
      }
    }
    return false;
  }

  private boolean cpfComputado(String cpf) {
    for (String cpfComputado : cpfsComputados) {
      if (cpfComputado.equals(cpf)) {
        return true;
      }
    }
    return false;
  }
}
