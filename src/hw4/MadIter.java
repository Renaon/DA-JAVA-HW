package hw4;

import java.util.Iterator;
import java.util.function.Consumer;

public class MadIter implements Iterator {
    private Link current;
    private final MadList list;
    private Link previous;

    public MadIter(MadList list){
        this.list = list;
        this.reset();
    }

    public void reset() {
        current = list.getFirst();
        previous = null;
    }

    public Link getCurrent() {
        return current;
    }


    public void display(){
        System.out.println("Name " + current.getName() + " age " + current.getAge());
    }

    public boolean hasNext() {
        return current != null;
    }

    public Link getNext(){
        return (Link) next();
    }

    @Override
    public Link next() {
        previous = current;
        current = current.next;
        return previous;
    }

}

