import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

public class PageController implements ControlledPage, Initializable{
	
	PagesController myController;

	@Override
	public void initialize(URL url, ResourceBundle rb){}

	public void setPageParent(PagesController PageParent){
		myController = PageParent;
	}
	

	@FXML
	private void goToPage2(ActionEvent event){
		myController.setPage(Hangman.page2ID);
	}

	@FXML
	private void goToPage3(ActionEvent event){
		myController.setPage(Hangman.page3ID);
	}

	
}