package com.mx.acm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
/**
 * 
 * 子串和
难度：3

描述 给定一整型数列{a1,a2...,an}，找出连续非空子串{ax,ax+1,...,ay}，使得该子序列的和最大，其中，1<=x<=y<=n。
输入第一行是一个整数N(N<=10)表示测试数据的组数）
 每组测试数据的第一行是一个整数n表示序列中共有n个整数，随后的一行里有n个整数I(-100=<I<=100)，表示数列中的所有元素。(0<n<=1000000)输出对于每组测试数据输出和最大的连续子串的和。
 
 * @author maoxin
 * 915068 ythyhvh 子串和 Accepted  1783  26732 java 07-11 15:02:20 	
 */
public class Test44 {

	 
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new  InputStreamReader(System.in));
		StringTokenizer st;
		int total = Integer.parseInt(br.readLine());
		int inputsum, input, max, result;
		while(total-- > 0)
		{
			inputsum = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine());
			max = Integer.parseInt(st.nextToken());
			inputsum--;
			result = max;
			while(inputsum-- > 0)
			{  
				input = Integer.parseInt(st.nextToken());
				if(result < 0)
					result = input;
				else
					result += input;
				
				if(result >= max)
					max = result;
				 
			}
			
			System.out.println(max);
		}

	}

}
