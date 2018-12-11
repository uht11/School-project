/* Uzzul Hussain cs435 9813 mp */

import java.util.Arrays;

public class Heap9813<T> {
    public static final int DEFAULT_SIZE = 32;
    HConstraint9813 cons;
    T[] data;
    int hsize;

    public Heap9813(HConstraint9813<T> constraint) {
        this(constraint, DEFAULT_SIZE);
    }

    public Heap9813(HConstraint9813<T> constraint, int size) {
        this(constraint, (T[])new Object[size], 0);
    }

    private Heap9813(HConstraint9813<T> constraint, T[] heapData, int size) {
        if (constraint == null) {
            throw new IllegalArgumentException();
        }
        
        cons = constraint;
        data = heapData;
        hsize = size;
    }

    public void insert(T item) {
        if (item == null) return;

        /* enlarge size if needed */
        if (hsize >= data.length) {
            data = Arrays.copyOf(data, data.length * 2);
        }

        int itemIndex = hsize++; 
        data[itemIndex] = item;
        
        shiftUp(itemIndex);
    }

    public T extract() {
        if (hsize <= 0) return null;

        T item = data[0];
        data[0] = data[--hsize]; 

        shiftDown(0);

        return item;
    }

    public int size() {
        return hsize;
    }

    private void shiftUp(int i) {
        if (!isPosValid(i) || i == 0) return;

        int parentIndex = (i - 1) / 2;

        boolean parentPosValid = isPosValid(parentIndex);
        boolean parentConsValid = !parentPosValid || cons.isConstraintValid(data[parentIndex], data[i]);

        if (!parentConsValid) {
            swap(parentIndex, i);
            shiftUp(parentIndex);
        }
    }

    private void shiftDown(int i) {
        if (!isPosValid(i)) return;

        int leftIndex = i * 2 + 1;
        int rightIndex = i * 2 + 2;
        
        boolean leftPosValid = isPosValid(leftIndex);
        boolean leftConsValid = !leftPosValid || cons.isConstraintValid(data[i], data[leftIndex]);

        boolean rightPosValid = isPosValid(rightIndex);        
        boolean rightConsValid = !rightPosValid || cons.isConstraintValid(data[i], data[rightIndex]);

        if (leftConsValid && rightConsValid) {
            return;
        } else if (!leftConsValid && !rightConsValid) {
            boolean leftAsParentConsValid = cons.isConstraintValid(data[leftIndex], data[rightIndex]);
            if (leftAsParentConsValid) {
                rightConsValid = true;
            } else {
                leftConsValid = true;
            }
        }

        if (!leftConsValid) {
            swap(i, leftIndex);
            shiftDown(leftIndex);
        } else if (!rightConsValid) {
            swap(i, rightIndex);
            shiftDown(rightIndex);
        }
    }

    private boolean isPosValid(int i) {
        return i >= 0 && i < hsize;
    }

    private void swap(int i, int j) {
        T temp = data[i];
        data[i] = data[j];
        data[j] = temp;
    }
    public static <T> Heap9813<T> fromArray(HConstraint9813<T> constraint, T[] data) {
        if (constraint == null || data == null) {
            throw new IllegalArgumentException();
        }
        return new Heap9813(constraint, data, data.length);
    }
}