package main;


import java.time.LocalDateTime;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class RootClass extends Application {
	
	String hejhej;
	String finalText = "";

	LocalDateTime currentTime;
	EnterSpa enterSpa = new EnterSpa();
	public static ObservableList<Booking>allBookings=FXCollections.observableArrayList();
	public static ObservableList<HBox> obj=FXCollections.observableArrayList();



	@Override
	public void start(Stage primaryStage) {

		BorderPane root = new BorderPane();
		Scene scene = new Scene(root, 800, 600);
		scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		primaryStage.setScene(scene);
		primaryStage.show();
		primaryStage.setResizable(false);
		

	
	/*
		//StackPane for 'root' center pane
		StackPane centerStack = new StackPane();*/
		

		//Test buttons to check items in allBookings
		Button print = new Button("Print to Console");
		//Button clear = new Button("Clear");

		HBox testButtons = new HBox(10);
		testButtons.getChildren().addAll(print);
		root.setBottom(testButtons);

		print.setOnAction(event->{
			for(Booking e:allBookings){
				
				System.out.println(e.getCreatedDtAsString()+" "+e.getTypeAsString());
				
			}
			System.out.println("");

		});

	/*	
		clear.setOnAction(event->{
			//allBookings.clear();
		   
		});
		*/
	
		
		
		
		
		
		
		/*####################################################################################*/
		
		
		
		
		
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
		//root.setCenter(centerStack); 
		
		
		//ActionEvents till huvudknapparna
		food.setOnAction(e -> {
			//centerStack.getChildren().clear();
			//centerStack.getChildren().add(stack0);
			root.setCenter(null);
			root.setCenter(EnterFood.showButtons());
		});
		
		spa.setOnAction(e -> {
			//centerStack.getChildren().clear();
			//centerStack.getChildren().add(stack1);
			root.setCenter(null);
			root.setCenter(EnterSpa.showButtons());
		});
		
		transport.setOnAction(e -> {
			//centerStack.getChildren().clear();
			//centerStack.getChildren().add(stack2);
			root.setCenter(null);
			root.setCenter(EnterTransport.showButtons());
		});
		
		houseKeeping.setOnAction(e -> {
			//centerStack.getChildren().clear();
			//centerStack.getChildren().add(stack3);
			root.setCenter(null);
			root.setCenter(EnterHouseKeeping.showButtons());
		});
		
		
		orders.setOnAction(e -> {
			//centerStack.getChildren().clear();
			root.setCenter(null);
			root.setCenter(AllEvents.getNode());
			
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
