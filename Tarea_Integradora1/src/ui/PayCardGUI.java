package ui;

import java.io.IOException;

import exceptions.InsufficientFundsException;
import exceptions.QueueIsAlreadyFullException;
import exceptions.QueueIsEmptyException;
import exceptions.UserNotFoundException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
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
    private TextField iD;


    @FXML
    void payCard(ActionEvent event)  {
    	String id = iD.getText();
    	double amount = Double.parseDouble(amountToPay.getText());
    	try {
			bank.modifyBalance(id, amount);
			iD.setText("");
			Alert alert = new Alert(Alert.AlertType.INFORMATION);
      	    alert.setHeaderText(null);
      	    alert.setTitle("Done");
      	    alert.setContentText("Operation was successfully done");
      	    alert.showAndWait();
		} catch (UserNotFoundException e) {
			Alert alert = new Alert(Alert.AlertType.ERROR);
      	    alert.setHeaderText(null);
      	    alert.setTitle("Error");
      	    alert.setContentText("User dont exist");
      	    alert.showAndWait();
		} catch (QueueIsAlreadyFullException e) {
			
		} catch (QueueIsEmptyException e) {
			
		} catch (InsufficientFundsException e) {
			Alert alert = new Alert(Alert.AlertType.ERROR);
      	    alert.setHeaderText(null);
      	    alert.setTitle("Error");
      	    alert.setContentText("Theres no sufficient funds to do this operation");
      	    alert.showAndWait();
		}
		
    }
    
    @FXML
    void goBack(ActionEvent event) throws IOException {
       	FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("fxmlFiles/SearchCostumer.fxml"));
    	fxmlLoader.setController(searchCostumer);
    	
    	Parent mainMenuPane = fxmlLoader.load();
    		
    	mainMenu.getMainPane().getChildren().clear();
    	mainMenu.getMainPane().setCenter(mainMenuPane);

    }

}
