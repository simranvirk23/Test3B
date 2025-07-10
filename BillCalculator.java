
// BillCalculator.java - Utility class for calculating pizza bills

public class BillCalculator {
    private static final double XL_PRICE = 20.0;
    private static final double L_PRICE = 15.0;
    private static final double M_PRICE = 12.0;
    private static final double S_PRICE = 8.0;
    private static final double TOPPING_PRICE = 2.0;

    public static double calculate(String size, int toppings) {
        double basePrice = 0.0;
        
        switch (size) {
            case "XL":
                basePrice = XL_PRICE;
                break;
            case "L":
                basePrice = L_PRICE;
                break;
            case "M":
                basePrice = M_PRICE;
                break;
            case "S":
                basePrice = S_PRICE;
                break;
        }
        
        return basePrice + (toppings * TOPPING_PRICE);
    }
}
