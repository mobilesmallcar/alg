package easy.day9;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

//对应编码 1
public class _1TwoSum {
    public static void main(String[] args){
        int[] ints = twoSum2(new int[]{2,7,11,15},9);
        System.out.println(Arrays.toString(twoSum(new int[]{2,7,11,15},9)));
        System.out.println(Arrays.toString(ints));
    }
    public static int[] twoSum(int[] nums, int target) {
        int length = nums.length;
        for(int i=0;i<length;i++){
            for(int j=i;j<length;j++){
                if(nums[i]+nums[j]==target){
                    return new int[]{i,j};
                }
            }
        }
        return new int[0];
    }

    public static int[] twoSum2(int[] nums,int target){
        Map<Integer,Integer> map = new HashMap();
        for(int i=0;i<nums.length;i++){
            int temp = target-nums[i];
            if(!map.containsKey(temp)){
                map.put(nums[i],i);
            }
            else{
                return new int[]{map.get(temp),i};
            }
        }
        return new int[]{};
    }
}
