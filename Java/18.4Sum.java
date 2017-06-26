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