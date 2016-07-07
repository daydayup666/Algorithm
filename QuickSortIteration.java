import java.util.*;

public class QuickSortIteration {
    public static void quickSort(int[] array) {
        if(array.length==0)
            return;
        Range[] range = new Range[array.length];

        int p=0;
        range[p++] = newRange(0,array.length-1);
        while(p != 0) {
            Range r = range[--p];
            int left = r.start;
            int right = r.end-1;
            if(r.start>=r.end)
                continue;
            int mid = array[r.end];

            while(left<right) {
                while(array[left] <= mid && left<right)
                    left++;
                while(array[right] >= mid && left<right)
                    right--;
                swap(array,left,right);
            }
            if(array[left]>mid)
                swap(array,left,r.end);
            else
                left++;
            range[p++] = newRange(r.start,left-1);
            range[p++] = newRange(left+1,r.end);
        }

    }

    public static Range newRange(int start,int end) {
        Range range = new Range();
        range.start = start;
        range.end = end;
        return range;
    }
    public static void swap(int[] array,int a,int b) {
        int temp = array[a];
        array[a] = array[b];
        array[b] = temp;
    }
    public static void main(String[] args) {
        int[] array = {};
        quickSort(array);
        for(int i=0;i<array.length;i++) {
            System.out.print(array[i]+" ");
        }
    }
}
class Range {
    int start;
    int end;
}