package com.mx.acm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
/**
 * 完全背包
描述 
直接说题意，完全背包定义有N种物品和一个容量为V的背包，每种物品都有无限件可用。第i种物品的体积是c，价值是w。求解将哪些物品装入背包可使这些物品的体积总和不超过背包容量，且价值总和最大。本题要求是背包恰好装满背包时，求出最大价值总和是多少。如果不能恰好装满背包，输出NO

输入
第一行： N 表示有多少组测试数据（N<7）。 
接下来每组测试数据的第一行有两个整数M，V。 M表示物品种类的数目，V表示背包的总容量。(0<M<=2000，0<V<=50000)
接下来的M行每行有两个整数c，w分别表示每种物品的重量和价值(0<c<100000，0<w<100000)
输出
对应每组测试数据输出结果（如果能恰好装满背包，输出装满背包时背包内物品的最大价值总和。 如果不能恰好装满背包，输出NO）

 * @author maoxin
 * 893463 ythyhvh 完全背包 Accepted  906  2575 java 06-10 13:55:37 
 */
public class Test311 {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int type; //种类
		int volume; //总容量
		int i,j;
		int[] w, v; //重量 、价钱
		int[] dp;
		
		st = new StringTokenizer(br.readLine());
		int total = Integer.parseInt(st.nextToken());
		while(total-- > 0)
		{
			st = new StringTokenizer(br.readLine());
			type = Integer.parseInt(st.nextToken());
			volume = Integer.parseInt(st.nextToken());
			 
			v = new int[type + 1];
			w = new int[type + 1];
			dp = new int[volume + 1];
			Arrays.fill(dp, Integer.MIN_VALUE);
			dp[0] = 0;
			
			for(i = 1; i <= type; i++)
			{
				st = new StringTokenizer(br.readLine());
				w[i] = Integer.parseInt(st.nextToken());
				v[i] = Integer.parseInt(st.nextToken());
			}
			
			for(i = 1; i <= type; i++)
			{
				for(j = w[i]; j <= volume; j++)
				{
					dp[j] = Math.max(dp[j], dp[j - w[i]] + v[i]);
				}
			}
			
			System.out.println(dp[volume] <= 0 ? "NO" : dp[volume]);
		}
		
		
	}

}
