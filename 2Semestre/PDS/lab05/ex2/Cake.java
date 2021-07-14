package lab05.ex2;

public class Cake {
    private Shape shape = Shape.CIRCULAR;
    private String cakeLayer;
    private int numCakeLayers = 1;
    private Cream midLayerCream;
    private Cream topLayerCream;
    private Topping topping;
    private String message;

    public void setShape(Shape shape) {
        this.shape = shape;
    }

    public void setCakeLayer(String cakeLayer) {
        this.cakeLayer = cakeLayer;
    }

    public void setNumCakeLayers(int numCakeLayers) {
        this.numCakeLayers = numCakeLayers;
    }

    public void setMidLayerCream(Cream midLayerCream) {
        this.midLayerCream = midLayerCream;
    }

    public void setTopLayerCream(Cream topLayerCream) {
        this.topLayerCream = topLayerCream;
    }

    public void setTopping(Topping topping) {
        this.topping = topping;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        switch (cakeLayer) {
        case "Soft chocolate":
            if (message.length() == 0) {
                return cakeLayer + " cake with " + numCakeLayers + " layers, topped with " + topLayerCream
                        + " cream and " + topping + ".";
            }
            return cakeLayer + " cake with " + numCakeLayers + " layers, topped with " + topLayerCream + " cream and "
                    + topping + ". Message says: " + message;
        case "Sponge":
            if (message.length() == 0) {
                return cakeLayer + " cake with " + numCakeLayers + " layers and " + midLayerCream
                        + " cream, topped with " + topLayerCream + " cream and " + topping + ".";
            }
            return cakeLayer + " cake with " + numCakeLayers + " layers and " + midLayerCream + ", topped with "
                    + topLayerCream + " cream and " + topping + ". Message says: " + message;
        case "Yogurt":
            if (message.length() == 0) {
                return cakeLayer + " cake with " + numCakeLayers + " layers and " + midLayerCream
                        + " cream, topped with " + topLayerCream + " cream and " + topping + ".";
            }
            return cakeLayer + " cake with " + numCakeLayers + " layers and " + midLayerCream + ", topped with "
                    + topLayerCream + " cream and " + topping + ". Message says: " + message;

        }
        return null;

    }

}

class CakeMaster {
    private CakeBuilder cakeBuilder;

    public void createCake() {
        cakeBuilder.createCake();
    }

    public void createCake(String message) {
        cakeBuilder.createCake();
        cakeBuilder.addMessage(message);
    }

    public void createCake(int numLayer) {
        cakeBuilder.createCake();
        cakeBuilder.getCake().setNumCakeLayers(numLayer);
    }

    public void createCake(Shape shape) {
        cakeBuilder.createCake();
        cakeBuilder.setCakeShape(shape);
    }

    public void createCake(Shape shape, int numLayer, String message) {
        cakeBuilder.createCake();
        cakeBuilder.addMessage(message);
        cakeBuilder.setCakeShape(shape);
        cakeBuilder.getCake().setNumCakeLayers(numLayer);

    }

    public void createCake(int numLayer, String message) {
        cakeBuilder.createCake();
        cakeBuilder.addMessage(message);
        cakeBuilder.getCake().setNumCakeLayers(numLayer);

    }

    public void createCake(int numLayer, Shape shape) {
        cakeBuilder.createCake();
        cakeBuilder.setCakeShape(shape);
        cakeBuilder.getCake().setNumCakeLayers(numLayer);

    }

    public void createCake(Shape shape, String message) {
        cakeBuilder.createCake();
        cakeBuilder.addMessage(message);
        cakeBuilder.setCakeShape(shape);
    }

    public Cake getCake() {
        return cakeBuilder.getCake();
    }

    public void setCakeBuilder(CakeBuilder cakeBuilder) {
        this.cakeBuilder = cakeBuilder;
    }

}

class ChocolateCakeBuilder implements CakeBuilder {

    protected Cake cake;

    public void setCakeShape(Shape shape) {
        cake.setShape(shape);
    }

    public void addMessage(String m) {
        cake.setMessage(m);
    }

    public void createCake() {
        cake = new Cake();
        cake.setTopping(Topping.Fruit);
        cake.setTopLayerCream(Cream.Whipped_Cream);
        cake.setCakeLayer("Soft chocolate");
    }

    public Cake getCake() {
        return cake;
    }

}

class SpongeCakeBuilder implements CakeBuilder{

    protected Cake cake;

    public void setCakeShape(Shape shape) {
        cake.setShape(shape);
    }

    public void addMessage(String m) {
        cake.setMessage(m);
    }

    public void createCake() {
        cake = new Cake();
        cake.setTopping(Topping.Fruit);
        cake.setTopLayerCream(Cream.Whipped_Cream);
        cake.setMidLayerCream(Cream.Red_Berries);
        cake.setCakeLayer("Sponge");
    }

    public Cake getCake() {
        return cake;
    }
}

class YogurtCakeBuilder implements CakeBuilder{
    protected Cake cake;

    public void setCakeShape(Shape shape) {
        cake.setShape(shape);
    }

    public void addMessage(String m) {
        cake.setMessage(m);
    }

    public void createCake() {
        cake = new Cake();
        cake.setTopping(Topping.Chocolate);
        cake.setTopLayerCream(Cream.Red_Berries);
        cake.setMidLayerCream(Cream.Vanilla);
        cake.setCakeLayer("Sponge");
    }

    public Cake getCake() {
        return cake;
    }
}