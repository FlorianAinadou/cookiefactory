package utils;

import di.Injection;
import model.consumables.Consumable;
import model.consumables.CookieComponent;
import repository.OrderRepository;
import model.Order;
import model.Shop;
import model.consumables.Cookie;
import model.consumables.Drink;
import repository.ShopRepository;

import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Aldric DUCREUX
 * @author Lydia BARAUKOVA
 */
public class Statistics {
    private static ShopRepository shopRepository = Injection.createShopRepository();
    private static OrderRepository orderRepository = Injection.createOrderRepository();

    private static List<Shop> allShops = shopRepository.getShops();
    private static List<Order> allOrders = orderRepository.getOrders();

    private static String noData = "No data";

    public static void showGeneralStatistics() {
        Log.print("General statistics: ");
        showStatistics(nbCookiesSold(), nbCodSold(), nbDrinksSold(), nbOrders(), nbOrdersWithDiscount(),
                bestSellingCookie(), worstSellingCookie(), bestSellingDrink(), worstSellingDrink(), moneyEarned());
    }

    public static void showShopStatistics(Shop shop) {
        Log.print("Statistics for the shop " + shop.getName()+": ");
        showStatistics(nbCookiesSoldInShop(shop), nbCodSoldInShop(shop), nbDrinksSoldInShop(shop),
                nbOrdersInShop(shop), nbOrdersWithDiscountInShop(shop), bestSellingCookieInShop(shop),
                worstSellingCookieInShop(shop), bestSellingDrinkInShop(shop), worstSellingDrinkInShop(shop),
                moneyEarnedByShop(shop));
    }

    public static void showStatistics(int nbCookiesSold, float nbCodSold, int nbDrinksSold, int nbOrders,
                                      float nbOrdersWithDiscount, String bestSellingCookie, String worstSellingCookie,
                                      String bestSellingDrink, String worstSellingDrink, double moneyEarned) {
        DecimalFormat decimal = new DecimalFormat();
        decimal.setMaximumFractionDigits(2);

        Log.print("\tCookies sold: " + nbCookiesSold);
        Log.print("\tNumber of personalized cookies sold: " + (int)nbCodSold);
        Log.print("\t% of personalized cookies: " +( nbCookiesSold==0 ? 0 : decimal.format(nbCodSold*100/nbCookiesSold)) + "%");
        Log.print("\tDrinks sold: " + nbDrinksSold);
        Log.print("\tNumber of orders: " + nbOrders);
        Log.print("\t% of orders with discount: " + ( nbOrders==0 ? 0 : decimal.format(nbOrdersWithDiscount*100/nbOrders) ) + "%");
        Log.print("\tBest selling recipe: " + bestSellingCookie);
        Log.print("\tWorst selling recipe: " + worstSellingCookie);
        Log.print("\tBest selling drink: " + bestSellingDrink);
        Log.print("\tWorst selling drink: " + worstSellingDrink);
        Log.print("\tMoney earned: " + decimal.format(moneyEarned) + " €\n");

    }

    // ---- general statistics ----

    public static int nbCookiesSold() {
        int res = 0;
        for (Order order: allOrders) {
            res += order.getCart().getNbCookies();
        }
        return res;
    }

    public static float nbCodSold() {
        int res = 0;
        for (Shop shop: allShops) {
            res += nbCodSoldInShop(shop);
        }
        return res;
    }

    public static int nbDrinksSold() {
        int res = 0;
        for (Shop shop: allShops) {
            res += nbDrinksSoldInShop(shop);
        }
        return res;
    }

    public static int nbOrders() {
        return allOrders.size();
    }

    public static float nbOrdersWithDiscount() {
        int res = 0;
        for (Shop shop: allShops) {
            res += nbOrdersWithDiscountInShop(shop);
        }
        return res;
    }

    public static String bestSellingCookie() {
        String cookie = noData;
        int quantity = 0;
        HashMap<String, Integer> allConsumable = getAllCookieWithQuantity();
        for (Map.Entry<String, Integer> mapEntry : allConsumable.entrySet()) {
            if (quantity < mapEntry.getValue() && !mapEntry.getKey().equals("")) {
                quantity = mapEntry.getValue();
                cookie = mapEntry.getKey();
            }
        }
        return cookie;
    }

