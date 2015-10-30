package main;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import main.Booking.Type;

import java.time.LocalDateTime;

import com.sun.tools.hat.internal.model.Root;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class BookATable {

	public static GridPane getNode() {

		GridPane root = new GridPane();
		Scene scene = new Scene(root, 800, 300);
		//scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());

		DatePicker date = new DatePicker();

		Button book = new Button("Book");
		ComboBox<Integer> comBoxPer;
		ObservableList<Integer> intEntry = FXCollections.observableArrayList();
		comBoxPer = new ComboBox<>(intEntry);
		for (int i = 1; i < 16; i++) {
			intEntry.add(i);
		}
		comBoxPer.setMinWidth(100);
		comBoxPer.setPromptText("2");

		//TextField time = new TextField();
		ObservableList<String> timeList = FXCollections.observableArrayList();
		ComboBox<String> time = new ComboBox<>(timeList);
		
		timeList.addAll("17:00", "17:30");
		timeList.addAll("18:00", "18:30");
		timeList.addAll("19:00", "19:30");
		timeList.addAll("20:00", "20:30");
		timeList.addAll("21:00", "21:30");
		timeList.addAll("22:00", "22:30");

		Label labelDate = new Label();
		Label labelTime = new Label();
		Label labelPpl = new Label();

		Label labelD = new Label("Date");
		Label labelP = new Label("Number of People");
		Label labelT = new Label("Time");
		time.setPromptText("setPromptText");
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

		date.setOnAction(e -> {

			labelDate.setText(date.getValue().toString());

		});
		
		/*
		time.setOnKeyPressed(e -> {

			if (e.getCode().equals(KeyCode.ENTER)) {
				labelTime.setText(time.getText());

			}
		});
	*/
		
		// sätter två personer som default till labelPlp
		labelPpl.setText("People" + comBoxPer.getPromptText().toString());
		comBoxPer.setValue(2);
		
		comBoxPer.setOnAction(e -> {

			labelPpl.setText("People" + comBoxPer.getValue().toString());
		});
		
		
		//public Booking(int month, int day, int hour, int minute, float price, String specification, Type type)
		
		book.setOnAction(event->{
			String [] parts  = date.getValue().toString().split("-");
			int part1 = Integer.parseInt(parts[0]);
			int part2 = Integer.parseInt(parts[1]);
			int part3 = Integer.parseInt(parts[2]);
			
			System.out.println(part1 + "-" + part2 + "-" + part3);
			
			String [] hourAndMinutes = time.getValue().toString().split(":");
			int hour = Integer.parseInt(hourAndMinutes[0]);
			int minute = Integer.parseInt(hourAndMinutes[1]);
			
			Booking temp  = new Booking(part2, part3, hour, minute, "Table for" + comBoxPer.getValue().toString(), Type.TABLE);
			RootClass.allBookings.add(temp);
			
			HBox hbox = new HBox(20);
			Button cancelButton = new Button("Cancel");
			Label timeOfOrder= new Label(RootClass.allBookings.get(RootClass.allBookings.size()-1).getCreatedDtAsString());
			Label type = new Label(RootClass.allBookings.get(RootClass.allBookings.size()-1).getTypeAsString());
			Label price = new Label(RootClass.allBookings.get(RootClass.allBookings.size()-1).getPriceAsString());
			
			hbox.getChildren().addAll(timeOfOrder,type,price,cancelButton);
			RootClass.obj.add(hbox);
			
			//events for cancel button
			cancelButton.setOnAction(event2->{
				RootClass.obj.remove(hbox);
				RootClass.allBookings.remove(temp);
			
			});
					
		});
		return root;
	}
}
