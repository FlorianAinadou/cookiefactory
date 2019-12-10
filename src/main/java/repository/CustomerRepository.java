package repository;

import api.ApiService;
import model.customer.Customer;

import java.util.List;

/**
 * @author Virgile FANTAUZZI
 * @author Lydia BARAUKOVA
 */
public class CustomerRepository {

    private final ApiService apiService;

    public CustomerRepository(ApiService apiService) {
        this.apiService = apiService;
    }

    public List<Customer> getCustomers() {
        return apiService.getCustomers();
    }
    public Customer getRandomRegisteredCustomer() {
        return apiService.getRandomRegisteredCustomer();
    }
    public Customer getRandomUnregisteredCustomer() { return apiService.getRandomUnregisteredCustomer(); }
    public void addCustomer(Customer c) {
        apiService.addCustomer(c);
    }
    public void deleteCustomer(Customer c) {
        apiService.deleteCustomer(c);
    }
}
