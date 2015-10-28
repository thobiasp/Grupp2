package main;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import main.MenuItem.Types;

public class RoomServiceNode  {

	ObservableList<MenuItem> menuData = null;
	ObservableList<MenuItem> pendingOrder = null;
	float bookingTotal = 0f;
	BorderPane root = null;
	
	public BorderPane getRsNode() {
		BorderPane root = null;
		Scene scene = new Scene(root, 800, 400);
		Label totalLabel = new Label("Your total: ");

		root = new BorderPane();
		// Scene scene = new Scene(root);
		HBox hbox1 = new HBox();
		HBox hbox2 = new HBox();
		HBox hbox3 = new HBox();
		HBox hbox4 = new HBox();
		HBox hbox5 = new HBox();
		Label menuLabel = new Label("Room Service Menu");
		
		TableView<MenuItem> menuView = new TableView<>();
		TableColumn<MenuItem, String> itemNameCol = null;
		TableColumn<MenuItem, String> itemDescriptionCol = null;
		TableColumn<MenuItem, Float> itemPriceCol = null;

		GridPane itemsView = new GridPane();
		final Button deleteB = new Button("Delete");
		
		pendingOrder = FXCollections.observableArrayList();
		menuData = FXCollections.observableArrayList();
		//Till Pontus ;)
		//***************KNAPP**********************************
		Button placeOrder = new Button("Place your order");
		//***************KNAPP**********************************
		// Se längre neråt för knapp kod

		root.setPrefSize(800, 300);
		BorderPane.setMargin(hbox1, new Insets(5, 5, 5, 5));

		hbox1.getChildren().add(menuLabel);
		hbox1.setPrefSize(800, 20);
		hbox1.setAlignment(Pos.CENTER_LEFT);
		hbox1.setPadding(new Insets(5));

		hbox2.setPrefSize(800, 230);
		hbox2.setPadding(new Insets(5));
		hbox2.getChildren().add(menuView);

		hbox3.setPrefSize(600, 100);
		hbox3.setPadding(new Insets(5));
		hbox3.getChildren().addAll(itemsView, totalLabel);

		hbox4.setPrefSize(200, 100);
		hbox4.setPadding(new Insets(10));
		hbox4.getChildren().add(placeOrder);
		this.populateMenu(10, menuData);

		hbox5.setPrefSize(800, 100);
		hbox5.setPadding(new Insets(5));
		hbox5.getChildren().addAll(hbox3, hbox4);

		itemNameCol = new TableColumn<>("");
		itemNameCol.setResizable(false);
		itemNameCol.setEditable(false);
		itemNameCol.setPrefWidth(100);
		itemNameCol.setCellValueFactory(new PropertyValueFactory<MenuItem, String>("name"));

		itemDescriptionCol = new TableColumn<>("");
		itemDescriptionCol.setResizable(false);
		itemDescriptionCol.setEditable(false);
		itemDescriptionCol.setPrefWidth(625);
		itemDescriptionCol.setCellValueFactory(new PropertyValueFactory<MenuItem, String>("description"));

		itemPriceCol = new TableColumn<>("");
		itemPriceCol.setResizable(false);
		itemPriceCol.setEditable(false);
		itemPriceCol.setPrefWidth(75);
		itemPriceCol.setCellValueFactory(new PropertyValueFactory<MenuItem, Float>("price"));

		menuView.getColumns().add(itemNameCol);
		menuView.getColumns().add(itemDescriptionCol);
		menuView.getColumns().add(itemPriceCol);
		menuView.getItems().addAll(menuData);
		menuView.setItems(menuData);
		
		itemsView.setAlignment(Pos.CENTER_LEFT);
		itemsView.setPadding(new Insets(5));
		itemsView.setPrefWidth(600);
		itemsView.setPrefSize(600, 100);

		deleteB.setPrefSize(40, 25);

		root.setTop(hbox1);
		root.setCenter(hbox2);
		root.setBottom(hbox5);
	
//******Kole*************
		root.setId("huvudPane");
		hbox1.setId("hbox1");
		hbox2.setId("hbox2");
		hbox3.setId("hbox3");
		hbox4.setId("hbox4");
		hbox5.setId("hbox5");
		menuLabel.setId("menuLabel");
		totalLabel.setId("totalLabel");
		menuView.setId("menuView");
		itemNameCol.setId("menuCol_1");
		itemDescriptionCol.setId("menuCol_2");
		itemPriceCol.setId("menuCol_3");
		itemsView.setId("itemsView");//GridPane som fungerar som en vy
		placeOrder.setId("orderButton");
		
		


		// ***************KNAPP KOD ********************************
		placeOrder.setOnAction((event) -> {
			ArrayList<MenuItem> items = (ArrayList<MenuItem>) new ArrayList<MenuItem>(pendingOrder);
			Booking rs = new RoomServiceBooking(items,bookingTotal);
			RootClass.addBooking(rs);
		});
		// ***************KNAPP KOD ********************************

		menuView.getSelectionModel().selectedItemProperty().addListener((observableValue, oldValue, newValue) -> {
			MenuItem item = menuView.getSelectionModel().getSelectedItem();
			if (item != null) {
				pendingOrder.add(item);
				this.bookingTotal += item.getPrice();
			}
		});	
		return root;
	}
	public void populateMenu(int numItems, ObservableList<MenuItem> menuData) {
		MenuItem food = null;
		MenuItem drink = null;
		for (int i = 1; i <= numItems; i++) {
			food = new MenuItem(Types.FOOD, "Hamburger", "A big, juicy hamburger with lettuce and tomato.", 65f);
			menuData.add(food);
			i++;
			drink = new MenuItem(Types.DRINK, "Corona", "Our best-selling lager!", 60f);
			menuData.add(drink);
		}
		Comparator<MenuItem> byType = (MenuItem o1, MenuItem o2) -> (o1.getType()).compareTo(o2.getType());
		Collections.sort(menuData, byType);
	}

}
