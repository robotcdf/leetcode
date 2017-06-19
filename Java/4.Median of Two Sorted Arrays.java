/*
 * [4] Median of Two Sorted Arrays 
 *
 * https://leetcode.com/problems/median-of-two-sorted-arrays/
 *
 * There are two sorted arrays nums1 and nums2 of size m and n respectively.
 * Find the median of the two sorted arrays. The overall run time complexity should be O(log (m+n)).
 * 
 * Example 1:
 *
 * nums1 = [1, 3]
 * nums2 = [2]
 * 
 * The median is 2.0
 * Example 2:
 * 
 * nums1 = [1, 2]
 * nums2 = [3, 4]
 * 
 * The median is (2 + 3)/2 = 2.5
 * 
 */

public class Solution {//第K大指从小往大数 第k大的数 而不是从大往小算 如[1，2，3，4，5] 第2大是2，而不是。
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        
        //此处利用取整特性 若m+n为偶数 则left、rigth为两个相邻数字 若m+n为奇数 则left、right为同一个数字
        int m = nums1.length, n = nums2.length, left = (m+n+1)/2, right = (m+n+2)/2;  
        
        return(findKth(nums1,nums2,left)
            + findKth(nums1,nums2,right))/2.0;
    }
    
    int findKth(int[] nums1, int[] nums2, int k){ //查找第k大个数
        int m = nums1.length, n = nums2.length;
        
        if(m > n) return findKth(nums2, nums1, k); //设定条件：nums1的长度永远小于nums的长度
        if(m == 0) return nums2[k-1];
        if(k == 1) return Math.min(nums1[0], nums2[0]);
        
        int i = Math.min(m, k/2), j = Math.min(n, k/2);
        if(nums1[i-1] < nums2[j-1]){
            return(findKth(Arrays.copyOfRange(nums1,i,m), nums2, k-i));
        }else{
            return(findKth(nums1, Arrays.copyOfRange(nums2,j,n), k-j));
        }

    }
}