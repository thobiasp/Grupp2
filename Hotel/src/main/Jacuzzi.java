package main;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;

public class Jacuzzi {

	
	public static GridPane getNode() {
		
		GridPane root = new GridPane();
		Scene scene = new Scene(root, 800, 300);
		root.setHgap(10);
		root.setVgap(10);
		
		DatePicker date = new DatePicker();
		
		Button book = new Button("Book");
		
		Label labelDate= new Label("Date");
		Label labelTime= new Label("Time");
		
		HBox hbox= new HBox();
		
		ObservableList<String> timeList = FXCollections.observableArrayList();
		ComboBox<String> time = new ComboBox<>(timeList);
		
		timeList.addAll("17:00", "17:30");
		timeList.addAll("18:00", "18:30");
		timeList.addAll("19:00", "19:30");
		timeList.addAll("20:00", "20:30");
		timeList.addAll("21:00", "21:30");
		timeList.addAll("22:00", "22:30");
		
		root.add(labelDate, 0, 0);
		root.add(date, 1, 0);
		
		
		
		
		// actionevents
		date.setOnAction(e -> {

			labelDate.setText(date.getValue().toString());

		});
		
		
		return root;
	}
}
