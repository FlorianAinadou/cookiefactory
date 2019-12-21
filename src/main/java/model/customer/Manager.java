package model.customer;

import model.Recipe;
import model.Shop;
import utils.Statistics;

public class Manager extends Customer {
    private Shop shop;

    public Manager(String firstName, String lastName, String tel, String email, double walletAmount, Shop shop) {
        super(firstName, lastName, tel, email, walletAmount);
        this.shop=shop;
    }

    @Override
    public boolean isRegistered() {
        return true;
    }
    public void setWorkingHours(int openingAt, int closingAt) {
        this.shop.setWorkingHours(openingAt, closingAt);
    }
    public void setRecipeOfTheMonth(Recipe newR) {
        this.shop.setRecipeOfTheMonth(newR);
    }

    public void showStatistique(Shop statShop) {
        Statistics.showGeneralStatistics();
        Statistics.showShopStatistics(statShop);
    }
}
