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

public class DepositGUI {
	
	
	private BankManagement bank;
	private MainMenuGUI mainMenu;
	private SearchCostumerGUI searchCostumer;

	public DepositGUI(BankManagement bank, MainMenuGUI mainMenu,SearchCostumerGUI searchCostumer) {
		this.bank = bank;
		this.mainMenu = mainMenu;
		this.searchCostumer= searchCostumer;
	}
	
	@FXML
	private TextField idCamp;
	
    @FXML
    private TextField amountCamp;

    @FXML
    public void depositMoney(ActionEvent event) throws QueueIsAlreadyFullException, QueueIsEmptyException, IOException {
    	String id = idCamp.getText();
     	if(id.equals("")) {
     		Alert alert = new Alert(Alert.AlertType.ERROR);
      	    alert.setHeaderText(null);
      	    alert.setTitle("Error");
      	    alert.setContentText("Enter an identification to look for");
      	    alert.showAndWait();
     	}else {
     			try {
					bank.modifyAmount(id, Double.parseDouble(amountCamp.getText()));
					//Message indicating the operation
					Alert alert = new Alert(Alert.AlertType.INFORMATION);
		      	    alert.setHeaderText(null);
		      	    alert.setTitle("Done!");
		      	    alert.setContentText("Operation was successfully done");
		      	    alert.showAndWait();
		      	    //Go Back
		      	    goBack();
				} catch (NumberFormatException e) {
					Alert alert = new Alert(Alert.AlertType.ERROR);
		      	    alert.setHeaderText(null);
		      	    alert.setTitle("Error");
		      	    alert.setContentText("Enter a numeric amount");
		      	    alert.showAndWait();
				} catch (UserNotFoundException e) {
					Alert alert = new Alert(Alert.AlertType.ERROR);
		      	    alert.setHeaderText(null);
		      	    alert.setTitle("Error");
		      	    alert.setContentText(e.getMessage());
		      	    alert.showAndWait();
				} catch (InsufficientFundsException e) {
					Alert alert = new Alert(Alert.AlertType.ERROR);
		      	    alert.setHeaderText(null);
		      	    alert.setTitle("Error");
		      	    alert.setContentText(e.getMessage());
		      	    alert.showAndWait();
				} 	
     	}
    }

    @FXML
    public void retireMoney(ActionEvent event) throws QueueIsAlreadyFullException, QueueIsEmptyException, IOException {
    	String id = idCamp.getText();
     	if(id.equals("")) {
     		Alert alert = new Alert(Alert.AlertType.ERROR);
      	    alert.setHeaderText(null);
      	    alert.setTitle("Error");
      	    alert.setContentText("Enter an identification to look for");
      	    alert.showAndWait();
     	}else {
     			try {
					bank.modifyAmount(id, -(Double.parseDouble(amountCamp.getText())));
					//Message indicating the operation
					Alert alert = new Alert(Alert.AlertType.INFORMATION);
		      	    alert.setHeaderText(null);
		      	    alert.setTitle("Done!");
		      	    alert.setContentText("Operation was successfully done");
		      	    alert.showAndWait();
		      	    //Go Back
		      	    goBack();
				} catch (NumberFormatException e) {
					Alert alert = new Alert(Alert.AlertType.ERROR);
		      	    alert.setHeaderText(null);
		      	    alert.setTitle("Error");
		      	    alert.setContentText("Enter a numeric amount");
		      	    alert.showAndWait();
				} catch (UserNotFoundException e) {
					Alert alert = new Alert(Alert.AlertType.ERROR);
		      	    alert.setHeaderText(null);
		      	    alert.setTitle("Error");
		      	    alert.setContentText(e.getMessage());
		      	    alert.showAndWait();
				} catch (InsufficientFundsException e) {
					Alert alert = new Alert(Alert.AlertType.ERROR);
		      	    alert.setHeaderText(null);
		      	    alert.setTitle("Error");
		      	    alert.setContentText(e.getMessage());
		      	    alert.showAndWait();
				} 	
     	}
    }
    
    @FXML
    public void goBack() throws IOException {
    	  FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("fxmlFiles/SearchCostumer.fxml"));
    	  fxmlLoader.setController(searchCostumer);
    	  Parent searchPane = fxmlLoader.load();
    	  mainMenu.getMainPane().getChildren().clear();
    	  mainMenu.getMainPane().setCenter(searchPane);
    }
  
}
