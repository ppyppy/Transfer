//There are two sorted arrays A and B of size m and n respectively. 
//Find the median of the two sorted arrays. The overall run time complexity should be O(log (m+n)).

public class Solution {
 public double findMedianSortedArrays(int A[], int B[]) {
	if(A==null && B==null)
		throw new RuntimeException();
	int length = A.length + B.length;
    if( (length&1)>0 ){
        return findKth(A, A.length, B, B.length, length/2+1);
    }else{
        return (findKth(A, A.length, B, B.length, length/2) + findKth(A, A.length, B, B.length, length/2+1))/2.0;
    }
 }

 public double findKth(int[] A, int la, int[] B, int lb, int k){
	if(la>lb){
	    return findKth(B, lb, A, la, k);
	}else if(la==0){
	    return B[k-1];
	}else if(k==1){
	    return Math.min(A[0], B[0]);
	}else{
	    int pa = Math.min(k/2, la);
	    int pb = k-pa;
	    if(A[pa-1]<B[pb-1]){
	        return findKth(Arrays.copyOfRange(A, pa, la), la-pa, B, lb, k-pa);
	    }else if(A[pa-1]>B[pb-1]){
	        return findKth(A, la, Arrays.copyOfRange(B, pb, lb), lb-pb, k-pb);
	    }else{
	        return A[pa-1];
	    }
	}
 }
}