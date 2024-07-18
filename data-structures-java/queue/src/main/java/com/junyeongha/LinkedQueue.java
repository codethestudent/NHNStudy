package com.junyeongha;

import java.util.EmptyStackException;

public class LinkedQueue<E> implements Queue<E> {
    // TODO : node 클래스를 활용하여 연결된 큐를 구현하세요.
    private Node<E> head = new Node<>();
    private int size;

    @Override
    public void add(E element) {
        head.prev = head.prev.next = new Node<>(element, head, head.prev);
        ++size;
    }

    @Override
    public E element() {
        if (size == 0) {
            throw new EmptyStackException();
        }
        return head.next.element;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public E remove() {
        if (size <= 0) {
            throw new EmptyStackException();
        }
        Node<E> node = head.next;
        head.next = head.next.next;
        head.next.prev = head;
        --size;
        return node.element;
    }

    @Override
    public int size() {
        return this.size;
    }

    private class Node<E> {
        private E element;
        private Node<E> next;
        private Node<E> prev;

        Node() {
            this.prev = this.next = this;
        }

        Node(E element, Node<E> next, Node<E> prev) {
            this.element = element;
            this.next = next;
            this.prev = prev;
        }
    }
}
