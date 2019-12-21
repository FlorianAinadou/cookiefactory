package model.customer;

/**
 * @author Lydia BARAUKOVA
 */
public class UnregisteredCustomer extends Customer {

    public UnregisteredCustomer(String firstName, String lastName, String tel, String email, double walletAmount) {
        super(firstName, lastName, tel, email, walletAmount);
        this.seniority=0;
    }

    @Override
    public boolean isRegistered(){
        return false;
    }
    @Override
    public boolean isManager() { return false; }
}
