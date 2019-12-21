package repository;

import api.ApiService;
import model.customer.Manager;

/**
 * @author Aldric DUCREUX
 */
public class ManagerRepository {
    private final ApiService apiService;

    public ManagerRepository(ApiService apiService) {
        this.apiService = apiService;
    }

    public Manager getManager() {
        return apiService.getManager();
    }

}
