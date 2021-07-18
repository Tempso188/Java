//Given two sorted arrays nums1 and nums2 of size m and n respectively, return the median of the two sorted arrays.
public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int result[] = new int[nums1.length+nums2.length];
        int i = 0;
        int j = 0;
        int k = 0;
        while(i < nums1.length && j < nums2.length){
            if(nums1[i] < nums2[j]){
                result[k++] = nums1[i++];
            }else{
                result[k++] = nums2[j++];
            }
        }
        while(i < nums1.length){
            result[k++] = nums1[i++];
            }
        while(j < nums2.length){
            result[k++] = nums2[j++];
        }
        return arrMedian(result);
        }
    
    public double arrMedian(int[] arr){
        double ans = 0;
        int n = arr.length;
        if(arr.length%2 == 1){
            ans = (double) arr[(n+1) / 2 - 1];
        }else{
            ans = (double)(arr[n/2-1]+arr[n/2])/2;
        }
        return ans;
    }