package easy.day3;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

//给定一个整数数组，判断是否存在重复元素。
//
//如果存在一值在数组中出现至少两次，函数返回 true 。如果数组中每个元素都不相同，则返回 false 。
//输入: [1,2,3,1]
//输出: true
//序号:217
public class _4ContainsDuplicate {
    public static void main(String[] args){
        System.out.println(containsDuplicate2(new int[]{1,2,3,1}));
        System.out.println(containsDuplicate2(new int[]{1,2,3,4}));
        System.out.println(containsDuplicate2(new int[]{1,1,1,3,3,4,3,2,5,2}));
    }
    public static boolean containsDuplicate(int[] nums){
        Map<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<nums.length;i++) {
            if (!map.containsKey(nums[i])) {
                map.put(nums[i],i);
            }
        }
        return map.size()==nums.length?false:true;

    }
    public static boolean containsDuplicate2(int[] nums){
        Set<Integer> set = new HashSet<>();
        for(int x:nums){
            if(!set.add(x)){
                return true;
            }
        }
        return false;
    }
}
