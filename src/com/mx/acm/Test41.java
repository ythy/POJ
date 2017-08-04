package com.mx.acm;

import java.util.Scanner;
/**
 * 三个数从小到大排序
 描述 
现在要写一个程序，实现给三个数排序的功能

输入
输入三个正整数
输出
给输入的三个正整数排序

 * @author maoxin
 * 867026 ythyhvh 三个数从小到大排序 Accepted  22  184 java 05-15 16:55:45 
 */
public class Test41 {
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int total = 0;
		int maxn = 3;
		int[] input = new int[maxn];
		while(total < maxn)
		{
			input[total] = scanner.nextInt();
			total ++ ;
		}
		
		int i,j,f;
		for(i = maxn - 1; i >= 0; i--)
		{
			for(j = 0; j < i; j ++)
			{
				if(input[j] > input[j + 1])
				{
					f = input[j + 1];
					input[j + 1] = input[j];
					input[j] = f;
				}
			}
		}
		
		StringBuffer bf = new StringBuffer();
		for(i = 0; i < maxn; i++)
		{
			bf.append(input[i] + " ");
		}
		System.out.println(bf);
		
	}
}
