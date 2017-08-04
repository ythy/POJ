package com.mx.acm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
 
public class Test132 {

	static String[] specStr = {""};
	
	public static void main2(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int total = Integer.parseInt(br.readLine());
		String input;
		char[] positiveAc, negativeAc;
		int i,j,length;
		int[][] dp;
		while(total-- > 0)
		{
			input = br.readLine();
			length = input.length();
			positiveAc = new char[length + 1];
			negativeAc = new char[length + 1];
			dp = new int[length + 1][length + 1];
			
			for(i = 1; i <= length; i++)
			{
				positiveAc[i] = input.charAt(i - 1);
				negativeAc[i] = input.charAt(length - i);
			}
			
			StringBuffer result = new StringBuffer();
			
			for(i = 1; i <= length; i++)
			{
				for(j = 1; j <= length; j++)
				{
					if(positiveAc[i] == negativeAc[j])
						dp[i][j] = dp[i - 1][j - 1] + 1;
					else
						dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
				}
			}
			
			System.out.println(length - dp[length][length]);
		}

	}
	
	//894072 ythyhvh 回文字符串 Accepted  372  16249 java 06-11 16:41:43   动归
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int total = Integer.parseInt(br.readLine());
		String input;
		char[] positiveAc;
		int i,j,p,length;
		int[][] dp;
		while(total-- > 0)
		{
			input = br.readLine();
			length = input.length();
			positiveAc = new char[length + 1];
			dp = new int[length + 1][length + 1];
			
			for(i = 1; i <= length; i++)
			{
				positiveAc[i] = input.charAt(i - 1);
			}
				
			for(i = 1; i <= length; i++)
			{
				for(j = 1; j <= length - i; j++)
				{
					p = i + j ;
					if(positiveAc[j] == positiveAc[p])
						dp[j][p] = dp[j + 1][p - 1];
					else
						dp[j][p] = Math.min(dp[j + 1][p], dp[j][p - 1]) + 1;
					 
				}
			}
			
			System.out.println(dp[1][length]);
		}

	}
	

}
