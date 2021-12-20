package easy.day3;

import java.util.ArrayList;
import java.util.List;

//统计所有小于非负整数 n 的质数的数量。
//输入：n = 10
//输出：4
//解释：小于 10 的质数一共有 4 个, 它们是 2, 3, 5, 7 。
public class _3CountPrimes {
    public static void main(String[] args) {
        System.out.println(countPrimes(10));
        System.out.println(countPrimes(0));
        System.out.println(countPrimes(1));
    }

    public static int countPrimes(int n) {
        if (n <= 1) {
            return 0;
        }
        List<Integer> list = new ArrayList<>();
        int count = 0;
        Boolean flag;
        int start = 1;
        while (start++ < n) {
            flag = true;
            for (int i = 2; i <= start / 2; i++) {
                if (start % i == 0) {
                    flag = false;
                    break;
                }
            }
            if(flag){
                list.add(start);
                count++;
            }

        }
        for(Integer integer:list){
            System.out.print(integer+" ");
        }
        System.out.print("->");
        return count;
    }
}
