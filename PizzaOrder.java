
// PizzaOrder.java - Data model for pizza orders

import javafx.beans.property.*;

public class PizzaOrder {
    private StringProperty name;
    private StringProperty mobile;
    private StringProperty size;
    private IntegerProperty toppings;
    private DoubleProperty bill;

    public PizzaOrder(String name, String mobile, String size, int toppings, double bill) {
        this.name = new SimpleStringProperty(name);
        this.mobile = new SimpleStringProperty(mobile);
        this.size = new SimpleStringProperty(size);
        this.toppings = new SimpleIntegerProperty(toppings);
        this.bill = new SimpleDoubleProperty(bill);
    }

    public StringProperty nameProperty() {
        return name;
    }

    public String getName() {
        return name.get();
    }

    public void setName(String name) {
        this.name.set(name);
    }

    public StringProperty mobileProperty() {
        return mobile;
    }

    public String getMobile() {
        return mobile.get();
    }

    public void setMobile(String mobile) {
        this.mobile.set(mobile);
    }

    public StringProperty sizeProperty() {
        return size;
    }

    public String getSize() {
        return size.get();
    }

    public void setSize(String size) {
        this.size.set(size);
    }

    public IntegerProperty toppingsProperty() {
        return toppings;
    }

    public int getToppings() {
        return toppings.get();
    }

    public void setToppings(int toppings) {
        this.toppings.set(toppings);
    }

    public DoubleProperty billProperty() {
        return bill;
    }

    public double getBill() {
        return bill.get();
    }

    public void setBill(double bill) {
        this.bill.set(bill);
    }
}
