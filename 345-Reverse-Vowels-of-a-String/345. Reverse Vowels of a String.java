public class Solution {
    // 我的算法
    public String reverseVowels(String s) 
    {
		char[] vowels = {'a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'};
		HashSet<Character> hs = new HashSet<Character>();
		for(char vowel : vowels)
			hs.add(vowel);

		StringBuilder sb = new StringBuilder(s);
		int left = 0, right = s.length() - 1;
		
		while(left < right)
		{
			char lCh = s.charAt(left), rCh = s.charAt(right);
			if(hs.contains(lCh) && hs.contains(rCh))
			{
				sb.setCharAt(left++, rCh);
				sb.setCharAt(right--, lCh);
				continue;
			}
			
			if(!hs.contains(lCh))
				left++;
			if(!hs.contains(rCh))
				right--;
			
		}
		return sb.toString();
    }
}