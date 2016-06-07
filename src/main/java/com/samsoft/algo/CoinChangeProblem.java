/**
 * 
 */
package com.samsoft.algo;

import java.util.Scanner;

/**
 * 
 * <p>
 * https://www.hackerrank.com/challenges/coin-change
 * 
 * <p>
 * http://www.algorithmist.com/index.php/Coin_Change
 * 
 * 
 * <p>
 * http://www.geeksforgeeks.org/dynamic-programming-set-7-coin-change/
 * 
 * 
 * @author Kumar Sambhav Jain
 *
 */
public class CoinChangeProblem {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		try (Scanner scanner = new Scanner(System.in);) {
			String[] split = scanner.nextLine().split(" ");

			int N = Integer.parseInt(split[0]);
			int m = Integer.parseInt(split[1]);
			int[] coins = new int[m];

			for (int i = 0; i < m; i++) {
				coins[i] = scanner.nextInt();
			}

			long[] table = new long[N + 1];

			table[0] = 1;
			for (int i = 0; i < m; i++)
				for (int j = coins[i]; j <= N; j++)
					table[j] += table[j - coins[i]];
			System.out.println(table[N]);
		}
	}

}
