package model.customer;

import model.Discount;

import java.util.ArrayList;

/**
 * @author Lydia BARAUKOVA
 */
public class RegisteredCustomer extends Customer {
    private int id; // every registered model.customer has an id
    private int cookieCount; // nb of cookies bought during all the time
    // additional information that registered customers provide
    private int age;
    private String address;
    private ArrayList<Discount> discountsList;

    public RegisteredCustomer(int id, String firstName, String lastName, int age, String tel, String email, String address) {
        super(firstName, lastName, tel, email);
        this.id = id;
        this.age = age;
        this.address = address;
        this.cookieCount = 0;
    }

    private ArrayList<Discount> getDiscountsList() {
        return discountsList;
    }

    public int getId() {
        return id;
    }

    public int getAge() {
        return age;
    }

    public String getAdress() {
        return address;
    }

    public void setAdress(String a) {
        address = a;
    }

    public int getCookieCount() {
        return cookieCount;
    }

    public void increaseCookieCount(int c) {
        cookieCount += c;
    }

    @Override
    public boolean isRegistered() {
        return true;
    }


}
