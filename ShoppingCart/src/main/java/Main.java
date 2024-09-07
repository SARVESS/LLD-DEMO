import enums.ProductType;

public class Main {
    public static void main(String[] args) {
        Product item1 = new ElectronicProduct("FAN", 1000, ProductType.ELECTRONIC);
        Product item2 = new FurnitureProduct("SOFA", 3000, ProductType.FURNITURE);

        ShoppingCart cart = new ShoppingCart();
        cart.addToCart(item1);
        cart.addToCart(item2);

        System.out.println("Total price after discount: " + cart.getTotalPrice());
    }
}