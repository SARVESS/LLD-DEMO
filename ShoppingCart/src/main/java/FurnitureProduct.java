import enums.ProductType;

public class FurnitureProduct extends Product{
    FurnitureProduct(String name, double originalPrice, ProductType type) {
        super(name, originalPrice, type);
    }
    @Override
    public double getPrice() {
        return originalPrice;
    }
}
