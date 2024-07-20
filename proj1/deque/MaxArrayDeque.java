package deque;

import java.util.Comparator;

//Since a MaxArrayDeque has all of the methods that an ArrayDeque has
//it inherit them from ArayDeque, so it is the subclass of ArrayDeque
public class MaxArrayDeque<T> extends ArrayDeque<T> {
    private final Comparator<T> comparator;

    public MaxArrayDeque(Comparator<T> c){
        this.comparator = c;
    }

    public T max(){
        if (this.isEmpty()) return null;
        T result = this.get(0);
        for (int i = 0 ; i < this.size()-1 ; i++) {
            if (comparator.compare(this.get(i), this.get(i+1)) < 0){
                result = this.get(i+1);
            }
        }
        return result;
    }

    public T max(Comparator<T> c){
        return max(comparator);
    }

    @Override
    public boolean equals(Object o){
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        return ((MaxArrayDeque<?>) o).max() == max();
    }
}
