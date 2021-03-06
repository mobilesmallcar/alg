package easy.day3;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class _1TwoSum {
    public static void main(String[] args){
        System.out.println(Arrays.toString(twoSum2(new int[]{2,7,11,15},9)));
        System.out.println(Arrays.toString(twoSum2(new int[]{1,1,3,3,6},6)));
        System.out.println(Arrays.toString(twoSum2(new int[]{-1,0},-1)));
        System.out.println(Arrays.toString(twoSum2(new int[]{5,25,75},100)));
    }
    public static int[] twoSum(int[] numbers,int target){
        Map<Integer,Integer> map = new HashMap<>();
        for(int i=1;i<=numbers.length;i++){
            int temp = target-numbers[i-1];
            if(!map.containsKey(temp)){
                map.put(numbers[i-1],i);
            }else{
                return new int[]{map.get(temp),i};
            }
        }
        return new int[]{0,0};
    }
    public static int[] twoSum2(int[] numbers,int target){
        for(int i=0;i<numbers.length;i++){
            int low = i+1,high = numbers.length -1;
            while(low<=high){
                int mid = (high-low)/2 +low;
                if(numbers[mid]==target-numbers[i]){
                    return new int[]{i+1,mid+1};
                }else if(numbers[mid]>target-numbers[i]){
                    high = mid-1;
                }else{
                    low = mid +1;
                }
            }


        }
        return new int[]{-1,-1};
    }

    public static int[] twoSum3(int[] numbers,int target){
        int low = 0,high = numbers.length-1;
        while(low<high){
            int sum = numbers[low] + numbers[high];
            if(sum == target){
                return new int[]{low+1,high+1};
            }else if(sum<target){
                ++low;
            }else{
                --high;
            }
        }
        return new int[]{-1,-1 };
    }
}
