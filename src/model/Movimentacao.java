package src.model;

import java.util.Date;
import src.utils.DataUtil;

public class Movimentacao {

  //#region Atributos
  private String descricao;

  private Date data;

  private Double valor;

  //#endregion

  //#region Construtor
  public Movimentacao() {}

  public Movimentacao(String descricao, Double valor) {
    this.descricao = descricao;
    this.data = new Date();
    this.valor = valor;
  }

  //#endregion

  //#region Getters e Setters
  public String getDescricao() {
    return descricao;
  }

  public void setDescricao(String descricao) {
    this.descricao = descricao;
  }

  public Date getData() {
    return data;
  }

  public Double getValor() {
    return valor;
  }

  //#endregion

  @Override
  public String toString() {
    String dataFormatada = DataUtil.converterDateParaDataEHora(this.getData());
    return (
      this.getDescricao() + " \n " + dataFormatada + " - R$ " + this.getValor()
    );
  }
}
