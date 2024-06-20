package com.skoryk.data.structures.LinkedList;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import static org.junit.jupiter.api.Assertions.*;


@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class LinkedListTest {

    LinkedList linkedList;

    @BeforeEach
    void beforeEach(){
        linkedList = new LinkedList();
    }

    @Test
    void isEmptyTrue() {
        assertTrue(linkedList.isEmpty());
    }

    @Test
    void isEmptyFalse() {
        linkedList.append(5);
        assertFalse(linkedList.isEmpty());
    }

    @Test
    void insert() {
        linkedList.append(4);
        assertEquals(linkedList.head.data, 4);
    }

    @Test
    void toStringListWithValues(){
        linkedList.append(43);
        linkedList.append(3);
        linkedList.append(4);

        assertEquals("[43, 3, 4]", linkedList.toString());
    }

    @Test
    void toStringListWithValue(){
        linkedList.append(43);
        assertEquals( "[43]", linkedList.toString());
    }

    @Test
    void toStringEmptyList(){
        assertEquals("[]", linkedList.toString());
    }

    @Test
    void shiftToEmptyList(){
        linkedList.shift(4);
        assertEquals(4, linkedList.head.data);
    }

    @Test
    void shiftToListWithOneElement(){
        linkedList.append(34);
        linkedList.shift(4);
        assertEquals(4, linkedList.head.data);
    }

    @Test
    void shiftToListWithValues(){
        linkedList.append(34);
        linkedList.append(3);
        linkedList.shift(4);
        assertEquals("[4, 34, 3]", linkedList.toString());
    }

    @Test
    void insertAtTheStartInListWithElements(){
        linkedList.append(34);
        linkedList.insert(3, 0);
        assertEquals("[3, 34]", linkedList.toString());
    }

    @Test
    void insertInTheMiddleInListWithElements(){
        linkedList.append(34);
        linkedList.append(4);
        linkedList.insert(3, 1);
        assertEquals("[34, 3, 4]", linkedList.toString());
    }

    @Test
    void insertAtTheEndInListWithElements(){
        linkedList.append(34);
        linkedList.append(4);
        linkedList.insert(3, 2);
        assertEquals("[34, 4, 3]", linkedList.toString());
    }

    @Test
    void insertInListWithoutElements(){
        linkedList.insert(3, 0);
        assertEquals("[3]", linkedList.toString());
    }

    @Test
    void insertInListWithoutElementsOutOfRange(){
        linkedList.insert(3, 32);
        assertEquals("[3]", linkedList.toString());
    }

    @Test
    void insertInListWithElementsOutOfRange(){
        linkedList.append(34);
        linkedList.append(4);
        assertThrows(NullPointerException.class, () -> linkedList.insert(3, 34));
    }

    @Test
    void deleteAtTheStartInListWithElements(){
        linkedList.append(34);
        linkedList.delete(0);
        assertEquals("[]", linkedList.toString());
    }

    @Test
    void deleteInTheMiddleInListWithElements(){
        linkedList.append(34);
        linkedList.append(4);
        linkedList.append(3);
        linkedList.delete(1);
        assertEquals("[34, 3]", linkedList.toString());
    }

    @Test
    void deleteAtTheEndInListWithElements(){
        linkedList.append(34);
        linkedList.append(4);
        linkedList.append(3);
        linkedList.delete(2);
        assertEquals("[34, 4]", linkedList.toString());
    }

    @Test
    void deleteInListWithoutElements(){
        linkedList.delete(0);
        assertEquals("[]", linkedList.toString());
    }

    @Test
    void deleteInListWithoutElementsOutOfRange(){
        linkedList.delete(32);
        assertEquals("[]", linkedList.toString());
    }

    @Test
    void deleteInListWithElementsOutOfRange(){
        linkedList.append(34);
        linkedList.append(4);
        assertThrows(NullPointerException.class, () -> linkedList.delete( 34));
    }

    @AfterEach
    void afterEach(){
        linkedList = null;
    }
}