package com.mx.acm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
/**
 * 最长公共子序列
描述 
咱们就不拐弯抹角了，如题，需要你做的就是写一个程序，得出最长公共子序列。
tip：最长公共子序列也称作最长公共子串(不要求连续)，英文缩写为LCS（Longest Common Subsequence）。其定义是，一个序列 S ，如果分别是两个或多个已知序列的子序列，且是所有符合此条件序列中最长的，则 S 称为已知序列的最长公共子序列。
输入
第一行给出一个整数N(0<N<100)表示待测数据组数
接下来每组数据两行，分别为待测的两组字符串。每个字符串长度不大于1000.
输出
每组测试数据输出一个整数，表示最长公共子序列长度。每组结果占一行。

 * @author maoxin
 * 885028 ythyhvh 最长公共子序列 Accepted  350  19796 java 05-29 11:49:28 
 */
public class Test36 {
	
	 
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int total = Integer.parseInt(br.readLine());
		char [] c, d;
		String a, b;
		int i,j;
		int [][] dp;
		while(total > 0)
		{
			a = br.readLine();
			b = br.readLine();
			c = new char[a.length() + 1];
			d = new char[b.length() + 1];
			for(i = 1; i <= a.length(); i++)
				c[i] = a.charAt(i - 1);
			for(i = 1; i <= b.length(); i++)
				d[i] = b.charAt(i - 1);
			
			dp = new int[c.length + 1][d.length + 1];
			
			for(i = 1; i <= a.length(); i++)
			{
				for(j = 1; j <= b.length(); j++)
				{
					if(c[i] == d[j])
						dp[i][j] = dp[i-1][j-1] + 1;
					else
						dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
				}
			}
			
			System.out.println(dp[a.length()][b.length()]);
			total--;
		}
	}

}
