package devices;

import java.util.*;

public class Repeter {
    private String name;
    private ConnectedNodes linked = new ConnectedNodes();

    public Repeter() {
    }

    public Repeter(String name) {
        this.name = name;
    }

    public Repeter(String name, ConnectedNodes linked) {
        this.name = name;
        this.linked = linked;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ConnectedNodes getLinked() {
        return this.linked;
    }

    public void setLinked(ConnectedNodes linked) {
        this.linked = linked;
    }

    public Repeter name(String name) {
        this.name = name;
        return this;
    }

    public Repeter linked(ConnectedNodes linked) {
        this.linked = linked;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Repeter)) {
            return false;
        }
        Repeter Repeter = (Repeter) o;
        return Objects.equals(name, Repeter.name) && Objects.equals(linked, Repeter.linked);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, linked);
    }

    @Override
    public String toString() {
        return "{" + " name='" + getName() + "'" + ", linked='" + getLinked() + "'" + "}";
    }

}
