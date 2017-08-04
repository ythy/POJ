package com.mx.acm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
/**
 * 士兵杀敌（三）
 * 描述 
南将军统率着N个士兵，士兵分别编号为1~N,南将军经常爱拿某一段编号内杀敌数最高的人与杀敌数最低的人进行比较，计算出两个人的杀敌数差值，用这种方法一方面能鼓舞杀敌数高的人，另一方面也算是批评杀敌数低的人，起到了很好的效果。

所以，南将军经常问军师小工第i号士兵到第j号士兵中，杀敌数最高的人与杀敌数最低的人之间军功差值是多少。

现在，请你写一个程序，帮小工回答南将军每次的询问吧。

注意，南将军可能询问很多次。

输入只有一组测试数据
 第一行是两个整数N,Q，其中N表示士兵的总数。Q表示南将军询问的次数。(1<N<=100000,1<Q<=1000000)
随后的一行有N个整数Vi(0<=Vi<100000000)，分别表示每个人的杀敌数。
 再之后的Q行，每行有两个正正数m,n，表示南将军询问的是第m号士兵到第n号士兵。输出对于每次询问，输出第m号士兵到第n号士兵之间所有士兵杀敌数的最大值与最小值的差。
 
 * @author maoxin
 * 960584 ythyhvh 士兵杀敌（三） Accepted  2212  9140 java 08-25 15:55:06 
 * 
 * RMQ----ST算法
 */
public class Test119 {
	
	static int MAX = 100010;
	static int[][] maxsum = new int[MAX][20];
	static int[][] minsum = new int[MAX][20];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new  InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int i, from, to, k, max, min;
		int[] result = new int[m];
		st = new StringTokenizer(br.readLine());
		for(i = 1; i <= n; i++)
		{
			maxsum[i][0] = minsum[i][0] = Integer.parseInt(st.nextToken());
		}
		dp(n);
		for(i = 0; i < m; i++)
		{
			st = new StringTokenizer(br.readLine());
			from = Integer.parseInt(st.nextToken());
			to = Integer.parseInt(st.nextToken());
			k = (int) (Math.log(to - from + 1)/Math.log(2.0));
			max = Math.max(maxsum[from][k], maxsum[to - (1 << k) + 1][k]);
			min = Math.min(minsum[from][k], minsum[to - (1 << k) + 1][k]);
			result[i] = max - min;
		}	
				
		for(i = 0; i < m; i++)
			System.out.println(result[i]);
	}
	
	
	static void dp(int num)
	{
		for(int j = 1; j < 20; j++)
		{
			for(int i = 1; i <= num; i++)
			{
				if(i + (1 << j) - 1 <= num)
				{
					maxsum[i][j] = Math.max(maxsum[i][j - 1], maxsum[i + (1 << (j - 1))][j - 1]);
					minsum[i][j] = Math.min(minsum[i][j - 1], minsum[i + (1 << (j - 1))][j - 1]);
				}
			}
		}

	}
	
	

}
        