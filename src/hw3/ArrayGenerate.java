package hw3;

import java.util.ArrayList;
import java.util.Random;

public class ArrayGenerate {
    private ArrayList<Integer> arr;
    private int SIZE = 0;

    public  ArrayGenerate(int n){
        this.SIZE = n;
        this.arr = new ArrayList<>();
        for (int i = 1; i<n; i++){
            this.arr.add(i);
        }
        int space = new Random().nextInt(n++);
        System.out.println(space);
        delSpace(space);

    }

    public ArrayList getArr(){
        return this.arr;
    }

    public int getSIZE(){
        return this.SIZE;
    }

    private void delSpace(int space){
        int low = 0;
        int high = SIZE--;
        while (low<=high){
            int mid = (int) Math.floor((low+high) / 2);
            if(arr.get(mid)>space) high = mid-1;
            else low = mid + 1;

            if(arr.get(mid) == space) {
                arr.remove(mid);
                this.SIZE--;
                return;
            }
        }
        return;
    }
}
