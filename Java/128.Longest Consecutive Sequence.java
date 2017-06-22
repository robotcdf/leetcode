/*
 * [128] Longest Consecutive Sequence 
 *
 * https://leetcode.com/problems/longest-consecutive-sequence/
 *
 *Given an unsorted array of integers, find the length of the longest consecutive elements sequence.
 *
 *For example,
 *
 *Given [100, 4, 200, 1, 3, 2],
 *
 *The longest consecutive elements sequence is [1, 2, 3, 4]. Return its length: 4.
 *
 *Your algorithm should run in O(n) complexity. 
 */

public class Solution {
    public int longestConsecutive(int[] nums) {
        int res=0,pre,next;
        Set<Integer> s = new HashSet<Integer> ();
        
        for(int num : nums) s.add(num);
        for(int num : nums){
            pre = num-1;
            next = num+1;
            if(s.remove(num)){
            
                while(s.remove(pre)) pre--;
                while(s.remove(next)) next++;
                res = Math.max(res,next-pre-1);
            }
        }
        return res;
    }
}