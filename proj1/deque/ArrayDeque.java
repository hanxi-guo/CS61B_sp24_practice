package deque;


import org.apache.commons.collections.iterators.ArrayListIterator;


import java.util.Iterator;
import java.util.NoSuchElementException;

public class ArrayDeque<T> {
    private T[] array;
    private int size;
    private int nextFirst;
    private int nextLast;
    private final int InitSize = 8;
    private static final double MIN_USAGE_RATIO = 0.25;


    public ArrayDeque() {
        this.array =  (T []) new Object[InitSize];
        this.size = 0;
        this.nextFirst = 0;
        this.nextLast = 1;
    }

    private void resize(int capacity) {
        T[] a = (T[]) new Object[capacity];
        System.arraycopy(array, 0, a, 0, size);
        array = a;
    }

    public void addFirst(T item){
        if (size == array.length){
            size = size*2;
            resize(size);
        }
        array[nextFirst] = item;
        nextFirst = (nextFirst - 1 + size) % size;
        size ++;
    }
    public void addLast(T item){
        if (size == array.length){
            size = size*2;
            resize(size);
        }
        array[nextLast] = item;
        nextLast = (nextLast + 1) % size;
        size ++;
    }

    public boolean isEmpty(){
        return size() == 0;
    }

    public int size(){
        return size;
    }

    public void printDeque(){
        for (T t : array) {
            System.out.print(t + " ");
        }
        System.out.println();
    }

    public T removeFirst(){
        if (size == 0){
            return null;
        }
        int index = (nextFirst + 1 ) % size;
        T t = array[index];
        array[index] = null;
        nextFirst = index;
        size --;

        // downsize the array when usage ratio is too small
        if (size > 0 && size < array.length * MIN_USAGE_RATIO) {
            resize(array.length / 2);
        }
        return t;
    }

    public T removeLast(){
        if (size == 0){
            return null;
        }
        int index = (nextLast - 1 + size) % size;
        T t = array[index];
        array[index] = null;
        nextLast = index;
        size -- ;

        // downsize the array when usage ratio is too small
        if (size > 0 && size < array.length * MIN_USAGE_RATIO) {
            resize(array.length / 2);
        }
        return t;
    }

    public T get(int index){
        if (index >= size || index < 0){
            return null;
        }
        return array[index];
    }

    public Iterator<T> iterator(){
        return new ArrayListIterator();
    }

    private class ArrayListIterator implements Iterator<T> {
        private int index ;
        public ArrayListIterator(){index = 0;}

        @Override
        public boolean hasNext() {
            return index < size;
        }

        @Override
        public T next() {
           if (hasNext()){
               return array[index++];
           }
           throw new NoSuchElementException();
        }
    }

    public boolean equals(Object o){
        return o instanceof ArrayDeque && o.equals(this);
    }

}
