package hw5;

public class Item {
    private final String name;
    private final int weight;
    private final int price;
    
    public Item(String name, int weight, int price){
        this.name = name;
        this.weight = weight;
        this.price = price;
    }

    public String getName(){
        return name;
    }

    public int getPrice() {
        return price;
    }

    public int getWeight() {
        return weight;
    }
}
