package gui;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class TabelaObito {
	private final SimpleStringProperty periodo;
	private final SimpleIntegerProperty quantidade;
	
	public TabelaObito(String periodo, Integer quantidade) {
		super();
		this.periodo = new SimpleStringProperty(periodo);
		this.quantidade = new SimpleIntegerProperty(quantidade);
	}
	
	public String getPeriodo() {
		return periodo.get();
	}
	public Integer getQuantidade() {
		return quantidade.get();
	}
}
