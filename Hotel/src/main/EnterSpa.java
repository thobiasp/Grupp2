package main;



import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class EnterSpa {

	public static StackPane showButtons(){

		StackPane rootNode = new StackPane();
		Scene scene = new Scene(rootNode, 800, 300);

		GridPane gp = new GridPane();
		ColumnConstraints column = new ColumnConstraints(400);
		RowConstraints row = new RowConstraints(150);
		gp.getColumnConstraints().add(column);
		gp.getRowConstraints().add(row);

		gp.setGridLinesVisible(true);

		Button treatments = new Button("treatments");
		Button openingHours = new Button("openingHours");
		Button sauna = new Button("Sauna");
		Button jacuzzi = new Button("Jacuzzi");

		treatments.setPrefSize(400, 150);
		openingHours.setPrefSize(400, 150);
		sauna.setPrefSize(400, 150);
		jacuzzi.setPrefSize(400, 150);

		gp.add(treatments, 0, 0);
		gp.add(openingHours, 1, 0);
		gp.add(sauna, 0, 1);
		gp.add(jacuzzi, 1, 1);

		rootNode.getChildren().add(gp);

		
		// ActionEvents for buttons

		treatments.setOnAction(e -> {
			System.out.println("test1");
		});

		openingHours.setOnAction(e -> {
			System.out.println("test2");
		});

		sauna.setOnAction(e -> {
			System.out.println("test3");
		});

		jacuzzi.setOnAction(e -> {
				rootNode.getChildren().clear();
				rootNode.getChildren().add(Jacuzzi.getNode());
			});
			
		
		return rootNode;
		

	}
}
