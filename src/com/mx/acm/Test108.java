package com.mx.acm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
/**
 * 士兵杀敌（一）
 * 描述 
南将军手下有N个士兵，分别编号1到N，这些士兵的杀敌数都是已知的。

小工是南将军手下的军师，南将军现在想知道第m号到第n号士兵的总杀敌数，请你帮助小工来回答南将军吧。

注意，南将军可能会问很多次问题。

输入只有一组测试数据
 第一行是两个整数N,M，其中N表示士兵的个数(1<N<1000000)，M表示南将军询问的次数(1<M<100000)
随后的一行是N个整数，ai表示第i号士兵杀敌数目。(0<=ai<=100)
随后的M行每行有两个整数m,n，表示南将军想知道第m号到第n号士兵的总杀敌数（1<=m,n<=N)。
输出对于每一个询问，输出总杀敌数
 每个输出占一行
 
 
 * @author maoxin
 * 960366 ythyhvh 士兵杀敌（一） Accepted  542  14303 java 08-25 10:29:03 
 */
public class Test108 {

	 
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new  InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int i, from, to;
		int[] result = new int[m];
		int[] soldierKills = new int[n + 1];
		st = new StringTokenizer(br.readLine());
		for(i = 1; i <= n; i++)
			soldierKills[i] = soldierKills[i - 1] + Integer.parseInt(st.nextToken());
		for(i = 0; i < m; i++)
		{
			st = new StringTokenizer(br.readLine());
			from = Integer.parseInt(st.nextToken());
			to = Integer.parseInt(st.nextToken());
			result[i] = soldierKills[to] - soldierKills[from - 1];
		}	
		
		for(i = 0; i < m; i++)
			System.out.println(result[i]);
	}

}
