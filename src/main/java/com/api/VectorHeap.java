package com.api;

import java.util.Vector;

public class VectorHeap<E extends Comparable<E>> {
    protected Vector<E> data;

    public VectorHeap() {
        data = new Vector<>();
    }

    private static int parent(int i) {
        return (i - 1) / 2;
    }

    private static int left(int i) {
        return 2 * i + 1;
    }

    private static int right(int i) {
        return 2 * i + 2;
    }

    private void percolateUp(int leaf) {
        int parent = parent(leaf);
        E value = data.get(leaf);
        while (leaf > 0 && value.compareTo(data.get(parent)) < 0) {
            data.set(leaf, data.get(parent));
            leaf = parent;
            parent = parent(leaf);
        }
        data.set(leaf, value);
    }

    private void pushDownRoot(int root) {
        int heapSize = data.size();
        E value = data.get(root);
        while (root < heapSize) {
            int childpos = left(root);
            if (childpos < heapSize) {
                if (right(root) < heapSize && data.get(childpos + 1).compareTo(data.get(childpos)) < 0) {
                    childpos++;
                }
                if (data.get(childpos).compareTo(value) < 0) {
                    data.set(root, data.get(childpos));
                    root = childpos;
                } else {
                    data.set(root, value);
                    return;
                }
            } else {
                data.set(root, value);
                return;
            }
        }
    }

    public void add(E value) {
        data.add(value);
        percolateUp(data.size() - 1);
    }

    public E remove() {
        if (data.isEmpty()) {
            return null;
        }
        E minVal = data.get(0);
        data.set(0, data.get(data.size() - 1));
        data.remove(data.size() - 1);
        if (!data.isEmpty()) {
            pushDownRoot(0);
        }
        return minVal;
    }

    public boolean isEmpty() {
        return data.isEmpty();
    }
}
