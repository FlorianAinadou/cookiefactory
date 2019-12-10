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
 */


public class FakeApiService implements ApiService {

    private List<Customer> users = generateUsers();
    private HashMap<String, Recipe> recipes = new HashMap<>(generateCookieRecipes());
    private HashMap<String, CookieComponent> doughs = new HashMap<>(generateCookieDough());
    private HashMap<String, CookieComponent> topping = new HashMap<>(generateCookieTopping());
    private HashMap<String, CookieComponent> mix = new HashMap<>(generateCookieMix());
    private HashMap<String, CookieComponent> cooking = new HashMap<>(generateCookieCooking());
    private HashMap<String, CookieComponent> flavours = new HashMap<>(generateCookieFlavour());
    private HashMap<Customer, ArrayList<Discount>> discounts = new HashMap<>(generateDiscounts());
    private List<Order> orders = new ArrayList<>();
    private HashMap<String, Discount> shopDiscounts = new HashMap<String, Discount>(getShopDiscounts());
    private List<Shop> shops = new ArrayList<>();


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
    public Map<String, CookieComponent> getCookieDough() {
        return doughs;
    }

    @Override
    public Map<String, CookieComponent> getCookieTopping() {
        return topping;
    }

    @Override
    public Map<String, CookieComponent> getCookieMix() {
        return mix;
    }

    @Override
    public Map<String, CookieComponent> getCookieCooking() {
        return cooking;
    }

    @Override
    public Map<String, CookieComponent> getCookieFlavour() {
        return flavours;
    }


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

    /**
     * Used to apply a discount asked by a customer
     * If the customer is not registered, return the total price of his cart
     * <<<<<<< HEAD
     *
     * @param customer
     * @param discount
     * @param customer active customer
     * @param discount discount he wants to apply
     * @return total price after discount application
     * >>>>>>> 303efee5d25b8ed71a8d181c3100665e1695e566
     */
    @Override
    public double applyDiscount(Customer customer, Shop shop, Discount discount) {
        if (customer.isRegistered()) {
            if (discounts.containsKey(customer)) {
                try {
                    discounts.get(customer).remove(discount);
                    return (customer.getCart().getTotalPrice() + customer.getCart().getTotalPrice() * shop.getTaxe()) * (1.f - discount.getRate());
                } catch (Throwable e) {
                    System.out.println("You don't have the right to this discount ");
                }

            }
        }
        return customer.getCart().getTotalPrice();
    }

    /**
     * the customer may just need to see the reduction which may be applied
     * Not useful right now
     *
     * @param customer
     * @param discount
     * @return
     */
    @Override
    public float askForADiscountApplying(Customer customer, Discount discount) {
        if (customer.isRegistered()) {
            return discount.getRate();
        }

        return 0.0f;

    }

    // public float getFinalPrice(Customer customer, Discount discount){ }

    /**
     * Return a list of {@link Order}
     * Those orders must be generated by {@link FakeApiServiceGenerator} if you want some MOCK
     */
    @Override
    public List<Order> getOrders() {
        return orders;
    }

    @Override
    public List<Shop> getShops() {
        return shops;
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
        giveDiscount(order);
        order.setOrderAmount(order.getCart().getTotalPrice() + order.getCart().getTotalPrice() * order.getShop().getTaxe());
        orders.add(order);
        System.out.println(order.toString());
        order.getCustomer().emptyCart(); // and empty the model.customer's cart

    }

    /**
     * used to get an order with a discount
     *
     * @param order
     * @param discount
     */
    @Override
    public void addOrder(Order order, Discount discount) {
        giveDiscount(order);
        DecimalFormat totalFinalPrice = new DecimalFormat();
        totalFinalPrice.setMaximumFractionDigits(2); //arrondi à 2 chiffres apres la virgules

        double totalPrice = applyDiscount(order.getCustomer(), order.getShop(), discount);
        System.out.println("The shop tax is " + order.getShop().getTaxe() * 100 + " %, total tax is " + totalFinalPrice.format(order.getCart().getTotalPrice() * order.getShop().getTaxe()) + " €");
        System.out.println("Price TTC is " + totalFinalPrice.format(order.getCart().getTotalPrice() + order.getCart().getTotalPrice() * order.getShop().getTaxe()) + " €");
        System.out.println("The discount " + discount.toString() + " have been used!");
        order.setOrderAmount(totalPrice);
        System.out.println(order.toString());
        order.setOrderStatu(order.getOrderStatu() + 1);
        orders.add(order);
        order.getCustomer().emptyCart(); // and empty the model.customer's cart
    }

