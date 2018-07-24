import java.net.URL;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.ResourceBundle;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
//import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;

public class GameController implements ControlledPage, Initializable{
	Game game = new Game();
	DifficultyController xController = new DifficultyController();
	public static String wordii = "Battlefield";
	public static LinkedList<Integer> indexes = new LinkedList<Integer>();
	public  String dashesForWord = "";	
	public  String result= dashesForWord;
	public static String lastResult="";
	public  boolean contain;
	public int lives = 9;
	public int score = 0;
	public int highScore = 0;
	public boolean forfeit = false;
	public int numberOfGame = 0;
	public static HashSet<Character> alreadyUsed = new HashSet<Character>();
	private ArrayList<Object> imagesArray = new ArrayList<Object>();
	//public String imageFiileName;
	public Image image = new Image(getClass().getResourceAsStream("/images/Image9.png"));
	
	public ImageView img1 = new ImageView();
	@FXML
	Button start = new Button();
	@FXML
	Button playAgain = new Button();
	@FXML
	Button load = new Button();
	@FXML
	Button givenUp = new Button();
	@FXML
	Label livesLeft = new Label();
	@FXML
	Label word = new Label();
	@FXML
	Label finish = new Label();
	@FXML
	Label press = new Label();
//	@FXML 
//	public Button newGame = new Button();
	@FXML
	Label entered = new Label();
	@FXML
	Label yourScore = new Label();
	@FXML
	Label theHighScore = new Label();
	@FXML
	Label givenIn = new Label();
	@FXML 
	public Button play = new Button();
	@FXML
	public Button pause = new Button();
	@FXML 
	public Button stop = new Button();
	
	MediaPlayer mediaPlayer;
	
	MediaPlayer letterUsed;
	
	MediaPlayer winSound;
	
	MediaPlayer loseSound;
	
	MediaPlayer correct;
	
	MediaPlayer wrong;
	
	Hangman hangman = new Hangman();

//	public void forNew(){
//		hangman.page3();
//	}
//	
	
	public void loadAllImageNames(){
		for(int i = 0; i <=9; i++){
			//"/images/Image"+i+".png");
			imagesArray.add(new Image(getClass().getResourceAsStream("/images/Image"+i+".png")));
			livesLeft.setText("Lives Left:"+lives);
		}
		
		
	}
	
	public void closeApp(ActionEvent event){
		Platform.exit();
		System.exit(0);
	}
	public void checkHighScore(){
		if(score>=highScore && forfeit==false){
			highScore = score;
		}
		
	}
	
	public void openNew(ActionEvent event){
		music();
		stopMusic();
		checkHighScore();
		if(forfeit==false) playMusic();
		forfeit = false;
		press.setVisible(false);
		givenUp.setVisible(true);
		playAgain.setVisible(false);
		finish.setVisible(false);
		score = 0;
		yourScore.setText("Your score:"+score);
		theHighScore.setText("Highscore:"+highScore);
		numberOfGame+=1;
		lives = 9;
		livesLeft.setText("Lives Left:"+lives);
		Image image = (Image)imagesArray.get(lives);
		
		img1.setImage(image);
		alreadyUsed.clear();
		wordii = DifficultyController.chosenDifficulty.get(numberOfGame);
		result = dashes(wordii);
		word.setText(dashes(result));
		start.setVisible(false);
	}
	
	public void changeDifficulty(){
		hangman.page2();
	}
	public void setImage(ActionEvent event){
		
		playAgain.setVisible(false);
		wordii = DifficultyController.chosenDifficulty.get(numberOfGame);
		result = dashes(wordii);
		press.setText("");
		press.setVisible(false);
		music();
		//place('u','u');
		loadAllImageNames();
		word.setText(result);
		System.out.print(imagesArray);
		int i = lives;
		
	//	Image image = new Image(getClass().getResourceAsStream(imagesArray.get(i)));
		Image image = (Image)imagesArray.get(i);
		img1.setImage(image);
		livesLeft.setText("Lives Left:"+lives);
		//lives--;
		
	}
	PagesController myController;
	@Override
	public void initialize(URL location, ResourceBundle resourceb) {
		
		
	}
	public void setPageParent(PagesController pageParent) {
		myController = pageParent;
		
	}
	
