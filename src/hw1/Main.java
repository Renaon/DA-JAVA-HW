package hw1;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args){
        System.out.println(factorial(BigInteger.valueOf(10000)));
    }

    public static BigInteger factorial(BigInteger n) {
        if (n.equals(BigInteger.ONE)) {
            return n;
        }
        return n.multiply(factorial(n.subtract(BigInteger.valueOf(1))));
    }
}


