package Bags;

public interface Bag {
    /*
        add(Object item) - adds  an Object item into the bag, returns true on success, otherwise false.
     */
    boolean add(Object item);
    /*
        remove(Object item) - removes an Object item from the bag, returns true if such an item was removed, otherwise false
     */
    boolean remove(Object item);

    /*
        contains(Object item) - checks if the bag contains Object item
     */
    boolean contains(Object item);

    /*
        numItems() - returns the number of items in the bag
     */
    int numItems();

    /*
        grab() - returns an Object that was "grabbed" from the bag, i.e. random item from the bag
     */
    Object grab();

    /*
        toArray() - returns an array containing the items from the bag
     */
    Object[] toArray();
    /*
        isEmpty() - returns true if the bag is empty
     */
    boolean isEmpty();
}
