package repository;


import api.ApiService;
import model.Discount;
import model.Shop;
import model.customer.Customer;
import model.customer.RegisteredCustomer;

import java.util.List;

/**
 * @author Virgile FANTAUZZI
 */

public class DiscountRepository {

    private final ApiService apiService;

    public DiscountRepository(ApiService apiService) {
        this.apiService = apiService;
    }

    public void addDiscount(RegisteredCustomer customer, Discount discount){
        apiService.addDiscount(customer, discount);
    }

    public List<Discount> getDiscounts(Customer customer){
        if(customer.isRegistered()) {
            return apiService.getDiscounts(customer);
        }
        return null;
    }

    public void applyDiscount(Customer customer, Shop shop, Discount discount){
        apiService.applyDiscount(customer, shop, discount);
    }
}
