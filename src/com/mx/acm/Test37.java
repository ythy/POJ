package com.mx.acm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
/**
 * 回文字符串
描述 
所谓回文字符串，就是一个字符串，从左到右读和从右到左读是完全一样的，比如"aba"。当然，我们给你的问题不会再简单到判断一个字符串是不是回文字符串。现在要求你，给你一个字符串，可在任意位置添加字符，最少再添加几个字符，可以使这个字符串成为回文字符串。
输入
第一行给出整数N（0<N<100）
接下来的N行，每行一个字符串，每个字符串长度不超过1000.
输出
每行输出所需添加的最少字符数

 * @author maoxin
 * 893978 ythyhvh 回文字符串 Accepted  434  14982 java 06-11 13:18:49 
 */
public class Test37 {

	 
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
