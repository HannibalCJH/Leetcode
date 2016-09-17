public class Solution {
    public List<List<Integer>> threeSum(int[] num) 
    {
        List<List<Integer>> result = new ArrayList<List<Integer>>();  
        if(num.length == 0)  
            return result;
        
        List<Integer> element;  
        Arrays.sort(num);
        int origin, left, right, sum;  
        for(int i = 0; i < num.length - 2; ) // no need for i++ here
        {	
            origin = num[i]; 
            if(origin > 0) // in the sorted array, three positive integers cannot add up to zero
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
                    while(left < right && temp == num[left]) // skip same number  
                        left++;  
                    temp = num[right];  
                    while(left < right && temp == num[right]) // skip same number  
                        right--;  
                } 
                else if(sum > 0) 
                    right--;  
                else  
                    left++;  
            }  
            while(++i < num.length && num[i] == origin) //skip same origins
            {
            	if(num[i] > 0)
            		break;
            }
        }  
        return result;  
    }
}