	public String place(char c, char c1){
		
		markIndex(c);
		markIndex(c1);
		char[] resultArray = result.toCharArray();
		
		int b = indexes.size();
		for(int i = 0; i < b; i++){
			//i in result should be swapped to = c
			int a = indexes.get(i);
			resultArray[a] = c1;
		}
		result = String.valueOf(resultArray);
		indexes.clear();
	//	LastResult = result;
		return result;
	} 
	
	public  void markIndex(char c ){ //marks the indexes of the word the letter is located.
		String s = wordii;
		String copy = s;
		contain = false;
		//if(indexes.isEmpty()) contain = false;
	for(int i = 0; i < s.length();i++){
		//int i = 10;
		if(copy.equals("") && contain == true) return;
			if(copy.equals("")) return;
			if(copy.charAt(0) == c){ 
				contain = true;
				indexes.add(i);
				
			}
			
			copy = copy.substring(1);
	}
		
	}
	
	public boolean contains(char a, char b){
		boolean check = false;
		String s = wordii;
		while(true){
		if(s.equals("")) return check;
		if(s.charAt(0)==a){
			check = true;
		}
		else if(s.charAt(0)==b){
			check = true;
		
		}
		s = s.substring(1);
		}
		
	}
	
	public boolean containsDashes(String s){
		while(true){
			if(s.isEmpty()) return false;
			if(s.charAt(0) == '-') return true;
			s = s.substring(1);
		}
	}
	
	public static String dashes(String s){
		int dash = s.length();
		String wordSoFar ="";
		for(int i = 0; i < dash; i++){
			wordSoFar = wordSoFar+='-';
		}
		return wordSoFar;
	}
	
	/////////////////////////
	public void forButton(char a, char b){
		contain = contains(a,b);
		entered.setText(""); 
			if(contain==false && alreadyUsed.contains(a) && alreadyUsed.contains(b)){ //If Button was already entered.
				entered.setText(("This letter was already entered"));
				usedAudio();
			}
		if(contain==true && !alreadyUsed.contains(a) && !alreadyUsed.contains(b)){ //If Letter is in word
			word.setText(place(a,b));
			alreadyUsed.add(a);
			alreadyUsed.add(b);
			score+=100;
			yourScore.setText("Your score:"+score);
			rightAnswer();
		}
			
		else if(contain==false && !alreadyUsed.contains(a) && !alreadyUsed.contains(b)){ //If Letter is not in word
				
				//checkLife();
				alreadyUsed.add(a);
				alreadyUsed.add(b);
				//checkLife();
				lives--;
				int i = lives;
				@SuppressWarnings("unused")
				Image image = (Image)imagesArray.get(lives);
				img1.setImage((Image)imagesArray.get(i));
				score-=10;
				yourScore.setText("Your score:"+score);
				wrongAnswer();
				}
			
		
			livesLeft.setText("Lives Left:"+lives);
			checkLife();
	}
	

	public void checkLife(){
		if(lives == 0) {
			finish.setText("The Word was: "+wordii+"... Play Again?");
			finish.setVisible(true);
			img1.setImage((Image)imagesArray.get(0));
			youLose();
			playAgain.setVisible(true);
			givenUp.setVisible(false);
			stopMusic();
			return;}
		
		if(containsDashes(result)==false){
			finish.setText("GAME OVER! YOU WIN");
			finish.setVisible(true);
			youWin();
			playAgain.setVisible(true);
			givenUp.setVisible(false);
			stopMusic();
			return;	
			
			}
		
		
	}
	
	public void giveUp(ActionEvent event){
		forfeit = true;
		stopMusic();
		openNew(event);
		score = 0;
		press.setText("The word was:"+wordii);
		press.setVisible(true);
		
		givenUp.setVisible(false);
		playAgain.setVisible(true);
	}
	
	public void music(){
		Media music = new Media("file:/Users/NathanMay/Documents/workspace/Hangman/src/application/backgroundMusic.mp3");
		mediaPlayer = new MediaPlayer(music);
		mediaPlayer.setVolume(0.2);
		mediaPlayer.setAutoPlay(true);
		play.setVisible(true);
		pause.setVisible(true);
		stop.setVisible(true);
	}
	
