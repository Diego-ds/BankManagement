package ui;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
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
    private TextField amountCamp;

    @FXML
    void depositMoney(ActionEvent event) {

    }

    @FXML
    void retireMoney(ActionEvent event) {

    }
}
