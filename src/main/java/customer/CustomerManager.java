package customer;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Lydia BARAUKOVA
 */
public class CustomerManager {
    private List<RegisteredCustomer> registeredCustomers;
    private int id;

    public CustomerManager() {
        registeredCustomers = new ArrayList<>();
        id = 0;
    }

    public void registerCustomer(String firstName, String lastName, int age, String tel, String email, String address) {
        id++;
        RegisteredCustomer newCustomer = new RegisteredCustomer(id, firstName, lastName, age, tel, email, address);
        registeredCustomers.add(newCustomer);
        System.out.println("A customer №" + id +" has been registered!");
    }
}
