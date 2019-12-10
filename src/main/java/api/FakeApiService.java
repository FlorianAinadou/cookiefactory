package api;

import model.discount.Discount;
import model.Order;
import model.Recipe;
import model.Shop;
import model.consumables.CookieComponent;
import model.customer.Customer;

import java.text.DecimalFormat;
import java.util.*;

import static api.FakeApiServiceGenerator.*;

/**
 * @author Virgile FANTAUZZI
 * @author Lydia BARAUKOVA
 */
public class FakeApiService implements ApiService {

    private List<Customer> customers = generateUsers();
    private List<Shop> shops = generateShops();
    private HashMap<String, Recipe> recipes = new HashMap<>(generateCookieRecipes());
    private HashMap<String, CookieComponent> doughs = new HashMap<>(generateCookieDough());
    private HashMap<String, CookieComponent> topping = new HashMap<>(generateCookieTopping());
    private HashMap<String, CookieComponent> mix = new HashMap<>(generateCookieMix());
    private HashMap<String, CookieComponent> cooking = new HashMap<>(generateCookieCooking());
    private HashMap<String, CookieComponent> flavours = new HashMap<>(generateCookieFlavour());
    private HashMap<Customer, ArrayList<Discount>> discounts = new HashMap<>(generateDiscounts());
    private HashMap<String, Discount> shopDiscounts = new HashMap<>(generateShopDiscounts());
    private List<Order> orders = new ArrayList<>();

    // customer related methods

    @Override
    public List<Customer> getCustomers() {
        return customers;
    }
    @Override
    public Customer getRandomRegisteredCustomer() { return FAKE_REGISTERED_CUSTOMERS.get(new Random().nextInt(FAKE_REGISTERED_CUSTOMERS.size())); }
    @Override
    public Customer getRandomUnregisteredCustomer() { return FAKE_UNREGISTERED_CUSTOMERS.get(new Random().nextInt(FAKE_UNREGISTERED_CUSTOMERS.size())); }
    @Override
    public void addCustomer(Customer customer) {
        customers.add(customer);
    }
    @Override
    public void deleteCustomer(Customer customer) {
        customers.remove(customer);
    }

    // shop related methods

    @Override
    public List<Shop> getShops() {
        return shops;
    }
    @Override
    public Shop getRandomShop() { return FAKE_SHOPS.get(new Random().nextInt(FAKE_SHOPS.size())); }
    @Override
    public void addShop(Shop shop) {
        shops.add(shop);
        System.out.println("New shop added: " + shop.getName());
    }
    @Override
    public void deleteShop(Shop shop) {
        shops.remove(shop);
    }

    // recipe and ingredient related methods

    @Override
    public Map<String, Recipe> getCookieRecipes() { return recipes; }
    @Override
    public void addCookieRecipe(String name, Recipe recipe) { recipes.put(name, recipe); }
    @Override
    public void changeRecipesMargin(String name, double value) {
        //???
    }
    @Override
    public Map<String, CookieComponent> getCookieDough() {
        return doughs;
    }
    @Override
    public Map<String, CookieComponent> getCookieTopping() { return topping; }
    @Override
    public Map<String, CookieComponent> getCookieMix() {
        return mix;
    }
    @Override
    public Map<String, CookieComponent> getCookieCooking() { return cooking; }
    @Override
    public Map<String, CookieComponent> getCookieFlavour() {
        return flavours;
    }

    // order related methods

