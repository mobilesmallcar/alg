package easy.day3;

import java.util.*;

public class _2MajorityElement {
    public static void main(String[] args){
        System.out.println(majorityElement2(new int[]{3,2,3}));
        System.out.println(majorityElement2(new int[]{2,2,1,1,1,2,2}));
//        System.out.println(majorityElement2(new int[]{1,1,2,2}));
    }
    public static int majorityElement(int[] nums){
        int n = nums.length;
        Map<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<n;i++){
            if(map.containsKey(nums[i])){
                map.put(nums[i],map.get(nums[i])+1);
            }else{
                map.put(nums[i],1);
            }
        }
        for(Map.Entry<Integer,Integer> entry:map.entrySet()){
            if(entry.getValue()>n/2){
                return entry.getKey();
            }
        }

        return 0;
    }
    public static int majorityElement2(int[] nums){
        Arrays.sort(nums);
        return nums[nums.length/2];
    }
}
