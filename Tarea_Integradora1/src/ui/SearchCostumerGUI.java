package ui;
import java.io.IOException;

import exceptions.QueueIsAlreadyFullException;
import exceptions.QueueIsEmptyException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import model.BankManagement;
import model.Client;

public class SearchCostumerGUI {
	
	private BankManagement bank;
	private MainMenuGUI mainMenu;
	private DepositGUI deposit;
	private PayCardGUI payCard;
	
    public SearchCostumerGUI(BankManagement bank, MainMenuGUI mainMenu) {
		this.bank = bank;
		this.mainMenu = mainMenu;
		this.deposit= new DepositGUI(bank,mainMenu,this);
		this.payCard= new PayCardGUI(bank,mainMenu,this);
	}

	@FXML
    private TextField idCamp;

    @FXML
    private Button searchCostumer;

    @FXML
    private Label nameCamp;

    @FXML
    private Label cardCamp;

    @FXML
    private Label cardDateCamp;

    @FXML
    private Label accountCamp;

    @FXML
    private Label registerDateCamp;

    @FXML
    private Label moneyCamp;

    @FXML
    public void cancelAccount(ActionEvent event) throws QueueIsAlreadyFullException, QueueIsEmptyException {
    	String id = idCamp.getText();
     	if(id.equals("")) {
     		Alert alert = new Alert(Alert.AlertType.ERROR);
      	    alert.setHeaderText(null);
      	    alert.setTitle("Error");
      	    alert.setContentText("Enter an identification to look for");
      	    alert.showAndWait();
     	}else {
     		Client c = bank.searchClient(id);
     		if(c==null) {
     			Alert alert = new Alert(Alert.AlertType.ERROR);
          	    alert.setHeaderText(null);
          	    alert.setTitle("Error");
          	    alert.setContentText("The user dont exist");
          	    alert.showAndWait();
     		}else {
     			bank.deleteClient(id, "Owner decision");
     			Alert alert = new Alert(Alert.AlertType.INFORMATION);
          	    alert.setHeaderText(null);
          	    alert.setTitle("Account");
          	    alert.setContentText("Account was deleted succesfully");
          	    alert.showAndWait();
     		}
     	}
    }

    @FXML
    public void depositRetireMoney(ActionEvent event) throws IOException {
    	FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("fxmlFiles/DepositScreen.fxml"));
    	fxmlLoader.setController(deposit);
    	Parent depositPane = fxmlLoader.load();
    	mainMenu.getMainPane().getChildren().clear();
    	mainMenu.getMainPane().setCenter(depositPane);
    }

    @FXML
    public void goBack(ActionEvent event) throws IOException {
    	FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("fxmlFiles/MainMenu.fxml"));
    	fxmlLoader.setController(mainMenu);
    	Parent enqueuePane = fxmlLoader.load();
    	mainMenu.getMainPane().getChildren().clear();
    	mainMenu.getMainPane().setCenter(enqueuePane);
    }

    @FXML
    public void payCreditCard(ActionEvent event) throws IOException {
     	FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("fxmlFiles/CreditCardPayment.fxml"));
    	fxmlLoader.setController(payCard);
    	Parent cardPane = fxmlLoader.load();
    	mainMenu.getMainPane().getChildren().clear();
    	mainMenu.getMainPane().setCenter(cardPane);
    }

    @FXML
    public void searchCostumer(ActionEvent event) throws IOException {
     	String id = idCamp.getText();
     	if(id.equals("")) {
     		Alert alert = new Alert(Alert.AlertType.ERROR);
      	    alert.setHeaderText(null);
      	    alert.setTitle("Error");
      	    alert.setContentText("Enter an identification to look for");
      	    alert.showAndWait();
     	}else {
     		Client c = bank.searchClient(id);
     		if(c==null) {
     			Alert alert = new Alert(Alert.AlertType.ERROR);
          	    alert.setHeaderText(null);
          	    alert.setTitle("Ups");
          	    alert.setContentText("The user dont exist");
          	    alert.showAndWait();
     		}else {
     			nameCamp.setText(c.getName());
     			cardCamp.setText(c.getCard().getCardNumber());
     			cardDateCamp.setText(c.getCard().getPaymentDue().toString());
     			accountCamp.setText(c.getAccountNumber());
     			registerDateCamp.setText(c.getRegisterDate().toString());
     			moneyCamp.setText(c.getAccountBalance());
     			idCamp.setText("");
     		}
     		
     	}
    }

    @FXML
    public void undo(ActionEvent event) throws QueueIsAlreadyFullException, QueueIsEmptyException {
    	try{
    		this.bank.setBank(bank.undo());
    		Alert alert = new Alert(Alert.AlertType.INFORMATION);
      	    alert.setHeaderText(null);
      	    alert.setTitle("Done!");
      	    alert.setContentText("Undo sucessfully!");
      	    alert.showAndWait();
    	}catch(QueueIsEmptyException e) {
    		Alert alert = new Alert(Alert.AlertType.ERROR);
      	    alert.setHeaderText(null);
      	    alert.setTitle("Ups");
      	    alert.setContentText("Theres no actions to undo");
      	    alert.showAndWait();
    	}
    }

}