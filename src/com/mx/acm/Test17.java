package com.mx.acm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
/**
 * 单调递增最长子序列
描述 
求一个字符串的最长递增子序列的长度
如：dabdbf最长递增子序列就是abdf，长度为4
输入
第一行一个整数0<n<20,表示有n个字符串要处理
随后的n行，每行有一个字符串，该字符串的长度不会超过10000
输出
输出字符串的最长递增子序列的长度

 * @author maoxin
 * 893559 ythyhvh 单调递增最长子序列 Accepted  729  176 java 06-10 17:25:53 
 */
public class Test17 {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int i,j,max;
		int[] dp;
		char[] input;
		
		st = new StringTokenizer(br.readLine());
		int total = Integer.parseInt(st.nextToken());
		while(total-- > 0)
		{
			input = br.readLine().toCharArray();
			dp = new int[input.length];
			max = Integer.MIN_VALUE;
			
			for(i = 0; i < input.length; i++)
			{
				dp[i] = 1;
				for(j = 0; j <= i; j++)
				{
					if(input[j] < input[i])
						dp[i] = Math.max(dp[i], dp[j] + 1);
				}
			}
			
			for(i = 0; i < input.length; i++)
			{
				if(dp[i] > max)
					max = dp[i];
			}
			System.out.println(max);
		}
	}

}
