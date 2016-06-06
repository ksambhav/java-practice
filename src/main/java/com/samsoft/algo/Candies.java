/**
 * 
 */
package com.samsoft.algo;

import java.util.Arrays;
import java.util.Scanner;

/**
 * <p>
 * Alice is a kindergarden teacher. She wants to give some candies to the
 * children in her class. All the children sit in a line ( their positions are
 * fixed), and each of them has a rating score according to his or her
 * performance in the class. Alice wants to give at least 1 candy to each child.
 * If two children sit next to each other, then the one with the higher rating
 * must get more candies. Alice wants to save money, so she needs to minimize
 * the total number of candies given to the children.
 * <p>
 * https://www.hackerrank.com/challenges/candies
 * 
 * @author sambhav.jain
 *
 */
public class Candies {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		try (Scanner scanner = new Scanner(System.in);) {
			int N = scanner.nextInt();
			long[] rating = new long[N];
			long[] candies = new long[N];
			for (int i = 0; i < N; i++) {
				rating[i] = scanner.nextInt();
				//candies[i] = 1;
			}

			for (int i = 1; i < N; i++) {
				if (rating[i] > rating[i - 1]) {
					candies[i] = candies[i - 1] + 1;
				}
			}

			for (int i = N - 2; i >= 0; i--) {
				if (rating[i] > rating[i + 1]) {
					candies[i] = candies[i] > candies[i + 1] + 1 ? candies[i] : candies[i + 1] + 1;
				}
			}

			System.out.println(Arrays.stream(candies).sum() + N);
		}
	}

}
