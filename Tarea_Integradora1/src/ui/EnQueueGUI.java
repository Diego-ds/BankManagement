package ui;

import java.io.IOException;

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
    void enqueue(ActionEvent event) {

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
