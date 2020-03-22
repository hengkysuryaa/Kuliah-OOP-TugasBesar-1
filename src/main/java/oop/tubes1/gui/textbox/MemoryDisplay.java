package oop.tubes1.gui.textbox;

import java.util.ArrayDeque;
import java.util.Queue;

import javax.swing.DefaultListModel;

/**
 * MemoryDisplay
 */
public class MemoryDisplay<T> {

    private Queue<T> queue;
    private DefaultListModel<T> display;

    public MemoryDisplay(DefaultListModel<T> display) {
        this.display = display;
        this.queue = new ArrayDeque<>();
    }

    public void store(T value) {
        queue.add(value);
        refreshDisplay();
    }

    public T recall() {
        T t = queue.poll();
        refreshDisplay();
        return t;
    }

    public void clear() {
        display.clear();
        queue.clear();
    }

    public boolean isEmpty() {
        return queue.isEmpty();
    }

    public T peek() {
        return queue.peek();
    }

    private void refreshDisplay() {
        display.clear();
        for (T t : queue) {
            display.addElement(t);
        }
    }

}