package com.junyeongha;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.EmptyStackException;

import static org.junit.jupiter.api.Assertions.*;

public class LinkedQueueTest {

    Queue<Integer> queue;

    @BeforeEach
    void setup() {
        queue = new LinkedQueue<>();
    }

    @Test
    void add() {
        assertTrue(queue.isEmpty());
        queue.add(1);
        assertEquals(1, queue.size());
        queue.add(2);
        assertEquals(2, queue.size());
    }

    @Test
    void testElement() {
        assertThrows(EmptyStackException.class, queue::element);
        queue.add(1);
        assertEquals(Integer.valueOf(1), queue.element());
        queue.add(2);
        assertEquals(Integer.valueOf(1), queue.element());
    }

    @Test
    void testIsEmpty() {
        assertTrue(queue.isEmpty());
        queue.add(1);
        assertFalse(queue.isEmpty());
    }

    @Test
    void testRemove() {
        assertThrows(EmptyStackException.class, queue::remove);

        queue.add(1);
        queue.add(2);
        assertEquals(Integer.valueOf(1), queue.remove());
        assertEquals(1, queue.size());
        assertEquals(Integer.valueOf(2), queue.remove());
        assertTrue(queue.isEmpty());
    }

    @Test
    void testSize() {
        assertEquals(0, queue.size());
        queue.add(1);
        assertEquals(1, queue.size());
        queue.add(2);
        assertEquals(2, queue.size());
        queue.remove();
        assertEquals(1, queue.size());
        queue.remove();
        assertEquals(0, queue.size());
    }
}