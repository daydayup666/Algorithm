/**
 * Created by Administrator on 2016/6/14.
 */
public class MergeSortRev {
    public static void mergeSort(int[] arr) {
        int len = arr.length;
        int[] result = new int[len];
        int block, start;

        for(block = 1; block < len ; block *= 2) {
            for(start = 0; start <len; start += 2 * block) {
                int low = start;
                int mid = (start + block) < len ? (start + block) : len;
                int high = (start + 2 * block) < len ? (start + 2 * block) : len;
                //两个块的起始下标及结束下标
                int start1 = low, end1 = mid;
                int start2 = mid, end2 = high;
                //开始对两个block进行归并排序
                while (start1 < end1 && start2 < end2) {
                    result[low++] = arr[start1] < arr[start2] ? arr[start1++] : arr[start2++];
                }
                while(start1 < end1) {
                    result[low++] = arr[start1++];
                }
                while(start2 < end2) {
                    result[low++] = arr[start2++];
                }
            }
            int[] temp = arr;
            arr = result;
            result = temp;
            for(int i=0;i<arr.length;i++) {
                System.out.print(arr[i]+"\t");
            }
            System.out.println();
        }
        result = arr;

    }

    public static void main(String[] args) {
        int[] array = {49,38,65,97,76,13,27,49,78,34,12,64,5,4,62,99,98,54,56,17,18,23,34,15,35,25,53};
        mergeSort(array);
        for(int i=0;i<array.length;i++) {
            System.out.print(array[i]+"\t");
        }
    }
}
