package main;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class BookATable {

		public GridPane getNode() {
		
		GridPane root = new GridPane();
		Scene scene = new Scene(root, 800, 300);
		scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());

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

		Label labelDate = new Label();
		Label labelTime = new Label();
		Label labelPpl = new Label();

		Label labelD = new Label("Date");
		Label labelP = new Label("Number of People");
		Label labelT = new Label("Time");
		time.setPromptText("12:00");
		HBox hbox1 = new HBox(10);
		hbox1.getChildren().addAll(labelDate, labelTime, labelPpl);
		root.setHgap(8);
		root.setVgap(8);
		root.add(labelD, 0, 0);
		root.add(date, 0, 1);
		root.add(labelT, 1, 0);
		root.add(time, 1, 1);
		root.add(hbox1, 2, 3);
		root.add(labelP, 0, 2);
		root.add(comBoxPer, 0, 3);
		root.add(book, 3, 3);

		time.setDisable(true);
		comBoxPer.setDisable(true);

		date.setOnAction(e -> {

			time.setDisable(false);
			labelDate.setText(date.getValue().toString());

		});

		time.setOnKeyPressed(e -> {

			if (e.getCode().equals(KeyCode.ENTER)) {
				labelTime.setText(time.getText());
				comBoxPer.setDisable(false);
			}
		});

		comBoxPer.setOnAction(e -> {
			
			labelPpl.setText("People" + comBoxPer.getValue().toString());

		});
		return root;
	}
}

