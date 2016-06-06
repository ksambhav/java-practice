/**
 * 
 */
package com.samsoft.algo;

/**
 * 
 * 
 * <p>
 * http://www.geeksforgeeks.org/maximum-difference-between-two-elements/
 * 
 * @author sambhav.jain
 *
 */
public class SingleStockMax {

	public static int maxDiff(int[] input) {
		if (input.length < 2) {
			return input[0];
		} else {
			int maxDiff = input[1] - input[0];

			int min = input[0];

			for (int i = 0; i < input.length; i++) {
				if (input[i] - min > maxDiff) {
					maxDiff = input[i] - min;
				}
				if (input[i] < min) {
					min = input[i];
				}
			}

			return maxDiff;
		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int arr[] = { 80, 2, 6, 3, 100 };
		System.out.println(maxDiff(arr));
	}

}
