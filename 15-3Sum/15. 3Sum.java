public class Solution {
    public List<List<Integer>> threeSum(int[] num) 
    {
        List<List<Integer>> result = new ArrayList<List<Integer>>();  
        if(num == null || num.length == 0)  
            return result;
        // 数组排序
        List<Integer> element;  
        Arrays.sort(num);
        int origin, left, right, sum;  
        for(int i = 0; i < num.length - 2; ) // no need for i++ here
        {	
            origin = num[i];
            // origin是第一个数，因为数组重新排序
            // 如果连第一个数都大于0那后面的两个数肯定大于0，三个正数不可能加起来为0
            if(origin > 0)
            	break;
            
            left = i + 1;  
            right = num.length - 1;  
            while(left < right)
            {  
                sum = origin + num[left] + num[right];  
                if(sum == 0) 
                {  
                	element = new ArrayList<Integer>();  
                	element.add(origin);  
                	element.add(num[left]);  
                	element.add(num[right]);  
                    result.add(element);  
                    int temp = num[left];  
                    while(left < right && temp == num[left]) left++;   // 跳过相同的数
                    temp = num[right];  
                    while(left < right && temp == num[right]) right--; // 跳过相同的数
                } 
                else if(sum > 0) 
                    right--;  
                else  
                    left++;  
            }  
            while(++i < num.length && num[i] == origin) // 跳过相同的第一个数
            {
                
                // 第一个数必须是负数
            	if(num[i] > 0)
            		break;
            }
        }  
        return result;  
    }
}