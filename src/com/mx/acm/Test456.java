package com.mx.acm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
/**
 * 邮票分你一半
描述 
     小珂最近收集了些邮票，他想把其中的一些给他的好朋友小明。每张邮票上都有分值，他们想把这些邮票分成两份，并且使这两份邮票的分值和相差最小（就是小珂得到的邮票分值和与小明的差值最小），现在每张邮票的分值已经知道了，他们已经分好了，你知道最后他们得到的邮票分值和相差多少吗？
输入
第一行只有一个整数m（m<=1000),表示测试数据组数。
接下来有一个整数n(n<=1000)，表示邮票的张数。
然后有n个整数Vi(Vi<=100)，表示第i张邮票的分值。
输出
输出差值，每组输出占一行

 * @author maoxin
 * 893481 ythyhvh 邮票分你一半 Accepted  273  1456 java 06-10 14:58:17 
 */
public class Test456 {

public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int type,totolWorth, halfWorth; //种类
		int i,j;
		int[] worth; //分值
		int[] dp;
		
		st = new StringTokenizer(br.readLine());
		int total = Integer.parseInt(st.nextToken());
		while(total-- > 0)
		{
			st = new StringTokenizer(br.readLine());
			type = Integer.parseInt(st.nextToken());
			worth = new int[type + 1]; 
			totolWorth = 0;
			st = new StringTokenizer(br.readLine());
			for(i = 1; i <= type; i++)
			{
				worth[i] = Integer.parseInt(st.nextToken());
				totolWorth += worth[i];
			}
			halfWorth = totolWorth/2;
			
			dp = new int[halfWorth + 10];
			for(i = 1; i <= type; i++)
			{
				for(j = halfWorth; j >= worth[i]; j--)
					dp[j] = Math.max(dp[j], dp[j - worth[i]] + worth[i]);
			}
			
			System.out.println(totolWorth - 2*dp[halfWorth] );
		}
		
		
	}

}
