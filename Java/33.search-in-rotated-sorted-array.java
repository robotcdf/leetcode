/*
 * [33] Search in Rotated Sorted Array
 *
 * https://leetcode.com/problems/search-in-rotated-sorted-array
 *
 * Medium (32.13%)
 * Total Accepted:    163998
 * Total Submissions: 510489
 * Testcase Example:  '[]\n5'
 *
 * Suppose an array sorted in ascending order is rotated at some pivot unknown
 * to you beforehand.
 * 
 * (i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).
 * 
 * You are given a target value to search. If found in the array return its
 * index, otherwise return -1.
 * 
 * You may assume no duplicate exists in the array.
 */
public class Solution {
    public int search(int[] nums, int target) {
        int first=0, last=nums.length;
        int middle = 0;
        
        while(first != last){
            middle = first + (last-first)/2;
            
            if(nums[middle] == target)
            return middle;
            
            if(nums[first] <= nums[middle]){
                if(nums[first] <= target && target < nums[middle]){     //左右边界需要做等于判断
                    last = middle;
                }else{
                    first = middle + 1;
                }
            }else{
                if(nums[middle] < target && target <= nums[last-1]){    //左右边界需要做等于判断
                    first = middle + 1;
                }else{
                    last = middle;
                }
            }     
        }
        
        return -1;
        
    }
}
