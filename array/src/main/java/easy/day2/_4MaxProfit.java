package easy.day2;


//输入：[7,1,5,3,6,4]
//输出：5
//解释：在第 2 天（股票价格 = 1）的时候买入，在第 5 天（股票价格 = 6）的时候卖出，最大利润 = 6-1 = 5 。
//
//序号--->>121
public class _4MaxProfit {
    public static void main(String[] args){
        System.out.println(maxProfit2(new int[]{7,1,5,3,6,4}));
        System.out.println(maxProfit2(new int[]{1,2,3,4,5}));
        System.out.println(maxProfit2(new int[]{7,6,4,3,1}));
        System.out.println(maxProfit2(new int[]{2,1,2,0,1}));
    }
    public static int maxProfit(int[] prices) {
        int min = Integer.MAX_VALUE;
        int max = 0;
        int sum = 0;
        for(int i=0;i<prices.length;i++){
            if(prices[i]<min&&max==0){
                min = prices[i];
            }else if(prices[i]-min>max){
                max = prices[i]-min;
            }else if(prices[i]-min<max){
                sum += max;
                i--;
                max = 0;
                min = Integer.MAX_VALUE;
            }
        }
        sum += max;
        return sum;
    }
    public static int maxProfit2(int[] prices){
        int min = Integer.MAX_VALUE;
        int max = 0;
        for(int i=0;i<prices.length;i++){
            if(prices[i]<min){
                min = prices[i];
            }else if(prices[i]-min>max){
                max = prices[i]-min;
            }
        }
        return max;
    }
}
