package deque;


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
        T[] newArray = (T[]) new Object[capacity];

        // Ensure some space at both ends since the min usage ratio is 25%
        // newFirstPos is where the new array start (MUST HAVE!!!)
        int newFirstPos = capacity / 4;


        System.arraycopy(array, 0, newArray, 0, size);

        array = newArray;
        nextFirst = Math.abs(newFirstPos - 1) % array.length;
        nextLast = Math.abs(nextFirst + size + 1) % array.length;
    }

    public void addFirst(T item){
        if (isEmpty()){
            array[nextFirst]  = item;
            nextFirst = (nextFirst - 1 + array.length) % array.length;
            size ++;
            return;
        }
        if (size == array.length){
            resize(size*2);
        }
        array[nextFirst] = item;
        nextFirst = (nextFirst - 1 + array.length) % array.length;
        size ++;
    }
    public void addLast(T item){
        if (isEmpty()){

            array[nextLast] = item;
            nextLast = (nextLast + 1) % array.length;
            size ++;
            return;
        }
        if (size == array.length){
            resize(size*2);
        }
        array[nextLast] = item;
        nextLast = (nextLast + 1) % array.length;
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
        int index = (nextFirst + 1 ) % array.length;
        T t = array[index];
        array[index] = null;
        nextFirst = index;
        size --;

        // downsize the array when usage ratio is too small
        if (size > 0 && size < array.length * MIN_USAGE_RATIO) {
            resize(array.length/2);
        }
        return t;
    }

    public T removeLast(){
        if (size == 0){
            return null;
        }
        int index = (nextLast - 1 + array.length) % array.length;
        T t = array[index];
        array[index] = null;
        nextLast = index;
        size -- ;

        // downsize the array when usage ratio is too small
        if (size > 0 && size < array.length * MIN_USAGE_RATIO) {
            resize(size);
        }
        return t;
    }

    public T get(int index){
        if (index > size - 1 || index < 0){
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

    @Override
    public boolean equals(Object o){
        // Reference equality check, directly return true
        if (this == o) return true;
        if (o instanceof ArrayDeque){
            // type transferring
            ArrayDeque<?> other = (ArrayDeque<?>) o;
            if (size != other.size) return false;
            for (int i = 0; i <= this.size; i++) {
                T thisElement = this.array[i];
                Object otherElement = other.array[i];
                if (thisElement != otherElement){
                    return false;
                }
            }
            return true;
        }
        return false;
    }
}
