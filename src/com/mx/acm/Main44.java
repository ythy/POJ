package com.mx.acm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main44 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new  InputStreamReader(System.in));
		StringTokenizer st;
		int total = Integer.parseInt(br.readLine());
		int inputsum, line, result;
		int[] dp;
		while(total-- > 0)
		{
			inputsum = Integer.parseInt(br.readLine());
			dp = new int[inputsum + 1];
			result = Integer.MIN_VALUE;
			st = new StringTokenizer(br.readLine());
			for(int i = 1; i <= inputsum; i++)
			{
				line = Integer.parseInt(st.nextToken());
				dp[i] = Math.max(line, dp[i - 1] + line);
				result = Math.max(dp[i], result);
			}
			System.out.println(result);
		}

	}

}
