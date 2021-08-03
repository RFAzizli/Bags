package Bags.ArrayBag;
import Bags.*;
public class ArrayBag implements Bag{
    private Object[] items;
    private int numItems;
    private int maxSize;

    /*
        ArrayBag()- default constructor for ArrayBag, initializes an empty ArrayBag with default size
     */
    public ArrayBag(){
        //Default size for the bag - 50
        this.maxSize=50;
        this.numItems=0;
        this.items=new Object[50];
    }
    /*
        ArrayBag(int size) - initializes an empty ArrayBag with specific size
     */
    public ArrayBag(int size){
        this.maxSize=size;
        this.numItems=0;
        this.items=new Object[size];
    }
    /*
        numItems() - returns the number of items in the bag
     */
    public int numItems(){
        return this.numItems;
    }
    /*
        add(Object o) - wrapper method for addItem()
     */
    public boolean add(Object o){
        return this.addItem(o);
    }
    /*
        addItem(Object o) - adds a new Object o in the ArrayBag, if bag is full, returns false, otherwise true
     */
    private boolean addItem(Object o){
        if(o==null){
            throw new IllegalArgumentException();
        }
        if(this.isFull()){
            return false;
        }
        this.items[numItems]=o;
        this.numItems++;
        return true;
    }
    /*
        isEmpty() - checks if the bag is empty
     */
    public boolean isEmpty(){
        return this.numItems==0;
    }
    /*
        isFull() - checks if the ArrayBag is full
     */
    public boolean isFull(){
        return this.numItems==this.maxSize;
    }
    /*
        remove(Object o) - wrapper method for removeItem()
     */
    public boolean remove(Object o){
        return this.removeItem(o);
    }
    /*
        removes a specific Object from the ArrayBag, on success returns true, otherwise false
     */
    private boolean removeItem(Object o){
        if(o==null){
            throw new IllegalArgumentException();
        }
        Object removed;
        for(int i=0;i<this.numItems;i++){
            if(this.items[i].equals(o)){
                // shift items if needed
                for(int j=i;j<this.numItems-1;j++){
                    this.items[j]=this.items[j+1];
                }
                this.numItems--;
                return true;
            }
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
        containsItem(Object o) - returns true if the ArrayBag has a specific Object o inside, otherwise returns false
     */
    private boolean containsItem(Object o){
        for(Object item:items){
            if(item.equals(o)){
                return true;
            }
        }
        return false;
    }
    /*
        resize(int newSize) - resizes the ArrayBag, if the newSize is less than number of items, returns false, otherwise true
     */
    public boolean resize(int newSize){
        if(newSize<0){
            throw new IllegalArgumentException();
        }
        if(newSize<this.numItems){
            return false;
        }
        Object[] newArray=new Object[newSize];
        for(int i=0;i<this.numItems;i++){
            newArray[i]=this.items[i];
        }
        this.items=newArray;
        this.maxSize=newSize;
        return true;
    }
    /*
        grab() - wrapper method for grabItem()
     */
    public Object grab(){
        return this.grabItem();
    }
    /*
        returns a random object from the bag
     */
    private Object grabItem(){
        if(this.isEmpty()){
            throw new IllegalStateException("The Bag is empty");
        }
        int rand=(int)(Math.random()*numItems);
        return this.items[rand];
    }
    /*
        toArray() - returns an array that contains the items from the ArrayBag
     */
    public Object[] toArray(){
        Object[] copy=new Object[this.numItems];
        for(int i=0;i<this.numItems;i++){
            copy[i]=this.items[i];
        }
        return copy;
    }
    /*
        toString() - overridden method from Object class, returns a String that represents ArrayBag object
     */
    public String toString(){
        String result="{";
        for(int i=0;i<this.numItems;i++){
            result+=items[i];
            if(i==this.numItems-1){
                break;
            }
            result+=", ";
        }
        result+="}";
        return result;
    }
}
