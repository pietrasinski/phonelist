package phonelist.java.fx;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;


public class PhoneListController implements Initializable {
    @FXML private TableView<phonelist> tabela;
    @FXML private TableColumn<phonelist, String> nazwaColumn;
    @FXML private TableColumn<phonelist, String> numerColumn;
    @FXML private Stage stage;
    @FXML private Button add;
    @FXML private Button update;
    @FXML private Button delete;
    @FXML private TextField name;
    @FXML private TextField phone;
    String sciezka =("lista.txt");
    ArrayList<phonelist> lista = new ArrayList<phonelist>();
  

@FXML 
private void update(ActionEvent event) {
        try {
        	PrintWriter pw = new PrintWriter(sciezka);
            BufferedWriter bw = new BufferedWriter(pw);
            for(int i=0;i<lista.size();i++) {
            bw.write(lista.get(i).getNazwa()+"\t"+lista.get(i).getNumer()+"\n");
            }
            bw.close();
        } catch (IOException e) {
        }
    	
    	
    }
@FXML
private void dodaj(ActionEvent event) {
    	if(!name.getText().isEmpty() && !phone.getText().isEmpty()) {
		lista.add(new phonelist(name.getText(),phone.getText()));
		tworzenie(lista);
    	}
		
    }
@FXML
private void usun(ActionEvent event) {
    	if(tabela.getSelectionModel().getSelectedIndex()!=-1) {
    	lista.remove(tabela.getSelectionModel().getSelectedIndex());
    	tworzenie(lista);
    	}
    
    	
    }
    
   
   
private void ladujDane() {  	
        Path sciezkaDoPliku = Paths.get(sciezka);
        ArrayList<String> odczyt = new ArrayList<String>();
        try {
        
            odczyt = (ArrayList<String>) Files.readAllLines(sciezkaDoPliku);
        } catch (IOException ex) {
            System.out.println("Brak pliku!");
        }
        
        
        for(String s : odczyt) {
            String[] tab = s.split("\\t");
            if (tab.length > 1){
            	
                lista.add(new phonelist(tab[0], tab[1]));
            }
        }
        tworzenie(lista);  
    }

        public void tworzenie(ArrayList<phonelist> lista) {
        	ObservableList<phonelist> dane = FXCollections.observableArrayList(lista);
        	tabela.itemsProperty().setValue(dane);
        	nazwaColumn.setCellValueFactory(new PropertyValueFactory<phonelist, String>("nazwa"));
        	numerColumn.setCellValueFactory(new PropertyValueFactory<phonelist, String>("numer"));
        }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
    	ladujDane();
 
    }
    
}      