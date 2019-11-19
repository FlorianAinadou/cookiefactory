package model;

import java.util.Date;

public class Shop {
    protected String adress;
    protected Place city;
    protected Date openShop;
    protected Date closeShop;
    protected double taxe;

    public Shop(String adress, Place city, Date openShop, Date closeShop, double taxe) {
        this.adress = adress;
        this.city = city;
        this.openShop = openShop;
        this.closeShop = closeShop;
        this.taxe = taxe;
    }

    public String getAdress() {
        return adress;
    }

    public Place getCity() {
        return city;
    }

    public Date getOpenShop() {
        return openShop;
    }

    public Date getCloseShop() {
        return closeShop;
    }

    public double getTaxe() {
        return taxe;
    }
}
