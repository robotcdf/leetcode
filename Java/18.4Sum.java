/*
* [18] 4Sum  
*
* https://leetcode.com/problems/4sum/
*
* Given an array S of n integers, are there elements a, b, c, and d in S such that a + b + c + d = target? 
* Find all unique quadruplets in the array which gives the sum of target.
* Note: The solution set must not contain duplicate quadruplets.
* 
* For example, given array S = [1, 0, -1, 0, -2, 2], and target = 0.
* A solution set is:
* [
*   [-1,  0, 0, 1],
*   [-2, -1, 1, 2],
*   [-2,  0, 0, 2]
* ]
*/

public class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Set<List<Integer>> resultSet = new HashSet<>();
        Arrays.sort(nums);
        
        for(int i=0; i<nums.length-3; i++){
            for(int j=i+1; j<nums.length-2; j++){
                int left = j+1, right = nums.length - 1;
                
                while(left < right){
                    int sum = nums[i] + nums[j] + nums[left] +nums[right];
                    
                    if(sum == target){
                        resultSet.add(Arrays.asList(nums[i], nums[j], nums[left], nums[right]));
                        ++left;--right;
                    }else if(sum > target){
                        --right;
                    }else {
                        ++left;
                    }
                }
                
            }
            
        }
        List<List<Integer>> result = new ArrayList<List<Integer>>(resultSet);
        return result;
    }
}