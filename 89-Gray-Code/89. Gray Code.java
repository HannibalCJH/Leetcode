public class Solution {
    // 工业中的第i个格雷码是这么生成的：(i >> 1) ^ i
	public List<Integer> grayCode(int n) 
    {
        List<Integer> result = new ArrayList<Integer>();
        // 能被n位二进制表示的数的个数有2^n个
        int size = 1 << n;
        // 1011 = 1110
        // it is (1011 >> 1) ^ 1011 = 1110
        for(int i = 0; i < size; i++) 
        	result.add((i >> 1) ^ i);  
        return result;   
    }
}