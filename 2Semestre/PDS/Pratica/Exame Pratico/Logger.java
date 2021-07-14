
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import miVersion.CatalogAdmin;
import miVersion.Servico;

public class Logger {
  private static Logger instance = null;
  private List<String> logs = new ArrayList<>();

  private Logger() {
  }

  public static Logger getInstance() {
    if (instance == null)
      return new Logger();
    return instance;
  }

  private void addLog(String msg) {
    SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
    logs.add("[" + formatter.format(new Date()) + "] " + msg);
  }

  public boolean registarServico(CatalogAdmin ctg, String codigo, Servico servico) {
    this.addLog("REGISTADO: CODIGO '" + codigo + "' SERVIÇO '" + servico + "'");
    return ctg.registarServico(codigo, servico);
  }

  public Servico removerServico(CatalogAdmin ctg, String codigo) {
    Servico s = ctg.removerServico(codigo);
    this.addLog("ELIMINADO: CODIGO '" + codigo + "' SERVIÇO '" + s + "'");
    return s;
  }

  public List<String> logs() {
    return logs;
  }
}
