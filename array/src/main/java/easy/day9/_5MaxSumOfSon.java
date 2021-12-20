package easy.day9;

/**
 * 给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 *
 * 输入：nums = [-2,1,-3,4,-1,2,1,-5,4]
 * 输出：6
 * 解释：连续子数组 [4,-1,2,1] 的和最大，为 6 。
 *
 * 输入：nums = [-1]
 * 输出：-1
 */
public class _5MaxSumOfSon {
    public static void main(String[] args){
        System.out.println(MaxSubArray1(new int[]{-2,1,-3,4,-1,2,1,-5,4}));
        System.out.println(MaxSubArray1(new int[]{-1}));
        System.out.println(MaxSubArray1(new int[]{1}));
        System.out.println(MaxSubArray1(new int[]{-2,-1}));
        System.out.println(MaxSubArray1(new int[]{-1,-2}));
        System.out.println(MaxSubArray1(new int[]{-3,-4,-2,-2}));
    }
    public static int MaxSubArray(int[] nums){
        int n = nums.length;
        if(n<=1){
            return nums[n-1];
        }
        int sum = 0,temp = nums[0];
        int fast = 0;
        while(fast<n){
            sum += nums[fast++];
            if(sum<0){
                if(temp<0&&temp<sum){
                    temp = sum;
                }
                sum = 0;
            }else if(temp<sum){
                temp = sum;
            }
        }
        return temp;
    }
    public static int MaxSubArray1(int[] nums){
        int n = nums.length;
        if(n<=1){
            return nums[n-1];
        }
        int sum = 0,temp = nums[0];
        int fast = 0;
        for(int i=0;i<n;i++){
            sum += nums[i];
            if(sum<0){
                if(temp<0&&temp<sum){
                    temp = sum;
                }
                sum = 0;
            }else if(temp<sum){
                temp = sum;
            }
        }
        return temp;
    }
}
