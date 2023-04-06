package src;

import src.model.ContaCorrente;
import src.model.ContaPoupanca;
import src.utils.DataUtil;

public class App {

  public static void main(String[] args) {
    System.out.println("Criando nosso banco digital \n");

    ContaCorrente conta = new ContaCorrente("0001", "7542", 5, 100.0);
    System.out.println("Saldo da conta atualmente " + conta.getSaldo() + "\n");

    conta.depositar(250.0);
    System.out.println("Saldo da conta atualmente " + conta.getSaldo() + "\n");

    conta.sacar(100.0);
    System.out.println("Saldo da conta atualmente " + conta.getSaldo() + "\n");

    ContaPoupanca conta2 = new ContaPoupanca("0001", "7543", 6, 200.0);
    conta2.transferir(100.0, conta);
    System.out.println("Saldo conta destino de R$ " + conta2.getSaldo() + "\n");

    System.out.println("Saldo atual de R$ " + conta.getSaldo() + "\n");

    System.out.println(conta2.getDataAbertura());

    // DataUtil util = new DataUtil();
    {
      String formatado = DataUtil.converterDateParaDataEHora(
        conta2.getDataAbertura()
      );
      System.out.println(formatado);
    }

    // Extrato bancario é composto por movimentações bancárias.
    // Ter algo que possa ser movimentado
    // Ter uma lista de movimentações

    // Conta corrente
    conta.imprimirExtrato();

    // Conta poupança
    conta2.imprimirExtrato();
  }
}
