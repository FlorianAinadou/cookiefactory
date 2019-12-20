package api;

import model.Cart;
import model.Order;
import model.Recipe;
import model.Shop;
import model.consumables.Consumable;

import model.consumables.Cookie;

import model.consumables.CookieComponent;
import model.consumables.PackComposition;
import model.customer.Customer;
import model.discount.Discount;
import model.discount.DiscountStrategy;
import model.discount.SeniorityPriority;

import java.text.DecimalFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

import static api.FakeApiServiceGenerator.*;

/**
 * @author Virgile FANTAUZZI
 * @author Lydia BARAUKOVA
 * @author Aldric Ducreux
 */
public class FakeApiService implements ApiService {

    private List<Customer> customers = generateCustomers();
    private List<Shop> shops = generateShops();
    private HashMap<String, Recipe> recipes = new HashMap<>(generateCookieRecipes());
    private HashMap<String, HashMap<String, Integer>> stocks = new HashMap<>(generateStocks());
    private HashMap<String, CookieComponent> doughs = new HashMap<>(generateCookieDough());
    private HashMap<String, CookieComponent> topping = new HashMap<>(generateCookieTopping());
    private HashMap<String, CookieComponent> mix = new HashMap<>(generateCookieMix());
    private HashMap<String, CookieComponent> cooking = new HashMap<>(generateCookieCooking());
    private HashMap<String, CookieComponent> flavours = new HashMap<>(generateCookieFlavour());
    private HashMap<Customer, ArrayList<Discount>> discounts = new HashMap<>(generateDiscounts());
    private HashMap<String, Discount> shopDiscounts = new HashMap<>(generateShopDiscounts());
    private ArrayList<PackComposition> packCompositions = new ArrayList<>(generatePacksComposition());
    private List<Order> orders = new ArrayList<>();

    // customer related methods

    @Override
    public List<Customer> getCustomers() {
        return customers;
    }

    @Override
    public Customer getRandomRegisteredCustomer() {
        return FAKE_REGISTERED_CUSTOMERS.get(new Random().nextInt(FAKE_REGISTERED_CUSTOMERS.size()));
    }

    @Override
    public Customer getRandomUnregisteredCustomer() {
        return FAKE_UNREGISTERED_CUSTOMERS.get(new Random().nextInt(FAKE_UNREGISTERED_CUSTOMERS.size()));
    }

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
    public Shop getRandomShop() {
        return FAKE_SHOPS.get(new Random().nextInt(FAKE_SHOPS.size()));
    }

    @Override
    public void addShop(Shop shop) {
        shops.add(shop);
        System.out.println("New shop added: " + shop.getName());
    }

    @Override
    public void deleteShop(Shop shop) {
        shops.remove(shop);
    }

    @Override
    public Map<String, Integer> getStocks(Shop shop) {
        return stocks.get(shop.getName());
    }

    @Override
    public void removeFromStock(Shop shop, Consumable consumable) {

        Map<String, Integer> stockNeed = new HashMap<>();

        if (consumable.isCookie()) {
            for (CookieComponent cc : ((Cookie) consumable).getRecipe().getIngredients()) {
                if (stockNeed.containsKey(cc.getName())) {
                    stockNeed.put(cc.getName(), stockNeed.get(cc.getName()) + 1);
                } else {
                    stockNeed.put(cc.getName(), 1);
                }
            }
        } else if (consumable.isCookiePack()) {
            for (Consumable cookie : consumable.getItemPack().keySet()) {
                for (CookieComponent cc : ((Cookie) cookie).getRecipe().getIngredients()) {

                    if (stockNeed.containsKey(cc.getName())) {
                        stockNeed.put(cc.getName(), stockNeed.get(cc.getName()) + 1);
                    } else {
                        stockNeed.put(cc.getName(), 1);
                    }
                }
            }
        } else {
            if (stockNeed.containsKey(consumable.getName())) {
                stockNeed.put(consumable.getName(), stockNeed.get(consumable.getName()) + 1);
            } else {
                stockNeed.put(consumable.getName(), 1);
            }
        }

        for (String name : stockNeed.keySet()) {
            if (stocks.get(name) == null || stocks.get(shop.getName()).get(name) < stockNeed.get(name)) {
                stocks.get(shop.getName()).put(name, stocks.get(shop.getName()).get(name) - stockNeed.get(name));
            }
        }
    }

    // recipe and ingredient related methods

