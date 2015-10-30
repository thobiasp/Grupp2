package main;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import main.Booking.Type;


public class AllEvents  {

	public static GridPane getNode() {
		
	GridPane root = new GridPane();
	Scene scene = new Scene(root, 800, 300);
	//scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
	

	
	//lists for 'upcomingEvents' center pane

	ListView<HBox> listOfEvents = new ListView<>(RootClass.obj);
	listOfEvents.setPrefWidth(800);
	
	
	//Test button for adding in 'upcoming events'
	Button testbook = new Button("test Book");

	
	root.add(testbook, 1, 4);
	root.add(listOfEvents, 1, 1);
	listOfEvents.setPrefHeight(300);

	
	
	//event for button in AllEvents
	testbook.setOnAction(event->{
		Booking temp  = new Booking(30,Type.TREATMENT);
		RootClass.allBookings.add(temp);
		
		HBox hbox = new HBox(20);
		Button cancelButton = new Button("Cancel");
		Label timeOfOrder= new Label(RootClass.allBookings.get(RootClass.allBookings.size()-1).getCreatedDtAsString());
		Label type = new Label(RootClass.allBookings.get(RootClass.allBookings.size()-1).getTypeAsString());
		Label price = new Label(RootClass.allBookings.get(RootClass.allBookings.size()-1).getPriceAsString());
		Label speci = new Label(RootClass.allBookings.get(RootClass.allBookings.size()-1).getSpecification());
		
		hbox.getChildren().addAll(timeOfOrder,type,price,speci,cancelButton);
		RootClass.obj.add(hbox);
		
		//events for cancel button
		cancelButton.setOnAction(event2->{
			RootClass.obj.remove(hbox);
			RootClass.allBookings.remove(temp);
		
		});
				
	});
	
return root;
	
}
}

