package tao;

public class MergeSort {
	public static void main(String[] args) {
		int[] array = {10,8,6,5,9,3,1,2,3,1000,50,80};
		mergeSort(array,0,array.length-1);
		for(int i=0;i<array.length;i++)
			System.out.print(array[i]+" ");
	}
	
	public static void mergeSort(int[] array,int p,int r) {
		if(p<r) {
			int q = (p+r)/2;
			mergeSort(array,p,q);
			mergeSort(array,q+1,r);
			merge(array,p,q,r);
		}
	}
	public static void merge(int[] array,int p,int q,int r) {
		int num1 = q-p+1;
		int num2 = r-q;
		int[] left = new int[num1+1];
		int[] right = new int[num2+1];
		for(int i=0;i<num1;i++) {
			left[i] = array[p+i];
		}
		for(int j=0;j<num2;j++) {
			right[j] = array[q+1+j];
		}
		left[num1] = Integer.MAX_VALUE;
		right[num2] = Integer.MAX_VALUE;
		int k = p;
		int i = 0;
		int j = 0;
		while(k<=r) {
			if(left[i]<=right[j]){
				array[k++] = left[i];
				i++;
			}else {
				array[k++] = right[j];
				j++;
			}
		}
	}
}
