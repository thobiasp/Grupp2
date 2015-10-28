package main;

import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
import javafx.scene.layout.StackPane;

public class EnterFood {

	public StackPane showButtons(){
		
		StackPane rootNode = new StackPane();
		Scene scene = new Scene(rootNode, 800, 300);

		GridPane gp = new GridPane();
		ColumnConstraints column = new ColumnConstraints(400);
		RowConstraints row = new RowConstraints(300);
		gp.getColumnConstraints().add(column);
		gp.getRowConstraints().add(row);

		gp.setGridLinesVisible(true);

		Button bookTable = new Button("Book \n a \n table");
		Button roomService = new Button("Room service");

		bookTable.setPrefSize(400, 300);
		roomService.setPrefSize(400, 300);

		gp.add(bookTable, 0, 0);
		gp.add(roomService, 1, 0);

		rootNode.getChildren().add(gp);

		
		// ActionEvents for buttons

		bookTable.setOnAction(e -> {
			rootNode.getChildren().clear();
			rootNode.getChildren().add(new BookATable().getNode());
		});

		roomService.setOnAction(e -> {
			rootNode.getChildren().clear();
			rootNode.getChildren().add(new RoomService().getRsNode());
		});
		
		return rootNode;
		

	}

}
