package main;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class RootClass extends Application {

	@Override
	public void start(Stage primaryStage) {
		
		BorderPane root = new BorderPane();
		Scene scene = new Scene(root, 800, 600);
		scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		primaryStage.setScene(scene);
		primaryStage.show();
		
		BorderPane rootTop = new BorderPane();
		
		Image night = new Image("images/night.jpg");
		ImageView nightView = new ImageView(night);
		nightView.setFitHeight(150);
		nightView.setFitWidth(800);
		
		HBox buttons = new HBox(10);
		buttons.setAlignment(Pos.CENTER);
		
		Button food = new Button("FOOD");
		Button spa = new Button("SPA");
		Button transport = new Button("TRANSPORT");
		Button houseKeeping = new Button("HOUSEKEEPING");
		
		VBox id = new VBox(10);
		id.setAlignment(Pos.CENTER);
		Label roomNumber = new Label();
		
		buttons.getChildren().addAll(food, spa, transport, houseKeeping);
		rootTop.setCenter(nightView);
		rootTop.setBottom(buttons);
		root.setTop(rootTop);
		
	}

	public static void main(String[] args) {
		launch(args);
	}
}
