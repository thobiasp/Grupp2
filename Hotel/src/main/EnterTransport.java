package main;

import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
import javafx.scene.layout.StackPane;

public class EnterTransport {

	public StackPane showButtons(){
		
		StackPane rootNode = new StackPane();
		Scene scene = new Scene(rootNode, 800, 300);

		GridPane gp = new GridPane();
		ColumnConstraints column = new ColumnConstraints(400);
		RowConstraints row = new RowConstraints(300);
		gp.getColumnConstraints().add(column);
		gp.getRowConstraints().add(row);

		gp.setGridLinesVisible(true);

		Button bookTransport = new Button("Book \n transport");
		Button quickBook = new Button("Quick Book \n(sends a taxi to the hotel right away)");

		bookTransport.setPrefSize(400, 300);  
		quickBook.setPrefSize(400, 300);

		gp.add(bookTransport, 0, 0);
		gp.add(quickBook, 1, 0);

		rootNode.getChildren().add(gp);

		
		// ActionEvents for buttons

		bookTransport.setOnAction(e -> {
			rootNode.getChildren().clear();
			rootNode.getChildren().add(new Transport().getNode());
		});

		quickBook.setOnAction(e -> {
			
		});
		
		return rootNode;
		

	}
}
