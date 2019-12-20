package repository;

import api.ApiService;
import model.Order;
import model.Shop;
import model.consumables.Consumable;
import model.consumables.Cookie;
import model.consumables.CookieComponent;
import model.consumables.CookiesPack;
import model.customer.Customer;
import model.discount.DiscountStrategy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Virgile FANTAUZZI
 */
public class OrderRepository {

    private final ApiService apiService;

    public OrderRepository(ApiService apiService) {
        this.apiService = apiService;
    }

    public List<Order> getOrders() {
        return apiService.getOrders();
    }

    public int getOrderNum() {
        return apiService.getOrderNum();
    }


    private boolean canMakeOrder(Order order) {
        Map<String, Integer> stock = apiService.getStocks(order.getShop());
        Map<String, Integer> stockNeed = new HashMap<>();
        for (Consumable c : order.getCart().getItems().keySet()) {
            if (c.isCookie()) {
                for (CookieComponent cc : ((Cookie) c).getRecipe().getIngredients()) {
                    if (stockNeed.containsKey(cc.getName())) {
                        stockNeed.put(cc.getName(), stockNeed.get(cc.getName()) + 1);
                    } else {
                        stockNeed.put(cc.getName(), 1);
                    }
                }
            } else if (c.isCookiePack()) {
                for (Consumable cookie : c.getItemPack().keySet()) {
                    for (CookieComponent cc : ((Cookie) cookie).getRecipe().getIngredients()) {

                        if (stockNeed.containsKey(cc.getName())) {
                            stockNeed.put(cc.getName(), stockNeed.get(cc.getName()) + 1);
                        } else {
                            stockNeed.put(cc.getName(), 1);
                        }
                    }
                }
            } else {
                if (stockNeed.containsKey(c.getName())) {
                    stockNeed.put(c.getName(), stockNeed.get(c.getName()) + 1);
                } else {
                    stockNeed.put(c.getName(), 1);
                }
            }
        }

        for (String name : stockNeed.keySet()) {
            if (stock.get(name) == null || stock.get(name) < stockNeed.get(name)) {
                System.out.println("The stock doesn't have enough " + name);
                return false;
            }
        }


        return true;
    }

    private void removeOrderFromStock(Order order) {
        for (Consumable c : order.getCart().getItems().keySet()) {
            apiService.removeFromStock(order.getShop(), c);
        }
    }

    public void addOrder(Order order) throws CloneNotSupportedException {
        if (canMakeOrder(order)) {
            apiService.addOrder(order);
            removeOrderFromStock(order);
        } else {
            System.out.println("This order can't be placed due to lack of ingredients in the stock");
        }
    }

    public void addOrder(Order order, DiscountStrategy discountStrategy) throws CloneNotSupportedException {
        if (canMakeOrder(order)) {
            apiService.addOrder(order, discountStrategy);
            removeOrderFromStock(order);
        } else {
            System.out.println("This order can't be placed due to lack of ingredients in the stock");
        }
    }

    //public void addOrder(Order order, Discount discount) { apiService.addOrder(order, discount); }

    public void payOrder(Order order, Customer customer) {
        apiService.payOrder(order, customer);
    }

    public void deleteOrder(Order order) {
        apiService.deleteOrder(order);
    }
}
