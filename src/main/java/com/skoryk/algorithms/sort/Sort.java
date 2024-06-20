package com.skoryk.algorithms.sort;

import java.util.Arrays;

public class Sort {

    /**
     * complexity: O(n^2)
     * space: O(n) where n is length of the array
     * Makes comparisons for the numbers in the array, making the largest
     * value flows upwards like the bubble
     *
     * @param arr to sort
     */
    public static void bubbleSort(int[] arr){
        for(int i = 0; i < arr.length; i++)
            for(int j = 0; j < arr.length - i - 1; j++)
                if(arr[j] > arr[j + 1]){
                    int temp = arr[j + 1];
                    arr[j + 1] = arr[j];
                    arr[j] = temp;
                }
    }
    /**
     * complexity: O(n^2)
     * space: O(n) where n is length of the array
     * Compares the numbers in array looking for the largest number
     * At the end of iteration swaps the largest number to the last possible index
     *
     * @param arr to sort
     */
    public static void selectionSort(int[] arr){
        int index;


        for(int i = 0; i < arr.length - 1; i++){
            index = i;
            for(int j = i + 1; j < arr.length; j++)
                if(arr[j] < arr[index])
                    index = j;

            int temp = arr[i];
            arr[i] = arr[index];
            arr[index] = temp;
        }
    }
    /**
     * complexity: O(n^2)
     * space: O(n) where n is length of the array
     * To sort the array we copy the value and we move it on the first position.
     * We start from the second position, comparing the value with the sorted part
     * of the array
     *
     * Perfect for sorted arrays
     *
     * @param arr to sort
     */
    public static void insertionSort(int[] arr){
        for(int i = 1; i < arr.length; i++){
            int key = arr[i];
            int j = i - 1;
            while (j >= 0 && arr[j] > key){
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = key;
        }
    }
    /**
     * complexity: O(n^2) for the worst, O(n log(n)) for the rest
     * space: O(n) where n is length of the array
     *
     * Divide and conquer
     * We find the pivot (hopefully the number thats in the right place,
     * consider finding place for it using another function)
     * We compare it with the rest of the array and swap it with the number <> depending on search
     * We perform this operation on the rest of the array using recursion
     * At the end we 'merge' the values into one array
     *
     * @param arr to sort
     * @param low the most left index of array
     * @param high the most right index of array
     */
    public static void quickSort(int[] arr, int low, int high){
        if(low < high){
            int pi = partition(arr, low, high);

            quickSort(arr, low, pi - 1);
            quickSort(arr, pi + 1, high);
        }
    }

    /**
     * Helper function for quickSort used to find pivot
     * @param arr array to sort
     * @param low the most left index of array
     * @param high the most right index of array
     * @return pivot
     */
    private static int partition(int[] arr, int low, int high){
        int pivot = arr[high];
        int i = low - 1;

        for(int j = low; j < high; j++){
            if(arr[j] < pivot){
                i++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        int temp = arr[i+1];
        arr[i+1] = arr[high];
        arr[high] = temp;

        return i + 1;
    }

    /**
     * complexity: O(n log(n))
     * space: O(n) where n is length of the array
     *
     * Also divide and conquer, we divide the array into single values
     * Than we marge them into one array in sorted order
     *
     * @param arr to sort
     */
    public static void mergeSort(int[] arr, int l, int r){
        if(l < r) {
            int mid = (l + r) / 2;

            mergeSort(arr, l, mid);
            mergeSort(arr, mid + 1, r);

            merge(arr, l, mid, r);
        }
    }

    private  static void merge(int[] arr, int l, int mid, int r){
        int n1 = mid - l + 1;
        int n2 = r - mid;

        int[] lArr = new int[n1];
        int[] rArr = new int[n2];

        // Populate arrays
        System.arraycopy(arr, l, lArr, 0, n1);
        for(int x=0;x<n2;x++){
            rArr[x] = arr[mid+x+1];
        }

        //Merge the
        int i =0 ;
        int j = 0;
        int k = l;

        while (i<n1 && j < n2){
            if(lArr[i] < rArr[j]){
                arr[k] = lArr[i];
                i++;
            } else {
                arr[k] = rArr[j];
                j++;
            }
            k++;
        }

        //For the remaining values in left Array and right Array
        while(i<n1){
            arr[k] = lArr[i];
            i++;
            k++;
        }
        while(j<n2){
            arr[k] = rArr[j];
            j++;
            k++;
        }

    }


}
