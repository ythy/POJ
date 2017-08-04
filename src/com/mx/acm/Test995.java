package com.mx.acm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Test995 {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int type, sum; 
		int[] coin;
		int i,j;
		int[] dp;
		while(true)
		{
			st = new StringTokenizer(br.readLine());
			type = Integer.parseInt(st.nextToken());
			sum = Integer.parseInt(st.nextToken());
			if(type == 0 && sum == 0)
				break;
			
			coin = new int[type + 1];
			st = new StringTokenizer(br.readLine());
			for(i = 1; i <= type; i++)
				coin[i] =  Integer.parseInt(st.nextToken());
			
			dp = new int[sum + 1];
			Arrays.fill(dp, Integer.MIN_VALUE);
			dp[0] = 0;
			
			for(i = 1; i <= type; i++)
			{
				for(j = coin[i]; j <= sum; j++)
				{
					dp[j] = Math.max(dp[j], dp[j - coin[i]] + 1); 
				}
				
			}
			
//			boolean result = false;
//			for(i = 1; i <= type; i++)
//			{
//				if(dp[sum] == dp[sum - coin[i]] - 1)
//				{
//					System.out.println(-dp[sum]);
//					result = true;
//					break;
//				}
//					
//			}
//			if(!result) 
//			{
//				Arrays.fill(dp, 0);
//				for(i = 1; i <= type; i++)
//				{
//					for(j = coin[i]; j <= sum; j++)
//					{
//						dp[j] = Math.max(dp[j], dp[j - coin[i]] - 1); 
//					}
//				}
//				System.out.println(-dp[sum]);
//			}
//			
			System.out.println(dp[sum]);
		}

	}


}