    public static String worstSellingCookie() {
        String recipe = noData;
        int quantity = -1;
        HashMap<String, Integer> allConsumable = getAllCookieWithQuantity();
        for (Map.Entry<String, Integer> mapEntry : allConsumable.entrySet()) {
            if ((quantity > mapEntry.getValue() || quantity < 0) && !mapEntry.getKey().equals("")) { // we don't count personalized cookies (they have no names)
                quantity = mapEntry.getValue();
                recipe = mapEntry.getKey();
            }
        }
        return recipe;
    }

    public static String bestSellingDrink() {
        String drink = noData;
        int quantity = 0;
        HashMap<String, Integer> allConsumable = getAllDrinkWithQuantity();
        for (Map.Entry<String, Integer> mapEntry : allConsumable.entrySet()) {
                if (quantity < mapEntry.getValue()) {
                    quantity = mapEntry.getValue();
                    drink = mapEntry.getKey();
                }
            }
        return drink;
    }

    public static String worstSellingDrink() {
        String drink = noData;
        int quantity = -1;
        HashMap<String, Integer> allConsumable = getAllDrinkWithQuantity();
        for (Map.Entry<String, Integer> mapEntry : allConsumable.entrySet()) {
                if ((quantity > mapEntry.getValue() || quantity < 0)) {
                    quantity = mapEntry.getValue();
                    drink = mapEntry.getKey();
                }
            }
        return drink;
    }

    public static float moneyEarned() {
        float res = 0;
        for (Shop shop: allShops) {
            res += moneyEarnedByShop(shop);
        }
        return res;
    }

    // ---- stats on a shop ----

    public static int nbCookiesSoldInShop(Shop shop) {
        int res = 0;
        for (Order order: allOrders) {
            if (order.getShop().equals(shop)) {
                res += order.getCart().getNbCookies();
            }
        }
        return res;
    }

    public static float nbCodSoldInShop(Shop shop) {
        int res = 0;
        HashMap<String, Integer> allConsumable = getAllCookieWithQuantity(shop);
        for (Map.Entry<String, Integer> mapEntry : allConsumable.entrySet()) {
                if (mapEntry.getKey().equals("")) {
                    res += mapEntry.getValue();
                }
            }
        return res;
    }

    public static int nbDrinksSoldInShop(Shop shop) {
        int res = 0;
        HashMap<String, Integer> allConsumable = getAllCookieWithQuantity(shop);
        for (Map.Entry<String, Integer> mapEntry : allConsumable.entrySet()) {
            res += mapEntry.getValue();
        }
        return res;
    }

    public static int nbOrdersInShop(Shop shop) {
        int res = 0;
        for (Order order: allOrders) {
            if (order.getShop().equals(shop)) {
                res++;
            }
        }
        return res;
    }

    public static float nbOrdersWithDiscountInShop(Shop shop) {
        int res = 0;
        for (Order order: allOrders) {
            if (order.getShop().equals(shop)) {
                if (order.getOrderStatus() == 2) {
                    res++;
                }
            }
        }
        return res;
    }

    public static String bestSellingCookieInShop(Shop shop) {
        String cookie = noData;
        int quantity = 0;
        HashMap<String, Integer> allConsumable = getAllCookieWithQuantity(shop);
        for (Map.Entry<String, Integer> mapEntry : allConsumable.entrySet()) {
            if (!mapEntry.getKey().equals("")) {
                if (quantity < mapEntry.getValue()) {
                    quantity = mapEntry.getValue();
                    cookie = mapEntry.getKey();
                }
            }
        }
        return cookie;
    }

    public static String worstSellingCookieInShop(Shop shop) {
        String cookie = noData;
        int quantity = -1;
        HashMap<String, Integer> allConsumable = getAllCookieWithQuantity(shop);
        for (Map.Entry<String, Integer> mapEntry : allConsumable.entrySet()) {
            if (!mapEntry.getKey().equals("")) {
                if (quantity > mapEntry.getValue() || quantity < 0) {
                    quantity = mapEntry.getValue();
                    cookie = mapEntry.getKey();
                }
            }
        }
        return cookie;
    }

