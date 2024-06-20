package com.skoryk.algorithms.search;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import org.junit.jupiter.api.TestInstance;

import static com.skoryk.SearchFunctions.binarySearch;
import static com.skoryk.algorithms.search.SearchFunctions.linearSearch;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class TestSearchFunctions {
    @Test
    void linearSearchFindMiddle(){
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8};
        int target = 3;
        Assertions.assertEquals(linearSearch(arr, target), 2);
    }

    @Test
    void linearSearchValueNotInArray(){
        int[] arr = {1, 2, 3, 4, 5};
        int target = 0;
        Assertions.assertEquals(linearSearch(arr, target), -1);
    }

    @Test
    void linearSearchEmptyArr(){
        int[] arr = {};
        int target = 0;
        Assertions.assertEquals(linearSearch(arr, target), -1);
    }

    @Test
    void binarySearchValueInTheMiddle(){
        int[] arr = {1, 2, 3, 4, 5, 6, 7};
        int target = 4;
        Assertions.assertEquals(binarySearch(arr, target), 3);
    }

    @Test
    void binarySearchValueAtTheEnd(){
        int[] arr = {1, 2, 3, 4, 5, 6, 7};
        int target = 7;
        Assertions.assertEquals(binarySearch(arr, target), 6);
    }

    @Test
    void binarySearchValueAtTheStart(){
        int[] arr = {1, 2, 3, 4, 5, 6, 7};
        int target = 1;
        Assertions.assertEquals(binarySearch(arr, target), 0);
    }

    @Test
    void binarySearchEmptyArr(){
        int[] arr = {};
        int target = 4;
        Assertions.assertEquals(binarySearch(arr, target), -1);
    }

    @Test
    void binarySearchValueNotInTheArray(){
        int[] arr = {1, 2, 3, 4, 5, 6, 7};
        int target = 9;
        Assertions.assertEquals(binarySearch(arr, target), -1);
    }
}
