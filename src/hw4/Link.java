package hw4;

public class Link {
    private String name;
    private int age;

    public Link next;

    public Link(String name, int age){
        this.name = name;
        this.age = age;
    }

    public Link(String name){
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public String getName() {
        return name;
    }

    public Link getValue(){
        return this;
    }

    public Link getNext(){
        return next;
    }

    public void display(){
        System.out.println("Name " + this.name + " age " + this.age);
    }
}
