package model.discount;

import model.customer.Customer;

public class SeniorityPriority extends DiscountStrategy{
    private int seniority=0;

    public SeniorityPriority(){

    }


    public SeniorityPriority(Customer customer){
        seniority= customer.getSeniority();
    }
    @Override
    public Discount applyStrategy() {
        return new Discount(seniority*0.01f,"Seniority: " +seniority +" years" );
    }
}
