package com.junyeongha;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

class ArrayQueueTest {

    private Queue<Integer> arrayQueue;

    @BeforeEach
    void setUp() {
        // Initially start with a default or empty queue
        arrayQueue = new ArrayQueue<>(10);
    }

    @Test
    void addAndSize() {
        assertEquals(0, arrayQueue.size(), "Queue should be empty initially");
        arrayQueue.add(1);
        assertEquals(1, arrayQueue.size(), "Queue should have one element after add");
        arrayQueue.add(2);
        assertEquals(2, arrayQueue.size(), "Queue should have two elements after second add");
    }

    @Test
    void element() {
        assertThrows(NoSuchElementException.class, arrayQueue::element,
                "Calling element on an empty queue should throw NoSuchElementException");

        arrayQueue.add(1);
        int frontElement = arrayQueue.element();
        assertEquals(1, frontElement, "The element retrieved should be the first one added");
        assertEquals(1, arrayQueue.size(), "Queue size should not change after calling element()");
    }

    @Test
    void isEmpty() {
        assertTrue(arrayQueue.isEmpty(), "Queue should be empty initially");
        arrayQueue.add(1);
        assertFalse(arrayQueue.isEmpty(), "Queue should not be empty after adding elements");
    }

    @Test
    void remove() {
        assertThrows(NoSuchElementException.class, arrayQueue::remove,
                "Calling remove on an empty queue should throw NoSuchElementException");

        arrayQueue.add(1);
        arrayQueue.add(2);
        assertEquals(1, arrayQueue.remove(), "The first element removed should be the first one added");
        assertEquals(1, arrayQueue.size(), "Queue size should decrease by one after remove");
        assertEquals(2, arrayQueue.remove(), "The next element removed should be the second one added");
        assertTrue(arrayQueue.isEmpty(), "Queue should be empty after removing all elements");
    }

    @Test
    void size() {
        assertEquals(0, arrayQueue.size(), "Initial size of the queue should be 0");
        arrayQueue.add(1);
        arrayQueue.add(2);
        assertEquals(2, arrayQueue.size(), "Size should reflect number of elements added");
        arrayQueue.remove();
        assertEquals(1, arrayQueue.size(), "Size should decrease after remove");
        arrayQueue.remove();
        assertEquals(0, arrayQueue.size(), "Size should be 0 after removing all elements");
    }
}