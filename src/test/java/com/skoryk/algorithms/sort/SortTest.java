package com.skoryk.algorithms.sort;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import static com.skoryk.algorithms.sort.Sort.*;
import static org.junit.jupiter.api.Assertions.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class SortTest {

    @Test
    void bubbleSortTest(){
        int[] arr = {4, 3, 1, 90, 23};
        int[] sortedArr = {1, 3, 4, 23, 90};
        bubbleSort(arr);
        assertArrayEquals(sortedArr, arr);
    }

    @Test
    void selectionSortTest(){
        int[] arr = {4, 45, 1, 90, 23};
        int[] sortedArr = {1, 4, 23, 45, 90};
        selectionSort(arr);
        assertArrayEquals(sortedArr, arr);
    }

    @Test
    void insertionSortTest(){
        int[] arr = {4, 45, 1, 90, 23};
        int[] sortedArr = {1, 4, 23, 45, 90};
        insertionSort(arr);
        assertArrayEquals(sortedArr, arr);
    }

    @Test
    void quickSortTest(){
        int[] arr = {4, 45, 1, 90, 23};
        int[] sortedArr = {1, 4, 23, 45, 90};
        quickSort(arr, 0, arr.length - 1);
        assertArrayEquals(sortedArr, arr);
    }

    @Test
    void mergeSortTest(){
        int[] arr = {4, 45, 1, 90, 23};
        int[] sortedArr = {1, 4, 23, 45, 90};
        mergeSort(arr, 0, arr.length - 1);
        assertArrayEquals(sortedArr, arr);
    }

}