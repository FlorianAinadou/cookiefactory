package api;

import customer.Customer;
import order.Order;

import java.util.ArrayList;
import java.util.List;

import static api.FakeApiServiceGenerator.generateUsers;

/**
 * @author Virgile FANTAUZZI
 */


public class FakeApiService implements ApiService {

    private List<Customer> users = generateUsers();
    private List<Order> orders = new ArrayList<>();

    /**
     * Return a list of {@link Customer}
     * Those users must be generated by {@link FakeApiServiceGenerator}
     */
    @Override
    public List<Customer> getUsers() {
        return users;
    }

    /**
     * Return a list of {@link Order}
     * Those orders must be generated by {@link FakeApiServiceGenerator} if you want some MOCK
     */
    @Override
    public List<Order> getOrders() {
        return orders;
    }

    /**
     * Generate an order ID according to the size of orders {@link Order} .
     * This number must be only get here.
     */
    @Override
    public int getOrderNum() {
        return orders.size();
    }

    /**
     * Generate a random {@link Customer} and add it {@link FakeApiService#users} list.
     * This user must be get from the {@link FakeApiServiceGenerator#FAKE_USERS_RANDOM} list.
     */
    @Override
    public void generateRandomUser() {
        users.add(Customer.random());
    }

    /**
     * Delete a {@link Customer} from the {@link FakeApiService#users} list.
     */
    @Override
    public void deleteUser(Customer user) {
        users.remove(user);
    }

    /**
     * Add a {@link Customer} from the {@link FakeApiService#users} list.
     */
    @Override
    public void addUser(Customer user) {
        users.add(user);
    }

    /**
     * Delete a {@link Order} from the {@link FakeApiService#users} list.
     */
    @Override
    public void deleteOrder(Order order) {
        orders.remove(order);

    }

    /**
     * Add a {@link Order} from the {@link FakeApiService#users} list.
     */
    @Override
    public void addOrder(Order order) {
        orders.add(order);
        System.out.println("The order №" + order.getId() + " has been placed!");
    }
}