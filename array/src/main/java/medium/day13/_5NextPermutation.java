package medium.day13;

import java.util.Arrays;

//实现获取 下一个排列 的函数，算法需要将给定数字序列重新排列成字典序中下一个更大的排列。
//
//如果不存在下一个更大的排列，则将数字重新排列成最小的排列（即升序排列）。
//
//必须 原地 修改，只允许使用额外常数空间。
//
//输入：nums = [1,2,3]
//输出：[1,3,2]
public class _5NextPermutation {
    public static void main(String[] args){
        nextPermutation(new int[]{1,2,3});
        nextPermutation(new int[]{3,2,1});
        nextPermutation(new int[]{1,1,5});
        nextPermutation(new int[]{1});
        nextPermutation(new int[]{1,3,2});
    }
    public static void nextPermutation(int[] nums){
//        1,2,3,6,5,4,6,5
        int n = nums.length;
        if(n<=1){
            System.out.println(Arrays.toString(nums));
            return ;
        }
        while(n-2>=0){
            int last = nums[n-1];
            for(int i=n-2;i>=0;i--){
                int temp = nums[i];
                if(temp<last){
                    nums[i] = last;
                    nums[n-1] = temp;
                    System.out.println(Arrays.toString(nums));
                    return;
                }
            }
            n--;
        }
//        n = n+1;
//        while(n<=nums.length-1){
//            int min = Integer.MAX_VALUE;
//            int temp = nums[n];
//            for(int i=n;i<=nums.length-1;i++){
//                if(nums[i]<min){
//                    min = nums[i];
//                    temp = i;
//                }
//            }
//            nums[temp] = nums[n];
//            nums[n] = min;
//            n++;
//        }
        Arrays.sort(nums);
        System.out.println(Arrays.toString(nums));
    }
}
