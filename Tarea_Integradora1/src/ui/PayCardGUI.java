package ui;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.TextField;
import model.BankManagement;

public class PayCardGUI {

	private BankManagement bank;
	private MainMenuGUI mainMenu;
	private SearchCostumerGUI searchCostumer;
	
	public PayCardGUI(BankManagement bank, MainMenuGUI mainMenu,SearchCostumerGUI searchCostumer ) {
		
		this.bank = bank;
		this.mainMenu = mainMenu;
		this.searchCostumer=searchCostumer;
	}
	
	
	
    @FXML
    private TextField amountToPay;

    @FXML
    void payCard(ActionEvent event) throws IOException {
    	
    	FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("fxmlFiles/MainMenu.fxml"));
    	fxmlLoader.setController(mainMenu);
    	
    	Parent mainMenuPane = fxmlLoader.load();
    		
    	mainMenu.getMainPane().getChildren().clear();
    	mainMenu.getMainPane().setCenter(mainMenuPane);
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
