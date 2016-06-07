/**
 * 
 */
package com.samsoft.algo;

import java.util.Scanner;
import java.util.stream.IntStream;
import java.util.stream.LongStream;

/**
 * 
 * 
 * 
 * <p>
 * https://www.hackerrank.com/challenges/longest-increasing-subsequent
 * 
 * @author Kumar Sambhav Jain
 *
 */
public class LongestIncreasinSubSeq {

	public static long lis(long[] input) {
		int N = input.length;
		long[] lis = new long[N];

		for (int i = 1; i < N; i++) {
			for (int j = 0; j < i; j++) {
				if (input[i] > input[j] && lis[i] < lis[j] + 1) {
					 lis[i] = lis[j] + 1;
				}
			}
		}

		return LongStream.of(lis).max().getAsLong() + 1;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in);) {
			int N = scanner.nextInt();
			long[] input = new long[N];
			IntStream.range(0, N).forEach(i -> input[i] = scanner.nextInt());
			System.out.println(lis(input));
		}

	}

}
