import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

public class DifficultyController implements ControlledPage, Initializable, EventHandler<ActionEvent>{
	
	public static ArrayList<String> am = new ArrayList<String>();
	public static ArrayList<String> sem = new ArrayList<String>();
	public static ArrayList<String> pro = new ArrayList<String>();
	public static ArrayList<String> wc = new ArrayList<String>();
	
	public static ArrayList<String> chosenDifficulty = new ArrayList<String>(); //Difficulty 
	Hangman hangman = new Hangman();
	@FXML
	private RadioButton amatuer = new RadioButton();
	@FXML
	private RadioButton semiPro = new RadioButton();
	@FXML
	private RadioButton professional = new RadioButton();
	@FXML
	private RadioButton worldClass = new RadioButton();
	@FXML
	private ToggleGroup group = new ToggleGroup();
	MediaPlayer startGame;
	
	public void startGame(){
		Media music = new Media("file:/Users/NathanMay/Documents/workspace/Hangman/src/application/startGame.mp3");
		startGame = new MediaPlayer(music);
		startGame.setVolume(0.5);
		startGame.setAutoPlay(false);
		startGame.play();
	}
	
	public void diFF1(){
		ArrayList<String> copy = FileHandling.chosenList;
		for(int i = 0; i <= copy.size() -1; i++){
			if(copy.get(i).length() <= 5){
				am.add(copy.get(i));
				
			}
		}
		chosenDifficulty = am;
		System.out.println("Words in your selected difficulty");
		System.out.println(chosenDifficulty);
	}
	
	public void diFF2(){
		ArrayList<String> copy = FileHandling.chosenList;
		for(int i = 0; i <= copy.size() -1; i++){
			if(copy.get(i).length() == 6){
				sem.add(copy.get(i));
			}
		}
		chosenDifficulty = sem;
		System.out.println("Words in your selected difficulty");
		System.out.println(chosenDifficulty);
	}
	
	public void diFF3(){
		ArrayList<String> copy = FileHandling.chosenList;
		for(int i = 0; i <= copy.size() -1; i++){
			if(copy.get(i).length() == 7){
				pro.add(copy.get(i));
			}
		}
		chosenDifficulty = pro;
		System.out.println("Words in your selected difficulty");
		System.out.println(chosenDifficulty );
	}
	
	public void diFF4(){
		ArrayList<String> copy = FileHandling.chosenList;
		for(int i = 0; i <= copy.size() -1; i++){
			if(copy.get(i).length() >=8){
				wc.add(copy.get(i));
			}
		}
		chosenDifficulty = wc;
		System.out.println("Words in your selected difficulty");
		System.out.println(chosenDifficulty);
	}
	
	@FXML
	public void diffSelected(){
		if(amatuer.isSelected()){
			diFF1();
			hangman.page3();
		}
		else if(semiPro.isSelected()){
			diFF2();
			hangman.page3();
		}
		else if(professional.isSelected()){
			diFF3();
			hangman.page3();
		}
		else if(worldClass.isSelected()){
			diFF4();
			hangman.page3();
		}
		else{
			System.out.println("No button was selected!");
		}
		startGame();
	}

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

	@Override
	public void handle(ActionEvent event) {
		// TODO Auto-generated method stub
		
	}
}
