import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

public class Page1Controller implements ControlledPage, Initializable{
	
	PagesController myController;

	@Override
	public void initialize(URL url, ResourceBundle resourceb){}

	public void setPageParent(PagesController pageParent){
		myController = pageParent;
	}

	@FXML
	private void goTopage2(ActionEvent event){
		myController.setPage(Hangman.page2ID);
	}

	@FXML
	private void goTopage3(ActionEvent event){
		myController.setPage(Hangman.page3ID);
	}

}