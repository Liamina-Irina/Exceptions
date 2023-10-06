package homework3;

public class MainHomework3 {
    public static void main(String[] args) {
        ProductDatabase productDatabase = new ProductDatabase();
        ShopManager manager = new ShopManager(productDatabase);
        OnlineShopUI onlineShopUI = new OnlineShopUI(manager);
        onlineShopUI.main();
    }
}