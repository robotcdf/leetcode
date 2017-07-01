/*
 * [60] Permutation Sequence
 *
 * https://leetcode.com/problems/permutation-sequence/
 *
 * The set [1,2,3,…,n] contains a total of n! unique permutations.
 *
 * By listing and labeling all of the permutations in order,
 * 
 * We get the following sequence (ie, for n = 3):
 * "123"
 * "132"
 * "213"
 * "231"
 * "312"
 * "321"
 * Given n and k, return the kth permutation sequence.
 *
 * Note: Given n will be between 1 and 9 inclusive.
 *
 */
 
public class Solution {
    public String getPermutation(int n, int k) {
        StringBuilder res = new StringBuilder();    //StringBuilder
        List<Integer> numbers = new ArrayList<>();
        int[] f = new int[n+1];
        f[0] = 1;
        
        for(int i=1; i<n; i++) f[i] = f[i-1]*i;
        //f[] = {1,1, 2, 6, 24, ..., n!}
        
        for(int i=1; i<=9; i++)numbers.add(i);
        //numbers[] = {1, 2, 3, 4, 5, 6, 7, 8, 9}
        
        k--;
        
        for(int i=n; i>=1; i--){
            int j = k / f[i-1];
            k = k % f[i-1];
            res.append(String.valueOf(numbers.get(j)));    //valueOf(int i) 返回int参数的字符串表示形式。 E get(int index) 返回列表中指定位置的元素。
            numbers.remove(j);
            
        }
        
        return String.valueOf(res);
        
        
    }
}
