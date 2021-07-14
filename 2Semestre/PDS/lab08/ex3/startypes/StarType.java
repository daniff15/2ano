package lab08.ex3.startypes;

import java.awt.*;

public abstract class StarType {

    private int size;
    private Color color;
    protected String description;
    protected Float[] physicalProperties;
    private int x;
    private int y;

    public StarType(int size, Color color, int x, int y) {
        this.size = size;
        this.color = color;
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public Color getColor(){
        return color;
    }

    public int getY() {
        return y;
    }

    public int getSize() {
        return size;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void draw(Graphics g) {
        g.setColor(color);
        g.fillOval(x, y , size, size);
    }
    
}