package devices;

import java.util.*;

public class Signal {

    private int strength = 5;

    public Signal(int strength) {
        this.strength = strength;
    }

    public Signal() {
    }

    public int getStrength() {
        return this.strength;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    public Signal strength(int strength) {
        this.strength = strength;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Signal)) {
            return false;
        }
        Signal signal = (Signal) o;
        return strength == signal.strength;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(strength);
    }

    @Override
    public String toString() {
        return "{" + " strength='" + getStrength() + "'" + "}";
    }

}
