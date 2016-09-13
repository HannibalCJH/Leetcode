public class Solution {
    public boolean isAnagram(String s, String t) 
	{
		char[] charAry1 = s.toCharArray();
		char[] charAry2 = t.toCharArray();
		
		Arrays.sort(charAry1);
		Arrays.sort(charAry2);
		
		return (String.valueOf(charAry1).equals(String.valueOf(charAry2)));
    }
}