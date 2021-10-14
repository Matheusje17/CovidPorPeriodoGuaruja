package performanceAnalyze;

import java.util.List;

import controller.ObitoController;
import model.Obito;


public class QuickSort {
	ObitoController oc = new ObitoController();
//	
	private int esq = 0; 
	private int dir = (oc.listaObitos().size() - 1); 
	private double tempoGasto;
	
	
	public List<Obito> retornaOrdenado(List<Obito> obitos) {
		
		return quickSort(obitos, esq, dir); 
	
	}


	long tInicial = System.currentTimeMillis();
	private  List<Obito> quickSort(List<Obito> obitos, int esq , int dir) {

		if (esq < dir) {
			int j = separar(obitos, esq, dir);
			quickSort(obitos,esq,j-1);
			quickSort(obitos, j+1, dir);
			
		}
		
		
		
		return obitos;
		
	}
	
	private int separar(List<Obito >obitos, int esq, int dir) {

		
		int i = esq+1;
		int j = dir;
		Obito pivo = obitos.get(esq);
		while (i <= j) {
			if(obitos.get(i).getQuantidade() <= pivo.getQuantidade()) i++;
			else if(obitos.get(j).getQuantidade() > pivo.getQuantidade()) j--;
			else if (i <= j) {
				trocar(obitos, i, j);
				i++;
				j--;
			}
		}
		trocar (obitos, esq, j);
		return j;
	}
	private void trocar(List<Obito> obitos, int i, int j) {
		Obito aux = new Obito(obitos.get(i).getPeriodo(), obitos.get(i).getQuantidade());
		obitos.get(i).setPeriodo(obitos.get(j).getPeriodo());
		obitos.get(i).setQuantidade(obitos.get(j).getQuantidade());
		obitos.get(j).setPeriodo(aux.getPeriodo());
		obitos.get(j).setQuantidade(aux.getQuantidade());
		
	}
	
	long tFinal = System.currentTimeMillis();
	
	public String getTempo() {
		
		String t = String.format("%.7f", tempoGasto);
		return t;
	}
}
