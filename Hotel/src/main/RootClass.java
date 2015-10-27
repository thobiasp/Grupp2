package main;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.LinkedList;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.input.MouseEvent;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontSmoothingType;
import javafx.stage.Stage;
import javafx.util.converter.LocalDateTimeStringConverter;
import main.Booking.BType;

public class RootClass extends Application {
	
	

	@Override
	public void start(Stage primaryStage) {
		
		BorderPane root = new BorderPane();
		Scene scene = new Scene(root, 800, 600);
		scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		primaryStage.setScene(scene);
		primaryStage.show();
		
		//lists for 'upcomingEvents' center pane
		ObservableList<HBox> obj=FXCollections.observableArrayList();
		ListView<HBox> listOfEvents = new ListView<>(obj);
		
	
		
		//StackPane for 'root' center pane
		StackPane centerStack = new StackPane();
		
		//test labels for testing buttons in 'root' top pane
		Label stack0 = new Label("Button 1");
		Label stack1 = new Label("Button 2");
		Label stack2 = new Label("Button 3");
		Label stack3 = new Label("Button 4");
		
		
		//Settings for 'upcoming events' BorderPane
		BorderPane upcomingEvents = new BorderPane();			
		VBox rightOfCenterPane = new VBox();
		VBox leftOfCenterPane = new VBox();
		rightOfCenterPane.setPrefWidth(300);
		leftOfCenterPane.setPrefWidth(300);
		
		//Test button for adding in 'upcoming events'
		Button add = new Button("add obj");
		
		//Add nodes to 'upcoming events' BorderPane
		upcomingEvents.setRight(rightOfCenterPane);
		upcomingEvents.setBottom(add);
		upcomingEvents.setCenter(listOfEvents);
		upcomingEvents.setLeft(leftOfCenterPane);
		
	

		
		//VBox for bottom pane in 'root' BorderPane
		VBox bottomVBoxInRoot = new VBox();
		Label head = new Label("Upcoming events");
		head.setFont(Font.font(STYLESHEET_CASPIAN, 25));
		bottomVBoxInRoot.getChildren().add(head);
	
		
		//event for button in 'upcomingEvents' bottom
		add.setOnAction(event->{
			LocalDateTime currenttime = LocalDateTime.now();
			HBox hbox = new HBox(10);
			Button x = new Button("X");
			Label test1 = new Label(currenttime.getHour()+":"+currenttime.getSecond()+" fahf");

			hbox.getChildren().addAll(test1,x);
			obj.add(hbox);
			
			x.setOnAction(event2->{
				obj.remove(hbox);
			});
		});
		
		
		//creates mouse event for VBox in root
		bottomVBoxInRoot.addEventHandler(MouseEvent.MOUSE_CLICKED, event ->{

			//clears root center and adds BorderPane 'upcomingEvents'
			centerStack.getChildren().clear();
			centerStack.getChildren().add(upcomingEvents);
			
			
		});
		
		//makes big label in bottom root VBox change color to GRAY when hovering
		bottomVBoxInRoot.addEventHandler(MouseEvent.MOUSE_ENTERED, event ->{
			
			head.setTextFill(Color.GRAY);
		});
		
		
		//makes big label in bottom root VBox change color to BLACK when not hovering
		bottomVBoxInRoot.addEventHandler(MouseEvent.MOUSE_EXITED, event ->{
			
			head.setTextFill(Color.BLACK);
			
			
		});
		
		root.setCenter(centerStack);
		root.setBottom(bottomVBoxInRoot);
		
		

		
		
		
		
		StackPane top = new StackPane();
		top.setPrefSize(800, 150);
		
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
		
		VBox id = new VBox(10);
		id.setAlignment(Pos.CENTER);
		Label roomNumber = new Label("237");
		Label fullName = new Label("Eyvind");
		Button hKButton = new Button("Cleaning");
		id.getChildren().addAll(roomNumber, fullName, hKButton);
		
		buttons.getChildren().addAll(food, spa, transport, houseKeeping);
		bpTop.setBottom(buttons);
		bpTop.setRight(id);
		top.getChildren().add(nightView);
		top.getChildren().add(bpTop);
		root.setTop(top);
		
		
		//ActionEvents till huvudknapparna
		food.setOnAction(e -> {
			centerStack.getChildren().clear();
			centerStack.getChildren().add(stack0);
		});
		
		spa.setOnAction(e -> {
			centerStack.getChildren().clear();
			centerStack.getChildren().add(stack1);
		});
		
		transport.setOnAction(e -> {
			centerStack.getChildren().clear();
			centerStack.getChildren().add(stack2);
		});
		
		houseKeeping.setOnAction(e -> {
			centerStack.getChildren().clear();
			centerStack.getChildren().add(stack3);
		});
		
	}

	public static void main(String[] args) {
		launch(args);
	}
}
