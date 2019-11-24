package repository;


import api.ApiService;
import model.customer.Customer;

import java.util.List;
/**
 * @author Virgile FANTAUZZI
 */

public class UserRepository {

    private final ApiService apiService;

    public UserRepository(ApiService apiService) {
        this.apiService = apiService;
    }

    public List<Customer> getUsers() {
        return apiService.getUsers();
    }

    public void generateRandomUser() {
        apiService.generateRandomUser();
    }

    public void addUser(Customer user) {
        apiService.addUser(user);
    }

    public void deleteUser(Customer user) {
        apiService.deleteUser(user);
    }
}
