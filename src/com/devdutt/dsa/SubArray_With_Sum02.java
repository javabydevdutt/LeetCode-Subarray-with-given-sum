package com.devdutt.dsa;

import java.util.ArrayList;
import java.util.Arrays;

/*Subarray with given sum
Given an unsorted array A of size N that contains only non-negative integers, find a continuous sub-array
which adds to a given number S.
In case of multiple subarrays, return the subarray which comes first on moving from left to right.
 Expected:- Time Complexity: O(N)
 Expected:-  Auxiliary Space: O(1)
Example 1:
    Input:A[] = {1,2,3,7,5}, N = 5, S = 12
        Output: 2 4
   Explanation: The sum of elements from 2nd position to 4th position is 12.

Example 2:
   Input:A[] = {1,2,3,4,5,6,7,8,9,10}, N = 10, S = 15
        Output: 1 5
   Explanation: The sum of elements from 1st position to 5th position is 15.

Efficient Approach: There is an idea if all the elements of the array are positive. If a subarray has sum greater than the given sum then there is
no possibility that adding elements to the current subarray the sum will be x (given sum).
Idea is to use a similar approach to a sliding window. Start with an empty subarray, add elements to the subarray until the sum is less than x.
If the sum is greater than x, remove elements from the start of the current subarray.

Algorithm:
----------
1. Create three variables, l=0, sum = 0
2. Traverse the array from start to end.
3. Update the variable sum by adding current element, sum = sum + array[i]
4. If the sum is greater than the given sum, update the variable sum as sum = sum – array[l], and update l as, l++.
5. If the sum is equal to given sum, print the subarray and break the loop.
 */
public class SubArray_With_Sum02 {

    //Function to find a continuous sub-array which adds up to a given number.
    public static ArrayList<Integer> subarraySum1(int[] arr, int n, int sum) {
        int start = 0, end = 0;
        boolean flag = false;
        int currSum = 0;

        //create an ArrayList
        ArrayList<Integer> list = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            currSum += arr[i];
            if (currSum >= sum) {
                end = i;

                while (sum < currSum && start < end) {
                    //subtracting the element from left
                    currSum -= arr[start];
                    start++;
                }//while

                if (currSum == sum) {
                    list.add(start + 1);
                    list.add(end + 1);
                    flag = true;
                    break;
                }//if
            }//if
        }//for
        if (!flag) {
            list.add(-1);
        }
        return list;
    }//method

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int n = 10, sum = 15;
        System.out.println(Arrays.toString(arr));
        ArrayList<Integer> list = subarraySum1(arr, n, sum);
        System.out.println(list);
    }
}
