package Testes.TESTE2020.DEUMERDA;

import java.util.ArrayList;
import java.util.List;

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
      logs.add(msg);
    }
  
    public boolean registarServico(CatologAdmin ctg, String codigo, Servico servico) {
      this.addLog("REGISTADO: CODIGO '" + codigo + "' SERVIÇO '" + servico + "'");
      return ctg.registarServico(codigo, servico);
    }
  
    public Servico removerServico(CatologAdmin ctg, String codigo) {
      Servico s = ctg.removerServico(codigo);
      this.addLog("ELIMINADO: CODIGO '" + codigo + "' SERVIÇO '" + s + "'");
      return s;
    }
  
    public List<String> logs() {
        return logs;
    }
    
}
