package main;


import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.TreeMap;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class RootClass extends Application {
	
 
	String finalText;

	LocalDateTime currentTime;
	EnterSpa enterSpa = new EnterSpa();
	public static ObservableList<Booking>allBookings=FXCollections.observableArrayList();
	
	public static void addBooking(Booking b){
		allBookings.add(b);
	}


	@Override
	public void start(Stage primaryStage) {
		//format to show in listOfEvents
		DateFormat dateFormat = new SimpleDateFormat("dd/MM HH:mm");
		//format to add to TreeMap so treemap can be sorted
		DateFormat dateFormat2 = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		BorderPane root = new BorderPane();
		Scene scene = new Scene(root, 800, 600);
		scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		primaryStage.setScene(scene);
		primaryStage.show();
		primaryStage.setResizable(false);
		
		TreeMap<String,String>mapForEvents = new TreeMap<>();
		
		//lists for 'upcomingEvents' center pane
		ObservableList<HBox> obj=FXCollections.observableArrayList();
		
		ListView<HBox> listOfEvents = new ListView<>(obj);
		
		
	
		//StackPane for 'root' center pane
		StackPane centerStack = new StackPane();
		

		//Test buttons to check items in allBookings
		Button print = new Button("Print");
		Button clear = new Button("Clear");
		TextArea testArea =new TextArea();
		testArea.setPrefHeight(70);
		HBox testButtons = new HBox(10);
		testButtons.getChildren().addAll(print,clear,testArea);
		root.setBottom(testButtons);

		//Settings for 'upcoming events' BorderPane
		BorderPane upcomingEvents = new BorderPane();			
		VBox rightOfCenterPane = new VBox();
		VBox leftOfCenterPane = new VBox();
		rightOfCenterPane.setPrefWidth(250);
		leftOfCenterPane.setPrefWidth(300);
		
		//Test button for adding in 'upcoming events'
		Button add = new Button("test Book");
		
		//Add nodes to 'upcoming events' BorderPane
		upcomingEvents.setRight(rightOfCenterPane);
		upcomingEvents.setBottom(add);
		upcomingEvents.setCenter(listOfEvents);
		upcomingEvents.setLeft(leftOfCenterPane);
		
		print.setOnAction(event->{
			for(Booking e:allBookings){
				
				String hej = e.getStartDtAsString()+ e.getType().toString();
				finalText+=hej+"\n";
			}
			
			testArea.setText(finalText);
		});
		
		
		clear.setOnAction(event->{
			allBookings.clear();
			testArea.clear();
		});
		
	
		
		//event for button in 'upcomingEvents' bottom
		add.setOnAction(event->{
			Date date = new Date();

			HBox hbox = new HBox(20);
			
			Button cancelButton = new Button("Cancel");
			Label timeOfOrder= new Label(dateFormat.format(date));
			Label test1 = new Label("Taxi");
			Label price = new Label("150:-");
			String dateToMap = dateFormat2.format(date);
			String typeToMap=test1.getText();
			
			hbox.getChildren().addAll(timeOfOrder,test1,price,cancelButton);
			obj.add(hbox);
			
			//adding key:date and value:type  to TreeMap 'mapForEvents'
			mapForEvents.put(dateToMap,typeToMap);
			
			
			//events for cancel button
			cancelButton.setOnAction(event2->{
				obj.remove(hbox);
				mapForEvents.remove(dateToMap);
				
				/*
				bottomVBoxInRoot.getChildren().remove(1);
				*/		
			});
					
		});
		

		
		root.setCenter(centerStack); 
		


		StackPane topNode = new StackPane();
		topNode.setPrefSize(800, 150);
		
		Image night = new Image("images/night.jpg");
		ImageView nightView = new ImageView(night);
		nightView.setFitHeight(150);
		nightView.setFitWidth(800);
		
		
		BorderPane bpTop = new BorderPane();
		bpTop.setPrefSize(800, 150);
		
		HBox buttons = new HBox(10);
		buttons.setAlignment(Pos.CENTER);
		
		Button food = new Button("FOOD");
		Button spa = new Button("SPA");
		Button transport = new Button("TRANSPORT");
		Button houseKeeping = new Button("HOUSEKEEPING");
		//thobias knapp
		Button orders = new Button("YOUR ORDERS");
		
		//Styles
//		food.setStyle("-fx-opacity: 0.7; -fx-color: rgb(168,0,0); -fx-font-weight: bold;");
//		spa.setStyle("-fx-opacity: 0.7; -fx-color: rgb(168,0,0); -fx-font-weight: bold;");
//		transport.setStyle("-fx-opacity: 0.7; -fx-color: rgb(168,0,0); -fx-font-weight: bold;");
//		houseKeeping.setStyle("-fx-opacity: 0.7; -fx-color: rgb(168,0,0); -fx-font-weight: bold;");
		
				// ID FOR CSS
				food.setMinSize(180, 30);
				spa.setMinSize(180, 30);
				transport.setMinSize(180, 30);
				houseKeeping.setMinSize(180, 30);
				orders.setMinSize(30, 30);
				
				food.setId("food");
				spa.setId("spa");
				transport.setId("transport");
				houseKeeping.setId("houseKeeping");
				orders.setId("orders");
				// ID FOR CSS   
		
		/*
		food.setPrefWidth(150);
		spa.setPrefWidth(150);
		transport.setPrefWidth(150);
		houseKeeping.setPrefWidth(150);
		orders.setPrefWidth(30);
		*/
		
		VBox id = new VBox(10);
		id.setAlignment(Pos.CENTER);
		Label roomNumber = new Label("ROOM: 237");
		Label fullName = new Label("No Name");
		Button hKButton = new Button("Housekeeping");
		hKButton.setTextFill(Color.GREEN);
		id.getChildren().addAll(roomNumber, fullName, hKButton);
		
		buttons.getChildren().addAll(food, spa, transport, houseKeeping,orders);
		bpTop.setBottom(buttons);
		bpTop.setRight(id);
		topNode.getChildren().add(nightView);
		topNode.getChildren().add(bpTop);
		root.setTop(topNode);
		
		
		//ActionEvents till huvudknapparna
		food.setOnAction(e -> {
			centerStack.getChildren().clear();
			//centerStack.getChildren().add(stack0);
			centerStack.getChildren().add(new EnterFood().showButtons());
		});
		
		spa.setOnAction(e -> {
			centerStack.getChildren().clear();
			//centerStack.getChildren().add(stack1);
			centerStack.getChildren().add(new EnterSpa().showButtons());
		});
		
		transport.setOnAction(e -> {
			centerStack.getChildren().clear();
			//centerStack.getChildren().add(stack2);
			centerStack.getChildren().add(new EnterTransport().showButtons());
		});
		
		houseKeeping.setOnAction(e -> {
			centerStack.getChildren().clear();
			//centerStack.getChildren().add(stack3);
			centerStack.getChildren().add(new EnterHouseKeeping().showButtons());
		});
		
		
		orders.setOnAction(e -> {
			centerStack.getChildren().clear();
			centerStack.getChildren().add(upcomingEvents);
			
		});
		
		//ActionEvent till HouseKeeping
		hKButton.setOnAction(e -> {
			if (hKButton.getText().equals("Housekeeping")){
				hKButton.setText("Do not disturb");
				hKButton.setTextFill(Color.RED);
			} else {
				hKButton.setText("Housekeeping");
				hKButton.setTextFill(Color.GREEN);
			}
		});
		
	}
	
	
	public static void main(String[] args) {
		launch(args);



	}
}