    @Override
    public Map<String, Recipe> getRecipes() {
        return recipes;
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
    public void changeRecipeMargin(String name, double value) {
        recipes.get(name).setPriceMargin(value);
    }

    @Override
    public Map<String, CookieComponent> getDough() {
        return doughs;
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
    public void changeDoughPrice(String name, double price) {
        doughs.get(name).setPrice(price);
    }

    @Override
    public Map<String, CookieComponent> getTopping() {
        return topping;
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
    public void changeToppingPrice(String name, double price) {
        topping.get(name).setPrice(price);
    }

    @Override
    public Map<String, CookieComponent> getMix() {
        return mix;
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
    public void changeMixPrice(String name, double price) {
        mix.get(name).setPrice(price);
    }

    @Override
    public Map<String, CookieComponent> getCooking() {
        return cooking;
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
    public void changeCookingPrice(String name, double price) {
        cooking.get(name).setPrice(price);
    }

    @Override
    public Map<String, CookieComponent> getFlavour() {
        return flavours;
    }

    @Override
    public void addFlavour(String name, CookieComponent flavour) {
        this.flavours.put(name, flavour);
    }

    @Override
    public void deleteFlavour(String name) {
        this.flavours.remove(name);
    }

    @Override
    public void changeFlavourPrice(String name, double price) {
        flavours.get(name).setPrice(price);
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
    public void addOrder(Order order) throws CloneNotSupportedException {
        giveDiscount(order);
        order.setTotalPrice(order.getCart().getTotalPrice() + order.getCart().getTotalPrice() * order.getShop().getTax());
        System.out.println(order.toString());
        order.setCart(order.getCustomer().getCart().clone()); //clone du panier pour la garder en mémoire car on le supprime de l'utilisateur après
        orders.add(order);
        order.getCustomer().emptyCart(); // and empty the customer's cart
    }

    @Override
    public void deleteOrder(Order order) {
        orders.remove(order);
    }

    @Override
    public void addOrder(Order order, DiscountStrategy discountStrategy) throws CloneNotSupportedException {
        giveDiscount(order);
        Discount discount = new Discount();
        if (discountStrategy != null) {
            discountStrategy.setDiscountList(order.getDiscountsYouCouldApply());
            discount = discountStrategy.applyStrategy();
        } else {
            discount = new SeniorityPriority(order.getCustomer());
        }

        DecimalFormat totalFinalPrice = new DecimalFormat();
        totalFinalPrice.setMaximumFractionDigits(2); //arrondi à 2 chiffres apres la virgules

        double totalPrice = applyDiscount(order.getCustomer(), order.getShop(), discount);
        System.out.println("The shop tax is " + order.getShop().getTax() * 100 + " %, total tax is " + totalFinalPrice.format(order.getCart().getTotalPrice() * order.getShop().getTax()) + " €");
        System.out.println("Price TTC is " + totalFinalPrice.format(order.getCart().getTotalPrice() + order.getCart().getTotalPrice() * order.getShop().getTax()) + " €");
        System.out.println("The discount " + discount.toString() + " have been used!");
        order.setTotalPrice(totalPrice);
        System.out.println(order.toString());
        order.setOrderStatus(order.getOrderStatus() + 1);
        Cart cloneCart = order.getCart().clone();
        order.setCart(cloneCart);
        orders.add(order);
        order.getCustomer().emptyCart(); // and empty the model.customer's cart
    }

    @Override
    public void payOrder(Order order, Customer customer) {
        System.out.println("Customer money before paying : " + customer.getWalletAmount() + " €");
        DecimalFormat totalFinalPrice = new DecimalFormat();
        totalFinalPrice.setMaximumFractionDigits(2); //arrondi à 2 chiffres apres la virgules
        if (customer.getWalletAmount() > order.getTotalPrice()) {
            order.setOrderStatus(order.getOrderStatus() + 1);
            customers.get(customers.indexOf(customer)).setWalletAmount((customer.getWalletAmount() - order.getTotalPrice()));
            System.out.println("Customer money : " + totalFinalPrice.format(customers.get(customers.indexOf(customer)).getWalletAmount()) + " €");
        } else {
            System.out.println("The order has not been paid, the walletAmount of the customer is not enough");
        }
    }

    // discount related methods*
    @Override
    public void pickUpOrder(Order order, Shop shop){
            shop.shopPickUp(order);
            System.out.println("This order can be pick up now");
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
    public float askForADiscountApplying(Customer customer, Discount discount) {
        if (customer.isRegistered()) {
            return discount.getRate();
        }
        return 0.0f;
    }

    @Override
    public ArrayList<PackComposition> getPacksComposition() {
        return packCompositions;
    }

    public void giveDiscount(Order order) {
        int nbCookies = order.getCart().getNbCookies();
        if (order.getCustomer().isRegistered()) {
            if (nbCookies >= shopDiscounts.get("LOYALTY_PROGRAM").getMinimumCookiesRequired()) {
                addDiscount(order.getCustomer(), shopDiscounts.get("LOYALTY_PROGRAM"));
                System.out.println("Great news! you get the Loyalty_program discount (10% discount). Use it next time)");
            }
        }


    }

    public void lastHourReduction(Order order, Discount discount){
        if(order.getShop().inTheLastHour(order.getDate().getHours())){
            for (Consumable consumable :  order.getCart().getItems().keySet()) {
                if(consumable.isCookie() && consumable.getName().equals("Personalized cookie")){
                    order.getCart().applyReductionOnConsumable(discount,consumable);
                }
            }
        }
    }
}
