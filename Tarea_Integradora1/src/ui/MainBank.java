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
	private BankGUI MainMenu;
	
	public MainBank() {
		bank = new BankManagement();
		MainMenu= new BankGUI(bank);
	}
	
	public static void main(String[] args) throws IOException, QueueIsAlreadyFullException, QueueIsEmptyException {
		MainBank main = new MainBank();
		BufferedReader br = new BufferedReader(new FileReader(new File("data/costumers.txt")));
		String line = br.readLine();
		while(line!=null) {
			String [] param = line.split(",");
			String name= param[0];
			String id = param[1];
			int priority = Integer.parseInt(param[2]);
			main.registerClient(name, id, priority);
			line= br.readLine();
			
		}
		br.close();
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
		primaryStage.setResizable(true);
		primaryStage.show();
	}
	
	public void registerClient(String name,String id,int priority) throws QueueIsAlreadyFullException, QueueIsEmptyException {
		bank.addToHash(name, id, priority);
	}
}
