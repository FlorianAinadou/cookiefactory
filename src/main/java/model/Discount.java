package model;


//import org.jetbrains.annotations.Nullable;

import java.util.Objects;

/**
 * @author Virgile FANTAUZZI
 */
public class Discount {

    private float rate;
    private String name;

    public Discount(float rate, String name) {
        this.rate = rate;
        this.name = name;
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
        return ( this.name + " with rate of " + this.rate);
    }
}
