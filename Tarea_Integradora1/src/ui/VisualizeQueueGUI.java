package ui;

import java.io.IOException;

import exceptions.QueueIsEmptyException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.layout.BorderPane;
import javafx.scene.shape.Rectangle;
import model.BankManagement;

public class VisualizeQueueGUI {
    @FXML
    private BorderPane mainPane;

    @FXML
    private Rectangle rl1;

    @FXML
    private Rectangle rl3;

    @FXML
    private Rectangle rl2;

    @FXML
    private Rectangle rd1;

    @FXML
    private Rectangle rd2;

    @FXML
    private Rectangle rl4;

    @FXML
    private Rectangle rd3;

    @FXML
    private Rectangle rd4;
    
    private BankManagement bank;
    private MainMenuGUI mainMenu;
    
    public VisualizeQueueGUI(BankManagement bank, MainMenuGUI mainMenu) {
		this.bank = bank;
		this.mainMenu = mainMenu;
		
	}
    
    @FXML
    public void initialize() {
    	int sizeQueue = bank.getSizeQueue();
    	switch(sizeQueue) {

    	 
    	case 0:
    		rl1.setVisible(false);
    		rl2.setVisible(false);
    		rl3.setVisible(false);
    		rl4.setVisible(false);
    		break;

    	case 1:
    		rl2.setVisible(false);
    		rl3.setVisible(false);
    		rl4.setVisible(false);
    		break;
    	case 2:
    		rl3.setVisible(false);
    		rl4.setVisible(false);
    		break;
    	case 3:
    		rl4.setVisible(false);
    		break;  		
    	}
    	
    	int sizePriorityQueue = bank.getPrioritySize();
    	switch(sizePriorityQueue) {

    	case 0:
    		rd1.setVisible(false);
    		rd2.setVisible(false);
    		rd3.setVisible(false);
    		rd4.setVisible(false);
    		break;

    	case 1:
    		rd2.setVisible(false);
    		rd3.setVisible(false);
    		rd4.setVisible(false);
    		break;
    	case 2:
    		rd3.setVisible(false);
    		rd4.setVisible(false);
    		break;
    	case 3:
    		rd4.setVisible(false);
    		break;  		
    	}
    	
    	
     }
    
    
    
    
    @FXML
    void dequeue(ActionEvent event) {
    	try {
			bank.removeFromQueue();
			initialize();
			Alert alert = new Alert(Alert.AlertType.INFORMATION);
	  	    alert.setHeaderText(null);
	  	    alert.setTitle("Done!");
	  	    alert.setContentText("The customer was successfully attended");
	  	    alert.showAndWait();
		} catch (QueueIsEmptyException e) {
			Alert alert = new Alert(Alert.AlertType.WARNING);
	  	    alert.setHeaderText(null);
	  	    alert.setTitle("Error");
	  	    alert.setContentText("Queue is empty");
	  	    alert.showAndWait();
		}
    }

    @FXML
    void dequeuePriority(ActionEvent event) {
    	try {
			bank.removeFromPriorityQueue();
			initialize();
			Alert alert = new Alert(Alert.AlertType.INFORMATION);
	  	    alert.setHeaderText(null);
	  	    alert.setTitle("Done!");
	  	    alert.setContentText("The customer was successfully attended");
	  	    alert.showAndWait();
		} catch (QueueIsEmptyException e) {
			Alert alert = new Alert(Alert.AlertType.WARNING);
	  	    alert.setHeaderText(null);
	  	    alert.setTitle("Error");
	  	    alert.setContentText("Queue is empty");
	  	    alert.showAndWait();
		}
    }

    @FXML
    void goBack(ActionEvent event) throws IOException {
  	  FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("fxmlFiles/MainMenu.fxml"));
  	  fxmlLoader.setController(mainMenu);
  	  Parent searchPane = fxmlLoader.load();
  	  mainMenu.getMainPane().getChildren().clear();
  	  mainMenu.getMainPane().setCenter(searchPane);
    }

}