    public static String bestSellingDrinkInShop(Shop shop) {
        String drink = noData;
        int quantity = 0;
        HashMap<String, Integer> allConsumable = getAllDrinkWithQuantity(shop);
        for (Map.Entry<String, Integer> mapEntry : allConsumable.entrySet()) {
            if (quantity < mapEntry.getValue()) {
                quantity = mapEntry.getValue();
                drink = mapEntry.getKey();
            }
        }
        return drink;
    }

    public static String worstSellingDrinkInShop(Shop shop) {
        String drink = noData;
        int quantity = -1;
        HashMap<String, Integer> allConsumable = getAllDrinkWithQuantity(shop);
        for (Map.Entry<String, Integer> mapEntry : allConsumable.entrySet()) {
                if (quantity > mapEntry.getValue() || quantity < 0) {
                    quantity = mapEntry.getValue();
                    drink = mapEntry.getKey();
                }
            }
        return drink;
    }

    public static float moneyEarnedByShop(Shop shop) {
        float res = 0;
        for (Order order: allOrders) {
            if (order.getShop().equals(shop) && order.getOrderStatus() >= 1) {
                res += order.getTotalPrice();
            }
        }
        return res;
    }


//Builder map consummable
    private static HashMap<String, Integer> getAllCookieWithQuantity() {
        HashMap<String, Integer> consumableWithQuantity = new HashMap<>();
        for (Order order: allOrders) {
            for (Map.Entry<Consumable, Integer> mapEntry : order.getCart().getItems().entrySet()) {
                if(mapEntry.getKey().isCookie()) {
                        if (consumableWithQuantity.containsKey(mapEntry.getKey().getName())) { // if the model.consumables is already in the cart
                            consumableWithQuantity.put(mapEntry.getKey().getName(), consumableWithQuantity.get(mapEntry.getKey().getName()) + mapEntry.getValue()); // we increase the quantity of this item
                        } else {
                            consumableWithQuantity.put(mapEntry.getKey().getName(), mapEntry.getValue()); // we add the new item
                        }
                }else if(mapEntry.getKey().isCookiePack()) {
                    for (Map.Entry<Consumable, Integer> mapEntryPack : mapEntry.getKey().getItemPack().entrySet()) {
                        if(mapEntryPack.getKey().isCookie()) {
                            if (consumableWithQuantity.containsKey(mapEntryPack.getKey().getName())) { // if the model.consumables is already in the cart
                                consumableWithQuantity.put(mapEntryPack.getKey().getName(), consumableWithQuantity.get(mapEntryPack.getKey().getName()) + mapEntryPack.getValue()); // we increase the quantity of this item
                            } else {
                                consumableWithQuantity.put(mapEntryPack.getKey().getName(), mapEntryPack.getValue()); // we add the new item
                            }
                        }
                    }
                }
            }
        }
        return consumableWithQuantity;
    }
    private static HashMap<String, Integer> getAllCookieWithQuantity(Shop shop) {
        HashMap<String, Integer> consumableWithQuantity = new HashMap<>();
        for (Order order: allOrders) {
            if(order.getShop().equals(shop)) {
                for (Map.Entry<Consumable, Integer> mapEntry : order.getCart().getItems().entrySet()) {
                    if (mapEntry.getKey().isCookie()) {
                        if (consumableWithQuantity.containsKey(mapEntry.getKey().getName())) { // if the model.consumables is already in the cart
                            consumableWithQuantity.put(mapEntry.getKey().getName(), consumableWithQuantity.get(mapEntry.getKey().getName()) + mapEntry.getValue()); // we increase the quantity of this item
                        } else {
                            consumableWithQuantity.put(mapEntry.getKey().getName(), mapEntry.getValue()); // we add the new item
                        }
                    } else if (mapEntry.getKey().isCookiePack()) {
                        for (Map.Entry<Consumable, Integer> mapEntryPack : mapEntry.getKey().getItemPack().entrySet()) {
                            if (mapEntryPack.getKey().isCookie()) {
                                if (consumableWithQuantity.containsKey(mapEntryPack.getKey().getName())) { // if the model.consumables is already in the cart
                                    consumableWithQuantity.put(mapEntryPack.getKey().getName(), consumableWithQuantity.get(mapEntryPack.getKey().getName()) + mapEntryPack.getValue()); // we increase the quantity of this item
                                } else {
                                    consumableWithQuantity.put(mapEntryPack.getKey().getName(), mapEntryPack.getValue()); // we add the new item
                                }
                            }
                        }

                    }
                }
            }
        }
        return consumableWithQuantity;
    }
    private static HashMap<String, Integer> getAllDrinkWithQuantity() {
        HashMap<String, Integer> consumableWithQuantity = new HashMap<>();
        for (Order order: allOrders) {
                for (Map.Entry<Consumable, Integer> mapEntry : order.getCart().getItems().entrySet()) {
                    if (mapEntry.getKey().isDrink()) {
                        if (consumableWithQuantity.containsKey(mapEntry.getKey().getName())) { // if the model.consumables is already in the cart
                            consumableWithQuantity.put(mapEntry.getKey().getName(), consumableWithQuantity.get(mapEntry.getKey().getName()) + mapEntry.getValue()); // we increase the quantity of this item
                        } else {
                            consumableWithQuantity.put(mapEntry.getKey().getName(), mapEntry.getValue()); // we add the new item
                        }
                    } else if (mapEntry.getKey().isCookiePack()) {
                        for (Map.Entry<Consumable, Integer> mapEntryPack : mapEntry.getKey().getItemPack().entrySet()) {
                            if (mapEntry.getKey().isDrink()) {
                                if (consumableWithQuantity.containsKey(mapEntryPack.getKey().getName())) { // if the model.consumables is already in the cart
                                    consumableWithQuantity.put(mapEntryPack.getKey().getName(), consumableWithQuantity.get(mapEntryPack.getKey().getName()) + mapEntryPack.getValue()); // we increase the quantity of this item
                                } else {
                                    consumableWithQuantity.put(mapEntryPack.getKey().getName(), mapEntryPack.getValue()); // we add the new item
                                }
                            }
                        }
                    }
                }
            }
        return consumableWithQuantity;
    }

