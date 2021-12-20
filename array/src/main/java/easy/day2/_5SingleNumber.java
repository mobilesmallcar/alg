package easy.day2;

import java.util.ArrayList;
import java.util.List;

//给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。
//输入: [2,2,1]
//输出: 1
//序号:136

//异或：满足 交换律 和 结合律
//0与0 1与1 1与0 异或
//自身异或为0  一个数与0异或不动，
public class _5SingleNumber {
    public static void main(String[] args){
        System.out.println(singleNumber1(new int[]{2,2,1}));
        System.out.println(singleNumber1(new int[]{1,2,1,4,2}));
        System.out.println(singleNumber1(new int[]{1,2,1,2,4}));
        System.out.println(singleNumber1(new int[]{7,1,2,1,2}));
    }
    public static int singleNumber(int[] nums){
        int n = nums.length;
        for(int i=0;i<n;){
            int temp = i;
            for(int j=0;j<n;j++){
                if(j!=i&&nums[j]==nums[i]){
                    i++;
                    break;
                }
            }
            if(temp==i){
                return nums[i];
            }
        }
        return 0;
    }
    public static int singleNumber1(int[] nums){
        int single = 0;
        for(int num:nums){
            single ^= num;
        }
        return single;
    }
    public static int singleNumber2(int[] nums){
        int n = nums.length;
        List<Integer> list = new ArrayList<>();
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += nums[i];
            if(!list.contains(nums[i])){
                list.add(nums[i]);
            }
        }
        int temp = 0;
        for (int i = 0; i < list.size(); i++) {
            temp += list.get(i);
        }
        return temp*2-sum;
    }
}
