/*
 * [15] 3Sum  
 *
 * Given an array S of n integers, are there elements a, b, c in S such that a + b + c = 0? 
 * Find all unique triplets in the array which gives the sum of zero.
 * Note: The solution set must not contain duplicate triplets.
 *
 * For example, given array S = [-1, 0, 1, 2, -1, -4],
 *
 * A solution set is:
 * [
 *   [-1, 0, 1],
 *   [-1, -1, 2]
 * ]
 * 
 */

public class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);    //按照从小到大的顺序的数组进行排序
        
        for(int i=0; i<nums.length-2; i++){
            if(i>0 && nums[i] == nums[i-1])//跳过相同的数值 避免重复计算
                continue;
            
            int j = i+1;
            int k = nums.length-1;
            int target = 0-nums[i];
            while(j < k){
                if(nums[j] + nums[k] == target){    //找到目标值
                    ArrayList<Integer> temp = new ArrayList<Integer>();
                    temp.add(nums[i]);
                    temp.add(nums[j]);
                    temp.add(nums[k]);
                    result.add(temp);
                    
                    j++;
                    k--;
                    while(j<k && nums[j] == nums[j-1]) j++;    //跳过相同的数值 避免重复计算
                    while(j<k && nums[k] == nums[k+1]) k--;    //注意这里是避免与nums[k+1]重复
                    
                }else if(nums[j] + nums[k] > target){
                    k--;
                    
                }else{
                    j++;
                    
                }
                
            }
        }
        return result;
    }
}