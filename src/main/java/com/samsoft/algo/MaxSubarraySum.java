/**
 * 
 */
package com.samsoft.algo;

import java.util.Scanner;
import java.util.stream.Stream;

/**
 * <p>
 * https://www.hackerrank.com/challenges/maxsubarray
 * <p>
 * Given an array of elements, find the maximum possible sum of a Contiguous
 * subarray
 * <p>
 * Non-contiguous (not necessarily contiguous) subarray.
 * <p>
 * Empty subarrays/subsequences should not be considered.
 * 
 * @author sambhav.jain
 *
 */
public class MaxSubarraySum {

	/**
	 * 
	 * @param arr
	 * @return array os size 2, 0 - contiguous, 1 - non-contiguous
	 */
	private static int[] solve(int[] arr) {
		int[] result = new int[2]; // will be initialized with 0

		result[0] = Integer.MIN_VALUE;
		int tempSum = 0;
		int globalMAx = Integer.MIN_VALUE;
		for (int i = 0; i < arr.length; i++) {

			if (arr[i] > globalMAx) {
				globalMAx = arr[i];
			}

			if (arr[i] > 0) {
				result[1] += arr[i];
			}
			////////////////////////////////////////////////////////////////////////
			tempSum = tempSum + arr[i];

			if (tempSum > result[0]) {
				result[0] = tempSum;
			}

			if (tempSum < 0) {
				tempSum = 0;
			}
			////////////////////////////////////////////////////////////////////////
		}

		if (globalMAx < 0) {
			result[0] = globalMAx;
			result[1] = globalMAx;
		}
		return result;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in);) {
			int T = scanner.nextInt();
			for (int i = 0; i < T; i++) {
				scanner.nextInt();
				scanner.nextLine();
				int[] input = Stream.of(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
				int[] result = solve(input);
				System.out.println(result[0] + " " + result[1]);
			}
		}
	}

}
