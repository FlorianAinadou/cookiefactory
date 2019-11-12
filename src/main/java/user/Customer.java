package user;

import order.Basket;
import order.Order;
import order.ReservationsPlace;

import java.util.Date;

public class Customer extends User {
    private Basket basket=null;

    public Customer(int id, String firstname, String name, int age, String mail, String adress, int countCookie) {
        super(id, firstname, name, age, mail, adress, countCookie);

    }

    //As his name says it
    public Order makeOrder(Basket basket, Customer customer, Date date, ReservationsPlace reservationsPlace){

        return new Order(basket, customer, date, reservationsPlace);
    }

    /**
    * Every customer can create a new Basket
    */
    public void createNewBasket(){
        this.basket=new Basket();
    }


    /**
     * A customer can ask for seeing hs own basket. Then if there is none, we create a new basket for him
     * @return the client's basket
     */
    public Basket getBasket(){
        if(this.basket!=null) createNewBasket();

        return this.basket;
    }

    public void showMyBasket(){
        System.out.println(this.basket.showBasket());
    }
}
