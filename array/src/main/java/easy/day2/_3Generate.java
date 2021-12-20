package easy.day2;

import java.util.ArrayList;
import java.util.List;

public class _3Generate {
    public static void main(String[] args){
//        generate(10);
        generate2(10);
    }
    public static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> list = new ArrayList<>();
        List<Integer> list1 = null;
//        list1.add(1);
        for(int i=1;i<=numRows;i++){
            list1 = new ArrayList<>();
            for(int j=1;j<=i;j++){
                if(i<=2){
                    list1.add(1);
                }else{
                    if(j==1||j==i){
                        list1.add(1);
                    }else{
                        list1.add(list.get(list.size()-1).get(j-2)+list.get(list.size()-1).get(j-1));
                    }
                }
            }
            list.add(list1);
        }
        list.stream().forEach(System.out::println);
        return list;
    }
    public static List<List<Integer>> generate2(int numRows) {
        List<List<Integer>> list = new ArrayList<>();
        List<Integer> list1 = null;
//        list1.add(1);
        for(int i=0;i<numRows;i++){
            list1 = new ArrayList<>();
            for(int j=0;j<=i;j++){
                if(i<=1){
                    list1.add(1);
                }else{
                    if(j==0||j==i){
                        list1.add(1);
                    }else{
                        list1.add(list.get(list.size()-1).get(j-1)+list.get(list.size()-1).get(j));
                    }
                }
            }
            list.add(list1);
        }
        list.stream().forEach(System.out::println);
        return list;
    }
}
