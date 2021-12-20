package medium.day13;

import java.util.*;
import java.util.stream.Collectors;

//给你一个包含 n 个整数的数组nums，判断nums中是否存在三个元素 a，b，c ，使得a + b + c = 0 ？请你找出所有和为 0 且不重复的三元组。
//
//注意：答案中不可以包含重复的三元组。
//序号:15

//输入：nums = [-1,0,1,2,-1,-4]
//输出：[[-1,-1,2],[-1,0,1]]
public class _2ThreeSum {
    public static void main(String[] args) {
        List<List<Integer>> sum1 = threeSum3(new int[]{-1, 0, 1, 2, -1, -4});
        List<List<Integer>> sum2 = threeSum3(new int[]{});
        List<List<Integer>> sum3 = threeSum3(new int[]{0});
        List<List<Integer>> sum4 = threeSum3(new int[]{0,0,0,0});
        System.out.println(sum1);
        System.out.println(sum2);
        System.out.println(sum3);
        System.out.println(sum4);
    }
    public static List<List<Integer>> threeSum2(int[] nums){
        if(nums==null|| nums.length<3){
            return new ArrayList<>();
        }
        Set<List<Integer>> res = new HashSet<>();

        Arrays.sort(nums);
        for(int i=0;i<nums.length;i++){
            for(int j=i+1;j<nums.length;j++){
                for(int k=j+1;k<nums.length;k++){
                    res.add(Arrays.asList(nums[i],nums[j],nums[k]));
                }
            }
        }
        return new ArrayList<>(res);
    }

    public static List<List<Integer>> threeSum3(int[] nums){
        if(nums==null||nums.length<3){
            return new ArrayList<>();
        }
        Set<List<Integer>> res = new HashSet<>();
        Arrays.sort(nums);

        for(int i=0;i<nums.length;i++){
            int target = -nums[i];
            int left = i+1;
            int right = nums.length-1;
            while(left<right){
                int sum = nums[left]+nums[right];
                if(sum==target){
                    res.add(Arrays.asList(nums[i],nums[left],nums[right]));
                    left++;
                    right--;
                }else if(sum<target){
                    left++;
                }else{
                    right--;
                }
            }
        }
        return new ArrayList<>(res);
    }
    public static List<List<Integer>> threeSum(int[] nums) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        List<Integer> list = null;
        List<List<Integer>> sum = new ArrayList<>();
        for(int i=0;i<nums.length-1;i++){
            for(int j=i+1;j<nums.length;j++){
                if(!map.containsKey(nums[j]+nums[i])){
                    list = new ArrayList<>();
                    list.add(i);
                    list.add(j);
                    map.put(nums[i]+nums[j],list);
                }
            }
        }
        System.out.println(map);
        Set<List<Integer>> set = new HashSet<>();
        for(int i=0;i<nums.length;i++){
            int temp = 0-nums[i];
            if(map.containsKey(temp)){
                list = map.get(temp);
                if(!list.contains(i)&&i>list.get(1)){
                    list.add(i);
                    Collections.sort(list);
                    List<Integer> list1 = new ArrayList<>();
                    for(Integer x:list){
                        list1.add(nums[x]);
                    }
                    set.add(Arrays.asList(list1.get(0),list1.get(1),list1.get(2)));
                }

            }
        }
        return new ArrayList<>(set);
    }
}
