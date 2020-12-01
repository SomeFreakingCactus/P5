package covidvis;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * This is a basic implementation of a linked list
 * 
 * @author Noah Coyle (noahcoyle11)
 * @version 11/14/2020
 * @param <E>
 *            The data type contained.
 */
public class SinglyLinkedList<E> implements LList<E> {

    private Node<E> head;
    private int size;

    /**
     * Creates a new SinglyLinkedList object
     */
    public SinglyLinkedList() {
        this.head = null;
        this.size = 0;
    }


    /**
     * Gets the number of elements in the list
     * 
     * @return the number of elements
     */
    @Override
    public int size() {
        return this.size;
    }


    /**
     * Adds the object to the position in the list
     * 
     * @precondition obj cannot be null
     * @param index
     *            where to add the object
     * @param obj
     *            the object to add
     * @throws IndexOutOfBoundsException
     *             if index is less than zero
     *             or greater than size
     * @throws IllegalArgumentException
     *             if obj is null
     */
    @Override
    public void add(int index, E obj) {
        if (obj != null) {
            if ((index < 0) || (index > size())) {
                throw new IndexOutOfBoundsException("Index is out of bounds");
            }
            if (!this.isEmpty()) {
                Node<E> current = this.head;
                if (index == 0) {
                    Node<E> newNode = new Node<E>(obj);
                    newNode.setNext(this.head);
                    this.head = newNode;
                }
                else {
                    int currentIndex = 0;
                    while (current != null) {
                        if ((currentIndex + 1) == index) {
                            Node<E> nextNext = current.next();
                            Node<E> newNode = new Node<E>(obj);
                            current.setNext(newNode);
                            newNode.setNext(nextNext);

                        }
                        current = current.next();
                        currentIndex++;
                    }
                }
                this.size++;
                return;
            }
            this.head = new Node<E>(obj);
            this.size++;
            return;
        }
        throw new IllegalArgumentException("Object is null");
    }


    /**
     * Adds the object to the end of the list.
     * 
     * @precondition obj cannot be null
     * @param obj
     *            the object to add
     * @throws IllegalArgumentException
     *             if obj is null
     */
    @Override
    public void add(E obj) {
        if (obj != null) {
            Node<E> current = this.head;
            if (!isEmpty()) {
                while (current.next != null) {
                    current = current.next;
                }
                current.setNext(new Node<E>(obj));
                this.size++;
                return;
            }
            this.head = new Node<E>(obj);
            this.size++;
            return;
        }
        throw new IllegalArgumentException("Object is null");
    }


    /**
     * Checks if the list is empty
     * 
     * @return true if the list is empty
     */
    @Override
    public boolean isEmpty() {
        return (size == 0);
    }


    /**
     * Removes the first instance of the given object from the list
     * 
     * @param obj
     *            the object to remove
     * @return true if successful
     */
    @Override
    public boolean remove(E obj) {
        Node<E> current = this.head;
        if ((null != this.head) && (obj.equals(current.data))) {
            this.head = this.head.next;
            this.size--;
            return true;
        }
        while (size() >= 2 && (current.next != null)) {
            if ((obj.equals(current.next.data))) {
                current.setNext(current.next.next);
                this.size--;
                return true;
            }
            current = current.next;
        }
        return false;
    }


    /**
     * Removes the object at the given position
     * 
     * @param index
     *            the position of the object
     * @return true if the removal was successful
     * @throws IndexOutOfBoundsException
     *             if there is no element at the index
     */
    @Override
    public boolean remove(int index) {
        if (index < 0 || this.head == null) {
            throw new IndexOutOfBoundsException("Index is out of bounds");
        }
        else if (index == 0) {
            this.head = this.head.next;
            this.size--;
            return true;
        }
        else {
            Node<E> current = this.head;
            int currentIndex = 0;

            while (current.next != null) {
                if ((currentIndex + 1) == index) {
                    Node<E> newNext = current.next.next;
                    current.setNext(newNext);
                    this.size--;
                    return true;
                }
                current = current.next;
                currentIndex++;
            }
            throw new IndexOutOfBoundsException("Index is out of bounds");
        }
    }


    /**
     * Gets the object at the given position
     * 
     * @param index
     *            where the object is located
     * @return The object at the given position
     * @throws IndexOutOfBoundsException
     *             if no node at the given index
     */
    @Override
    public E get(int index) {
        Node<E> current = this.head;
        int currentIndex = 0;
        E data = null;
        while (current != null) {
            if (currentIndex == index) {
                data = current.data;
            }
            currentIndex++;
            current = current.next;
        }
        if (data == null) {
            throw new IndexOutOfBoundsException("Index exceeds the size.");
        }
        return data;
    }


    /**
     * Checks if the list contains the given object
     * 
     * @param obj
     *            the object to check for
     * @return true if it contains the object
     */
    @Override
    public boolean contains(E obj) {
        Node<E> current = this.head;
        while (current != null) {
            if (obj.equals(current.data)) {
                return true;
            }
            current = current.next;
        }
        return false;
    }


