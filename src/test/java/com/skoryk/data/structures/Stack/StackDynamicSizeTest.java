package com.skoryk.data.structures.Stack;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import static org.junit.jupiter.api.Assertions.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class StackDynamicSizeTest {

    StackDynamicSize stack;
    @BeforeEach
    void beforeEach(){
        stack = new StackDynamicSize();
    }

    @Test
    void getCapacityTest(){
        assertEquals(2, stack.getCapacity());
    }

    @Test
    void pushToEmptyStack() {
        stack.push(3);
        assertEquals("[3]", stack.toString());
    }


    @Test
    void pushToStackWithOneElement() {
        stack.push(3);
        stack.push(4);
        assertEquals("[3, 4]", stack.toString());
    }

    @Test
    void pushToStackToResize() {
        stack.push(3);
        stack.push(4);
        stack.push(43);
        stack.push(5);
        stack.push(6);
        stack.push(2);
        assertEquals("[3, 4, 43, 5, 6, 2]", stack.toString());
    }

    @Test
    void popOnEmptyStack() {
        assertNull(stack.pop());
    }

    @Test
    void popOnStackWithOneElement() {
        stack.push(3);
        assertEquals(3, stack.pop());
    }

    @Test
    void popOnStackWithMultipleElements() {
        stack.push(3);
        stack.push(4);
        stack.push(43);
        assertEquals(43, stack.pop());
    }

    @Test
    void popOnStackWithMultipleElementsToShrink() {
        stack.push(3);
        stack.push(4);
        stack.push(42);
        stack.push(12);
        stack.push(34);
        stack.pop();
        stack.pop();

        assertEquals(4, stack.getCapacity());
    }

    @Test
    void peekOnEmptyStack() {
        assertNull(stack.peek());
    }

    @Test
    void peekOnStackWithElements() {
        stack.push(3);
        stack.push(4);
        assertEquals(4, stack.peek());
    }

    @Test
    void peekOnStackWithOneElement() {
        stack.push(3);
        assertEquals(3, stack.peek());
    }

    @Test
    void sizeOfEmptyStack() {
        assertEquals(0, stack.size());
    }

    @Test
    void sizeOfStackWithElements() {
        stack.push(3);
        stack.push(4);
        stack.push(43);
        assertEquals(3, stack.size());
    }

    @Test
    void sizeOfStackAfterPopElements() {
        stack.push(3);
        stack.push(34);
        stack.pop();
        assertEquals(1, stack.size());
    }

    @Test
    void isEmptyTrue() {
        assertTrue(stack.isEmpty());
    }

    @Test
    void isEmptyFalse() {
        stack.push(3);
        assertFalse(stack.isEmpty());
    }

    @Test
    void testToStringOnEmptyStack() {
        assertEquals("[]", stack.toString());
    }

    @Test
    void testToStringOnStackWithOneElement() {
        stack.push(3);
        assertEquals("[3]", stack.toString());
    }
    @Test
    void testToStringOnStackWithMultipleElements() {
        stack.push(3);
        stack.push(4);
        stack.push(43);
        assertEquals("[3, 4, 43]", stack.toString());
    }

}