package devices;

import java.util.*;

public class Computer extends Signal {
    private String name;
    private ConnectedNodes linked = new ConnectedNodes();

    public Computer(String name) {
        super();
        this.name = name;
    }

    public Computer() {
    }

    public Computer(String name, ConnectedNodes linked) {
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

    public Computer name(String name) {
        this.name = name;
        return this;
    }

    public Computer linked(ConnectedNodes linked) {
        this.linked = linked;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Computer)) {
            return false;
        }
        Computer computer = (Computer) o;
        return Objects.equals(name, computer.name) && Objects.equals(linked, computer.linked);
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
