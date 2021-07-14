package miVersion;

public abstract class AbstractServico implements Servico{
  private String name;
  private String description;
  private double price;

  public AbstractServico(String name, String description, double price) {
    this.name = name;
    this.description = description;
    this.price = price;
  }

  public AbstractServico(String name, String description){
    this.name = name;
    this.description = description;
  }

  public String name() {
    return name;
  }

  public String description() {
    return description;
  }

  public double price() {
    return price;
  }

  @Override
  public String toString() {
    return this.getClass().getName().split("[.]")[1] + " [name=" + name + ", description=" + description + ", price="
        + price + "]";
  }
}
