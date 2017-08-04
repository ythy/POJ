package com.mx.acm;

import java.util.Scanner;
/**
 * 单调递增子序列(二)
描述 
给定一整型数列{a1,a2...,an}（0<n<=100000），找出单调递增最长子序列，并求出其长度。

如：1 9 10 5 11 2 13的最长单调递增子序列是1 9 10 11 13，长度为5。

输入
有多组测试数据（<=7）
每组测试数据的第一行是一个整数n表示序列中共有n个整数，随后的下一行里有n个整数，表示数列中的所有元素.每个整形数中间用空格间隔开（0<n<=100000）。
数据以EOF结束 。
输入数据保证合法（全为int型整数）！
输出
对于每组测试数据输出整形数列的最长递增子序列的长度，每个输出占一行。


 * @author maoxin
 * 888735 ythyhvh 单调递增子序列(二) Accepted  1056  8018 java 06-03 13:59:40 
 * 
 * 用动态规划 会超时
 */
public class Test214 {

	public static void main(String[] args){
		Scanner scanner = new Scanner(System.in);
		int total;
		int[] dp;
		int num, low, high, mid, top; //二分查找用
		while(scanner.hasNextInt())
		{
			total = scanner.nextInt();
			dp = new int[total + 1];
			
			top = 0;
			dp[top] = Integer.MIN_VALUE;
					
			while(total-- > 0)
			{
				num = scanner.nextInt();
				if(num > dp[top])
				{
					top++;
					dp[top] = num;
				}
				else
				{
					low = 1;
					high = top;
					while(low <= high)
					{
						mid = (low + high)/2;
						if(num > dp[mid])
							low = mid + 1;
						else
							high = mid - 1;
					}
					dp[low] = num;
				}
			}
			
			System.out.println(top);
		}
		 
	}
	
}
