package main;

import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.RowConstraints;
import javafx.scene.layout.StackPane;
import main.Booking.Type;

public class EnterTransport {

	public static StackPane showButtons(){
		
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
			rootNode.getChildren().add(Transport.getNode());
		});

		quickBook.setOnAction(e -> {
			/*
			String [] parts  = date.getValue().toString().split("-");
			int part1 = Integer.parseInt(parts[0]);
			int part2 = Integer.parseInt(parts[1]);
			int part3 = Integer.parseInt(parts[2]); */
			
			/*
			String fromTo = from.getText().toString()+"-"+to.getText().toString();
			*/
			/*
			String [] hourAndMinutes = cb.getValue().toString().split(":");
			int hour = Integer.parseInt(hourAndMinutes[0]);
			int minute = Integer.parseInt(hourAndMinutes[1]);
			*/
			
			Booking temp  = new Booking(25,Type.TAXI);
			
			RootClass.allBookings.add(temp);
			
			HBox hbox2 = new HBox(20);
			Button cancelButton = new Button("Cancel");
			Label timeOfOrder= new Label(RootClass.allBookings.get(RootClass.allBookings.size()-1).getCreatedDtAsString());
			Label type = new Label(RootClass.allBookings.get(RootClass.allBookings.size()-1).getTypeAsString());
			Label price2 = new Label("$"+RootClass.allBookings.get(RootClass.allBookings.size()-1).getPriceAsString());
			Label speci = new Label(RootClass.allBookings.get(RootClass.allBookings.size()-1).getSpecification());
			
			hbox2.getChildren().addAll(timeOfOrder,type,price2,speci,cancelButton);
			RootClass.obj.add(hbox2);
			
			//events for cancel button
			cancelButton.setOnAction(event2->{
				RootClass.obj.remove(hbox2);
				RootClass.allBookings.remove(temp);
			
			});
			
			
		});
			
			
			
			
			

		
		return rootNode;
		

	}
}
