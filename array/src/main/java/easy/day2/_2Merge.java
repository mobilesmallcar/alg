package easy.day2;

import java.util.Arrays;

public class _2Merge {
    public static void main(String[] args){
        merge2(new int[]{1,2,3,0,0,0},3,new int[]{2,5,6},3);
    }
    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int p1 = m-1,p2 = n-1;
        int length = nums1.length;
        int cur = 0;
        while(p1>0||p2>0){
            if(p1==0){
                cur = nums2[p2--];
            }else if(p1==0){
                cur = nums1[p1--];
            }else if(nums2[p2]>nums1[p1]){
                cur = nums2[p2--];
            }else{
                cur = nums1[p1--];
            }
            nums1[--length] = cur;
        }
        System.out.println(Arrays.toString(nums1));




    }
    public static void merge2(int[] nums1, int m, int[] nums2, int n) {
        int p1=m-1,p2=n-1;
        for(int i=nums1.length-1;i>=0;i--){
            if(p1<0){
                nums1[i] = nums2[p2--];
            }else if(p2<0){
                nums1[i] = nums1[p1--];
            }else if(nums1[p1]>nums2[p2]){
                nums1[i] = nums1[p1--];
            }else{
                nums1[i] = nums2[p2--];
            }
        }
        System.out.println(Arrays.toString(nums1));
    }
}
