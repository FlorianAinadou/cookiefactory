package api;

import model.Cart;
import model.Order;
import model.Recipe;
import model.Shop;
import model.consumables.CookieComponent;
import model.customer.Customer;
import model.discount.Discount;
import model.discount.DiscountStrategy;

import java.util.List;
import java.util.Map;

/**
 * @author Virgile FANTAUZZI
 * @author Lydia BARAUKOVA
 * @author Aldric Ducreux
 */
public interface ApiService {

    List<Customer> getCustomers();
    Customer getRandomRegisteredCustomer();
    Customer getRandomUnregisteredCustomer();
    void addCustomer(Customer username);
    void deleteCustomer(Customer username);

    List<Shop> getShops();
    Shop getRandomShop();
    void addShop(Shop shop);
    void deleteShop(Shop shop);

    List<Order> getOrders();
    int getOrderNum();
    void addOrder(Order orderNum) throws CloneNotSupportedException;
    void deleteOrder(Order orderNum);
    void addOrder(Order order, DiscountStrategy discountStrategy) throws CloneNotSupportedException;
    void payOrder(Order order, Customer customer);

    /*List<Cart> getCarts();
    void addcart(Cart cartNum);
    void deletecart(Cart cartNum);*/


    Map<String, Recipe> getRecipes();
    void addRecipe(String name, Recipe recipe);
    void deleteRecipe(String name);
    void changeRecipeMargin(String name, double margin);

    Map<String, CookieComponent> getDough();
    void addDough(String name, CookieComponent dough);
    void deleteDough(String name);
    void changeDoughPrice(String name, double price);

    Map<String, CookieComponent> getTopping();
    void addTopping(String name, CookieComponent topping);
    void deleteTopping(String name);
    void changeToppingPrice(String name, double price);

    Map<String, CookieComponent> getMix();
    void addMix(String name, CookieComponent mix);
    void deleteMix(String name);
    void changeMixPrice(String name, double price);

    Map<String, CookieComponent> getCooking();
    void addCooking(String name, CookieComponent cooking);
    void deleteCooking(String name);
    void changeCookingPrice(String name, double price);

    Map<String, CookieComponent> getFlavour();
    void addFlavour(String name, CookieComponent flavour);
    void deleteFlavour(String name);
    void changeFlavourPrice(String name, double price);

    List<Discount> getDiscounts(Customer customer);
    void addDiscount(Customer customer, Discount discount);
    double applyDiscount(Customer customer, Shop shop, Discount discount);
    float askForADiscountApplying(Customer customer, Discount discount);
}
