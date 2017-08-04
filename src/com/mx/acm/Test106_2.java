package com.mx.acm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
/**
 * 背包问题
 * 
 * 描述 现在有很多物品（它们是可以分割的），我们知道它们每个物品的单位重量的价值v和重量w（1<=v,w<=10）；如果给你一个背包它能容纳的重量为m（10<=m<=20）,你所要做的就是把物品装到背包里，使背包里的物品的价值总和最大。
输入第一行输入一个正整数n（1<=n<=5）,表示有n组测试数据；
 随后有n测试数据，每组测试数据的第一行有两个正整数s，m（1<=s<=10）;s表示有s个物品。接下来的s行每行有两个正整数v，w。输出输出每组测试数据中背包内的物品的价值和，每次输出占一行。
 
 * @author maoxin
 * 958704 ythyhvh 背包问题 Accepted  1  61 java 08-22 16:10:33  
 * 转化为完全背包问题
 */
public class Test106_2 {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new  InputStreamReader(System.in));
		int total = Integer.parseInt(br.readLine().trim());
		StringTokenizer st;
		int s, m, i, j, k;
		int[] v, b, f;
		while(total-- > 0)
		{
			st = new StringTokenizer(br.readLine().trim());
			s = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());
			
			v = new int[s + 1];
			b = new int[s + 1];
			f = new int[m + 1];
			for(i = 1; i <= s; i++)
			{
				st = new StringTokenizer(br.readLine().trim());
				v[i] =  Integer.parseInt(st.nextToken());
				b[i] =  Integer.parseInt(st.nextToken());
			}
			
			for(i = 1; i <= s; i++)
			{
				for(j = 1; j <= b[i]; j++)
				{
					for(k = m; k >= 1; k--)
					{
						f[k] = Math.max(f[k], f[k - 1] + v[i]);
					}
					
				}
			}
			
			
			System.out.println(f[m]);
			 
		}

	}

}
