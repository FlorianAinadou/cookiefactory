package repository;

import api.ApiService;
import model.customer.Customer;
import model.customer.Manager;

import java.util.List;

public class ManagerRepository {
    private final ApiService apiService;

    public ManagerRepository(ApiService apiService) {
        this.apiService = apiService;
    }

    public Manager getManager() {
        return apiService.getManager();
    }

}
