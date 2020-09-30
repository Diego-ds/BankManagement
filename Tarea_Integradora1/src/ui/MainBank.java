package ui;
import java.io.*;

import exceptions.QueueIsAlreadyFullException;
import exceptions.QueueIsEmptyException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import model.BankManagement;

public class MainBank extends Application {
	
	private BankManagement bank;
	private MainMenuGUI MainMenu;
	
	public MainBank() throws IOException, QueueIsAlreadyFullException, QueueIsEmptyException {
		bank = new BankManagement();
		BufferedReader br = new BufferedReader(new FileReader(new File("data/costumers.txt")));
		String line = br.readLine();
		
		while(line!=null) {
			
			String [] param = line.split(",");
			String name= param[0];
			String id = param[1];
			int priority = Integer.parseInt(param[2]);
			bank.addToHash(name,id,priority);
			line= br.readLine();
			
		}
		
		br.close();
		MainMenu= new MainMenuGUI(bank);
	}
	
	public static void main(String[] args) throws IOException, QueueIsAlreadyFullException, QueueIsEmptyException {
		launch();	
	}
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("fxmlFiles/WelcomeScreen.fxml"));
		fxmlLoader.setController(MainMenu);
		
		Parent root = fxmlLoader.load();
		Scene scene = new Scene(root);
		primaryStage.setScene(scene);
		primaryStage.setTitle("Bank");
		primaryStage.setResizable(false);
		primaryStage.show();
	}
}
