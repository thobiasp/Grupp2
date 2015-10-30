package main;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import main.Booking.Type;

public class Transport /*extends Application*/ {
	
	
	static ObservableList<String> timeList=FXCollections.observableArrayList();
	
	//@Override
	//public void start(Stage primaryStage) {
		
	
		public static GridPane getNode() {
		
		GridPane root = new GridPane();
		Scene scene = new Scene(root, 800, 300);
		//scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		//primaryStage.setScene(scene);
		//primaryStage.show();
		//primaryStage.setTitle("Book A Taxi");
		
		Label labelFr= new Label("From");
		Label labelTo= new Label("To");
		Label labelDat= new Label("Date");
		Label labelTim= new Label("Time");
		TextField from= new TextField();
		from.setText("STARGAZE SPA & RESORT");
		
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
		comformfr.setText(" From "+from.getText().toString());
		
		HBox hbox= new HBox();
		hbox.getChildren().addAll(comformfr,comformto,comformdate,comformtime,comformprice);
		root.setHgap(10);
		root.setVgap(10);
		
		timeList.addAll("17:00","17:30");
		timeList.addAll("18:00","18:30");
		timeList.addAll("19:00","19:30");
		timeList.addAll("20:00","20:30");
		timeList.addAll("21:00","21:30");
		timeList.addAll("22:00","22:30");
		
        ComboBox cb = new ComboBox(timeList);
        cb.setPromptText("Select Time");

		root.add(labelFr, 0,0 );
		root.add(from, 1, 0);
		root.add(labelTo, 2, 0);
		root.add(to, 3, 0);
		root.add(labelDat, 0,1 );
		root.add(date, 1, 1);
		root.add(labelTim, 2, 1);
		root.add(cb, 3, 1);
		root.add(bookbn, 5, 1);
		root.add(hbox, 0, 5);
		root.setColumnSpan(hbox, 5);
		
		to.setDisable(false);
		date.setDisable(false);
		time.setDisable(false);
		
	      from.setOnMouseEntered(e -> {
	    	  from.setOnMouseClicked(event2 ->{
	    		  from.setText("");
	    		  comformfr.setText("");
	    		  
	    	  });
	    	  
	      });
		
		
		from.setOnAction(event->{

			
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
		
		
		


		cb.setOnAction(event->{
		
			comformtime.setText(" "+cb.getValue().toString()+" ");
			
			String value= Float.toString(price);
			comformprice.setText(value +" $ ");
		});
		
		
		bookbn.setOnAction(event->{
			
			String [] parts  = date.getValue().toString().split("-");
			int part1 = Integer.parseInt(parts[0]);
			int part2 = Integer.parseInt(parts[1]);
			int part3 = Integer.parseInt(parts[2]);
			
			String fromTo = from.getText().toString()+"-"+to.getText().toString();
			
			
			String [] hourAndMinutes = cb.getValue().toString().split(":");
			int hour = Integer.parseInt(hourAndMinutes[0]);
			int minute = Integer.parseInt(hourAndMinutes[1]);
			
			
			Booking temp  = new Booking(part2, part3, hour, minute,fromTo, Type.TAXI);
			
			RootClass.allBookings.add(temp);
			
			HBox hbox2 = new HBox(20);
			Button cancelButton = new Button("Cancel");
			Label timeOfOrder= new Label(RootClass.allBookings.get(RootClass.allBookings.size()-1).getCreatedDtAsString());
			Label type = new Label(RootClass.allBookings.get(RootClass.allBookings.size()-1).getTypeAsString());
			Label price2 = new Label(RootClass.allBookings.get(RootClass.allBookings.size()-1).getPriceAsString());
			Label speci = new Label(RootClass.allBookings.get(RootClass.allBookings.size()-1).getSpecification());
			
			hbox2.getChildren().addAll(timeOfOrder,type,speci,cancelButton);
			RootClass.obj.add(hbox2);
			
			//events for cancel button
			cancelButton.setOnAction(event2->{
				RootClass.obj.remove(hbox2);
				RootClass.allBookings.remove(temp);
			
			});
			
			
		});
		
		
		
		
		
		
		return root;
		

		
	}

}
