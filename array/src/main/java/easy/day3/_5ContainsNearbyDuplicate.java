package easy.day3;

//给定一个整数数组和一个整数k，判断数组中是否存在两个不同的索引i和j，使得nums [i] = nums [j]，并且 i 和 j的差的 绝对值 至多为 k。
//
//输入: nums = [1,2,3,1], k = 3
//输出: true
public class _5ContainsNearbyDuplicate {
    public static void main(String[] args){
        System.out.println(containsNearbyDuplicate2(new int[]{1,2,3,1},3));
        System.out.println(containsNearbyDuplicate2(new int[]{1,0,1,1},1));
        System.out.println(containsNearbyDuplicate2(new int[]{1,2,3,1,2,3},2));
        System.out.println(containsNearbyDuplicate2(new int[]{1,2,3,1,2,3},3));
    }
    public static boolean containsNearbyDuplicate(int[] nums,int k){
        int start;
        int end;
        boolean flag = false;
        for(int i=0;i<nums.length;i++){
            if(i-k<0){
                start = 0;
            }else{
                start = i-k;
            }
            if(i+k>=nums.length){
                end = nums.length;
            }else{
                end = i+k;
            }
            for(int j=start;j<end;j++){
                if(i!=j&&nums[j]==nums[i]){
                    return true;
                }
            }
        }
        return flag;
    }
    public static boolean containsNearbyDuplicate2(int[] nums, int k){
        for(int i=0;i<nums.length;++i){
            for(int j = Math.max(i-k,0);j<i;++j){
                if(nums[i]==nums[j]) return true;
            }
        }
        return false;
    }
}
