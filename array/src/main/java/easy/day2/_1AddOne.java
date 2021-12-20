package easy.day2;

import java.util.Arrays;

public class _1AddOne {
    public static void main(String[] args){
        int[] temp11 =plusOne(new int[]{9,9,8});
        int[] temp12 =plusOne(new int[]{9,9,9});
        int[] temp21 =plusOne2(new int[]{9,9,8});
        int[] temp22 =plusOne2(new int[]{9,9,9});
        System.out.println(Arrays.toString(temp11));
        System.out.println(Arrays.toString(temp12));
        System.out.println(Arrays.toString(temp21));
        System.out.println(Arrays.toString(temp22));
    }

    public static int[] plusOne(int[] digits) {
        for(int i=digits.length-1;i>=0;i--){
            digits[i]++;
            digits[i] = digits[i] % 10;
            if(digits[i]!=0)return digits;
        }
        digits = new int[digits.length+1];
        digits[0] = 1;
        return digits;
    }
    public static int[] plusOne2(int[] digits){
        for(int i=digits.length-1;i>=0;i--){
            if(digits[i]==9){
                digits[i] = 0;
            }else{
                digits[i]++;
                return digits;
            }
        }
        digits = new int[digits.length+1];
        digits[0] = 1;
        return digits;
    }

}
