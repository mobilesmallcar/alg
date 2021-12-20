package easy.day9;

/**
 * 给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
 * 你可以假设数组中无重复元素。
 *
 * 输入: [1,3,5,6], 5
 * 输出: 2
 *
 * 输入: [1,3,5,6], 2
 * 输出: 1
 */
public class _4SearchInPosition {
    public static void main(String[] args){
//        System.out.println(searchInsert(new int[]{1,3,5,6},0));
//        System.out.println(searchInsert1(new int[]{1,3,5,6},0));
        System.out.println(searchInsert(new int[]{1,3,5,6},2));
        System.out.println(searchInsert1(new int[]{1,3,5,6},2));
        System.out.println(searchInsert(new int[]{1,3,5,6},4));
        System.out.println(searchInsert1(new int[]{1,3,5,6},4));
        System.out.println(3/2);
//        System.out.println(searchInsert(new int[]{1,3,5,6},7));
//        System.out.println(searchInsert1(new int[]{1,3,5,6},7));
    }
    private static int searchInsert1(int[] nums,int target){
        int n = nums.length;
        int left=0,right=n-1;
        while(left<=right){
            int mid = left+(right-left)/2;
            if(nums[mid]<target){
                left = mid+1;
            }else{
                right = mid-1;
            }
        }
        System.out.println("left->"+left);
        System.out.println("right->"+right);
        return left;
//        int n = nums.length;
//        int l=0,r=n-1;
//        while(l<=r){
//            int mid=l+(r-l)/2;
//            if(nums[mid]<target)
//                l=mid+1;
//            else r=mid-1;
//        }
//        return l;
    }

    private static int searchInsert(int[] nums,int target){
        int result = 0;
        int i = 0;
        if(nums[0]>target){
            return 0;
        }
        while(i<nums.length-2){
            if(nums[i]==target){
                return i;
            }else if(nums[i]<target){
                if(nums[i+1]<target){
                    i++;
                }
                else{
                    return i+1;
                }
            }
        }
        if(nums[nums.length-1]==target){
            i = nums.length-1;
        }else{
            i = nums.length;
        }
        return i;
    }
}
