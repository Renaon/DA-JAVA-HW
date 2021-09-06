package hw5;


public class Backpack_task {
    private static int SIZE = 6;
    private static Backpack[][] bp;
    private static int itemsNum;
    private static Item[] items;

    public static void main(String[] args) {

        items = new Item[]{
                new Item("0", 1, 500),
                new Item("1", 2, 600),
                new Item("2", 1, 300),
                new Item("3", 3, 400),
                new Item("4", 2, 350),
                new Item("5", 4, 800),
                new Item("6", 5, 1000),
                new Item("7", 4, 450)
        };

        itemsNum = items.length;

        System.out.println("Ценнейший сбор: " + reccalc(itemsNum-1, SIZE));

    }

    private static int reccalc(int i, int size){
        if(i < 0) return 0;
        if(items[i].getWeight()>size) return reccalc(i-1,size);
        else return Math.max(reccalc(i-1,size), reccalc(i-1,size - items[i].getWeight()) + items[i].getPrice());
    }
}
