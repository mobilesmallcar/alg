package medium.day13;

//给定一个包括n 个整数的数组num和 一个目标target。找出nums中的三个整数，使得它们的和与target最接近。返回这三个数的和。假定每组输入只存在唯一答案。
//序号:16

import java.util.*;

//输入：nums = [-1,2,1,-4], target = 1
//输出：2
//解释：与 target 最接近的和是 2 (-1 + 2 + 1 = 2) 。
public class _3ThreeSumClosest {
    public static void main(String[] args){
        System.out.println(threeSumClosest2(new int[]{-1,2,1,-4},1));//2
        System.out.println(threeSumClosest2(new int[]{1,1,1,1},0));//3
        System.out.println(threeSumClosest2(new int[]{1,1,-1,-1,3},-1));//-1
        System.out.println(threeSumClosest2(new int[]{0,1,2},0));//3
        System.out.println(threeSumClosest2(new int[]{1,2,4,8,16,32,64,128},82));//82
        System.out.println(threeSumClosest2(new int[]{1,-3,3,5,4,1},1));//1

    }
    public static int threeSumClosest2(int[] nums,int target){
        Arrays.sort(nums);
        int res = Integer.MAX_VALUE - target;

        for (int i = 0; i < nums.length - 2; i++) {
            int l = i+1, r = nums.length-1;
            while(l<r){
                int sum = nums[i]+nums[l]+nums[r];
                if(sum==target){
                    return sum;
                }else if(sum > target){
                    if(Math.abs(sum-target)<Math.abs(res-target)){
                        res = sum;
                    }
                    r--;
                }else{
                    if(Math.abs(sum-target)<Math.abs(res-target)){
                        res = sum;
                    }
                    l++;
                }
            }

        }
        return res;
    }
    private static int threeSumClosest(int[] nums,int target){
            if(nums==null||nums.length<3){
                return 0;
            }
            int min = Integer.MAX_VALUE;
            Set<List<Integer>> res = null;
            Arrays.sort(nums);
            for(int i=0;i<nums.length-2;i++){
                int temp = target-nums[i];
                int left = i+1;
                int right = nums.length-1;
                while(left<right){
                    if(Math.abs(nums[left]+nums[right]-temp)<=Math.abs(min)){
                        if(nums[left]+nums[right]-temp>0){
                            min = nums[left]+nums[right]-temp;
                            res = new HashSet<>();
                            res.add(Arrays.asList(nums[i],nums[left],nums[right]));
                            right--;
                        }else{
                            min = nums[left]+nums[right]-temp;
                            res = new HashSet<>();
                            res.add(Arrays.asList(nums[i],nums[left],nums[right]));
                            left++;
                        }
                    }else{
                        if(nums[left]+nums[right]<temp){
                            left++;
                        }else{
                            right--;
                        }
                    }
                }
            }
            int sum = 0;
            System.out.println(res);
            for(List<Integer> x:res){
                for(Integer cc:x){
                    sum += cc;
                }
            }
            return sum;
    }
}



