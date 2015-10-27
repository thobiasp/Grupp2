package main;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class BookATable extends Application {

	@Override
	public void start(Stage primaryStage) {
		GridPane root = new GridPane();
		Scene scene = new Scene(root, 800, 300);
		scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		primaryStage.setScene(scene);
		primaryStage.show();
		primaryStage.setTitle("Book A Table");

		DatePicker date = new DatePicker();

		Button book = new Button("Book");
		ComboBox<Integer> comBoxPer;
		ObservableList<Integer> intEntry = FXCollections.observableArrayList();
		comBoxPer = new ComboBox<>(intEntry);
		for (int i = 1; i < 16; i++) {
			intEntry.add(i);
		}
		comBoxPer.setMinWidth(100);

		TextField time = new TextField();
		TableView<Booking> tableView = new TableView<>();
		// ObservableList<Booking> ta =
		
		tableView.setMaxSize(100, 100);
		Label labelD = new Label("Date");
		Label labelP = new Label("Number of People");
		Label labelT = new Label("Time");
		time.setPromptText("12:00");

		root.add(labelD, 0, 0);
		root.add(date, 0, 1);
		root.add(labelT, 1, 0);
		root.add(time, 1, 1);

		root.add(labelP, 0, 2);
		root.add(comBoxPer, 0, 3);
		root.add(tableView, 2, 3);
		root.add(book, 3, 3);
	}

	public static void main(String[] args) {
		launch(args);
	}
}
