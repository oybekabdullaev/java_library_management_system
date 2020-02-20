package lms.windows;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import lms.entities.Book;
import lms.managers.BookManager;

public class FilterController implements Initializable {
	@FXML private RadioButton title;
	@FXML private RadioButton subject;
	@FXML private RadioButton author;
	@FXML private RadioButton isbn;
	@FXML private RadioButton publishDate;
	@FXML private TextField text;
	
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub

	}

	public void filter(ActionEvent event) throws IOException {
		String filter = "";
		String filterText = text.getText();
		if (title.isSelected()) filter = "title";
		if (subject.isSelected()) filter = "subject";
		if (author.isSelected()) filter = "author";
		if (isbn.isSelected()) filter = "isbn";
		if (publishDate.isSelected()) filter = "publishDate";
		BookManager manager = BookManager.getInstance();
		ObservableList<Book> list = manager.getFilteredBooks(filter, filterText);
		
		((Node) event.getSource()).getScene().getWindow().hide();
		Stage primaryStage = new Stage();
		FXMLLoader loader = new FXMLLoader();
		Pane root;
		root = loader.load(getClass().getResource("DisplayFilteredBooks.fxml").openStream());
		DisplayFilteredBooksController controller = (DisplayFilteredBooksController)loader.getController();
		controller.fill(list);
		Scene scene = new Scene(root);
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	public void cancel(ActionEvent event) {
		((Node) event.getSource()).getScene().getWindow().hide();
	}
}
