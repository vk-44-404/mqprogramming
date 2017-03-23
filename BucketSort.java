package practice;

import java.util.Arrays;

public class BucketSort {
	// Given input array of A[0...maxValue], bucketSortAsc will
	// sort the array in ascending order.
	// Excessive commenting of code is their for future revision purposes

	public static void bucketSortAsc(int[] A, int maxValue) {
		if (A == null || A.length == 0) {
			return;
		}

		// bucket created with size [maxValue + 1], A[0...10] = 11 values.
		int[] bucket = new int[maxValue + 1];
		
		int initialCount = 0; 

		// set all buckets to value of 0
		for (int i = 0; i < bucket.length; i++) {
			bucket[i] = initialCount;
		}
		
		//array showing arrangement of buckets
		System.out.println("Buckets created, and empty:  " + Arrays.toString(bucket));
		
		// consider: i = 0, int[] A = {2, 4, 1, 3} - therefore, int x = A[i] = 2 if i = 0. 
		// this loop adds a counter to the the bucket containing the
		// corresponding array value. 
		for (int i = 0; i < A.length; i++) {
			int x = A[i]; // if int x = 2
			bucket[x]++; // then a counter is added to bucket[2],
			// meaning bucket[] will look like {0, 0, 1, 0} 
		}

		System.out.println("Buckets successfully filled:  " + Arrays.toString(bucket));
	
		//cycles through bucket, overwriting values of array A
		for (int i = 0; i < bucket.length; i++) {
			for (int k = 0; k < bucket[i]; k++) {
				A[initialCount++] = i;
			}
		}
	}

	public static void main(String[] args) {
		int maxValue = 5; // represents highest integer found in integer array
		// i.e. {0, 1, 2, 3....maxValue}
		int[] A = {0, 5, 2, 1, 4, 4, 3, 2, 1 ,2 ,3, 4};
		System.out.println("Array is not sorted: " + Arrays.toString(A));
		bucketSortAsc(A, maxValue);
		System.out.println("Bucket Sort complete: " + Arrays.toString(A));
	}
}
