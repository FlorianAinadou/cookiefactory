package repository;

import api.ApiService;
import model.Order;
import model.Shop;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Lydia BARAUKOVA
 */
public class ShopRepository {
    private final ApiService apiService;

    public ShopRepository(ApiService apiService) {
        this.apiService = apiService;
    }

    public void showStock(Shop shop) {
        System.out.println("In " + shop.getName());
        apiService.getStocks(shop).forEach((c, n) -> {
            System.out.println("There are " + n + " " + c + " left.");
        });
    }

    public void changeMarginCod(Shop shop, double margin) {
        apiService.changeCodMargin(shop, margin);
    }

    public Map<String, Integer> getStock(Shop shop) {
        return apiService.getStocks(shop);
    }

    public List<Shop> getShops() {
        return apiService.getShops();
    }

    public Shop getRandomShop() {
        return apiService.getRandomShop();
    }

    public void addShop(Shop shop) {
        apiService.addShop(shop);
    }

    public void deleteShop(Shop shop) {
        apiService.deleteShop(shop);
    }
}
