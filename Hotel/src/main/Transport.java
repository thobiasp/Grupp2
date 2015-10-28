package main;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class Transport /*extends Application*/ {

	
	//@Override
	//public void start(Stage primaryStage) {
		
	
		public GridPane getNode() {
		
		GridPane root = new GridPane();
		Scene scene = new Scene(root, 800, 300);
		scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		//primaryStage.setScene(scene);
		//primaryStage.show();
		//primaryStage.setTitle("Book A Taxi");
		
		Label labelFr= new Label("From");
		Label labelTo= new Label("To");
		Label labelDat= new Label("Date");
		Label labelTim= new Label("Time");
		TextField from= new TextField();
		TextField to= new TextField();
		DatePicker date= new DatePicker();
		Button bookbn= new Button("Book"); 
		TextField time= new TextField();
		Label comformfr= new Label();
		Label comformto= new Label();
		Label comformdate= new Label();
		Label comformtime= new Label();
		Label comformprice=new Label();
		float price= 35f;
		HBox hbox= new HBox();
		hbox.getChildren().addAll(comformfr,comformto,comformdate,comformtime,comformprice);
		root.setHgap(10);
		root.setVgap(10);

		root.add(labelFr, 0,0 );
		root.add(from, 1, 0);
		root.add(labelTo, 2, 0);
		root.add(to, 3, 0);
		root.add(labelDat, 0,1 );
		root.add(date, 1, 1);
		root.add(labelTim, 2, 1);
		root.add(time, 3, 1);
		root.add(bookbn, 4, 5);
		root.add(hbox, 1, 5);
		
		
		to.setDisable(true);
		date.setDisable(true);
		time.setDisable(true);
		from.setOnAction(event->{
			to.setDisable(false);
			comformfr.setText(" From "+from.getText().toString());
			
		});
		
		
	    
		to.setOnAction(event->{
			date.setDisable(false);
			comformto.setText( " To "+to.getText().toString());
			
		});
		
		
		
		date.setOnAction(event->{
			time.setDisable(false);
			comformdate.setText(" "+date.getValue().toString());
			
		});
		
		
		


		time.setOnAction(event->{
		
			comformtime.setText(" "+time.getText().toString()+" ");
			
			String value= Float.toString(price);
			comformprice.setText(value +" $ ");
		});
		return root;
		



		
	}
/*
	public static void main(String[] args) {
		launch(args);
	}
	*/
}
