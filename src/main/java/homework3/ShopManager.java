package homework3;

import homework3.exceptions.ProductNotFoundException;
import homework3.exceptions.ShopManagerException;

import java.util.List;

public class ShopManager {

    public double purchaseProduct(int productId, int quantity) throws ShopManagerException, ProductNotFoundException {
        Product product = productDatabase.getProduct(productId);
        if (product.getAvailableQuantity() < quantity) {
            throw new ShopManagerException("Not enough products in shop.");
        }
        double totalPrice = product.getPrice() * quantity;
        productDatabase.reduceProductQuantity(product, quantity);
        return totalPrice;
    }
    private final ProductDatabase productDatabase;

    public ShopManager(ProductDatabase productDatabase) {
        this.productDatabase = productDatabase;
    }

    public List<Product> getAllProducts() {
        return productDatabase.getShop();
    }

}