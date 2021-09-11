package hw6;

import java.util.*;

public class Application {

    public static void main(String[] args) {
        List<Tree> forest = new Vector<>();
        int n = 20;

        for(int i = 0; i<n; i++){
            forest.add(new Tree());
            int m = 9 + new Random().nextInt(12);
            for(int j = 0; j< m; j++){
                Random r = new Random();
                int tmp = -25 + r.nextInt(1);
                forest.get(i).insert(tmp);
            }
        }

        int nonBalaceCoount = 0;
        for(Tree test: forest){
            if(isBalanced(test.getRoot())) nonBalaceCoount++;
        }
        int nonPercent = nonBalaceCoount * 100 / n;
        System.out.println("Несбалансированных " + nonPercent + " процентов");
    }

    public static boolean isBalanced(Node node) {
        return (node == null) ||
                isBalanced(node.getLeftChild()) &&
                        isBalanced(node.getRightChild()) &&
                        Math.abs(height(node.getLeftChild()) - height(node.getRightChild())) <= 1;
    }

    private static int height(Node node) {
        return node == null ? 0 : 1 + Math.max(height(node.getLeftChild()), height(node.getRightChild()));
    }
}
