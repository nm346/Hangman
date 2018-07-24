import java.util.HashMap;

import javafx.animation.KeyFrame;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.layout.StackPane;
import javafx.util.Duration;

public class PagesController extends StackPane {
	private HashMap<String, Node> Pages = new HashMap<>();

	public PagesController() {
		super();
	}

	public void addPage(String name, Node Page) {
		Pages.put(name, Page);
	}

	public Node getPage(String name) {
		return Pages.get(name);
	}

	public boolean loadPage(String name, String resource) {
		try {
			FXMLLoader loader = new FXMLLoader(
					getClass().getResource(resource));
			Parent loadPage = (Parent) loader.load();
			ControlledPage myPageController = ((ControlledPage) loader
					.getController());
			myPageController.setPageParent(this);
			addPage(name, loadPage);
			return true;
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return false;
		}
	}

	public boolean setPage(final String name) {
		if (Pages.get(name) != null) {
			if (!getChildren().isEmpty()) {

				new KeyFrame(new Duration(1000),
						new EventHandler<ActionEvent>() {
							@Override
							public void handle(ActionEvent a) {
								getChildren().remove(0);
								getChildren().add(0, Pages.get(name));
							}
						});
				
			} else {
				getChildren().add(Pages.get(name));
			}
			return true;
		}

		else {
			System.out.println("Page was not loaded");
			return false;
		}
	}

	public boolean unloadPage(String name) {
		if (Pages.remove(name) == null) {
			System.out.println("there is no Page");
			return false;
		} else {
			return true;
		}
	}
}