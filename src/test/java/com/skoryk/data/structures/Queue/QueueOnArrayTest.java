package com.skoryk.data.structures.Queue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import static org.junit.jupiter.api.Assertions.*;
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class QueueOnArrayTest {

    QueueOnArray queue;
    @BeforeEach
    void beforeEach(){
        queue = new QueueOnArray();
    }

    @Test
    void getSize() {
        assertEquals(0, queue.getSize());
    }

    @Test
    void enqueueOnEmptyQueue() {
        queue.enqueue(4);
        assertEquals("[4]", queue.toString());
    }

    @Test
    void enqueueOnQueueWithElements() {
        queue.enqueue(4);
        queue.enqueue(43);
        assertEquals("[4, 43]", queue.toString());
    }

    @Test
    void enqueueOnQueueWithMaximumElements() {
        queue.enqueue(4);
        queue.enqueue(43);
        queue.enqueue(3);
        queue.enqueue(31);
        queue.enqueue(2);
        queue.enqueue(1);
        assertEquals("[4, 43, 3, 31, 2]", queue.toString());
    }

    @Test
    void dequeueOnEmptyQueue() {
        assertNull(queue.dequeue());
    }

    @Test
    void dequeueOnQueueWithOneElement() {
        queue.enqueue(4);
        assertEquals(4, queue.dequeue());
    }

    @Test
    void isEmptyOnEmptyQueue() {
        assertTrue(queue.isEmpty());
    }

    @Test
    void isEmptyOnQueueWithElement() {
        queue.enqueue(4);
        assertFalse(queue.isEmpty());
    }

    @Test
    void isFullOnEmptyQueue() {
        assertFalse(queue.isFull());
    }

    @Test
    void isFullOnQueueWithMaximumElements() {
        queue.enqueue(4);
        queue.enqueue(43);
        queue.enqueue(3);
        queue.enqueue(32);
        queue.enqueue(2);
        assertTrue(queue.isFull());
    }

    @Test
    void checkForArrayCycling(){
        queue.enqueue(4);
        queue.enqueue(42);
        queue.enqueue(12);
        queue.dequeue();
        queue.dequeue();
        queue.enqueue(12);
        queue.enqueue(121);
        queue.dequeue();
        queue.enqueue(32);
        assertEquals("[12, 121, 32]", queue.toString());
    }

    @Test
    void testToStringOnEmptyQueue() {
        assertEquals("[]", queue.toString());
    }

    @Test
    void testToStringOnQueueWithElement() {
        queue.enqueue(4);
        assertEquals("[4]", queue.toString());
    }

    @Test
    void testToStringOnQueueWithElements() {
        queue.enqueue(4);
        queue.enqueue(43);
        queue.enqueue(3);
        assertEquals("[4, 43, 3]", queue.toString());
    }
}