package di;


import api.FakeApiService;
import repository.OrderRepository;
import repository.UserRepository;
/**
 * @author Virgile FANTAUZZI
 */

public class Injection {

    private static FakeApiService fakeApiService = new FakeApiService();

    public static UserRepository createUserRepository() {
        return new UserRepository(fakeApiService);
    }

    public static OrderRepository createOrderRepository() {
        return new OrderRepository(fakeApiService);
    }
}
