package src.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DataUtil {

  public static String converterDateParaDataEHora(Date data) {
    SimpleDateFormat formatador = new SimpleDateFormat("dd/MM/YYYY HH:mm");
    return formatador.format(data);
  }
}
