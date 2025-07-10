
// PizzaOrderPage.java - JavaFX UI

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.layout.*;

public class PizzaOrderPage {
    private VBox view;
    private TextField nameField, mobileField, toppingsField;
    private CheckBox xlBox, lBox, mBox, sBox;
    private TableView<PizzaOrder> table;
    private ObservableList<PizzaOrder> orders;

    public PizzaOrderPage() {
        view = new VBox(10);
        view.setPadding(new Insets(20));

        Label title = new Label("Pizza Ordering System");
        title.setStyle("-fx-font-size: 24px; -fx-font-weight: bold;");

        nameField = new TextField();
        nameField.setPromptText("Customer Name");

        mobileField = new TextField();
        mobileField.setPromptText("Mobile Number");

        toppingsField = new TextField();
        toppingsField.setPromptText("Number of Toppings");

        xlBox = new CheckBox("XL");
        lBox = new CheckBox("L");
        mBox = new CheckBox("M");
        sBox = new CheckBox("S");

        HBox sizeBox = new HBox(10, xlBox, lBox, mBox, sBox);

        Button createBtn = new Button("Create");
        Button readBtn = new Button("Read");
        Button updateBtn = new Button("Update");
        Button deleteBtn = new Button("Delete");
        Button clearBtn = new Button("Clear");

        orders = FXCollections.observableArrayList();
        table = new TableView<>(orders);

        TableColumn<PizzaOrder, String> nameCol = new TableColumn<>("Name");
        nameCol.setCellValueFactory(cell -> cell.getValue().nameProperty());
        TableColumn<PizzaOrder, String> mobileCol = new TableColumn<>("Mobile");
        mobileCol.setCellValueFactory(cell -> cell.getValue().mobileProperty());
        TableColumn<PizzaOrder, String> sizeCol = new TableColumn<>("Size");
        sizeCol.setCellValueFactory(cell -> cell.getValue().sizeProperty());
        TableColumn<PizzaOrder, Integer> toppingsCol = new TableColumn<>("Toppings");
        toppingsCol.setCellValueFactory(cell -> cell.getValue().toppingsProperty().asObject());
        TableColumn<PizzaOrder, Double> billCol = new TableColumn<>("Total Bill");
        billCol.setCellValueFactory(cell -> cell.getValue().billProperty().asObject());

        table.getColumns().addAll(nameCol, mobileCol, sizeCol, toppingsCol, billCol);

        createBtn.setOnAction(e -> {
            try {
                String name = nameField.getText();
                String mobile = mobileField.getText();
                int toppings = Integer.parseInt(toppingsField.getText());
                String size = getSelectedSize();
                
                if (name.isEmpty() || mobile.isEmpty() || size.isEmpty()) {
                    Alert alert = new Alert(Alert.AlertType.WARNING);
                    alert.setTitle("Missing Information");
                    alert.setHeaderText(null);
                    alert.setContentText("Please fill in all fields and select a size.");
                    alert.showAndWait();
                    return;
                }
                
                double bill = BillCalculator.calculate(size, toppings);
                PizzaOrder order = new PizzaOrder(name, mobile, size, toppings, bill);
                orders.add(order);
                
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Order Created");
                alert.setHeaderText(null);
                alert.setContentText("Order created successfully!");
                alert.showAndWait();
                
            } catch (NumberFormatException ex) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Invalid Input");
                alert.setHeaderText(null);
                alert.setContentText("Please enter a valid number for toppings.");
                alert.showAndWait();
            }
        });

        readBtn.setOnAction(e -> {
            PizzaOrder selected = table.getSelectionModel().getSelectedItem();
            if (selected != null) {
                nameField.setText(selected.getName());
                mobileField.setText(selected.getMobile());
                toppingsField.setText(String.valueOf(selected.getToppings()));
                setSelectedSize(selected.getSize());
            }
        });

        updateBtn.setOnAction(e -> {
            PizzaOrder selected = table.getSelectionModel().getSelectedItem();
            if (selected != null) {
                selected.setName(nameField.getText());
                selected.setMobile(mobileField.getText());
                selected.setSize(getSelectedSize());
                selected.setToppings(Integer.parseInt(toppingsField.getText()));
                selected.setBill(BillCalculator.calculate(selected.getSize(), selected.getToppings()));
                table.refresh();
                
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Update Successful");
                alert.setHeaderText(null);
                alert.setContentText("Order updated successfully!");
                alert.showAndWait();
            } else {
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle("No Selection");
                alert.setHeaderText(null);
                alert.setContentText("Please select an order to update.");
                alert.showAndWait();
            }
        });

        deleteBtn.setOnAction(e -> {
            PizzaOrder selected = table.getSelectionModel().getSelectedItem();
            if (selected != null) {
                Alert confirmAlert = new Alert(Alert.AlertType.CONFIRMATION);
                confirmAlert.setTitle("Confirm Delete");
                confirmAlert.setHeaderText(null);
                confirmAlert.setContentText("Are you sure you want to delete this order?");
                
                if (confirmAlert.showAndWait().get() == ButtonType.OK) {
                    orders.remove(selected);
                    
                    Alert successAlert = new Alert(Alert.AlertType.INFORMATION);
                    successAlert.setTitle("Delete Successful");
                    successAlert.setHeaderText(null);
                    successAlert.setContentText("Order deleted successfully!");
                    successAlert.showAndWait();
                }
            } else {
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle("No Selection");
                alert.setHeaderText(null);
                alert.setContentText("Please select an order to delete.");
                alert.showAndWait();
            }
        });

        clearBtn.setOnAction(e -> {
            nameField.clear();
            mobileField.clear();
            toppingsField.clear();
            xlBox.setSelected(false);
            lBox.setSelected(false);
            mBox.setSelected(false);
            sBox.setSelected(false);
        });

        // Load sample data
        SampleData.loadSampleData(orders);

        view.getChildren().addAll(title, nameField, mobileField, sizeBox, toppingsField,
                new HBox(10, createBtn, readBtn, updateBtn, deleteBtn, clearBtn), table);
    }

    private String getSelectedSize() {
        if (xlBox.isSelected()) return "XL";
        if (lBox.isSelected()) return "L";
        if (mBox.isSelected()) return "M";
        if (sBox.isSelected()) return "S";
        return "";
    }

    private void setSelectedSize(String size) {
        xlBox.setSelected(size.equals("XL"));
        lBox.setSelected(size.equals("L"));
        mBox.setSelected(size.equals("M"));
        sBox.setSelected(size.equals("S"));
    }

    public VBox getView() {
        return view;
    }
}
