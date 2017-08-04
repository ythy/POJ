package com.mx.acm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
/**
 * 日期计算
描述 
如题，输入一个日期，格式如：2010 10 24 ，判断这一天是这一年中的第几天。
输入
第一行输入一个数N（0<N<=100）,表示有N组测试数据。后面的N行输入多组输入数据，每行的输入数据都是一个按题目要求格式输入的日期。
输出
每组输入数据的输出占一行，输出判断出的天数n

 * @author maoxin
 * 878843 ythyhvh 日期计算 Accepted  1  122 java 05-23 10:09:34 
 */
public class Test75 {

	
	private static int[] f = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
	private static int[] sum = new int[13];
	private static int[] sum29 = new int[13];
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		 BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		 int total = Integer.parseInt(br.readLine());
		 StringTokenizer st;
		 int y, m, d;
		 setSumDays();
		 while(total > 0)
		 {
			 st = new StringTokenizer(br.readLine());
			 y = Integer.parseInt(st.nextToken());
			 m = Integer.parseInt(st.nextToken());
			 d = Integer.parseInt(st.nextToken());
			 System.out.println((isFeb29Days(y) ? sum29[m - 1] : sum[m - 1])  + d);
			 
			 total --;
		 }
	}
	
	static boolean isFeb29Days(int year)
	{
		if((year%4 == 0 && year%100 != 0) || year%400 == 0)
			return true;
		else
			return false;
	}
	
	static void setSumDays()
	{
		 int i;
		 for(i = 1; i <= 12; i++)
		 {
			 if(i == 2)
				 sum29[i] = sum29[i - 1] + f[i] + 1;
			 else
				 sum29[i] = sum29[i - 1] + f[i];
			 
			 sum[i] = sum[i - 1] + f[i]; 
		 }
	}

}
