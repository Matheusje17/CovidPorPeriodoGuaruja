package dao;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import model.Obito;

public class ObitoDao {
	
	public List<Obito> getListaObito() {
		
		List <Obito> listObitos = new ArrayList<>();
		//C:\WorkSpaces\Aps\Covid\Covid\src\dao\TabelaAps.txt
		String path = "TabelaAps.txt";
		try (BufferedReader br = new BufferedReader(new FileReader(path))) {
			String line = br.readLine();
			while (line != null) {
				Obito obito = new Obito();
				String[] fields = line.split(",");
				String periodo = fields[0];
				int numero = Integer.parseInt(fields[1]);
				
				obito.setPeriodo(periodo);
				obito.setQuantidade(numero);
				listObitos.add(obito);
				line = br.readLine();
				

			}
		return listObitos;
		} catch (IOException e) {
			System.out.println("Error: " + e.getMessage());
			return null;
		}
	}
}
