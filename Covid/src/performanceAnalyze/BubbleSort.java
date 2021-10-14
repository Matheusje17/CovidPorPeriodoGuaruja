package performanceAnalyze;

import java.util.List;

import model.Obito;

public class BubbleSort {
	
	private double tempoGasto;
	
	
	public List<Obito> retornaOrdenado(List<Obito> obitos){
		long tInicial = System.currentTimeMillis();
		Obito aux;
		
		for (int i = 0; i < obitos.size();i++) {
			for (int j = 0; j < obitos.size() - 1; j++) {
				if(obitos.get(j).getQuantidade() > obitos.get(j+1).getQuantidade()) {
					aux = new Obito(obitos.get(j).getPeriodo(), obitos.get(j).getQuantidade());
					obitos.get(j).setPeriodo(obitos.get(j +1).getPeriodo());
					obitos.get(j).setQuantidade(obitos.get(j +1).getQuantidade());
					obitos.get(j+1).setPeriodo(aux.getPeriodo());
					obitos.get(j+1).setQuantidade(aux.getQuantidade());
				}
			}
				
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
