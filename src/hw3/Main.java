package hw3;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args){
        ArrayGenerate generator = new ArrayGenerate(10);
        ArrayList<Integer> arr = generator.getArr();
        int size = generator.getSIZE();
        new Main().printArray(arr, size);
        System.out.println(new Main().findSpace(arr,size));
    }

    private void printArray(ArrayList arr, int n){
        for(int i = 0; i<n; i++){
            System.out.print(arr.get(i) + " ");
        }
    }

    private int findSpace(ArrayList arr, int size){
       for (int i = 1; i<size; i++){
           int prev = (int) arr.get(i-1);
           if(!arr.get(i).equals(prev + 1)) return prev+1;
       }
       return -1;
    }
}
