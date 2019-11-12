package customer;

/**
 * @author Lydia BARAUKOVA
 */
public class RegisteredCustomer extends Customer {
    private int id; // every registered customer has an id
    private int cookieCount; // nb of cookies bought during all the time
    // additional information that registered customers provide
    private int age;
    private String address;

    public RegisteredCustomer(int id, String firstName, String lastName, int age, String tel, String email, String address) {
        super(firstName, lastName, tel, email);
        this.id = id;
        this.age = age;
        this.address = address;
        this.cookieCount = 0;
    }

    public int getId() { return id; }
    public int getAge() { return age; }
    public String getAdress() { return address; }
    public void setAdress(String a) { address = a; }
    public int getCookieCount() { return cookieCount; }
    public void increaseCookieCount(int c) { cookieCount += c; }
}