    @Override
    public void payOrder(Order order, Customer customer) {
        System.out.println("Customer money before paying : " + customer.getWalletAmount() + " €");
        DecimalFormat totalFinalPrice = new DecimalFormat();
        totalFinalPrice.setMaximumFractionDigits(2); //arrondi à 2 chiffres apres la virgules
        if (customer.getWalletAmount() > order.getOrderAmount()) {
            order.setOrderStatu(order.getOrderStatu() + 1);
            users.get(users.indexOf(customer)).setWalletAmount((customer.getWalletAmount() - order.getOrderAmount()));
            System.out.println("Customer money : " + totalFinalPrice.format(users.get(users.indexOf(customer)).getWalletAmount()) + " €");
        } else {
            System.out.println("The order has not been paid, the walletAmount of the customer is not enough");
        }
    }

    /**
     * Add a {@link Shop } from the {@link FakeApiService#shops} list.
     *
     * @param shop
     */
    @Override
    public void addShop(Shop shop) {
        shops.add(shop);
        System.out.println(shop.getShopName() + ",nouveau Shop ajouté ");
    }

    /**
     * Delete a {@link Shop } from the {@link FakeApiService#shops} list.
     *
     * @param shop
     */
    @Override
    public void deleteShop(Shop shop) {
        shops.remove(shop);
    }

    @Override
    public void addRecipe(String name, Recipe recipe) {
        recipes.put(name, recipe);
    }

    @Override
    public void deleteRecipe(String name) {
        recipes.remove(name);
    }

    @Override
    public void addMix(String name, CookieComponent mix) {
        this.mix.put(name, mix);
    }

    @Override
    public void deleteMix(String name) {
        this.mix.remove(name);
    }

    @Override
    public void addTopping(String name, CookieComponent topping) {
        this.topping.put(name, topping);
    }

    @Override
    public void deleteTopping(String name) {
        this.topping.remove(name);
    }

    @Override
    public void addDough(String name, CookieComponent dough) {
        this.doughs.put(name, dough);
    }

    @Override
    public void deleteDough(String name) {
        this.doughs.remove(name);
    }

    @Override
    public void addCooking(String name, CookieComponent cooking) {
        this.cooking.put(name, cooking);
    }

    @Override
    public void deleteCooking(String name) {
        this.cooking.remove(name);
    }

    @Override
    public void addFlavour(String name, CookieComponent flavour) {
        this.flavours.put(name, flavour);
    }

    @Override
    public void deleteFlavour(String name) {
        this.flavours.remove(name);
    }


    /**
     * change schedule of a {@link Shop }
     *
     * @param shop
     * @param open
     * @param close
     */
    @Override
    public void changeHorairesShop(Shop shop, Date open, Date close) {
        shop.setOpenShop(open);
        shop.setCloseShop(close);
        System.out.println("Le shop: " + shop.getShopName() + " sera ouvert de" + shop.getOpenShop() + " à " + shop.getCloseShop());
    }

    /**
     * used to give some discount to a customer for things he has bought
     *
     * @return the final price of the order
     */
    public void giveDiscount(Order order) {

        int cookiesNumber = order.getCart().getCookiesNumber();
        if (order.getCustomer().isRegistered()) {

            if (cookiesNumber >= shopDiscounts.get("LOYALTY_PROGRAM").getMinimumCookiesRequired()) {
                addDiscount(order.getCustomer(), shopDiscounts.get("LOYALTY_PROGRAM"));
                System.out.println("Great news! you get the Loyalty_program discount (10% discount). Use it next time)");
            }

            /*if (cookiesNumber >= shopDiscounts.get("CE")) {

            }
        }*/
        }
    }
}
