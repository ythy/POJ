package com.mx.acm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
/**
 * 苹果
描述 
ctest有n个苹果，要将它放入容量为v的背包。给出第i个苹果的大小和价钱，求出能放入背包的苹果的总价钱最大值。

输入
有多组测试数据，每组测试数据第一行为2个正整数，分别代表苹果的个数n和背包的容量v，n、v同时为0时结束测试，此时不输出。接下来的n行，每行2个正整数，用空格隔开，分别代表苹果的大小c和价钱w。所有输入数字的范围大于等于0，小于等于1000。
输出
对每组测试数据输出一个整数，代表能放入背包的苹果的总价值。

 * @author maoxin
 * 883070 ythyhvh 苹果 Accepted  273  1030 java 05-27 10:51:10 
 * 893870 ythyhvh 苹果 Accepted  343  1092 java 06-11 09:29:40  当前版本 去掉asm计数
 */
public class Test289 {
 
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int total; //苹果总数
		int volume; //背包总容量
		int i,j;
		int[] v, w; //苹果大小 、价钱
		int[] dp;
		while(true)
		{
			st = new StringTokenizer(br.readLine());
			total = Integer.parseInt(st.nextToken());
			volume = Integer.parseInt(st.nextToken());
			if(total == 0 && volume == 0)
				break;
			v = new int[total + 1];
			w = new int[total + 1];
			dp = new int[volume + 1];
			
			for(i = 1; i <= total; i++)
			{
				st = new StringTokenizer(br.readLine());
				v[i] = Integer.parseInt(st.nextToken());
				w[i] = Integer.parseInt(st.nextToken());
			}
			
			for(i = 1; i <= total; i++)
			{
				for(j = volume; j >= v[i]; j--)
				{
					dp[j] = Math.max(dp[j], dp[j - v[i]] + w[i]);
				}
			}
			
			System.out.println(dp[volume]);
		}
		
		
	}

}
