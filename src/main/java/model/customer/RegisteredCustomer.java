package model.customer;

import model.discount.Discount;

import java.util.List;
import java.util.ArrayList;

/**
 * @author Lydia BARAUKOVA
 * @author Florian AINADOU
 */
public class RegisteredCustomer extends Customer {

    private int id; // every registered model.customer has an id
    private int cookieCount; // nb of cookies bought during all the time

    // additional information for registered customers
    private int age;
    private String address;
    private List<Discount> discountsList;

    public RegisteredCustomer(int id, String firstName, String lastName, int age, String tel, String email, String address, double walletAmount) {
        super(firstName, lastName, tel, email, walletAmount);
        this.id = id;
        this.age = age;
        this.address = address;
        this.cookieCount = 0;
        this.discountsList = new ArrayList<>();
    }

    private List<Discount> getDiscountsList() {
        return discountsList;
    }
    public int getId() {
        return id;
    }
    public int getAge() {
        return age;
    }
    public String getAddress() {
        return address;
    }
    public void setAddress(String a) {
        address = a;
    }
    public int getCookieCount() {
        return cookieCount;
    }
    public void increaseCookieCount(int c) {
        cookieCount += c;
    }

    @Override
    public boolean isRegistered() { return true; }
}
