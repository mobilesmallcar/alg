package easy.day2;

public class _42MaxProfit {
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
                min = prices[i];
                sum += max;
                max = 0;
            }

        }
        sum += max;
    return sum;
    }
    public static int maxProfit2(int[] prices){
        int min = Integer.MAX_VALUE;
        int max = 0;
        int sum = 0;
        for(int i=0;i<prices.length;i++){
            if(prices[i]<min&&max==0){
                min = prices[i];
            }else if(prices[i]-min>max){
                max = prices[i]-min;
            }else if(prices[i]-min<max){
                min = prices[i];
                sum += max;
                max = 0;
            }
        }
        sum += max;
        return sum;
    }
}
