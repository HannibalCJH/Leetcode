public class Solution {
    public int countPrimes(int n) 
    {
        boolean[] isPrime = new boolean[n];
		for(int i = 2; i < n; i++)
			isPrime[i] = true;
		// Loop's ending condition is i * i < n instead of i < sqrt(n)
		// to avoid repeatedly calling an expensive function sqrt().
		// 排除合数就留下了质数
		for(int i = 2; i * i < n; i++) 
		{
			// 已经排除则跳过
			if(!isPrime[i])
				continue;
			// 讨论i的倍数所以每次都是j+=i
			// 从i*i开始，前面的i*2，i*3等到都已经被讨论2和3的时候排除了
			for(int j = i * i; j < n; j += i)
				isPrime[j] = false;
		}
		int count = 0;
		// 再进行一遍遍历统计个数
		for(int i = 2; i < n; i++)
			if(isPrime[i]) 
				count++;
		return count;
    }
}