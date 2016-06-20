package tao;

public class QuickSort {
    public static void quickSort(int[] arr,int p,int r) {
        if(arr.length==0) {
            return;
        }
        if(p<r) {
            int q = partition(arr,p,r);
            quickSort(arr,p,q-1);
            quickSort(arr,q+1,r);
        }
    }
    public static int partition(int[] arr,int p,int r){
        if(arr.length==0) return 0;
        int x = arr[r];
        int i=p-1;
        for(int j=p;j<=r-1;j++) {
            if(arr[j]<=x) {
                i=i+1;
                swap(arr,i,j);            
            }
        }
        swap(arr,i+1,r);
        
        return i+1;
    }
    
    public static void swap(int[] arr,int a,int b) {
        int tmp = arr[a];
        arr[a] = arr[b];
        arr[b] = tmp;
    }
    public static void main(String[] args) {
    	int[] array = {10,8,6,5,9,3,1,2,3,1000,5000,80};
		quickSort(array,0,array.length-1);
		for(int i=0;i<array.length;i++)
			System.out.print(array[i]+" ");
    }
}
