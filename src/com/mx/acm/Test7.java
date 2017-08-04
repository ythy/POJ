package com.mx.acm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 街区最短路径问题
 * 描述 一个街区有很多住户，街区的街道只能为东西、南北两种方向。

 住户只可以沿着街道行走。

 各个街道之间的间隔相等。

 用(x,y)来表示住户坐在的街区。

 例如（4,20），表示用户在东西方向第4个街道，南北方向第20个街道。

 现在要建一个邮局，使得各个住户到邮局的距离之和最少。

 求现在这个邮局应该建在那个地方使得所有住户距离之和最小；


输入第一行一个整数n<20，表示有n组测试数据，下面是n组数据;
每组第一行一个整数m<20,表示本组有m个住户，下面的m行每行有两个整数0<x,y<100，表示某个用户所在街区的坐标。
m行后是新一组的数据；
输出每组数据输出到邮局最小的距离和，回车结束；


 * @author maoxin
 * 903566 ythyhvh 街区最短路径问题 Accepted  7  122 java 06-27 10:10:53 
 */
public class Test7 {

	 
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new  InputStreamReader(System.in));
		StringTokenizer st;
		int total = Integer.parseInt(br.readLine());
		int sumnum, i;
		int [] x, y;
		int dx, dy, result;
		while(total-- > 0)
		{
			sumnum = Integer.parseInt(br.readLine());
			x = new int[sumnum + 1];
			y = new int[sumnum + 1];
			result = 0;
			
			for(i = 1; i <= sumnum; i++ )
			{
				st = new StringTokenizer(br.readLine());
				x[i] = Integer.parseInt(st.nextToken());
				y[i] = Integer.parseInt(st.nextToken());
				 
			}
			Arrays.sort(x); 
			Arrays.sort(y); 
			
			dx = sumnum%2 != 0 ? x[(sumnum + 1)/2] : (x[sumnum/2] + x[sumnum/2 + 1])/2;
			dy = sumnum%2 != 0 ? y[(sumnum + 1)/2] : (y[sumnum/2] + y[sumnum/2 + 1])/2;
			 
			for(i = 1; i <= sumnum; i++ )
			{
				result += Math.abs(dx - x[i]) + Math.abs(dy - y[i]);
			}
			System.out.println(result);
		}

	}

}
