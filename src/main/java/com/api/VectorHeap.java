//  @ Hoja de trabajo 8
//  @ File Name : VectorHeap.java
//  @ Date : 27/03/2025
//  Extraido del libro Java Structures de Duane A. Bailey September 2007
//

package com.api;

import java.util.Vector;

/**
 * A priority queue implementation using a binary heap stored in a Vector.
 * 
 * @param <E> The type of elements stored in the heap, which must be comparable.
 */
public class VectorHeap<E extends Comparable<E>> {
    protected Vector<E> data;

    /**
     * Constructs an empty VectorHeap.
     */
    public VectorHeap() {
        data = new Vector<>();
    }

    /**
     * Returns the index of the parent of the given index.
     * 
     * @param i The index of the child.
     * @return The index of the parent.
     */
    private static int parent(int i) {
        return (i - 1) / 2;
    }

    /**
     * Returns the index of the left child of the given index.
     * 
     * @param i The index of the parent.
     * @return The index of the left child.
     */
    private static int left(int i) {
        return 2 * i + 1;
    }

    /**
     * Returns the index of the right child of the given index.
     * 
     * @param i The index of the parent.
     * @return The index of the right child.
     */
    private static int right(int i) {
        return 2 * i + 2;
    }

    /**
     * Moves the element at the given index up the heap to restore the heap property.
     * 
     * @param leaf The index of the element to move up.
     */
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

    /**
     * Moves the element at the root down the heap to restore the heap property.
     * 
     * @param root The index of the root element.
     */
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

    /**
     * Adds a new element to the heap.
     * 
     * @param value The element to add.
     */
    public void add(E value) {
        data.add(value);
        percolateUp(data.size() - 1);
    }

    /**
     * Removes and returns the smallest element from the heap.
     * 
     * @return The smallest element, or null if the heap is empty.
     */
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

    /**
     * Checks if the heap is empty.
     * 
     * @return True if the heap is empty, false otherwise.
     */
    public boolean isEmpty() {
        return data.isEmpty();
    }
}
