package repository;


import api.ApiService;
import model.Discount;
import model.Order;
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

    void addDiscount(RegisteredCustomer customer, Discount discount){
        apiService.addDiscount(customer, discount);
    }

    List<Discount> getDiscounts(RegisteredCustomer customer){
        return apiService.getDiscounts(customer);
    }

    float applyDiscount(RegisteredCustomer customer, Discount discount){
        return apiService.applyDiscount(customer, discount);
    }
}
