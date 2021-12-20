package easy.day9;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
//对应编码 26
public class _2RemoveDuplicates {
    public static void main(String[] args){
        int num = removeDuplicates2(new int[]{0,0,1,1,1,2,2,3,3,4});
        System.out.println(num);
        String a = null;
        if(a==null&&!("1".equals(a))||"5".equals(a)){
            System.out.println("11111");
        }
    }
    public static int removeDuplicates(int[] nums){
        Map<Integer,Integer> map = new HashMap<>();
        for(int i=1;i<nums.length;i++){
            if(!map.containsKey(nums[i])){
                map.put(nums[i],i);
            }
        }
        Integer[] integers = map.keySet().toArray(new Integer[map.size()]);
        for(int i=0;i< integers.length;i++){
            nums[i]=integers[i].intValue();
        }
        System.out.println(Arrays.toString(nums));
        return map.size();
    }
    public static int removeDuplicates2(int[] nums){
        int start=1;
        for(int i=1;i<nums.length;i++){
            if(nums[i] != nums[i-1]){
                nums[start] = nums[i];
                start++;
            }
        }
        System.out.println(Arrays.toString(nums));
        return start;
    }
    //简洁的写法
    public static int removeDuplicate3(int[] nums){
        int t = 0;
        for (int i = 0; i < nums.length; i ++ ) {
            if (i == 0 || nums[i] != nums[i - 1]) nums[t ++ ] = nums[i];
        }
        return t;
    }
}
