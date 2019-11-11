package order;

import user.Customer;

import java.util.Date;

public class Order {

    Basket basket;
    Customer customer;
    int orderNumber;  // Just a  random number given to every order
    Date date; //The order date
    ReservationsPlace reservationsPlace;


    public Order(Basket basket, Customer customer, int number, Date date, ReservationsPlace reservationsPlace){
         this.basket = basket;
         this.customer= customer;
         this.orderNumber= number;
         this.date=date;
         this.reservationsPlace= reservationsPlace;
    }
}