	public void rightAnswer(){
		Media right = new Media("file:/Users/NathanMay/Documents/workspace/Hangman/src/application/correct.mp3");
		correct = new MediaPlayer(right);
		correct.setVolume(1.0);
		correct.setAutoPlay(true);
		correct.play();
	}
	
	public void wrongAnswer(){
		Media incorrect = new Media("file:/Users/NathanMay/Documents/workspace/Hangman/src/application/wrong.mp3");
		wrong = new MediaPlayer(incorrect);
		wrong.setVolume(1.0);
		wrong.setAutoPlay(true);
		wrong.play();
	}
	
	public void usedAudio(){
		Media used = new Media("file:/Users/NathanMay/Documents/workspace/Hangman/src/application/used.mp3");
		letterUsed = new MediaPlayer(used);
		letterUsed.setVolume(1.0);
		letterUsed.setAutoPlay(false);
		letterUsed.play();
	
	}
	
	public void youLose(){
		Media loseSound = new Media("file:/Users/NathanMay/Documents/workspace/Hangman/src/application/lose.mp3");
		letterUsed = new MediaPlayer(loseSound);
		letterUsed.setVolume(1.0);
		letterUsed.setAutoPlay(false);
		letterUsed.play();
	
	}
	
	public void youWin(){
		Media winSound = new Media("file:/Users/NathanMay/Documents/workspace/Hangman/src/application/win.mp3");
		letterUsed = new MediaPlayer(winSound);
		letterUsed.setVolume(1.0);
		letterUsed.setAutoPlay(false);
		letterUsed.play();
	
	}
	public void playMusic() {
				mediaPlayer.play();
				
			}
	public void pauseMusic() {
		mediaPlayer.pause();
		
	}
	public void stopMusic() {
		mediaPlayer.stop();
		
	}

	@FXML
	Button a = new Button();
	public void checkItA(){
		forButton('A','a');
		
	}
	@FXML
	Button b = new Button();
	public void checkItB(){
		forButton('B','b');
	}
	@FXML
	Button c = new Button();
	public void checkItC(){
		forButton('C','c');
	}
	@FXML
	Button d = new Button();
	public void checkItD(){
		forButton('D','d');
	}
	@FXML
	Button e = new Button();
	public void checkItE(){
		forButton('E','e');
	}
	@FXML
	Button f = new Button();
	public void checkItF(){
		forButton('F','f');
	}
	@FXML
	Button g = new Button();
	public void checkItG(){
		forButton('G','g');
	}
	@FXML
	Button h = new Button();
	public void checkItH(){
		forButton('H','h');
	}
	@FXML
	Button i = new Button();
	public void checkItI(){
		forButton('I','i');
	}
	@FXML
	Button j = new Button();
	public void checkItJ(){
		forButton('J','j');
	}
	@FXML
	Button k = new Button();
	public void checkItK(){
		forButton('K','k');
	}
	@FXML
	Button l = new Button();
	public void checkItL(){
		forButton('L','l');
	}
	@FXML
	Button m = new Button();
	public void checkItM(){
		forButton('M','m');
	}
	@FXML
	Button n = new Button();
	public void checkItN(){
		forButton('N','n');
	}
	@FXML
	Button o = new Button();
	public void checkItO(){
		forButton('O','o');
	}
	@FXML
	Button p = new Button();
	public void checkItP(){
		forButton('P','p');
	}
	@FXML
	Button q = new Button();
	public void checkItQ(){
		forButton('Q','q');
	}
	@FXML
	Button r = new Button();
	public void checkItR(){
		forButton('R','r');
	}
	@FXML
	Button s = new Button();
	public void checkItS(){
		forButton('S','s');
	}
	@FXML
	Button t = new Button();
	public void checkItT(){
		forButton('T','t');
	}
	@FXML
	Button u = new Button();
	public void checkItU(){
		forButton('U','u');
	}
	@FXML
	Button v = new Button();
	public void checkItV(){
		forButton('V','v');
	}
	@FXML
	Button w = new Button();
	public void checkItW(){
		forButton('W','w');
	}
	@FXML
	Button x = new Button();
	public void checkItX(){
		forButton('X','x');
	}
	@FXML
	Button y = new Button();
	
	public void checkItY(){
		forButton('Y','y');
	}@FXML
	Button z = new Button();
	public void checkItZ(){
		forButton('Z','z');
	}
}