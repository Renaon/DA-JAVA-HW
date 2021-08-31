package hw3;

public class Deque {
    private int maxSize;
    private int[] deque;
    private int front;
    private int rear;
    private int items;
    private int last;

    public Deque(int s){
        maxSize = s;
        deque = new int[maxSize];
        front = 0;
        rear = -1;
        items = 0;
        last = maxSize-1;
    }

    public void insert(int i){
        if(rear==maxSize-1) {
            rear = -1;
            deque[++rear] = i;
            items++;
        }
    }

    public int removeFirst(){
        int temp = deque[front++];
        if(front == maxSize){
            front = 0;
            items--;
            return temp;
        }
        return -1;
    }

    public int removeLast(){
        return this.deque[this.last--];
    }

    public int getFront() {
        return deque[front];
    }

    public int getLast() {
        return deque[last];
    }

    public boolean isEmpty(){
        return (this.last == -1);
    }

    public boolean isFull(){
        return (this.last == this.maxSize-1);
    }
}
