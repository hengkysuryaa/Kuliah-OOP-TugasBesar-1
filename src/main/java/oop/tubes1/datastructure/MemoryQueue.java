package oop.tubes1.datastructure;

import java.util.ArrayDeque;

/**
 * MemoryQueue
 */
public class MemoryQueue<T> extends ArrayDeque<T> {

    private static final long serialVersionUID = 2096864553581918219L;

    public void store(T value) {
        add(value);
    }

    public T recall() {
        return remove();
    }

    public void clear() {
        super.clear();
    }

}