/**
 * Created by Administrator on 2016/6/16.
 */
public class GreatestSumOfSubArray {
    public int findGreatestSumOfSubArray(int[] array) {
        if(array.length==0) return 0;
        int sum = 0;
        int greatestSum = Integer.MIN_VALUE;
        for(int i=0;i<array.length;i++) {
            if(sum<=0) {
                sum = array[i];
            }else {
                sum += array[i];
            }
            if(greatestSum < sum) {
                greatestSum = sum;
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        int[] array = {1,-2,3,10,-4,7,2,-5};
        GreatestSumOfSubArray sum = new GreatestSumOfSubArray();
        System.out.println(sum.findGreatestSumOfSubArray(array));
    }
}

