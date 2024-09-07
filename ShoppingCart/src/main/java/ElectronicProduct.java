import enums.ProductType;

public class ElectronicProduct extends Product {
    ElectronicProduct(String name, double originalPrice, ProductType type) {
        super(name, originalPrice, type);
    }

    @Override
    public double getPrice() {
        return originalPrice;
    }
}
