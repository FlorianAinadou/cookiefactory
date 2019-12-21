package model.customer;

import model.Recipe;
import model.Shop;
import utils.Statistics;
/**
 * @author Aldric DUCREUX
 */
public class Manager extends Customer {


    public Manager(String firstName, String lastName, String tel, String email, double walletAmount) {
        super(firstName, lastName, tel, email, walletAmount);
    }

    @Override
    public boolean isRegistered() { return true; }
    @Override
    public boolean isManager() { return true; }
    public void setWorkingHours(Shop shop, int openingAt, int closingAt) {
        shop.setWorkingHours(openingAt, closingAt);
    }
    public void setRecipeOfTheMonth(Shop shop, Recipe newR) {
        shop.setRecipeOfTheMonth(newR);
    }

    public void showStatistique() {
        Statistics.showGeneralStatistics();
    }
    public void showStatistique(Shop statShop) {
        Statistics.showShopStatistics(statShop);
    }
}
