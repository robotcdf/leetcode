/*
 * [81] Search in Rotated Sorted Array II
 *
 * https://leetcode.com/problems/search-in-rotated-sorted-array-ii
 *
 * Medium (32.84%)
 * Total Accepted:    90854
 * Total Submissions: 276605
 * Testcase Example:  '[]\n5'
 *
 * 
 * Follow up for "Search in Rotated Sorted Array":
 * What if duplicates are allowed?
 * 
 * Would this affect the run-time complexity? How and why?
 * 
 * 
 * Suppose an array sorted in ascending order is rotated at some pivot unknown
 * to you beforehand.
 * 
 * (i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).
 * 
 * Write a function to determine if a given target is in the array.
 * 
 * The array may contain duplicates.
 */
public class Solution {
    public boolean search(int[] nums, int target) {
	int first=0, last=nums.length;
        int mid = 0;
        
        while(first != last){
            mid = first + (last-first)/2;
            if(nums[mid] == target)
                return true;
                
            if(nums[first] < nums[mid]){
                if(nums[first] <= target && target < nums[mid]){
                    last = mid;
                }else{
                    first = mid+1;
                }
            }else if(nums[first] > nums[mid]){
                if(nums[mid] < target && target <= nums[last-1]){
                    first = mid+1;
                }else{
                    last = mid;
                }
            }else{
                first++;
            }
        }
        return false;
        
    }
}
