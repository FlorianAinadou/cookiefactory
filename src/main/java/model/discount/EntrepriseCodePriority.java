package model.discount;

import java.util.List;

public class EntrepriseCodePriority extends DiscountStrategy{

    public EntrepriseCodePriority(){

    }

    public EntrepriseCodePriority(List<Discount> discountList){
        this.discountList= discountList;
    }



    public Discount applyStrategy() {
        for(Discount discount:discountList){
            if(discount.getName().contains("CE_")){
                return discount;
            }
        }
        return new Discount(0.0f,"No company code");
    }


}
