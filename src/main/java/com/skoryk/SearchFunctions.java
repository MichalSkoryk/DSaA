package com.skoryk;

// Name the class as the same you want to test
// Then go to tests folder find tests for your class
// and override import to be to this class
public class SearchFunctions {
    public static int binarySearch(int[] arr, int n){
        int right = arr.length - 1;
        int left = 0;
        int mid;

        while(right >= left){
            mid = (right + left) / 2;
            if(arr[mid] == n) return mid;
            if(arr[mid] > n)
                right = mid - 1;
            else left = mid + 1;
        }
        return -1;
    }
}
