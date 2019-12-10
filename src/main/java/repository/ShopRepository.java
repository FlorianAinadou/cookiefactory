package repository;

import api.ApiService;
import model.Shop;

import java.util.List;

/**
 * @author Lydia BARAUKOVA
 */
public class ShopRepository {
    private final ApiService apiService;

    public ShopRepository(ApiService apiService) {
        this.apiService = apiService;
    }

    public List<Shop> getShops() { return apiService.getShops(); }
    public Shop getRandomShop() { return apiService.getRandomShop(); }
    public void addShop(Shop shop) { apiService.addShop(shop);}
    public void deleteShop(Shop shop) { apiService.deleteShop(shop); }
}
