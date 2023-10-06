package homework3;

import homework3.exceptions.ProductNotFoundException;

import java.util.ArrayList;
import java.util.List;

public class ProductDatabase {
    private final List<Product> shop;
    public List<Product> getShop() {
        return shop;
    }

    public ProductDatabase() {
        this.shop = new ArrayList<>();
        this.shop.add(new Product("Product 1", 10, 5.99));
        this.shop.add(new Product("Product 2", 17, 14.99));
        this.shop.add(new Product("Product 3", 6, 9.99));
    }

    public Product getProduct(int productId) throws ProductNotFoundException{
        if ((productId > 0) && (productId <= shop.size())) {
            return shop.get(productId - 1);
        }
        throw new ProductNotFoundException("Product not found.");
    }

    public void reduceProductQuantity(Product product, int quantity) {
        product.setAvailableQuantity(product.getAvailableQuantity() - quantity);
    }
}
