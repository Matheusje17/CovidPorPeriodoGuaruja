package model;

import java.util.List;

import dao.ObitoDao;

public class Obito {
	private String periodo;
	private Integer quantidade;
	
	
	public Obito(String periodo, Integer quantidade) {
		this.periodo = periodo;
		this.quantidade = quantidade;
	}
	
	public Obito() {

	}

	public String getPeriodo() {
		return periodo;
	}
	public void setPeriodo(String periodo) {
		this.periodo = periodo;
	}

	public Integer getQuantidade() {
		return quantidade;
	}
	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}
	
	public List<Obito> listaObito() {
		//new ObitoperiodoDAO().getListaObitoperiodoOrdenadaXX();
		return new ObitoDao().getListaObito();
	}
	
	
	
	
}
