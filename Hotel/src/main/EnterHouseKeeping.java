package main;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;

public class EnterHouseKeeping {

public Group showButtons(){
		
		Group rootNode = new Group();
		Scene scene = new Scene(rootNode, 800, 300);

		GridPane gp = new GridPane();
		ColumnConstraints column = new ColumnConstraints(400);
		RowConstraints row = new RowConstraints(300);
		gp.getColumnConstraints().add(column);
		gp.getRowConstraints().add(row);

		gp.setGridLinesVisible(true);

		Button requests = new Button("Requsets");
		Button clean = new Button("Clean");

		requests.setPrefSize(400, 300);
		clean.setPrefSize(400, 300);

		gp.add(requests, 0, 0);
		gp.add(clean, 1, 0);

		rootNode.getChildren().add(gp);

		
		// ActionEvents for buttons

		requests.setOnAction(e -> {
			System.out.println("test1");
		});

		clean.setOnAction(e -> {
			if(clean.getText().equals("Clean")){
				clean.setText("Do not disturb");
			} else {
				clean.setText("Clean");
			}
		});
		
		return rootNode;
	}

}
