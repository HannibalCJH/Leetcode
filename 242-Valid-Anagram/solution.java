public class Solution {
    public boolean isAnagram(String s, String t) 
	{
	    if(s.length() != t.length())
	        return false;
        int[] bitmap = new int[26];
        for(int i = 0; i < s.length(); i++)
            bitmap[s.charAt(i) - 'a']++;
        for(int i = 0; i < t.length(); i++)
            bitmap[t.charAt(i) - 'a']--;
        for(int i = 0; i < bitmap.length; i++)
            if(bitmap[i] > 0)
                return false;
        return true;
	}
}