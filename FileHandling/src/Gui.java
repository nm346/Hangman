import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.FlowPane;
import javafx.scene.text.Font;
import javafx.stage.*;

//import java fx.*;
public class Gui extends Application implements EventHandler<ActionEvent> {
  // public void start(Stage stage){
  // callback
  // }
  RadioButton buttonP;
  RadioButton buttonS;
  Button submit;
  ToggleGroup group;

  public static void main(String[] args) {
	launch();
	FileHandling.binarySerialize(FileHandling.chosenList, "serialize.bin");
  }

  public void start(Stage stage) throws Exception {
	Label message = new Label("Please choose which mode you wish to choose words from");
	message.setFont(new Font(10));
	FlowPane layout = new FlowPane();
	buttonP = new RadioButton();
	buttonS = new RadioButton();
	group = new ToggleGroup();
	submit = new Button();

	buttonP.setToggleGroup(group);
	buttonS.setToggleGroup(group);
	buttonP.setText("Parallel");
	buttonS.setText("Sequential");
	submit.setText("Submit");
	submit.setOnAction(this);
	// button1.setOnAction(e -> forButton1());
	Scene scene = new Scene(layout, 300, 100);
	stage.setScene(scene);
	stage.setTitle("Hangman Word Chooser");
	stage.show();

	layout.getChildren().add(message);
	layout.getChildren().add(buttonP);
	layout.getChildren().add(buttonS);
	layout.getChildren().add(submit);
  }

  public void selected() {
	if (buttonP.isSelected()) {
	  forButtonP();
	} else if (buttonS.isSelected()) {
	  forButtonS();
	} else {
	  System.out.println("No button was selected!");
	}

  }

  public void forButtonP() {
	FileHandling.runInParallel();
	// System.out.println("now in s");
	FileHandling.runInSequential();
	FileHandling.chosenList = FileHandling.allLists;

	if (FileHandling.timeForSequential < FileHandling.timeForParallel) {
	  long diff = FileHandling.timeForParallel - FileHandling.timeForSequential;
	  System.out.println("Sequential was faster by " + diff + " milliseconds");
	}

	else if (FileHandling.timeForParallel < FileHandling.timeForSequential) {
	  long diff = FileHandling.timeForSequential - FileHandling.timeForParallel;
	  System.out.println("Parallel was faster by " + diff + " milliseconds");
	}
  }

  public void forButtonS() {
	FileHandling.runInSequential();
	// System.out.println("now in p");
	FileHandling.runInParallel();
	FileHandling.chosenList = FileHandling.allLists1;

	if (FileHandling.timeForSequential < FileHandling.timeForParallel) {
	  long diff = FileHandling.timeForParallel - FileHandling.timeForSequential;
	  System.out.println("Sequential was faster by " + diff + " milliseconds");
	}

	else if (FileHandling.timeForParallel < FileHandling.timeForSequential) {
	  long diff = FileHandling.timeForSequential - FileHandling.timeForParallel;
	  System.out.println("Parallel was faster by " + diff + " milliseconds");
	}
  }

  public void handle(ActionEvent event) {
	if (event.getSource() == submit) {
	  selected();
	}
  }
}

/*
 * public void handle(ActionEvent event){ if(event.getSource()==button){
 * System.out.println(FileHandling.sequentially()); } }
 */