    /**
     * Removes all of the elements from the list
     */
    @Override
    public void clear() {
        if (head != null) {
            head.setNext(null);
            head = null;
            size = 0;
        }
    }


    /**
     * Gets the last time the given object is in the list
     * 
     * @param obj
     *            the object to look for
     * @return the last position of it. -1 If it is not in the list
     */
    @Override
    public int lastIndexOf(E obj) {
        int lastIndex = -1;
        Node<E> current = this.head;
        int currentIndex = 0;
        while (current != null) {
            if (obj.equals(current.data)) {
                lastIndex = currentIndex;
            }
            currentIndex++;
            current = current.next;
        }
        return lastIndex;
    }


    /**
     * String representation of the List
     * 
     * @return the string representation of the List
     */
    @Override
    public String toString() {
        String result = "{";
        Node<E> current = this.head;
        while (current != null) {
            result += "" + current.data;
            current = current.next;
            if (current != null) {
                result += ", ";
            }
        }
        result += "}";
        return result;
    }


    /**
     * Array representation of the List
     * 
     * @return the array representation of the List
     */
    public Object[] toArray() {
        Object[] array = new Object[this.size()];
        Node<E> current = this.head;
        int count = 0;
        while (current != null) {
            array[count] = current.getData();
            current = current.next;
            count++;
        }
        return array;
    }


    /**
     * Returns true if both lists have the exact same contents
     * in the exact same order
     * 
     * @return True or False if the obj equals this
     */
    @Override
    public boolean equals(Object obj) {
        if (obj != this) {
            if (obj != null) {
                if (this.getClass() == obj.getClass()) {
                    @SuppressWarnings("unchecked")
                    SinglyLinkedList<E> other = ((SinglyLinkedList<E>)obj);
                    if (other.size() == this.size()) {
                        Node<E> current = this.head;
                        Node<E> otherCurrent = other.head;
                        while (current != null) {
                            if (!current.getData().equals(otherCurrent
                                .getData())) {
                                return false;
                            }
                            current = current.next();
                            otherCurrent = otherCurrent.next();
                        }
                        return true;
                    }
                }
            }
            return false;
        }
        return true;
    }


    /**
     * Iterator method creates Iterator object
     * 
     * @return new Iterator object
     */
    public Iterator<E> iterator() {
        return new SinglyLinkedListIterator<E>(this);
    }

    /**
     * This represents a iterator in a singly linked list. This node stores data
     * along with having a pointer to the next node in the list
     *
     * @author Noah Coyle noahcoyle11
     * @version 11/14/2020
     * @param <E>
     *            The data type contained.
     */
    private class SinglyLinkedListIterator<A> implements Iterator<E> {
        private SinglyLinkedList<E> list;
        private Node<E> node;
        private int size;

        /**
         * Creates a new SinglyLinkedListIterator
         */
        public SinglyLinkedListIterator(SinglyLinkedList<E> list) {
            this.list = list;
            this.node = null;
            this.size = -1;
        }


        /**
         * Checks if there are more elements in the list
         *
         * @return true if there are more elements in the list
         */
        @Override
        public boolean hasNext() {
            if (this.node == null && this.size == -1) {
                return this.list.head != null;
            }
            return this.node.next != null;
        }


        /**
         * Gets the next value in the list
         * 
         * @return the next value
         * @throws NoSuchElementException
         *             if there are
         *             no nodes left in the list
         */
        @Override
        public E next() {
            if (this.hasNext()) {
                if (this.node == null && this.size == -1) {
                    this.node = this.list.head;
                    this.size++;
                    return this.node.data;
                }
                this.node = this.node.next;
                this.size++;
                return this.node.data;
            }
            else {
                throw new NoSuchElementException();
            }
        }


        /**
         * Removes the last object returned with next() from the list
         * 
         * @throws IllegalStateException
         *             if next has not been called yet
         *             and if the element has already been removed
         */
        @Override
        public void remove() {
            if (this.node == null && this.size == -1) {
                this.node = this.list.head;
                this.size++;
            }
            if (this.node == null) {
                throw new IllegalStateException("Node is null");
            }
            this.node.data = null;
            this.list.remove(this.size);
            this.size--;
        }
    }


    /**
     * This represents a node in a singly linked list. This node stores data
     * along with having a pointer to the next node in the list
     *
     * @author Noah Coyle noahcoyle11
     * @version 11/14/2020
     * @param <D>
     *            The data type contained.
     */
    public static class Node<D> {

        private D data;
        private Node<D> next;

        /**
         * Creates a new node with the given data
         * 
         * @param data
         *            The data given to the node
         */
        public Node(D data) {
            this.data = data;
        }


        /**
         * Sets the node after this node
         * 
         * @param n
         *            The node after this one
         */
        public void setNext(Node<D> n) {
            this.next = n;
        }


        /**
         * Gets the next node
         * 
         * @return the next node
         */
        public Node<D> next() {
            return next;
        }


        /**
         * Gets the data in the node
         * 
         * @return the data in the node
         */
        public D getData() {
            return data;
        }
    }
}
