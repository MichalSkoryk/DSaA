package com.skoryk.algorithms.search;

public abstract class SearchFunctions{
    //Class that has different searches

    /**
     * complexity: O(n)
     * space: O(n) where n is the length of the array
     * goes through every number in array checking if it matches the number
     *
     * @param arr to search through
     * @param n number to search for
     * @return index of the number n
     */
    public static int linearSearch(int[] arr, int n){
        for(int i = 0; i < arr.length; i++)
            if(arr[i] == n)
                return i;
        return -1;
    }

    /**
     * complexity: O(log(n))
     * space: O(n) where n is the length of the array
     * Works only on sorted arrays!
     *
     * Function finds the middle element, compares it to the looked for number
     * and changes the range accordingly
     * @param arr to search through
     * @param n number to search for
     * @return index of the number n
     */
    public static int binarySearch(int[] arr, int n){
        int right = arr.length - 1;
        int left = 0;
        int mid;
        while (right >= left){
            mid = (right + left) / 2;
            if(arr[mid] == n) return mid;
            if(arr[mid] > n) right = mid - 1;
            else left = mid + 1;
        }
        return -1;
    }
}
