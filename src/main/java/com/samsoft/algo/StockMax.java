/**
 * 
 */
package com.samsoft.algo;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * 
 * <p>
 * https://www.hackerrank.com/challenges/stockmax
 * 
 * 
 * <p>
 * Your algorithms have become so good at predicting the market that you now
 * know what the share price of Wooden Orange Toothpicks Inc. (WOT) will be for
 * the next N days.
 * 
 * Each day, you can either buy one share of WOT, sell any number of shares of
 * WOT that you own, or not make any transaction at all. What is the maximum
 * profit you can obtain with an optimum trading strategy?
 * 
 * @author sambhav.jain
 *
 */
public class StockMax {

	/**
	 * 
	 * 
	 * 10 12 14 9 7 100
	 * 
	 * @param args
	 */
	public static void main(String[] args) {

		try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {

			int T = Integer.parseInt(br.readLine());
			for (int t = 0; t < T; t++) {
				Integer.parseInt(br.readLine());
				int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

				int maxPrice = 0;
				long profit = 0;

				int pi = 0;
				for (int i = input.length - 1; i >= 0; i--) {
					pi = input[i];
					maxPrice = Integer.max(maxPrice, pi);
					if (pi < maxPrice) {
						profit += maxPrice - pi;
					}
				}

				System.out.println(profit);
			}

		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

}
