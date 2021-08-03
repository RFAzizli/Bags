package Bags.LinkedBag;
import Bags.Bag;
public class LinkedBag implements Bag{
    private class Node{
        private Object item;
        private Node next;
        private Node(Object i,Node n){
            this.item=i;
            this.next=n;
        }
    }
    private Node head;
    private Node last;
    private int length;
    /*
        numItems() - returns the number of items in the list
     */
    public int numItems(){
        return this.length;
    }
    /*
        LinkedBag() - constructor that initializes an empty LinkedBag
     */
    public LinkedBag(){
        this.length=0;
        this.head=new Node(null,null); //Dummy head Node
        this.last=this.head;
    }
    /*
        add(Object o) - wrapper method for addItem()
     */
    public boolean add(Object o){
        return this.addItem(o);
    }
    /*
        addItem(Object o) - adds a new Object o in the bag
     */
    private boolean addItem(Object o){
        if(o==null){
            throw new IllegalArgumentException();
        }
        this.last.next=new Node(o,null);
        this.last=this.last.next;
        this.length++;
        return true;
    }
    /*
        remove(Object o) -wrapper method for removeItem()
     */
    public boolean remove(Object o){
        return this.removeItem(o);
    }
    /*
        removeItem(Object o) - removes an Object o from the bag, if successful returns true, otherwise false
     */
    private boolean removeItem(Object o){
        if(o==null){
            throw new IllegalArgumentException();
        }
        Node current=this.head;
        while(current.next!=null){
            if(current.next.item.equals(o)){
                if(current.next==this.last){
                    this.last=current;
                }
                current.next=current.next.next;
                this.length--;
                return true;
            }
            current=current.next;
        }
        return false;
    }
    /*
        contains(Object o) - wrapper method for containsItem()
     */
    public boolean contains(Object o){
        return this.containsItem(o);
    }
    /*
        containsItem(Object o) - checks if the bag has a specific object o
     */
    private boolean containsItem(Object o){
        if(o==null){
            throw new IllegalArgumentException();
        }
        Node current=this.head;
        while(current!=null){
            if(o.equals(current.item)){
                return true;
            }
            current=current.next;
        }
        return false;
    }
    /*
        grab() -wrapper method for grabItem()
     */
    public Object grab(){
        return this.grabItem();
    }
    /*
        grabItem() - returns a random item from the bag
     */
    private Object grabItem(){
        if(this.isEmpty()){
            throw new IllegalArgumentException("The Bag is empty");
        }
        Object[] items=this.toArray();
        int rand=(int)(Math.random()*this.length);
        return items[rand];
    }
    /*
        isEmpty() - checks if the bag is empty
     */
    public boolean isEmpty(){
        return this.length==0;
    }
    /*
        isFull() - checks if the Bag is full
     */
    public boolean isFull(){
        return false;
    }
    /*
        toArray() - returns an array that contains the items from the bag
     */
    public Object[] toArray(){
        Object[] items=new Object[this.length];
        Node current=this.head.next;
        for(int i=0;i<items.length;i++){
            items[i]=current.item;
            current=current.next;
        }
        return items;
    }
    /*
        toString() - overridden method from Object class that returns a String that represents LinkedBag object
     */
    public String toString(){
        String result="{";
        Object[] items=this.toArray();
        for(int i=0;i<items.length;i++){
            result+=items[i];
            if(i==this.length-1){
                break;
            }
            result+=", ";
        }
        result+="}";
        return result;
    }

}
