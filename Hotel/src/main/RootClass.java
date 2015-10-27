package main;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontSmoothingType;
import javafx.stage.Stage;

public class RootClass extends Application {

	@Override
	public void start(Stage primaryStage) {
		
		BorderPane root = new BorderPane();
		Scene scene = new Scene(root, 800, 600);
		scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		primaryStage.setScene(scene);
		primaryStage.show();
		
		
		StackPane centerStack = new StackPane();
		TextArea test = new TextArea();
		root.setCenter(test);
		VBox bottomNode = new VBox();
		Label head = new Label("Upcoming events");
		head.setFont(Font.font(STYLESHEET_CASPIAN, 25));
		Label test1 = new Label("17:00 Spa");
		Label test2 = new Label("19:00 Table booked - 4 persons");
		Label test3 = new Label("21:00 Sauna booked");
		Label test4 = new Label("23:00 Taxi booked - 4 persons");
		bottomNode.getChildren().addAll(head,test1,test2,test3,test4);
		
		
	
		bottomNode.addEventHandler(MouseEvent.MOUSE_CLICKED, event ->{
			
			test.setText("Test");
			
			
		});
		
		bottomNode.addEventHandler(MouseEvent.MOUSE_ENTERED, event ->{
			
			head.setTextFill(Color.GRAY);
			
			
		});
		
		bottomNode.addEventHandler(MouseEvent.MOUSE_EXITED, event ->{
			
			head.setTextFill(Color.BLACK);
			
			
		});
		root.setBottom(bottomNode);
		
		
		
		
	}

	public static void main(String[] args) {
		launch(args);
	}
}
