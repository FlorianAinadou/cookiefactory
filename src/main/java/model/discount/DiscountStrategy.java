package model.discount;

import java.util.List;

public abstract class DiscountStrategy extends Discount {
    protected List<Discount> discountList;

    public abstract Discount applyStrategy();


    public String toString(){
        String result= "";
        for (Discount discount:discountList) {
            result+= " " + discount.toString();
        }

        return  result;
    }

    public void setDiscountList(List<Discount> discountsYouCouldApply){
        this.discountList=discountsYouCouldApply;
    }
}
