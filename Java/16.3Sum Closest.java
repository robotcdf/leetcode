/*
 * [16] 3Sum Closest  
 *
 * https://leetcode.com/problems/3sum-closest/
 * 
 * Given an array S of n integers, find three integers in S such that the sum is closest to a given number, target. 
 * 
 * Return the sum of the three integers. You may assume that each input would have exactly one solution.
 * 
 * For example, given array S = {-1 2 1 -4}, and target = 1.
 * 
 * The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
 * 
 */

public class Solution {
    public int threeSumClosest(int[] nums, int target) {
        int closest = Integer.MAX_VALUE;//Ĭ��ȡ���ֵ
        int mindiff = Integer.MAX_VALUE;
        Arrays.sort(nums);
        
        for(int i=0; i<nums.length-2; i++){
            int j = i+1, k = nums.length-1;
            
            while(j<k){
                int sum = nums[i] + nums[j] + nums[k];
                int diff = Math.abs(target - sum);    //Ҫȡ����ֵ
                
                if(diff < mindiff){
                    closest = sum;
                    mindiff = diff;
                }
                
                if(sum > target) {k--;}
                else {j++;}  //������if(sum<target) Ĭ���������j++ ������while(j<k)ѭ�� 
            }
        }
        return closest;
    }
}