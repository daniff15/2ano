package Testes.TESTE2020.DEUMERDA;

import java.util.Iterator;
import java.util.Map;

public interface CatologAdmin extends Iterable<String> {
    
    boolean registarServico(String codigo, Servico servico);
    boolean verificarServico(String codigo);
    Servico removerServico(String codigo);
    Iterator<String> iterator();
    Servico selecionarServico(String string);
	public Map<String, Servico> getServicos();


}
