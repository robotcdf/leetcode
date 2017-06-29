/*
 * [31] Next Permutation 
 *
 * https://leetcode.com/problems/next-permutation/
 *
 * Implement next permutation, which rearranges numbers into the lexicographically next greater permutation of numbers.
 * 
 * If such arrangement is not possible, it must rearrange it as the lowest possible order (ie, sorted in ascending order).
 * 
 * The replacement must be in-place, do not allocate extra memory.
 * 
 * Here are some examples. Inputs are in the left-hand column and its corresponding outputs are in the right-hand column.
 * 1,2,3 → 1,3,2
 * 3,2,1 → 1,2,3
 * 1,1,5 → 1,5,1
 * 
 */

public class Solution {
    public void nextPermutation(int[] nums) {
        int i=0,j=0,n=nums.length;
        
        for(i=n-2; i>=0; --i){
            if(nums[i] < nums[i+1]){
                for(j=n-1; j>=i; --j){
                    if(nums[j] > nums[i])
                        break;
                }
                
                swap(nums, i, j);
                reverse(nums, i+1, n-1);
                return;          //此处用return直接返回，在一系列嵌套循环中，break只终止内层的循环
            }
        }
        
        reverse(nums, 0, n-1);   //若初始程序为倒序，则以上未执行操作，直接反转
        
    }
    
    public void swap(int[] num, int i, int j){
        int temp=0;
        temp = num[i];
        num[i] = num[j];
        num[j] = temp;
    }
    
    public void reverse(int[] num, int start, int end){
        for(int i=start; i<=(start+end)/2; i++){
            swap(num, i, start+end-i);
        }
    }
}