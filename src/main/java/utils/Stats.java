package utils;

import di.Injection;
import model.Order;
import model.Shop;
import model.consumables.Cookie;
import model.consumables.Drink;
import repository.OrderRepository;

import java.text.DecimalFormat;
import java.util.List;
import java.util.Map;

public class Stats {
    private static OrderRepository orderRepository = Injection.createOrderRepository();
    private static List<Order> allOrders = orderRepository.getOrders();
    private static int somme = 0;
    private static String name = "Aucunes Informations";



    public static void showStat() {
        System.out.println("Ensemble des Statistiques Nationnal : ");
        System.out.println("\tNombre de Cookie vendu : " + numberofCookieSell());
        System.out.println("\t% de cookie sur mesure : " + numberofCookieOnDemandSell() +"%");
        System.out.println("\tNombre de Boisson vendu : " + numberofDrinkSell());
        System.out.println("\tNombre de commande passé  : " + numberofOrder());
        System.out.println("\tNombre de commande avec réduction  : " + numberofOderWithDiscount());
        System.out.println("\tRecette la plus rentable : "+ bestRecipeSell());
        System.out.println("\tRecette la moins rentable : "+ worseRecipeSell());
        System.out.println("\tBoisson la plus rentable : "+ bestDrinkSell());
        System.out.println("\tBoisson la moins rentable : "+ worseDrinkSell());
        System.out.println("\tLa chaine de magasin a gagné : "+ Money() +" €");
    }
    public static void showStat(Shop shop) {
        System.out.println("Ensemble des Statistiques du Magasin " + shop.getName()+" : ");
        System.out.println("\tNombre de Cookie vendu : " + numberofCookieSell(shop));
        System.out.println("\t% de cookie sur mesure : " + numberofCookieOnDemandSell(shop) +"%");
        System.out.println("\tNombre de Boisson vendu : " + numberofDrinkSell(shop));
        System.out.println("\tNombre de commande passé  : " + numberofOrder(shop));
        System.out.println("\tNombre de commande avec réduction  : " + numberofOderWithDiscount(shop));
        System.out.println("\tRecette la plus rentable : "+ bestRecipeSell(shop));
        System.out.println("\tRecette la moins rentable : "+ worseRecipeSell(shop));
        System.out.println("\tBoisson la plus rentable : "+ bestDrinkSell(shop));
        System.out.println("\tBoisson la moins rentable : "+ worseDrinkSell(shop));
        System.out.println("\t"+ shop.getName() +" a gagné : "+ Money(shop) +" €");
    }

//----------------------------------------------------------------
    //statistique nationnal
    public static int numberofCookieSell() {
        somme = 0;
        for (int i = 0; i < allOrders.size(); i++) {
            for (Map.Entry mapentry : allOrders.get(i).getCart().getItems().entrySet()) {
                if (mapentry.getKey()instanceof Cookie) {
                    somme += mapentry.getValue().hashCode();
                }
            }
        }
        return somme;
    }
    public static int numberofDrinkSell() {
        somme = 0;
        for (int i = 0; i < allOrders.size(); i++) {
            for (Map.Entry mapentry : allOrders.get(i).getCart().getItems().entrySet()) {
                if (mapentry.getKey()instanceof Drink) {
                    somme += mapentry.getValue().hashCode();
                }
            }
        }
        return somme;
    }

    public static float numberofCookieOnDemandSell() {
        somme = 0;
        for (int i = 0; i < allOrders.size(); i++) {
            for (Map.Entry mapentry : allOrders.get(i).getCart().getItems().entrySet()) {
                if (mapentry.getKey()instanceof Cookie) {
                    if(((Cookie) mapentry.getKey()).getName().equals(""))
                        somme += mapentry.getValue().hashCode();
                }
            }
        }
        float res = (float) somme*100/numberofCookieSell();
        return res;
    }

