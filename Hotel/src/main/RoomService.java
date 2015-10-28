package main;

import java.util.Collections;
import java.util.Comparator;
import java.util.ListIterator;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import main.MenuItem.Types;

public class RoomService {
	ObservableList<MenuItem> menuData = null;
	ObservableList<MenuItem> pendingOrder = null;

	public BorderPane getRsNode() {
		BorderPane root = null;
		Label totalLabel = new Label("Your total: ");

		root = new BorderPane();
		//Scene scene = new Scene(root);
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

		TableView<MenuItem> pendingView = new TableView<>();
		TableColumn<MenuItem, String> itemNameCol2 = null;
		TableColumn<MenuItem, Float> itemPriceCol2 = null;
		
		pendingOrder = FXCollections.observableArrayList();
		menuData = FXCollections.observableArrayList();
		Button placeOrder = new Button("Place your order");
		//LinkedList<MenuItem> itemsOrdered = new LinkedList<>();

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
		hbox3.getChildren().addAll(pendingView, totalLabel);

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

		itemPriceCol = new TableColumn<>("Price");
		itemPriceCol.setResizable(false);
		itemPriceCol.setEditable(false);
		itemPriceCol.setPrefWidth(75);
		itemPriceCol.setCellValueFactory(new PropertyValueFactory<MenuItem, Float>("price"));

		menuView.getColumns().add(itemNameCol);
		menuView.getColumns().add(itemDescriptionCol);
		menuView.getColumns().add(itemPriceCol);
		menuView.getItems().addAll(menuData);
		menuView.setItems(menuData);

		itemNameCol2 = new TableColumn<>("");
		itemNameCol2.setResizable(false);
		itemNameCol2.setEditable(false);
		itemNameCol2.setPrefWidth(125);
		itemNameCol2.setCellValueFactory(new PropertyValueFactory<MenuItem, String>("name"));

		itemPriceCol2 = new TableColumn<>("Price");
		itemPriceCol2.setResizable(false);
		itemPriceCol2.setEditable(false);
		itemPriceCol2.setPrefWidth(75);
		itemPriceCol2.setCellValueFactory(new PropertyValueFactory<MenuItem, Float>("price"));


		pendingView.getColumns().add(itemNameCol2);
		pendingView.getColumns().add(itemPriceCol2);
		pendingView.getItems().addAll(pendingOrder);
		pendingView.setItems(pendingOrder);

		root.setTop(hbox1);
		root.setCenter(hbox2);
		root.setBottom(hbox5);
		
		placeOrder.setOnAction((event) -> {
		});

		menuView.getSelectionModel().selectedItemProperty().addListener((observableValue, oldValue, newValue) -> {
			MenuItem item = menuView.getSelectionModel().getSelectedItem();
			if (item != null) {
				pendingOrder.add(item);
			}
		});
		pendingView.setOnMouseClicked(event -> {
			MenuItem item = menuView.getSelectionModel().getSelectedItem();
			if (item != null) {
				pendingOrder.remove(item);
			}
			Platform.runLater(new Runnable() {
				@Override
				public void run() {
					ListIterator<MenuItem> it = pendingOrder.listIterator();
					float theTotal = 0f;
					while (it.hasNext()) {
						MenuItem next = it.next();
						theTotal += next.getPrice();
					}
					totalLabel.setText("Your total:  " + theTotal);
				}
			});
		});
		return root;
		
		/*
		 * pendingView.getSelectionModel().selectedItemProperty().addListener((
		 * observableValue, oldValue, newValue) -> { MenuItem item =
		 * menuView.getSelectionModel().getSelectedItem(); if (item != null) {
		 * pendingOrder.remove(item); } Platform.runLater(new Runnable() {
		 * 
		 * @Override public void run() { ListIterator<MenuItem> it =
		 * pendingOrder.listIterator(); float theTotal = 0f; while
		 * (it.hasNext()){ MenuItem next = it.next(); theTotal +=
		 * next.getPrice(); } totalLabel.setText("Your total:  " + theTotal); }
		 * }); });
		 */

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
