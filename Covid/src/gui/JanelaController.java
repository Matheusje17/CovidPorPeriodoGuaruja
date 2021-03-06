package gui;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import controller.ObitoController;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import model.Obito;
import performanceAnalyze.BubbleSort;
import performanceAnalyze.InsertionSort;
import performanceAnalyze.QuickSort;

public class JanelaController implements Initializable{
	@FXML
	private TableView<TabelaObito> tb_Covid;
	
	@FXML
	private Label lblMetodo = new Label();
	
	@FXML
	private Label lblTempo = new Label();
	
	@FXML
	private Button btnBubbleSort = new Button();
	
	@FXML
	private Button btnInsertionSort = new Button();
	
	@FXML
	private Button btnQuickSort = new Button();
	
	@FXML
	private TableColumn<TabelaObito, String> c_Periodo;
	
	@FXML
	private TableColumn<TabelaObito, Integer> c_Quantidade;
	
	private ObitoController oc = new ObitoController();
	private BubbleSort bubble= new BubbleSort();
	private InsertionSort insert= new InsertionSort();
	private QuickSort quick= new QuickSort();
	
	
	private List<Obito> obitoBubble = bubble.retornaOrdenado(oc.listaObitos());
	private ObservableList<TabelaObito> listTabelaBubble = FXCollections.observableArrayList();
	
	private List<Obito> obitoInsert = insert.retornaOrdenado(oc.listaObitos());
	private ObservableList<TabelaObito> listTabelaInsert = FXCollections.observableArrayList();
	
	private List<Obito> obitoQuick = quick.retornaOrdenado(oc.listaObitos());
	private ObservableList<TabelaObito> listTabelaQuick = FXCollections.observableArrayList();
	
	private List<Obito> obito = oc.listaObitos();
	private ObservableList<TabelaObito> listTabelaObito = FXCollections.observableArrayList();


	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
	
		listarObitos();
	}
	
	public void listarObitos() {
		
		for (Obito listObito : obito ) {
			TabelaObito t = new TabelaObito(listObito.getPeriodo(), listObito.getQuantidade());
			listTabelaObito.add(t);
		}
		
		c_Periodo.setCellValueFactory(new PropertyValueFactory<TabelaObito,String>("Periodo"));
		c_Quantidade.setCellValueFactory(new PropertyValueFactory<TabelaObito,Integer>("Quantidade"));
		
		tb_Covid.setItems(listTabelaObito);
	}
	
	
	@FXML
	public void listarBubbleSort() {
		if(!listTabelaBubble.isEmpty()) {
			listTabelaBubble.clear();
		}
		
		lblMetodo.setText(btnBubbleSort.getText());
		lblTempo.setText(bubble.getTempo() + " ms");
		
		for (Obito listObito : obitoBubble ) {
			TabelaObito t = new TabelaObito(listObito.getPeriodo(), listObito.getQuantidade());
			listTabelaBubble.add(t);
		}
		
		c_Periodo.setCellValueFactory(new PropertyValueFactory<TabelaObito,String>("Periodo"));
		c_Quantidade.setCellValueFactory(new PropertyValueFactory<TabelaObito,Integer>("Quantidade"));
		
		tb_Covid.setItems(listTabelaBubble);
	}
	
	@FXML
	public void listarInsertionSort() {
		if(!listTabelaInsert.isEmpty()) {
			listTabelaInsert.clear();
		}
		
		lblMetodo.setText(btnInsertionSort.getText());
		lblTempo.setText(insert.getTempo() + " ms");
		
		for (Obito listObito : obitoInsert ) {
			TabelaObito t = new TabelaObito(listObito.getPeriodo(), listObito.getQuantidade());
			listTabelaInsert.add(t);
		}
		
		c_Periodo.setCellValueFactory(new PropertyValueFactory<TabelaObito,String>("Periodo"));
		c_Quantidade.setCellValueFactory(new PropertyValueFactory<TabelaObito,Integer>("Quantidade"));
		
		tb_Covid.setItems(listTabelaInsert);
	}
	
	@FXML
	public void listarQuickSort() {
		if(!listTabelaQuick.isEmpty()) {
			listTabelaQuick.clear();
		}
		
		lblMetodo.setText(btnQuickSort.getText());
		lblTempo.setText(quick.getTempo() + "ms");
		
		for (Obito listObito : obitoQuick ) {
			TabelaObito t = new TabelaObito(listObito.getPeriodo(), listObito.getQuantidade());
			listTabelaQuick.add(t);
		}
		
		c_Periodo.setCellValueFactory(new PropertyValueFactory<TabelaObito,String>("Periodo"));
		c_Quantidade.setCellValueFactory(new PropertyValueFactory<TabelaObito,Integer>("Quantidade"));
		
		tb_Covid.setItems(listTabelaQuick);
	}








}