    public static int numberofOrder() {
        return orderRepository.getOrderNum();
    }
    public static int numberofOderWithDiscount() {
        somme = 0;
        for (int i = 0; i < allOrders.size(); i++) {
            if(allOrders.get(i).getOrderStatus() == 2)
                somme ++;
        }
        return somme;
    }

    public static String bestRecipeSell() {
        String recipe = name;
        int quantity = 0;
        for (int i = 0; i < allOrders.size(); i++) {
            for (Map.Entry mapentry : allOrders.get(i).getCart().getItems().entrySet()) {
                if (mapentry.getKey() instanceof Cookie) {
                    if(quantity < mapentry.getValue().hashCode()) {
                        quantity = mapentry.getValue().hashCode();
                        recipe = ((Cookie) mapentry.getKey()).getName();
                    }
                }
            }
        }
        return recipe;
    }
    public static String worseRecipeSell() {
        String recipe = name;
        int quantity = -1;
        for (int i = 0; i < allOrders.size(); i++) {
            for (Map.Entry mapentry : allOrders.get(i).getCart().getItems().entrySet()) {
                if (mapentry.getKey() instanceof Cookie) {
                    if((quantity > mapentry.getValue().hashCode() || quantity < 0 ) && !((Cookie) mapentry.getKey()).getName().equals("")) { //test de la quantité et si c'est pas un cookie sur mesure (sans nom)
                        quantity = mapentry.getValue().hashCode();
                        recipe = ((Cookie) mapentry.getKey()).getName();
                    }
                }
            }
        }
        return recipe;
    }

    public static String bestDrinkSell() {
        String drink = name;
        int quantity = 0;
        for (int i = 0; i < allOrders.size(); i++) {
            for (Map.Entry mapentry : allOrders.get(i).getCart().getItems().entrySet()) {
                if (mapentry.getKey() instanceof Drink) {
                    if(quantity < mapentry.getValue().hashCode()) {
                        quantity = mapentry.getValue().hashCode();
                        drink = ((Drink) mapentry.getKey()).getName();
                    }
                }
            }
        }
        return drink;
    }
    public static String worseDrinkSell() {
        String drink = name;
        int quantity = -1;
        for (int i = 0; i < allOrders.size(); i++) {
            for (Map.Entry mapentry : allOrders.get(i).getCart().getItems().entrySet()) {
                if (mapentry.getKey() instanceof Drink) {
                    if((quantity > mapentry.getValue().hashCode() || quantity < 0 )) {
                        quantity = mapentry.getValue().hashCode();
                        drink = ((Drink) mapentry.getKey()).getName();
                    }
                }
            }
        }
        return drink;
    }

    public static float Money() {
        float somme = 0;
        for (int i = 0; i < allOrders.size(); i++) {
            if(allOrders.get(i).getOrderStatus() >=1 )
                somme += allOrders.get(i).getTotalPrice();
        }
        return somme;
    }

    //---------------------------------------------------------------
    //stats on a shop
    public static int numberofCookieSell(Shop shop) {
        somme = 0;
        for (int i = 0; i < allOrders.size(); i++) {
            if( allOrders.get(i).getShop().equals(shop)) {
                for (Map.Entry mapentry : allOrders.get(i).getCart().getItems().entrySet()) {
                    if (mapentry.getKey() instanceof Cookie) {
                        somme += mapentry.getValue().hashCode();
                    }
                }
            }
        }
        return somme;
    }
    public static int numberofDrinkSell(Shop shop) {
        somme = 0;
        for (int i = 0; i < allOrders.size(); i++) {
            if( allOrders.get(i).getShop().equals(shop)) {
                for (Map.Entry mapentry : allOrders.get(i).getCart().getItems().entrySet()) {
                    if (mapentry.getKey() instanceof Drink) {
                        somme += mapentry.getValue().hashCode();
                    }
                }
            }
        }
        return somme;
    }

