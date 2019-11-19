package model;

import com.sun.istack.internal.Nullable;
import model.customer.Customer;

import java.util.Date;
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
    public boolean equals(@Nullable Object obj) {
        if (obj == null) return false;
        if (obj == this) return true;
        if (!(obj instanceof Discount)) return false;
        return (((Discount) obj).getName().equals(this.getName()));
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getRate());
    }
}
