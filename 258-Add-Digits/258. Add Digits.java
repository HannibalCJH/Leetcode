public class Solution {
	public int addDigits(int num) 
	{
		int temp = num, sum = 0;
		while(temp >= 10)
		{
			sum = 0;
			while(temp > 0)
			{
				int remainder = temp % 10;
				temp /= 10;
				sum += remainder;
			}
			temp = sum;
		}
		return temp;
    }
}