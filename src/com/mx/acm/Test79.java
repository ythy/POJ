package com.mx.acm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
/**
 * 拦截导弹
描述 
某国为了防御敌国的导弹袭击，发展中一种导弹拦截系统。但是这种导弹拦截系统有一个缺陷：虽然它的第一发炮弹能够到达任意的高度，但是以后每一发炮弹都不能高于等于前一发的高度。某天，雷达捕捉到敌国导弹来袭。由于该系统还在试用阶段，所以只用一套系统，因此有可能不能拦截所有的导弹。

输入
第一行输入测试数据组数N（1<=N<=10）
接下来一行输入这组测试数据共有多少个导弹m（1<=m<=20）
接下来行输入导弹依次飞来的高度，所有高度值均是大于0的正整数。

输出
输出最多能拦截的导弹数目


 * @author maoxin
 * 884122 ythyhvh 拦截导弹 Accepted  1  61 java 05-28 13:10:45 
 */
public class Test79 {

	private static int [] dp;
	private static int [] f;
	public static void main1(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int total = Integer.parseInt(br.readLine());
		int input;
		int i,j,max;
		while(total > 0)
		{
			input = Integer.parseInt(br.readLine());
			f = new int[input + 1];
			st = new StringTokenizer(br.readLine());
			dp = new int[input + 1];
			max = Integer.MIN_VALUE;
			
			for(i = 1; i <= input; i++)
			{
				f[i] = Integer.parseInt(st.nextToken());
			}
			
			for(i = 1; i <= input; i++)
			{
				dp[i] = 1;
				for(j = 1; j <= i; j++)
				{
					if(f[j] > f[i]) 
						dp[i] = Math.max(dp[i], dp[j] + 1);
				}
			} 
			
			
			for(i = 1; i <= input; i++)
			{
				if(dp[i] > max)
					max = dp[i];
				 
			} 
			
			System.out.println(max);
			
			total--;
		}
	}
	
	//888850 ythyhvh 拦截导弹 Accepted  13  61 java 06-03 17:09:27 
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int total = Integer.parseInt(br.readLine());
		int input,num,top,mid,low,high;
		int[] stack;
		while(total-- > 0)
		{
			input = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine());
			stack = new int[input + 1];
			top = 0;
			stack[0] = Integer.MAX_VALUE;
			
			while(input-- > 0)
			{
				num = Integer.parseInt(st.nextToken());
				if(num < stack[top])
				{
					top++;
					stack[top] = num;
				}
				else
				{
					low = 1;
					high = top;
					while(low <= high)
					{
						mid = (low + high)/2;
						if(num < stack[mid])
							low = mid + 1;
						else
							high = mid - 1;
					}
					stack[low] = num;
				}
			
			}
			
			System.out.println(top);
		}
	}

}
