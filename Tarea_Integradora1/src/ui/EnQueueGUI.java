package ui;

import java.io.IOException;

import exceptions.QueueIsAlreadyFullException;
import exceptions.QueueIsEmptyException;
import javafx.event.ActionEvent;
import javafx.fxml.*;
import javafx.scene.Parent;
import javafx.scene.control.*;
import model.BankManagement;

public class EnQueueGUI {
	private BankManagement bank;
	private MainMenuGUI mainMenu;

	public EnQueueGUI(BankManagement bank, MainMenuGUI mainMenu) {
		
		this.bank = bank;
		this.mainMenu = mainMenu;
	}

    @FXML
    private TextField name;

    @FXML
    private TextField iD;

    @FXML
    public void enqueue(ActionEvent event) {
    	String n = name.getText();
    	String id = iD.getText();
    	if(n.equals("") || id.equals("")) {
    		Alert alert = new Alert(Alert.AlertType.ERROR);
      	    alert.setHeaderText(null);
      	    alert.setTitle("Error");
      	    alert.setContentText("Please fill all the camps");
      	    alert.showAndWait();
    	}else if(!n.equals("") && !id.equals("")) {
    		
    		try {
				bank.addToQueue(n, id);
				name.setText("");
				iD.setText("");
				Alert alert = new Alert(Alert.AlertType.INFORMATION);
	      	    alert.setHeaderText(null);
	      	    alert.setTitle("Done!");
	      	    alert.setContentText("The customer was correctly added to queue");
	      	    alert.showAndWait();
			} catch (QueueIsAlreadyFullException e) {
				Alert alert = new Alert(Alert.AlertType.ERROR);
	      	    alert.setHeaderText(null);
	      	    alert.setTitle("Error");
	      	    alert.setContentText(e.getMessage());
	      	    alert.showAndWait();
			} catch (QueueIsEmptyException e) {
				Alert alert = new Alert(Alert.AlertType.ERROR);
	      	    alert.setHeaderText(null);
	      	    alert.setTitle("Error");
	      	    alert.setContentText(e.getMessage());
	      	    alert.showAndWait();
			}
    	}
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
