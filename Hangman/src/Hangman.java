import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Hangman extends Application{
	
	public static String page1ID = "options";
	public static String page1File = "/Options.fxml";
	public static String page2ID = "Difficulty";
	public static String page2File = "/Difficulty.fxml";
	public static String page3ID = "game";
	public static String page3File = "/theGame.fxml";
	
	public static void main(String[] args){
		launch();
		//FileHandling.binarySerialize(FileHandling.chosenList,"serialize.bin");
		}
	@FXML
	PagesController container = new PagesController();
	public void start(Stage primary){
		page1();
//		container.loadPage(Hangman.page1ID, Hangman.page1File);
//		container.loadPage(Hangman.page2ID, Hangman.page2File);
//		container.loadPage(Hangman.page3ID, Hangman.page3File);
//		container.setPage(Hangman.page1ID);
//
//	Group group = new Group();
//		group.getChildren().addAll(container);
//		Scene scene = new Scene(group);
//		primary.setScene(scene);
//		primary.show();	
		
	}

	public void page1(){
		Stage primary = new Stage();
		container.loadPage(Hangman.page1ID, Hangman.page1File);
			container.setPage(Hangman.page1ID);
			primary.setResizable(false);
		Group group = new Group();
			group.getChildren().addAll(container);
			Scene scene = new Scene(group);
			primary.setScene(scene);
			primary.show();
			primary.setOnCloseRequest(e -> Platform.exit());
	}
	
	public void page2(){
		
		Stage primary = new Stage();
		container.loadPage(Hangman.page2ID, Hangman.page2File);
			container.setPage(Hangman.page2ID);
			primary.setResizable(false);
		Group group = new Group();
			group.getChildren().addAll(container);
			Scene scene = new Scene(group);
			primary.setScene(scene);
			primary.show();	
			primary.setOnCloseRequest(e -> Platform.exit());
	}
	
public void page3(){
		
		Stage primary = new Stage();
		container.loadPage(Hangman.page3ID, Hangman.page3File);
			container.setPage(Hangman.page3ID);
			primary.setResizable(false);
		Group group = new Group();
			group.getChildren().addAll(container);
			Scene scene = new Scene(group);
			primary.setScene(scene);
			primary.show();	
			primary.setOnCloseRequest(e -> Platform.exit());
	}
}