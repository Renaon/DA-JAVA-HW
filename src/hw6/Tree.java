package hw6;

import java.util.Stack;

public class Tree {
    private Node root;
    private int size;

    public Tree(){
        root = null;
        size = 0;
    }

    public Node find(int value){ // ищет по значению
        Node current = root;
        while(current.getValue() != value){
            if(value< current.getValue()) {
                current = current.getLeftChild();
            }else{
                current = current.getRightChild();
            }
            if(current == null) return null;

        }
        return current;
    }

    public void insert(int value){
        Node newNode = new Node();
        newNode.setValue(value);

        if (root == null) root = newNode;
        else{
            Node current = root;
            Node parent;
            while(true){
                parent = current;
                if(value == current.getValue()) return;
                else if(value < current.getValue()){ //движение влево
                    current = current.getLeftChild();
                    if(current == null){ //конец
                        parent.setLeftChild(newNode);
                        return;
                    }
                }
                else { //вправо
                    current = current.getRightChild();
                    if (current == null){
                        parent.setRightChild(newNode);
                        return;
                    }
                }
            }
        }
        size +=1;
    }

    public boolean delete(int value){
        Node current = root;
        Node parent = root;

        boolean isLeft = true;
        
        while (current.getValue() != value){
            parent = current;

            if(value < current.getValue()){
                isLeft = true;
                current = current.getLeftChild();
            }
            else{
                isLeft = false;
                current = current.getRightChild();
            }
            if (current == null) return false;
        }

        if(current.getLeftChild() == null && current.getRightChild() == null){
            if (current == root) root = null;
            else if (isLeft) parent.setLeftChild(null);
            else parent.setRightChild(null);

        }
        else if(current.getRightChild() == null){
            if (current == root) root = current.getLeftChild();
            else if (isLeft) parent.setLeftChild(current.getLeftChild());
            else parent.setRightChild(current.getLeftChild());
        }
        else if(current.getLeftChild() == null){
            if (current  == root) root = current.getRightChild();
            else if (isLeft) parent.setLeftChild(current.getRightChild());
            else parent.setRightChild(current.getRightChild());
        }
        else {
            Node heir = recieveHeir(current);
            if(current == root) root = heir;
            else if(isLeft) parent.setLeftChild(heir);
            else parent.setRightChild(heir);
        }
        size -= 1;
        return true;
    }

    private Node recieveHeir(Node node){
        Node parentNode = node;
        Node heirNode = node;
        Node currentNode = node.getRightChild();
        while (currentNode  != null){
            parentNode = heirNode;
            heirNode = currentNode;
            currentNode = currentNode.getLeftChild();
        }
        if(heirNode != node.getRightChild()){
            parentNode.setLeftChild(heirNode.getRightChild());
            heirNode.setRightChild(node.getRightChild());
        }
        return  heirNode;
    }

    public void printTree() { // метод для вывода дерева в консоль
        Stack globalStack = new Stack(); // общий стек для значений дерева
        globalStack.push(root);
        int gaps = 32; // начальное значение расстояния между элементами
        boolean isRowEmpty = false;
        String separator = "-----------------------------------------------------------------";
        System.out.println(separator);// черта для указания начала нового дерева
        while (isRowEmpty == false) {
            Stack localStack = new Stack(); // локальный стек для задания потомков элемента
            isRowEmpty = true;

            for (int j = 0; j < gaps; j++)
                System.out.print(' ');
            while (globalStack.isEmpty() == false) { // покуда в общем стеке есть элементы
                Node temp = (Node) globalStack.pop(); // берем следующий, при этом удаляя его из стека
                if (temp != null) {
                    System.out.print(temp.getValue()); // выводим его значение в консоли
                    localStack.push(temp.getLeftChild()); // соохраняем в локальный стек, наследники текущего элемента
                    localStack.push(temp.getRightChild());
                    if (temp.getLeftChild() != null ||
                            temp.getRightChild() != null)
                        isRowEmpty = false;
                }
                else {
                    System.out.print("__");// - если элемент пустой
                    localStack.push(null);
                    localStack.push(null);
                }
                for (int j = 0; j < gaps * 2 - 2; j++)
                    System.out.print(' ');
            }
            System.out.println();
            gaps /= 2;// при переходе на следующий уровень расстояние между элементами каждый раз уменьшается
            while (localStack.isEmpty() == false)
                globalStack.push(localStack.pop()); // перемещаем все элементы из локального стека в глобальный
        }
        System.out.println(separator);// подводим черту
    }

    public int getSize() {
        return size;
    }

    public Node getRoot() {
        return root;
    }
}