    private static HashMap<String, Integer> getAllDrinkWithQuantity(Shop shop) {
        HashMap<String, Integer> consumableWithQuantity = new HashMap<>();
        for (Order order : allOrders) {
            if (order.getShop().equals(shop)) {
                for (Map.Entry<Consumable, Integer> mapEntry : order.getCart().getItems().entrySet()) {
                    if (mapEntry.getKey().isDrink()) {
                        if (consumableWithQuantity.containsKey(mapEntry.getKey().getName())) { // if the model.consumables is already in the cart
                            consumableWithQuantity.put(mapEntry.getKey().getName(), consumableWithQuantity.get(mapEntry.getKey().getName()) + mapEntry.getValue()); // we increase the quantity of this item
                        } else {
                            consumableWithQuantity.put(mapEntry.getKey().getName(), mapEntry.getValue()); // we add the new item
                        }
                    } else if (mapEntry.getKey().isCookiePack()) {
                        for (Map.Entry<Consumable, Integer> mapEntryPack : mapEntry.getKey().getItemPack().entrySet()) {
                            if (mapEntryPack.getKey().isDrink()) {
                                if (consumableWithQuantity.containsKey(mapEntryPack.getKey().getName())) { // if the model.consumables is already in the cart
                                    consumableWithQuantity.put(mapEntryPack.getKey().getName(), consumableWithQuantity.get(mapEntryPack.getKey().getName()) + mapEntryPack.getValue()); // we increase the quantity of this item
                                } else {
                                    consumableWithQuantity.put(mapEntryPack.getKey().getName(), mapEntryPack.getValue()); // we add the new item
                                }
                            }
                        }

                    }
                }
            }
        }
        return consumableWithQuantity;
    }

}
