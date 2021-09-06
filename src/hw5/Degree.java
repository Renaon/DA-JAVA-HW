package hw5;

public class Degree {

    public static void main(String[] args) {
        System.out.println(new Degree().exponentiation(4, 3));
    }

    public long exponentiation(int n, int ex){
        if (ex<=1) return n;
        else return n * exponentiation(n, --ex);
    }
}
