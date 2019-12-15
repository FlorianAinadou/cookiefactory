package model.discount;

import java.util.List;

public class EventPriority extends DiscountStrategy {

    public EventPriority(){

    }

    public EventPriority(List<Discount> discountList){
        this.discountList= discountList;
    }



    @Override
    public Discount applyStrategy() {
        for(Discount discount:discountList){
            if(discount.getName().contains("EVENT_")){
                return discount;
            }
        }
        return new Discount(0.0f,"No special event code");
    }

    @Override
    public String toString(){
        return ( applyStrategy().getName() + " with rate of " + this.rate);
    }

}
