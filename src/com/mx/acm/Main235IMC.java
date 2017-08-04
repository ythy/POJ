package com.mx.acm;

public class Main235IMC {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		int[] weight = {5, 8, 13, 27, 14};
		int total = 5;
		int sum = 0, half, j, i;
		
		for(i = 0; i < total; ++i)
			sum += weight[i];
		half = sum/2;
		int[] dp = new int[half + 1];
		for(i = 0; i < total; ++i)
			for(j = half; j >= weight[i]; --j)
				dp[j] = Math.max(dp[j - weight[i]] + weight[i], dp[j]);
		
		System.out.println(sum - 2 * dp[half]);

	}

}
