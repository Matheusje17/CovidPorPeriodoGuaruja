package performanceAnalyze;

import java.util.List;

import model.Obito;

public class InsertionSort {
	
	private double tempoGasto;
	
	public List<Obito> retornaOrdenado(List<Obito> obitos){
		long tInicial = System.currentTimeMillis();
		Obito aux;
		int j;
		
		for (int i = 0; i < obitos.size();i++) {
			aux = new Obito(obitos.get(i).getPeriodo(),obitos.get(i).getQuantidade());
			j = i - 1;
			while((j >= 0) && obitos.get(j).getQuantidade() > aux.getQuantidade()) {
				obitos.get(j + 1).setPeriodo(obitos.get(j).getPeriodo());
				obitos.get(j + 1).setQuantidade(obitos.get(j).getQuantidade());
				j = j -1;
			}
			obitos.get(j + 1).setQuantidade(aux.getQuantidade());
			obitos.get(j + 1).setPeriodo(aux.getPeriodo());
				
		}
		long tFinal = System.currentTimeMillis();
		
		tempoGasto = tFinal - tInicial;
		
		return obitos;
		
	}
	
	
	public String getTempo() {
		
		String t = String.format("%.7f", tempoGasto);
		return t;
	}
}
