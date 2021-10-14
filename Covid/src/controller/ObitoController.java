package controller;

import java.util.List;

import model.Obito;

public class ObitoController {
	
	public List<Obito> listaObitos() {

		return new Obito().listaObito(); 
	}
	
}
