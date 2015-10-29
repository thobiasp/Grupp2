package main;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.ListIterator;

import javafx.application.Application;
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
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.RowConstraints;
import javafx.stage.Stage;
import main.MenuItem.Types;

public class LisaTestar extends Application {

	ObservableList<MenuItem> menuData = null;
	ObservableList<MenuItem> pendingOrder = null;
	float bookingTotal = 0f;
	BorderPane root = null;
	Label totalLabel = new Label("Your total: ");
	GridPane itemsView = null;
	Label itemName = null;
	Label itemPrice = null;
	Button deleteB = null;
	Label deleteL = null;

	@Override
	public void start(Stage primaryStage) {
		root = new BorderPane();
		Scene scene = new Scene(root);
		HBox hbox1 = new HBox();
		HBox hbox2 = new HBox();
		//HBox hbox3 = new HBox();
		FlowPane fPane = new FlowPane();
		HBox hbox4 = new HBox();
		HBox hbox5 = new HBox();
		Label menuLabel = new Label("Room Service Menu");

		TableView<MenuItem> menuView = new TableView<>();
		TableColumn<MenuItem, String> itemNameCol = null;
		TableColumn<MenuItem, String> itemDescriptionCol = null;
		TableColumn<MenuItem, Float> itemPriceCol = null;

		pendingOrder = FXCollections.observableArrayList();
		menuData = FXCollections.observableArrayList();
		// Till Pontus ;)
		// ***************KNAPP**********************************
		Button placeOrder = new Button("Place your order");
		// Se längre neråt för knapp kod

		root.setPrefSize(800, 300);
		BorderPane.setMargin(hbox1, new Insets(5));
		hbox1.getChildren().add(menuLabel);
		hbox1.setPrefSize(800, 20);
		hbox1.setAlignment(Pos.CENTER_LEFT);
		hbox1.setPadding(new Insets(5));

		hbox2.setPrefSize(800, 230);
		hbox2.setPadding(new Insets(5));
		hbox2.getChildren().add(menuView);

		hbox4.setPrefSize(200, 100);
		hbox4.setPadding(new Insets(10));
		hbox4.getChildren().add(placeOrder);
		this.populateMenu(10, menuData);

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

		itemsView = new GridPane();
		itemsView.setAlignment(Pos.CENTER_LEFT);
		itemsView.setPadding(new Insets(5));
		itemsView.setPrefWidth(600);
		itemsView.setPrefSize(600, 100);

		fPane.setPrefSize(600, 100);
		fPane.setPadding(new Insets(5));
		fPane.getChildren().add(itemsView);
		hbox5.setPrefSize(800, 100);
		hbox5.setPadding(new Insets(5));
		hbox5.getChildren().addAll(fPane, hbox4);

		root.setTop(hbox1);
		root.setCenter(hbox2);
		root.setBottom(hbox5);

		// ******Kole*************
		root.setId("huvudPane");
		hbox1.setId("topBox");
		hbox2.setId("menuBox");
		fPane.setId("itemViewPane");
		hbox4.setId("sendOrderBox");
		hbox5.setId("bottomBox");
		menuLabel.setId("menuLabel");
		totalLabel.setId("totalLabel");
		menuView.setId("menuView");
		itemNameCol.setId("menuCol_1");
		itemDescriptionCol.setId("menuCol_2");
		itemPriceCol.setId("menuCol_3");
		itemsView.setId("itemsView");// GridPane som fungerar som en vy
		placeOrder.setId("orderButton");

		primaryStage.setScene(scene);
		primaryStage.show();
		primaryStage.setTitle("GUI for Logging In");
		// ***************KNAPP KOD ********************************
		placeOrder.setOnAction((event) -> {
			ArrayList<MenuItem> items = (ArrayList<MenuItem>) new ArrayList<MenuItem>(pendingOrder);
			Booking rs = new RoomServiceBooking(items, bookingTotal);
			pendingOrder.clear();
			RootClass.addBooking(rs);
			System.out.println("Booking added");
		});
		// ***************KNAPP KOD ********************************

		menuView.getSelectionModel().selectedItemProperty().addListener((observableValue, oldValue, newValue) -> {
			MenuItem item = menuView.getSelectionModel().getSelectedItem();
			if (item != null) {
				pendingOrder.add(item);
				this.reConstructGridPane();
				this.bookingTotal += item.getPrice();
			}
		});
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

	private void reConstructGridPane() {
		itemsView.setAlignment(Pos.CENTER_LEFT);
		// HPos halignment, VPos valignment, Priority hgrow,Priority vgrow)
		RowConstraints row = new RowConstraints();
		ColumnConstraints itemCol = new ColumnConstraints();
		ColumnConstraints priceCol = new ColumnConstraints();
		ColumnConstraints deleteCol = new ColumnConstraints();
		itemCol.setPercentWidth(50);
		priceCol.setPercentWidth(25);
		deleteCol.setPercentWidth(25);
		itemCol.setHgrow(Priority.NEVER);
		priceCol.setHgrow(Priority.NEVER);
		deleteCol.setHgrow(Priority.NEVER);

		itemsView.getColumnConstraints().addAll(itemCol, priceCol, deleteCol);
		MenuItem mi = new MenuItem();
		ListIterator<MenuItem> it = pendingOrder.listIterator();
		int iRow = 0;
		do {
			//new instances of each node
			itemName = new Label();
			itemPrice = new Label();
			deleteB = new Button("Delete");
			deleteL = new Label("Delete");
			//prevent all nodes from changing size
			GridPane.setVgrow(itemName, Priority.NEVER);
			GridPane.setVgrow(itemPrice, Priority.NEVER);
			GridPane.setVgrow(deleteB, Priority.NEVER);
			GridPane.setHgrow(itemName, Priority.NEVER);
			GridPane.setHgrow(itemPrice, Priority.NEVER);
			GridPane.setHgrow(deleteB, Priority.NEVER);
			//each node-type is assigned to a column
			GridPane.setColumnIndex(itemName, 0);
			GridPane.setColumnIndex(itemPrice, 1);
			GridPane.setColumnIndex(deleteB, 2);
			//fill each row-cell with current data.
			mi = it.next();
			itemName.setText(mi.getName());
			itemPrice.setText(Float.valueOf(mi.getPrice()).toString());
			itemsView.addRow(iRow, itemName, itemPrice, deleteL);
			iRow++;
		} while (it.hasNext());
	}

	public static void main(String[] args) {
		launch(args);
	}
}
