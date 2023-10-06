package homework3;

import java.util.List;
import java.util.Scanner;

import homework3.exceptions.ProductNotFoundException;
import homework3.exceptions.ShopManagerException;
import homework3.exceptions.InvalidNumberException;

public class OnlineShopUI {

    private final ShopManager shopManager;

    public OnlineShopUI(ShopManager shopManager) {
        this.shopManager = shopManager;
    }

    public void main() {
        Scanner scanner = new Scanner(System.in);
        onlineShopCommands();
        int inputNumber;
        while (true) {
            System.out.print("Enter number of command: ");
            inputNumber = scanner.nextInt();
            switch (inputNumber) {
                case 1:
                    listProduct();
                    break;
                case 2:
                    buyProduct();
                    break;
                case 3: {
                    return;
                }
                default:
                    try {
                        throw new InvalidNumberException("Error! Enter numbers 1, 2, or 3.");
                    } catch (InvalidNumberException e) {
                        System.out.println(e.getMessage());
                    }
            }
        }
    }

    private void buyProduct() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter product ID: ");
        int productId = scanner.nextInt();
        System.out.print("Enter quantity: ");
        int quantity = scanner.nextInt();
        try {
            double totalPrice = shopManager.purchaseProduct(productId, quantity);
            System.out.println("Total purchase price: $" + totalPrice);
        } catch (ProductNotFoundException | ShopManagerException e) {
            System.out.println(e.getMessage());
        }
    }

    private void onlineShopCommands() {
        System.out.println("Commands to operate in online shop: \n"
                + "1 - view available products; \n"
                + "2 - buy products; \n"
                + "3 - exit. \n");
    }

    private void listProduct() {
        List<Product> products = shopManager.getAllProducts();
        for (int i = 0; i < products.size(); i++) {
            System.out.println("ID: " + (i + 1) + ",  " + products.get(i));
        }
    }
}