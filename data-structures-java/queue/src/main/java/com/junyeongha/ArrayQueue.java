package com.junyeongha;

import java.util.NoSuchElementException;

public class ArrayQueue<E> implements Queue<E> {
    private E[] elements;
    private int front;
    private int back;
    private static final int initialSize = 4;

    public ArrayQueue() {
        elements = (E[]) new Object[initialSize];
    }

    public ArrayQueue(int capacity) {
        elements = (E[]) new Object[capacity];
    }

    @Override
    public void add(E element) {
        if (size() == elements.length) {
            resize();
        }
        elements[back++] = element;
        if (back >= elements.length - 1) {
            back = 0;
        }
    }

    private void resize() {
        assert size() == elements.length;
        E[] a = (E[]) new Object[elements.length * 2];
        if (front <= back) {
            System.arraycopy(elements, front, a, 0, elements.length - front);
        } else {
            System.arraycopy(elements, front, a, 0, elements.length - front);
            System.arraycopy(elements, 0, a, elements.length - front, back);
        }
        elements = a;
        front = 0;
        back = size();
    }

    @Override
    public E element() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        return elements[front];
    }

    @Override
    public boolean isEmpty() {
        return size() == 0;
    }

    @Override
    public E remove() {
        if (size() == 0) {
            throw new NoSuchElementException();
        }
        E element = elements[front];
        elements[front++] = null;
        if (front == back) {
            front = back = 0;
        }
        if (front >= elements.length) {
            front = 0;
        }
        return element;
    }

    @Override
    public int size() {
        if (front <= back) {
            return back - front;
        } else {
            return back - front + elements.length;
        }
    }
}
