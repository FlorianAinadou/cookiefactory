package repository;

import api.ApiService;
import model.Order;
import model.Shop;
import model.consumables.Consumable;
import model.consumables.Cookie;
import model.consumables.CookieComponent;
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


    public boolean canMakeOrder(Order order) {
        Map<String, Integer> stock = apiService.getStocks(order.getShop());
        HashMap<String, Integer> tmp = new HashMap<>();
        for (Consumable c : order.getCart().getItems().keySet()) {
            int val = 1;
            if (tmp.containsKey(c.getName())) {
                val = tmp.get(c.getName()) + 1;
                tmp.put(c.getName(), val);
            } else {
                tmp.put(c.getName(), val);
            }
            if (c.isCookie()) {
                for (CookieComponent cc : ((Cookie) c).getRecipe().getIngredients()) {
                    if (tmp.containsKey(cc.getName())) {
                        val = tmp.get(cc.getName()) + 1;
                        tmp.put(cc.getName(), val);
                    } else {
                        tmp.put(cc.getName(), val);
                    }
                    if (stock.get(cc.getName()) == null || stock.get(cc.getName()) < val) {
                        System.out.println("The stock doesn't have enough " + c.getName());
                        return false;
                    }
                }
            } else {
                if (stock.get(c.getName()) == null || stock.get(c.getName()) < val) {
                    System.out.println("The stock doesn't have enough " + c.getName());
                    return false;
                }
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
