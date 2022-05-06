package com.devdutt.dsa;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
/*

Find subarray with given sum (Handles Negative Numbers)
 Given an unsorted array of integers, find a subarray that adds to a given number. If there is more than one subarray with the sum of the given number, print any of them.

Example:
        Input: arr[] = {1, 4, 20, 3, 10, 5}, sum = 33
        Output: Sum found between indexes 2 and 4
        Explanation: Sum of elements between indices
        2 and 4 is 20 + 3 + 10 = 33

        Input: arr[] = {10, 2, -2, -20, 10}, sum = -10
        Output: Sum found between indexes 0 to 3
        Explanation: Sum of elements between indices
        0 and 3 is 10 + 2 - 2 - 20 = -10

        Input: arr[] = {-10, 0, 2, -2, -20, 10}, sum = 20
        Output: No subarray with given sum exists
        Explanation: There is no subarray with the given sum
        Approach: The idea is to store the sum of elements of every prefix of the array in a hashmap, i.e, every index stores the sum of elements
        up to that index hashmap. So to check if there is a subarray with a sum equal to s, check for every index i, and sum up to that index as x.
        If there is a prefix with a sum equal to x – s, then the subarray with the given sum is found.

        Algorithm:
        ----------
        1.Create a Hashmap (hm) to store a key-value pair, i.e, key = prefix sum and value = its index, and a variable to store the current sum
        (sum = 0) and the sum of the subarray as s
        2.Traverse through the array from start to end.
        3.For every element update the sum, i.e sum = sum + array[i]
        4.If the sum is equal to s then print that the subarray with the given sum is from 0 to i
        5.If there is any key in the HashMap which is equal to sum – s then print that the subarray with the given sum is from hm[sum – s] to i
        6.Put the sum and index in the hashmap as a key-value pair.

*/
public class SubArray_With_Sum {

    private static void subArraySum(int[] arr1, int n, int sum) {
        int currSum = 0;
        int start = 0;
        int end = -1;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            currSum += arr1[i];
            if ((currSum - sum) == 0) {
                end = i;
                break;
            }
            if (map.containsKey((currSum - sum))) {
                start = map.get((currSum - sum)) + 1;
                end = i;
                break;
            }//if
            map.put(currSum, i);
        }//for
        if (end == -1) {
            System.out.println("Sum not found");
        } else {
            System.out.println(start + "------" + end);
        }//else
    }//method

    public static void main(String[] args) {
        int[] arr1 = {10, 15, -5, 15, -10, 5};
        int sum1 = 5;
        System.out.println("Input :- " + Arrays.toString(arr1));
        subArraySum(arr1, arr1.length, sum1);
        System.out.println("=====================================");
        int[] arr2 = {10, 15, -5, 15, -10, 5};
        int sum2 = 20;
        System.out.println("Input :- " + Arrays.toString(arr1));
        subArraySum(arr1, arr2.length, sum2);
    }//main
}//class
