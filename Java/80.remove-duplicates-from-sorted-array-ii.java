/*
 * [80] Remove Duplicates from Sorted Array II
 *
 * https://leetcode.com/problems/remove-duplicates-from-sorted-array-ii
 *
 * Medium (35.48%)
 * Total Accepted:    112980
 * Total Submissions: 318436
 * Testcase Example:  '[]'
 *
 * 
 * Follow up for "Remove Duplicates":
 * What if duplicates are allowed at most twice?
 * 
 * 
 * For example,
 * Given sorted array nums = [1,1,1,2,2,3],
 * 
 * 
 * Your function should return length = 5, with the first five elements of nums
 * being 1, 1, 2, 2 and 3. It doesn't matter what you leave beyond the new
 * length.
 * 
 */
public class Solution {
    public int removeDuplicates(int[] nums) {
        if(nums.length == 0) return 0;
        
        int index=0,r=0;
        for(int i=1; i<nums.length; i++){
            if(nums[index] != nums[i]){
                nums[++index] = nums[i];
                r=0;
            }else{
                r++;
                if(r<2){
                    nums[++index] = nums[i];
                }
            }
        }
        return index+1;
    }
}
