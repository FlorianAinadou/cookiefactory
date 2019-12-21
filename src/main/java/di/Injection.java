package di;

import api.FakeApiService;
import repository.*;

/**
 * @author Virgile FANTAUZZI
 * @author Lydia BARAUKOVA
 * @author Aldric DUCREUX
 */
public class Injection {

    private static FakeApiService fakeApiService = new FakeApiService();

    public static CustomerRepository createCustomerRepository() {
        return new CustomerRepository(fakeApiService);
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
    public static ShopRepository createShopRepository() {
        return new ShopRepository(fakeApiService);
    }
    public static ManagerRepository createManagerRepository() {
        return new ManagerRepository(fakeApiService);
    }
}
