package deque;


import java.util.Iterator;
import java.util.NoSuchElementException;

public class LinkedListDeque<T> {
    private class Node<Generic> {
        Generic item;
        Node<Generic> previous;
        Node<Generic> next;


        public Node(Generic item) {
            this.item = item;
            this.previous = null;
            this.next = null;
        }
    }

    private Node<T> sentinel = new Node<>(null);
    private Integer size;

    public void addFirst(T item) {
        Node<T> addNode = new Node<>(item);
        addNode.previous = sentinel;
        addNode.next = sentinel.next;

        //ensures that the previous last node’s next reference is updated to point to the new added node
        sentinel.previous.next = addNode;
        sentinel.next = addNode;
        //do not need sentinel.next.previous = addNode; since addNode has been assigned to the sentinel.next

        //update the size of the circular linked list
        size ++;
    }

    //almost same as addFirst because of circular
    public void addLast(T item) {
        Node<T> addNode = new Node<>(item);
        sentinel.previous.next = addNode;
        addNode.next = sentinel;
        addNode.previous = sentinel.previous;

        sentinel.previous = addNode;
        size ++;
    }

    public boolean isEmpty() {
        return (sentinel.next == sentinel.previous);
    }

    public int size() {
        return size;
    }

    public void printDeque() {
        // cannot directly modify the deque when iterate
        Node<T> current = sentinel.next;
        while (current != sentinel) {
            System.out.print(current.item + " ");
            current = current.next;
        }
        System.out.println();
    }

    public T removeFirst() {
        Node<T> firstNode = sentinel.next;
        if (isEmpty()) {
            return null;
        }
        // remove the pointers to that object.
        sentinel.next = firstNode.next;
        sentinel.next.previous = sentinel;
        size --;
        return firstNode.item;
    }

    public T removeLast() {
        Node<T> lastNode = sentinel.previous;
        if (isEmpty()) {
            return null;
        }
        // remove the pointers to that object.
        sentinel.previous = lastNode.previous;
        lastNode.previous.next = sentinel;
        size -- ;
        return lastNode.item;
    }

    public T get(int index){
        if (index < 0 || index >= size) {
            return null;
        }
        Node<T> current = sentinel.next;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        return current.item;
    }


    public Iterator<T> iterator() {
        return new LinkedListIterator();
    }

    private class LinkedListIterator implements Iterator<T> {
        private int FollowIndex;
        private Node<T> current = sentinel.next;

        public LinkedListIterator() {
            FollowIndex = 0;
        }

        @Override
        public boolean hasNext() {
            return FollowIndex < size;
        }

        @Override
        public T next() {
            if (this.hasNext() ){
                T nextItem = current.item;
                FollowIndex ++;
                current = current.next;
                return nextItem;
            }
            throw new NoSuchElementException();
        }
    }

    public boolean equals (Object o) {
        Iterator<T> iteratorList = this.iterator();
        return o instanceof LinkedListDeque && o.equals(this);
    }

    public LinkedListDeque(){
        sentinel.next = sentinel;
        sentinel.previous = sentinel;
        size = 0;
    }

    public T getRecursive(int index){
        if (index < 0 || index >= size) {
            return null;
        }
        Node<T> current = sentinel.next;
        if (index == 0) {
            return current.item;
        }else{
            current = current.next;
            return getRecursive(index - 1);
        }

    }
}


