package api;

import model.Discount;
import model.Order;
import model.cookie.Recipe;
import model.customer.Customer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import static api.FakeApiServiceGenerator.*;

/**
 * @author Virgile FANTAUZZI
 */


public class FakeApiService implements ApiService {

    private List<Customer> users = generateUsers();
    private Map<String, Recipe> recipes = generateCookieRecipes();
    private Map<Customer, List<Discount>> discounts = generateDiscounts();
    private List<Order> orders = new ArrayList<>();
    private Map<String, Discount> shopDiscounts= getShopDiscounts();

    /**
     * Return a list of {@link Customer}
     * Those users must be generated by {@link FakeApiServiceGenerator}
     */
    @Override
    public List<Customer> getUsers() {
        return users;
    }

    /**
     * Return a map of strings and {@link Recipe}
     * Those cookies must be generated by {@link FakeApiServiceGenerator}
     */
    @Override
    public Map<String, Recipe> getCookieRecipes() {
        return recipes;
    }

    @Override
    public void addDiscount(Customer customer, Discount discount) {
        if(discounts.containsKey(customer)){
            discounts.get(customer).add(discount);
        }else{
            discounts.put(customer, Collections.singletonList(discount));
        }
    }

    @Override
    public List<Discount> getDiscounts(Customer customer) {
        if(customer.isRegistered()) return discounts.get(customer);

        else {
            System.out.println("Customer not registered");
            return null;
        }

    }

    @Override
    public float applyDiscount(Customer customer, Discount discount) {
        if(customer.isRegistered()) {
            discounts.get(customer).remove(discount);
            return discount.getRate();
        }

        return 0.0f;
    }

    /**
     * Return a list of {@link Order}
     * Those orders must be generated by {@link FakeApiServiceGenerator} if you want some MOCK
     */
    @Override
    public List<Order> getOrders() {
        return orders;
    }

    /**
     * Generate an order ID according to the size of orders {@link Order} .
     * This number must be only get here.
     */
    @Override
    public int getOrderNum() {
        return orders.size();
    }

    /**
     * Generate a random {@link Customer} and add it {@link FakeApiService#users} list.
     * This user must be get from the {@link FakeApiServiceGenerator#FAKE_USERS_RANDOM} list.
     */
    @Override
    public void generateRandomUser() {
        users.add(Customer.random());
    }

    /**
     * Delete a {@link Customer} from the {@link FakeApiService#users} list.
     */
    @Override
    public void deleteUser(Customer user) {
        users.remove(user);
    }

    /**
     * Add a {@link Customer} from the {@link FakeApiService#users} list.
     */
    @Override
    public void addUser(Customer user) {
        users.add(user);
    }

    /**
     * Delete a {@link Order} from the {@link FakeApiService#users} list.
     */
    @Override
    public void deleteOrder(Order order) {
        orders.remove(order);

    }

    /**
     * Add a {@link Order} from the {@link FakeApiService#users} list.
     */
    @Override
    public void addOrder(Order order) {
        orders.add(order);

        //System.out.println("The order №" + order.getId() + " has been placed!");
        System.out.println("The order №" + order.getId() + " has been placed, for the shop at" + order.getShop().getAdress()+", "+order.getShop().getCity());

    }


    /**
     * used to give some discount to a customer for things he has bought
     * @return the final price of the order
     */
    public void giveDiscount(Order order){

        int cookiesNumber=order.getCart().getCookiesNumber();
        if (order.getCustomer().isRegistered() && cookiesNumber>=30){
           addDiscount(order.getCustomer(), shopDiscounts.get("LOYALTY_PROGRAM"));
        }



    }
}
