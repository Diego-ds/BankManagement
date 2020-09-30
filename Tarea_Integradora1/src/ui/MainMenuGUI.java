package ui;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.layout.BorderPane;
import model.BankManagement;

public class MainMenuGUI {
	
	private BankManagement bank;
	private EnQueueGUI enqueueScreen;
	private SearchCostumerGUI searchCostumer;
	private RegisteredCostumersGUI registeredCostumers;
	
	 @FXML
	 private BorderPane mainPane;
	
    public MainMenuGUI(BankManagement bank) {
		this.bank = bank;
		this.enqueueScreen = new EnQueueGUI(bank,this);
		this.searchCostumer = new SearchCostumerGUI(bank, this);
		this.registeredCostumers = new RegisteredCostumersGUI(bank,this);
	}
    
   
    
	@FXML
    void enqueueCostumer(ActionEvent event) throws IOException {
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("fxmlFiles/QueueCostumer.fxml"));
    	fxmlLoader.setController(enqueueScreen);
    	
    	Parent enqueuePane = fxmlLoader.load();
    	mainPane.getChildren().clear();
    	mainPane.setCenter(enqueuePane);
    }

    @FXML
    void searchCostumer(ActionEvent event) throws IOException {
    	FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("fxmlFiles/SearchCostumer.fxml"));
    	fxmlLoader.setController(searchCostumer);
    	
    	Parent searchPane = fxmlLoader.load();
    	mainPane.getChildren().clear();
    	mainPane.setCenter(searchPane);

    }

    @FXML
    void showRegisteredUsers(ActionEvent event) throws IOException {
    	FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("fxmlFiles/RegisteredCostumers.fxml"));
    	fxmlLoader.setController(registeredCostumers);
    	
    	Parent costumersPane = fxmlLoader.load();
    	mainPane.getChildren().clear();
    	mainPane.setCenter(costumersPane);
    	registeredCostumers.initializeTableView(bank.hashToArray());
		registeredCostumers.initializeComboBox();
		
    }

    @FXML
    void visualizeQueue(ActionEvent event) throws IOException {
    	FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("fxmlFiles/VisualizeQueue.fxml"));
    	fxmlLoader.setController(registeredCostumers);
    	
    	Parent costumersPane = fxmlLoader.load();
    	mainPane.getChildren().clear();
    	mainPane.setCenter(costumersPane);
    }
    

	@FXML
	void aboutUs(ActionEvent event) {
		Alert alert = new Alert(Alert.AlertType.INFORMATION);
  	    alert.setHeaderText(null);
  	    alert.setTitle("About Us");
  	    alert.setContentText("We are MontoGarcia Enterprises");
  	    alert.showAndWait();
	}
    
    public BorderPane getMainPane() {
    	return mainPane;
    }
    
	@FXML
	public void goMenu() throws IOException {
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("fxmlFiles/MainMenu.fxml"));
    	fxmlLoader.setController(this);
    	
    	Parent enqueuePane = fxmlLoader.load();
    	getMainPane().getChildren().clear();
    	getMainPane().setCenter(enqueuePane);
		
	}

}
