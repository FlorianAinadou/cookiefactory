package utils;

import di.Injection;
import model.consumables.Consumable;
import repository.OrderRepository;
import model.Order;
import model.Shop;
import model.consumables.Cookie;
import model.consumables.Drink;
import repository.ShopRepository;

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

    public static void showStatistics(int nbCookiesSold, int nbCodSold, int nbDrinksSold, int nbOrders,
                                      int nbOrdersWithDiscount, String bestSellingCookie, String worstSellingCookie,
                                      String bestSellingDrink, String worstSellingDrink, double moneyEarned) {
        Log.print("\tCookies sold: " + nbCookiesSold);
        Log.print("\t% of personalized cookies: " + ( nbCookiesSold==0 ? 0 : nbCodSold/nbCookiesSold*100 ) + "%");
        Log.print("\tDrinks sold: " + nbDrinksSold);
        Log.print("\tNumber of orders: " + nbOrders);
        Log.print("\t% of orders with discount: " + ( nbOrders==0 ? 0 : nbOrdersWithDiscount/nbOrders*100 ) + "%");
        Log.print("\tBest selling recipe: " + bestSellingCookie);
        Log.print("\tWorst selling recipe: " + worstSellingCookie);
        Log.print("\tBest selling drink: " + bestSellingDrink);
        Log.print("\tWorst selling drink: " + worstSellingDrink);
        Log.print("\tMoney earned: " + moneyEarned + " €");

    }

    // ---- general statistics ----

    public static int nbCookiesSold() {
        int res = 0;
        for (Order order: allOrders) {
            res += order.getCart().getNbCookies();
        }
        return res;
    }

    public static int nbCodSold() {
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

    public static int nbOrdersWithDiscount() {
        int res = 0;
        for (Shop shop: allShops) {
            res += nbOrdersWithDiscountInShop(shop);
        }
        return res;
    }

    public static String bestSellingCookie() {
        String cookie = noData;
        int quantity = 0;
        for (Order order: allOrders) {
            for (Map.Entry<Consumable, Integer> mapEntry : order.getCart().getItems().entrySet()) {
                System.out.println(mapEntry.getKey().getClass().getName());
                if (mapEntry.getKey().isCookie()) {
                    if (quantity < mapEntry.getValue()) {
                        quantity = mapEntry.getValue();
                        cookie = mapEntry.getKey().getName();
                    }
                }
                if(mapEntry.getKey().isCookiePack()) {
                    for (Map.Entry<Consumable, Integer> mapEntryPack :mapEntry.getKey().getItemPack().entrySet()) {
                        if (mapEntryPack.getKey().isCookie()) {
                            if (quantity < mapEntryPack.getValue()) {
                                quantity = mapEntryPack.getValue();
                                cookie = mapEntryPack.getKey().getName();
                            }
                        }
                    }

                }
            }
        }
        return cookie;
    }

    public static String worstSellingCookie() {
        String recipe = noData;
        int quantity = -1;
        for (Order order: allOrders) {
            for (Map.Entry<Consumable, Integer> mapEntry : order.getCart().getItems().entrySet()) {
                if (mapEntry.getKey().isCookie()) {
                    if ((quantity > mapEntry.getValue() || quantity < 0) && !mapEntry.getKey().getName().equals("")) { // we don't count personalized cookies (they have no names)
                        quantity = mapEntry.getValue();
                        recipe = mapEntry.getKey().getName();
                    }
                }
            }
        }
        return recipe;
    }

    public static String bestSellingDrink() {
        String drink = noData;
        int quantity = 0;
        for (Order order: allOrders) {
            for (Map.Entry<Consumable, Integer> mapEntry : order.getCart().getItems().entrySet()) {
                if (!mapEntry.getKey().isCookie()) {
                    if (quantity < mapEntry.getValue()) {
                        quantity = mapEntry.getValue();
                        drink = mapEntry.getKey().getName();
                    }
                }
            }
        }
        return drink;
    }

    public static String worstSellingDrink() {
        String drink = noData;
        int quantity = -1;
        for (Order order: allOrders) {
            for (Map.Entry<Consumable, Integer> mapEntry : order.getCart().getItems().entrySet()) {
                if (!mapEntry.getKey().isCookie()) {
                    if ((quantity > mapEntry.getValue() || quantity < 0)) {
                        quantity = mapEntry.getValue();
                        drink = mapEntry.getKey().getName();
                    }
                }
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
                for (Map.Entry<Consumable, Integer> mapEntry : order.getCart().getItems().entrySet()) {
                    if (mapEntry.getKey().isCookie()) {
                        res += mapEntry.getValue();
                    }
                }
            }
        }
        return res;
    }

    public static int nbCodSoldInShop(Shop shop) {
        int res = 0;
        for (Order order: allOrders) {
            if (order.getShop().equals(shop)) {
                for (Map.Entry<Consumable, Integer> mapEntry : order.getCart().getItems().entrySet()) {
                    if (mapEntry.getKey().isCookie()) {
                        if (mapEntry.getKey().getName().equals("")) {
                            res += mapEntry.getValue();
                        }
                    }
                }
            }
        }
        return res;
    }

    public static int nbDrinksSoldInShop(Shop shop) {
        int res = 0;
        for (Order order: allOrders) {
            if (order.getShop().equals(shop)) {
                for (Map.Entry<Consumable, Integer> mapEntry : order.getCart().getItems().entrySet()) {
                    if (!mapEntry.getKey().isCookie()) {
                        res += mapEntry.getValue();
                    }
                }
            }
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

    public static int nbOrdersWithDiscountInShop(Shop shop) {
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
        for (Order order: allOrders) {
            if (order.getShop().equals(shop)) {
                for (Map.Entry<Consumable, Integer> mapEntry : order.getCart().getItems().entrySet()) {
                    if (mapEntry.getKey().isCookie()) {
                        if (quantity < mapEntry.getValue()) {
                            quantity = mapEntry.getValue();
                            cookie = mapEntry.getKey().getName();
                        }
                    }
                }
            }
        }
        return cookie;
    }

    public static String worstSellingCookieInShop(Shop shop) {
        String cookie = noData;
        int quantity = -1;
        for (Order order: allOrders) {
            if (order.getShop().equals(shop)) {
                for (Map.Entry<Consumable, Integer> mapEntry : order.getCart().getItems().entrySet()) {
                    if (mapEntry.getKey().isCookie()) {
                        if ((quantity > mapEntry.getValue() || quantity < 0) && !mapEntry.getKey().getName().equals("")) { // we don't count personalized cookies (they have no names)
                            quantity = mapEntry.getValue();
                            cookie = mapEntry.getKey().getName();
                        }
                    }
                }
            }
        }
        return cookie;
    }

    public static String bestSellingDrinkInShop(Shop shop) {
        String drink = noData;
        int quantity = 0;
        for (Order order: allOrders) {
            if (order.getShop().equals(shop)) {
                for (Map.Entry<Consumable, Integer> mapEntry : order.getCart().getItems().entrySet()) {
                    if (!mapEntry.getKey().isCookie()) {
                        if (quantity < mapEntry.getValue()) {
                            quantity = mapEntry.getValue();
                            drink = mapEntry.getKey().getName();
                        }
                    }
                }
            }
        }
        return drink;
    }

    public static String worstSellingDrinkInShop(Shop shop) {
        String drink = noData;
        int quantity = -1;
        for (Order order: allOrders) {
            if (order.getShop().equals(shop)) {
                for (Map.Entry<Consumable, Integer> mapEntry : order.getCart().getItems().entrySet()) {
                    if (!mapEntry.getKey().isCookie()) {
                        if ((quantity > mapEntry.getValue() || quantity < 0)) {
                            quantity = mapEntry.getValue();
                            drink = mapEntry.getKey().getName();
                        }
                    }
                }
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
}
