import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import java.net.URL;
import java.util.ResourceBundle;

//import java fx.*;
public class HangmanController implements ControlledPage, Initializable, EventHandler<ActionEvent>
{
	@FXML
	private RadioButton buttonP = new RadioButton();
	@FXML
	private RadioButton buttonS = new RadioButton();
	@FXML
	public static Button submit = new Button();
	@FXML
	private ToggleGroup group = new ToggleGroup();
	@FXML
	private Label option1 = new Label();
	@FXML
	private Label option2 = new Label();
	@FXML
	private Label comparison = new Label();
	@FXML
	private static Button next = new Button();
	
	
	private boolean noButton = false;
	
	
	Hangman hangman = new Hangman();
	public void selected(){
		if(buttonP.isSelected()){
			forButtonP();
		}
		else if(buttonS.isSelected()){
			forButtonS();
		}
		else{
			noButton = true;
			option1.setText("No button was selected!");
		}
		
	}

	public void forNext(){
		if(FileHandling.chosenList == null || noButton == false){
		hangman.page2();
		}
		else{
			option2.setText("Can't go to the Next page!! ");
			comparison.setText("Make sure you selected an Option and you clicked Submit");
		}
		
	}
	
	public void forButtonP(){
			FileHandling.runInParallel();
			System.out.println("now in s");
		//	FileHandling.runInSequential();
			FileHandling.chosenList = FileHandling.allLists;
			option1.setText(FileHandling.forP);
			option2.setText(FileHandling.forS);
			if(FileHandling.timeForSequential < FileHandling.timeForParallel ){
				long diff = FileHandling.timeForParallel - FileHandling.timeForSequential;
			 comparison.setText("Sequential was faster by "+diff+" milliseconds");
			
			 
			}
			
			else if( FileHandling.timeForParallel < FileHandling.timeForSequential ){
				long diff = FileHandling.timeForSequential - FileHandling.timeForParallel;
			comparison.setText("Parallel was faster by "+diff+" milliseconds");
			
			}
			}
	
	
	
	public void forButtonS(){
		FileHandling.runInSequential();
		System.out.println("now in p");
		FileHandling.runInParallel();
		FileHandling.chosenList = FileHandling.allLists1;
		option1.setText(FileHandling.forP);
		option2.setText(FileHandling.forS);
		if(FileHandling.timeForSequential < FileHandling.timeForParallel ){
			long diff = FileHandling.timeForParallel - FileHandling.timeForSequential;
			comparison.setText("Sequential was faster by "+diff+" milliseconds");
			
			
		}
		
		else if( FileHandling.timeForParallel < FileHandling.timeForSequential ){
			long diff = FileHandling.timeForSequential - FileHandling.timeForParallel;
			comparison.setText("Parallel was faster by "+diff+" milliseconds");
		
		}
	}
	public void handle(ActionEvent event){
		buttonP.setToggleGroup(group);
		buttonS.setToggleGroup(group);
		if(event.getSource()==submit){
			//selected();
		}
		
	}
	
	PagesController myController;

	@Override
	public void initialize(URL url, ResourceBundle resourceb){}

	public void setPageParent(PagesController pageParent){
		myController = pageParent;
	}

	@FXML
	private void goTopage2(){
		myController.setPage(Hangman.page2ID);
		
	}

	@FXML
	private void goTopage3(ActionEvent event){
		myController.setPage(Hangman.page3ID);
	}

}