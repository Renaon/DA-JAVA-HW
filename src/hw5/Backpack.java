package hw5;

import java.util.Arrays;
import java.util.stream.Collectors;

public class Backpack {
    private Item[] items;
    private int totalPrice;

    public Backpack(Item[] items, int price){
        this.items = items;
        this.totalPrice = price;
    }

    public int getTotalPrice() {
        return totalPrice;
    }

    public Item[] getItems() {
        return items;
    }

    public String getDescription() {
        return items == null ? "" : Arrays.stream(items).map(Item::getName).collect(Collectors.joining("+")) + "-" + getTotalPrice();}
}