    @Override
    public List<Order> getOrders() {
        return orders;
    }
    @Override
    public int getOrderNum() {
        return orders.size();
    }
    @Override
    public void addOrder(Order order) {
        giveDiscount(order);
        order.setTotalPrice(order.getCart().getTotalPrice() + order.getCart().getTotalPrice() * order.getShop().getTax());
        orders.add(order);
        System.out.println(order.toString());
        order.getCustomer().emptyCart(); // and empty the customer's cart
    }
    @Override
    public void deleteOrder(Order order) { orders.remove(order); }
    @Override
    public void addOrder(Order order, Discount discount) {
        giveDiscount(order);
        DecimalFormat totalFinalPrice = new DecimalFormat();
        totalFinalPrice.setMaximumFractionDigits(2); //arrondi à 2 chiffres apres la virgules

        double totalPrice = applyDiscount(order.getCustomer(), order.getShop(), discount);
        System.out.println("The shop tax is " + order.getShop().getTax() * 100 + " %, total tax is " + totalFinalPrice.format(order.getCart().getTotalPrice() * order.getShop().getTax()) + " €");
        System.out.println("Price TTC is " + totalFinalPrice.format(order.getCart().getTotalPrice() + order.getCart().getTotalPrice() * order.getShop().getTax()) + " €");
        System.out.println("The discount " + discount.toString() + " have been used!");
        order.setTotalPrice(totalPrice);
        System.out.println(order.toString());
        order.setOrderStatus(order.getOrderStatus() + 1);
        orders.add(order);
        order.getCustomer().emptyCart(); // and empty the model.customer's cart
    }
    @Override
    public void payOrder(Order order, Customer customer) {
        System.out.println("Customer money before paying : " + customer.getWalletAmount() + " €");
        DecimalFormat totalFinalPrice = new DecimalFormat();
        totalFinalPrice.setMaximumFractionDigits(2);
        if (customer.getWalletAmount() > order.getTotalPrice()) {
            order.setOrderStatus(order.getOrderStatus() + 1);
            customers.get(customers.indexOf(customer)).setWalletAmount((customer.getWalletAmount() - order.getTotalPrice()));
            System.out.println("Customer money : " + totalFinalPrice.format(customers.get(customers.indexOf(customer)).getWalletAmount()) + " €");
        } else {
            System.out.println("The order has not been paid, the walletAmount of the customer is not enough");
        }
    }

    // discount related methods

    @Override
    public void addDiscount(Customer customer, Discount discount) {
        if (customer.isRegistered()) {
            if (discounts.containsKey(customer)) {
                // ArrayList<Discount> dis = discounts.get(customer);
                //discounts.put(customer,)
                discounts.get(customer).add(discount);
            } else {
                discounts.put(customer, new ArrayList<>(Collections.singletonList(discount)));
            }
        }
    }
    @Override
    public List<Discount> getDiscounts(Customer customer) {
        if (customer.isRegistered()) return discounts.get(customer);
        else {
            System.out.println("Customer not registered");
            return null;
        }
    }
    @Override
    public double applyDiscount(Customer customer, Shop shop, Discount discount) {
        if (customer.isRegistered()) {
            if (discounts.containsKey(customer)) {
                try {
                    discounts.get(customer).remove(discount);
                    return (customer.getCart().getTotalPrice() + customer.getCart().getTotalPrice() * shop.getTax()) * (1.f - discount.getRate());
                } catch (Throwable e) {
                    System.out.println("You don't have the right to this discount ");
                }
            }
        }
        return customer.getCart().getTotalPrice();
    }
    @Override
    public float askForADiscountApplying(Customer customer, Discount discount) { // not useful right now
        if (customer.isRegistered()) {
            return discount.getRate();
        }
        return 0.0f;
    }

    public void giveDiscount(Order order) {

        int cookiesNumber=order.getCart().getNbCookies();
        if (order.getCustomer().isRegistered()){

            if (cookiesNumber >= shopDiscounts.get("LOYALTY_PROGRAM").getMinimumCookiesRequired()) {
                addDiscount(order.getCustomer(), shopDiscounts.get("LOYALTY_PROGRAM"));
                System.out.println("Great news! you get the Loyalty_program discount (10% discount). Use it next time)");
            }

            /*if (cookiesNumber >= shopDiscounts.get("CE")) {

            }*/
        }
    }
}
