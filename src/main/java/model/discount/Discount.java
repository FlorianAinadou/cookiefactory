package model.discount;


//import org.jetbrains.annotations.Nullable;

import java.util.Objects;

/**
 * @author Virgile FANTAUZZI
 * @author Florian
 */
public class Discount {

    protected float rate;
    private String name;
    private final int minimumCookiesRequired;


    public Discount(float rate, String name, int minimumCookiesRequired) {
        this.rate = rate;
        this.name = name;
        this.minimumCookiesRequired= minimumCookiesRequired;
    }

    public Discount(){
        rate=0;
        name="";
        minimumCookiesRequired=0;
    }

    public Discount(float rate, String name) {
        this.rate = rate;
        this.name = name;
        this.minimumCookiesRequired= 0;
    }



    public int getMinimumCookiesRequired() {
        return minimumCookiesRequired;
    }

    public float getRate() {
        return rate;
    }

    public void setRate(float rate) {
        this.rate = rate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }



    @Override
    public boolean equals( Object obj) {
        if (obj == null) return false;
        if (obj == this) return true;
        if (!(obj instanceof Discount)) return false;
        return (((Discount) obj).getName().equals(this.getName()));
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getRate());
    }

    @Override
    public String toString(){
        return this.name + " with a rate of " + this.rate;
    }
}
