package lab07.ex3;

import java.nio.Buffer;

public abstract class Product {
    protected static StringBuffer indent = new StringBuffer();

    public abstract String toString();
    public abstract double getWeight();
}

