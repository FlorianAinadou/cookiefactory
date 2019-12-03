package model;


import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

import static api.FakeApiServiceGenerator.FAKE_SHOPS;

public class Shop {
    public final int id;  // just a  random number given to every order
    protected String shopName;
    protected String adress;
    protected Place city;
    protected Date openShop;
    protected Date closeShop;
    protected  double taxe;
    protected List<Order> orderHistoric = new ArrayList<>();

    public Shop(int id, String shopName, String adress, Place city, Date openShop, Date closeShop, double taxe) {
        this.id =id;
        this.shopName = shopName;
        this.adress = adress;
        this.city = city;
        this.openShop = openShop;
        this.closeShop = closeShop;
        this.taxe = taxe;
    }

    public int getId() {return id;}

    public String getShopName() { return shopName;}

    public String getAdress() {
        return adress;
    }

    public Place getCity() {
        return city;
    }

    public Date getOpenShop() { return openShop; }
    public Date getCloseShop()  { return closeShop; }
    public void setOpenShop(Date openShop) {this.openShop = openShop; }
    public void setCloseShop(Date closeShop) {this.closeShop = closeShop; }

    public  double getTaxe() {
        return taxe;
    }

    public static Shop random(){
        return FAKE_SHOPS.get(new Random().nextInt(FAKE_SHOPS.size()));
    }

    @Override
    public boolean equals(@Nullable Object obj) {
        if (obj == null) return false;
        if (obj == this) return true;
        if (!(obj instanceof Order)) return false;
        return (((Order) obj).getId() == (this.getId()));
    }
}
