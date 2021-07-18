import java.util.Arrays;

public class MergeSort{
	
	public static int[] sort(int[] arr1, int[] arr2) {
    	int mSorted[] = new int[arr1.length+arr2.length];
    	int i = 0; 
    	int j = 0; 
    	int k = 0;
    	while(i < arr1.length && j < arr2.length) {
    		if(arr1[i] < arr2[j]) {
    			mSorted[k] = arr1[i];
    			k++; i++;
    		}else {
    			mSorted[k] = arr2[j];
    			k++; j++;
    			}
    		}
    	while(i < arr1.length) {
    		mSorted[k] = arr1[i];
    		k++; i++;
    	}
    	while(j < arr2.length) {
    		mSorted[k] = arr2[j];
    		k++; j++;
    	}
    	return mSorted;
    }
	
	public static void main(String[] args) {
		int[] a = new int[]{1,3,6,8,9,10,14,17};
		int[] b = new int[]{2,4,5,11,12,15,21};
        System.out.println(Arrays.toString(sort(a,b)));
	}
}