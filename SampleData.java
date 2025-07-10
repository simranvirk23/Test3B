
// SampleData.java - Sample data for the application

import javafx.collections.ObservableList;

public class SampleData {
    public static void loadSampleData(ObservableList<PizzaOrder> orders) {
        // Sample Customer 1
        PizzaOrder order1 = new PizzaOrder(
            "harman", 
            "23456789", 
            "XL", 
            3, 
            BillCalculator.calculate("XL", 3)
        );
        
        // Sample Customer 2
        PizzaOrder order2 = new PizzaOrder(
            "Raman", 
            "23417865", 
            "L", 
            2, 
            BillCalculator.calculate("L", 2)
        );
        
        // Sample Customer 3
        PizzaOrder order3 = new PizzaOrder(
            "rohan", 
            "567346976", 
            "M", 
            1, 
             
            BillCalculator.calculate("M", 1)
        );
        
        orders.addAll(order1, order2, order3);
    }
}
