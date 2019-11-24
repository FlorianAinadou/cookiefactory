package di;


import api.FakeApiService;
import repository.CookieRepository;
import repository.DiscountRepository;
import repository.OrderRepository;
import repository.UserRepository;
/**
 * @author Virgile FANTAUZZI
 */

public class Injection {

    public static FakeApiService fakeApiService = new FakeApiService();

    public static UserRepository createUserRepository() {
        return new UserRepository(fakeApiService);
    }
    public static DiscountRepository createDiscountRepository() {
        return new DiscountRepository(fakeApiService);
    }
    public static OrderRepository createOrderRepository() {
        return new OrderRepository(fakeApiService);
    }
    public static CookieRepository createCookieRepository() {
        return new CookieRepository(fakeApiService);
    }
}
