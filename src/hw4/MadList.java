package hw4;

import java.util.Iterator;

public class MadList<T> implements Iterable<T> {
    private Link first;

    public MadList(){
        first = null;
    }

    public boolean isEmpty(){
        return (first == null);
    }

    public Link getFirst() {
        return first;
    }

    public void insertFirst(String name, int age){
        Link newLink = new Link(name, age);
        newLink.next = first;
        first = newLink;
    }

    public Link delete(){
        Link temp = first;
        first = first.next;
        return temp;
    }

    public Link delete(String name, int age){
        Link currentLink = first;
        Link prev = first;
        while (!currentLink.getName().equals(name) && currentLink.getAge() != age){
            if(currentLink.next == null) return null;
            else{
                prev = currentLink;
                currentLink = currentLink.next;
            }
        }

        if (currentLink == first) first = first.next;
        else prev.next = currentLink.next;
        return currentLink;
    }

    public void display(){
        Link current = first;
        while(current != null){
            current.display();
            current = current.next;
        }
    }
    
    public Link find(String searchableName){
        Link find = new Link(searchableName);
        Link current = first;
        while(current != null){
            if(current.getName().equals(find.getName())){
                return find.getValue();
            }
            current = current.getNext();
        }
        return null;
    }

    public Link find(String searchableName, int searchableAge){
        Link find = new Link(searchableName, searchableAge);
        Link current = first;
        while(current != null){
            if(current.getName().equals(find.getName()) && current.getAge() == find.getAge()){
                return find.getValue();
            }
            current = current.getNext();
        }
        return null;
    }

    @Override
    public Iterator<T> iterator() {
        return new MadIter(this);
    }
}