    public static float numberofCookieOnDemandSell(Shop shop) {
        somme = 0;
        for (int i = 0; i < allOrders.size(); i++) {
            if( allOrders.get(i).getShop().equals(shop)) {
                for (Map.Entry mapentry : allOrders.get(i).getCart().getItems().entrySet()) {
                    if (mapentry.getKey() instanceof Cookie) {
                        if (((Cookie) mapentry.getKey()).getName().equals(""))
                            somme += mapentry.getValue().hashCode();
                    }
                }
            }
        }
        float res = (float) somme*100/numberofCookieSell(shop);
        return res;
    }

    public static int numberofOrder(Shop shop) {
        somme = 0;
        for (int i = 0; i < allOrders.size(); i++) {
            if( allOrders.get(i).getShop().equals(shop))
                somme ++;
        }
        return somme;
    }
    public static int numberofOderWithDiscount(Shop shop) {
        somme = 0;
        for (int i = 0; i < allOrders.size(); i++) {
            if( allOrders.get(i).getShop().equals(shop)) {
                if (allOrders.get(i).getOrderStatus() == 2)
                    somme++;
            }
        }
        return somme;
    }

    public static String bestRecipeSell(Shop shop) {
        String recipe = name;
        int quantity = 0;
        for (int i = 0; i < allOrders.size(); i++) {
            if( allOrders.get(i).getShop().equals(shop)) {
                for (Map.Entry mapentry : allOrders.get(i).getCart().getItems().entrySet()) {
                    if (mapentry.getKey() instanceof Cookie) {
                        if (quantity < mapentry.getValue().hashCode()) {
                            quantity = mapentry.getValue().hashCode();
                            recipe = ((Cookie) mapentry.getKey()).getName();
                        }
                    }
                }
            }
        }
        return recipe;
    }
    public static String worseRecipeSell(Shop shop) {
        String recipe = name;
        int quantity = -1;
        for (int i = 0; i < allOrders.size(); i++) {
            if( allOrders.get(i).getShop().equals(shop)) {
                for (Map.Entry mapentry : allOrders.get(i).getCart().getItems().entrySet()) {
                    if (mapentry.getKey() instanceof Cookie) {
                        if ((quantity > mapentry.getValue().hashCode() || quantity < 0) && !((Cookie) mapentry.getKey()).getName().equals("")) { //test de la quantité et si c'est pas un cookie sur mesure (sans nom)
                            quantity = mapentry.getValue().hashCode();
                            recipe = ((Cookie) mapentry.getKey()).getName();
                        }
                    }
                }
            }
        }
        return recipe;
    }

    public static String bestDrinkSell(Shop shop) {
        String drink = name;
        int quantity = 0;
        for (int i = 0; i < allOrders.size(); i++) {
            if( allOrders.get(i).getShop().equals(shop)) {
                for (Map.Entry mapentry : allOrders.get(i).getCart().getItems().entrySet()) {
                    if (mapentry.getKey() instanceof Drink) {
                        if (quantity < mapentry.getValue().hashCode()) {
                            quantity = mapentry.getValue().hashCode();
                            drink = ((Drink) mapentry.getKey()).getName();
                        }
                    }
                }
            }
        }
        return drink;
    }
    public static String worseDrinkSell(Shop shop) {
        String drink = name;
        int quantity = -1;
        for (int i = 0; i < allOrders.size(); i++) {
            if( allOrders.get(i).getShop().equals(shop)) {
                for (Map.Entry mapentry : allOrders.get(i).getCart().getItems().entrySet()) {
                    if (mapentry.getKey() instanceof Drink) {
                        if ((quantity > mapentry.getValue().hashCode() || quantity < 0)) {
                            quantity = mapentry.getValue().hashCode();
                            drink = ((Drink) mapentry.getKey()).getName();
                        }
                    }
                }
            }
        }
        return drink;
    }

    public static float Money(Shop shop) {
        float somme = 0;
        for (int i = 0; i < allOrders.size(); i++) {
            if(allOrders.get(i).getShop().equals(shop) && allOrders.get(i).getOrderStatus() >=1 )
                somme += allOrders.get(i).getTotalPrice();
        }
        return somme;
    }
}
