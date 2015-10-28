package main;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Housekeeping extends Application {
String finalRequest="";
	@Override
	public void start(Stage primaryStage) {
		
		GridPane root = new GridPane();
		Scene scene = new Scene(root, 800, 300);
		scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		primaryStage.setScene(scene);
		primaryStage.show();
		primaryStage.setTitle("Book Housekeeping");
		CheckBox box1 = new CheckBox("MiniBar");
		CheckBox box2 = new CheckBox("Extra Bed");
		CheckBox box3 = new CheckBox("Extra Pillow");
		CheckBox box4 = new CheckBox("Extra  Sheets");
		Label label=new Label(" Request");
        TextArea text=new TextArea();
        Button sendbn= new Button("Send");
        root.add(box1, 0, 0);
        root.add(box2, 0, 1);
        root.add(box3, 0, 2);
        root.add(box4, 0, 3);
        root.add(label, 0, 4);
        root.add(text, 0, 5);
        root.add(sendbn, 0, 6);
        sendbn.setOnAction(event->{
        	if (box1.isSelected()){
        		finalRequest+=" Please refile my minibar \n";
        		
        	}
        	if (box2.isSelected()){
        		finalRequest+=" I want Extra Bed \n";
        	}
        	
        
    	if (box3.isSelected()){
    		finalRequest+=" I want Extra Pillow  \n";
    	}
        	
        
    	if (box4.isSelected()){
    		finalRequest+=" I want Extra Sheets \n";
    	}
    	
    	finalRequest+= text.getText();
    
    	
        });
		
	}

	public static void main(String[] args) {
		launch(args);
	}
}
