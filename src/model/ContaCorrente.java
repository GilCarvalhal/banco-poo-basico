package src.model;

import java.util.Date;
import src.utils.DataUtil;

public class ContaCorrente extends ContaBancaria {

  public ContaCorrente(
    String agencia,
    String conta,
    Integer digito,
    Double saldoInicial
  ) {
    super(agencia, conta, digito, saldoInicial);
  }

  @Override
  public void imprimirExtrato() {
    System.out.println("******************************");
    System.out.println("****** Extrato Bancario ******");
    System.out.println("****************************** \n");

    System.out.println(
      "Gerado em: " + DataUtil.converterDateParaDataEHora(new Date()) + "\n"
    );

    // Para cada Movimentacao dentro de movimentacoes...
    for (Movimentacao movimentacao : this.movimentacoes) {
      System.out.println(movimentacao + "\n");
    }
    System.out.println("******************************");
    System.out.println("******************************");
    System.out.println("****************************** \n");
  }
}
