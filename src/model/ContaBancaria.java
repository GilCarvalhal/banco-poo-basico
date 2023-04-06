package src.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.InputMismatchException;

public abstract class ContaBancaria {

  //#region Atributos
  protected String agencia;

  protected String conta;

  protected Integer digito;

  protected Double saldo;

  protected Date dataAbertura;

  protected ArrayList<Movimentacao> movimentacoes;

  protected Double VALOR_MINIMO_DEPOSITO = 10.0;

  //#endregion

  //#region Construtores
  public ContaBancaria(
    String agencia,
    String conta,
    Integer digito,
    Double saldoInicial
  ) {
    this.agencia = agencia;
    this.conta = conta;
    this.digito = digito;
    this.saldo = saldoInicial;
    this.dataAbertura = new Date();

    // Se não instanciar, vai dar uma exception de nullPointerException.
    this.movimentacoes = new ArrayList<Movimentacao>();

    // Criando a nossa primeira movimentação.
    Movimentacao movimentacoes = new Movimentacao(
      "Abertura de conta",
      saldoInicial
    );
    // Aqui estou salvando a movimentação dentro do meu array de movimentações.
    // Iniciando o meu extrato bancário.
    this.movimentacoes.add(movimentacoes);
  }

  //#endregion

  //#region Getters e Setters

  public String getAgencia() {
    return agencia;
  }

  public void setAgencia(String agencia) {
    this.agencia = agencia;
  }

  public Integer getDigito() {
    return digito;
  }

  public void setDigito(Integer digito) {
    this.digito = digito;
  }

  public String getConta() {
    return conta;
  }

  public void setConta(String conta) {
    this.conta = conta;
  }

  public Double getSaldo() {
    return saldo;
  }

  public Date getDataAbertura() {
    return dataAbertura;
  }

  //#endregion

  //#region Métodos

  public void depositar(Double valor) {
    // Verifica se o valor de deposito é menor que o valor minimo
    // Se for não pode acontecer deposito
    if (saldo < VALOR_MINIMO_DEPOSITO) {
      throw new InputMismatchException(
        "O valor minimo para deposito é R$" + VALOR_MINIMO_DEPOSITO
      );
    } else this.saldo += valor; // Efetua o deposito somando o valor ao saldo.

    // Aqui faço a movimentação do extrato.
    Movimentacao movimentacoes = new Movimentacao("Deposito", valor);
    this.movimentacoes.add(movimentacoes);
  }

  public Double sacar(Double valor) {
    // Verifica se o valor é maior que o saldo da conta.
    // Se for, manda mensagem de saldo insuficiente
    if (valor > saldo) {
      throw new InputMismatchException("O saldo é insuficiente");
    }
    // Efetua o saque subtraindo o valor do saldo.
    this.saldo -= valor;

    // Aqui faço a movimentação do extrato.
    Movimentacao movimentacoes = new Movimentacao("Retirada do valor", valor);
    this.movimentacoes.add(movimentacoes);

    // Retorna o valor sacado ao usuário
    return valor;
  }

  public void transferir(Double valor, ContaBancaria contaDestino) {
    this.sacar(valor);

    contaDestino.depositar(valor);
  }

  //#endregion

  // Metodo abstrato obriga as classes que estão herdando de implementarem este metodo.
  public abstract void imprimirExtrato();
}
