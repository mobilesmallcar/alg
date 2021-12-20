package easy.day9;

import java.util.Arrays;

/**
 * 不要使用额外的数组空间，你必须仅使用 O(1) 额外空间并 原地 修改输入数组。
 * <p>
 * 输入：nums = [3,2,2,3], val = 3
 * 输出：2, nums = [2,2]
 * 解释：函数应该返回新的长度 2, 并且 nums 中的前两个元素均为 2。你不需要考虑数组中超出新长度后面的元素。例如，函数返回的新长度为 2 ，而 nums = [2,2,3,3] 或 nums = [2,2,0,0]，也会被视作正确答案。
 * <p>
 * 输入：nums = [0,1,2,2,3,0,4,2], val = 2
 * 输出：5, nums = [0,1,4,0,3]
 * 解释：函数应该返回新的长度 5, 并且 nums 中的前五个元素为 0, 1, 3, 0, 4。注意这五个元素可为任意顺序。你不需要考虑数组中超出新长度后面的元素。
 */
public class _3RemoveVal {
    public static void main(String[] args) {
        System.out.println(removeElement(new int[]{3, 2, 2, 3}, 3));
        System.out.println(removeElement3(new int[]{3, 2, 2, 3}, 3));
        System.out.println(removeElement(new int[]{0,1,2,2,3,0,4,2,2},2));
        System.out.println(removeElement3(new int[]{0,1,2,2,3,0,4,2,2},2));
        System.out.println(removeElement(new int[]{2},3));
        System.out.println(removeElement3(new int[]{2},3));
    }

    private static int removeElement(int[] nums, int val) {
        int n = nums.length;
        int left = 0;
        for (int right = 0; right < n; right++) {
            if (nums[right] != val) {
                nums[left++] = nums[right];
//                left++;
            }
        }
        System.out.println(Arrays.toString(nums));
        return left;
    }
    private static int removeElement2(int[] nums, int val) {
        int left=0,right=nums.length;
        while(left<right){
            if(nums[left]==val){
                nums[left] = nums[right-1];
                right--;
            }else{
                left++;
            }
        }
        System.out.println(Arrays.toString(nums));
        return left;
    }
    private static int removeElement3(int[] nums, int val) {
        int left=0,right=nums.length-1;
        while(left<=right){
            if(nums[left]==val){
                nums[left] = nums[right];
                right--;
            }else{
                left++;
            }
        }
        System.out.println(Arrays.toString(nums));
        return left;
    }
}
