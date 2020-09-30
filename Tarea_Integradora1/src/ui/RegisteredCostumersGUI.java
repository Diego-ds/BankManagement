package ui;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import model.BankManagement;
import model.Client;

public class RegisteredCostumersGUI {
	
	private BankManagement bank;
	private MainMenuGUI mainMenu;
	private ArrayList<Client> costumers;
	
    public RegisteredCostumersGUI(BankManagement bank, MainMenuGUI mainMenu) {
		this.bank = bank;
		this.mainMenu = mainMenu;
	}
    
    @FXML
    private TableView<Client> table;
    
	@FXML
    private TableColumn<Client, String> nameColumn;

    @FXML
    private TableColumn<Client, String> idColumn;

    @FXML
    private TableColumn<Client, String> dateColumn;

    @FXML
    private TableColumn<Client, String> amountColumn;

    @FXML
    private ComboBox<String> comboBox;

    @FXML
    void sortCostumers(ActionEvent event) {
    	
    }
    
    public void initializeComboBox() {
    	comboBox.getItems().clear();
    	comboBox.setValue("Ordenar por ID");
    	comboBox.getItems().addAll("Sort by ID","Sort by name","Sort by Amount","Sort by Date");
    }
    
    public void initializeTableView(ArrayList<Client> costumers) {
    	ObservableList<Client> obs = FXCollections.observableArrayList(costumers);
	 	table.setItems(obs);
	 	nameColumn.setCellValueFactory(new PropertyValueFactory<Client,String>("name"));
	 	idColumn.setCellValueFactory(new PropertyValueFactory<Client,String>("id"));
	 	dateColumn.setCellValueFactory(new PropertyValueFactory<Client,String>("registerDate"));
	 	amountColumn.setCellValueFactory(new PropertyValueFactory<Client,String>("accountBalance"));
	 	
    }

    @FXML
    void goBack(ActionEvent event) throws IOException {
       	FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("fxmlFiles/MainMenu.fxml"));
    	fxmlLoader.setController(mainMenu);
    	
    	Parent mainMenuPane = fxmlLoader.load();
    		
    	mainMenu.getMainPane().getChildren().clear();
    	mainMenu.getMainPane().setCenter(mainMenuPane);

    }
}

