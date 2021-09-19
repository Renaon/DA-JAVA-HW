package hw4;


import java.util.HashMap;
import java.util.Iterator;

public class CensusPeople {

    public static void main(String[] args) {
        MadList<MadIter> list = new MadList<>();

        list.insertFirst("Artem", 20);
        list.insertFirst("Egor", 24);
        list.insertFirst("Ivan", 25);

        list.find("Egor").display();

        for(MadIter i : list){
            i.display();
        }
    }
}
