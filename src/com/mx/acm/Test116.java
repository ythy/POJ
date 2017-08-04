package com.mx.acm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
/**
 * 士兵杀敌（二）
 * 
 * 描述 
南将军手下有N个士兵，分别编号1到N，这些士兵的杀敌数都是已知的。

小工是南将军手下的军师，南将军经常想知道第m号到第n号士兵的总杀敌数，请你帮助小工来回答南将军吧。

南将军的某次询问之后士兵i可能又杀敌q人，之后南将军再询问的时候，需要考虑到新增的杀敌数。


输入只有一组测试数据
 第一行是两个整数N,M，其中N表示士兵的个数(1<N<1000000)，M表示指令的条数。(1<M<100000)
随后的一行是N个整数，ai表示第i号士兵杀敌数目。(0<=ai<=100)
随后的M行每行是一条指令，这条指令包含了一个字符串和两个整数，首先是一个字符串，如果是字符串QUERY则表示南将军进行了查询操作，后面的两个整数m,n，表示查询的起始与终止士兵编号；如果是字符串ADD则后面跟的两个整数I,A(1<=I<=N,1<=A<=100),表示第I个士兵新增杀敌数为A.
输出对于每次查询，输出一个整数R表示第m号士兵到第n号士兵的总杀敌数，每组输出占一行

 * @author maoxin
 * 960379 ythyhvh 士兵杀敌（二） Accepted  895  16445 java 08-25 10:51:32 
 */
public class Test116 {

	static String QUERY = "QUERY";
	static String ADD = "ADD";
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new  InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int i, temp, from, to;
		List<Integer> result = new ArrayList<Integer>();
		int[] soldierKills = new int[n + 1];
		String order;
		st = new StringTokenizer(br.readLine());
		for(i = 1; i <= n; i++)
			soldierKills[i] = Integer.parseInt(st.nextToken());
		for(i = 0; i < m; i++)
		{
			temp = 0;
			st = new StringTokenizer(br.readLine());
			order = st.nextToken();
			from = Integer.parseInt(st.nextToken());
			to = Integer.parseInt(st.nextToken());
			if(order.equals(QUERY))
			{
				while(to-- >= from)
				{
					temp += soldierKills[to + 1];
				}
				result.add(temp);
			}
			else
				soldierKills[from] += to;
		}	
		
		for(i = 0; i < result.size(); i++)
			System.out.println(result.get(i));
	}

}
    