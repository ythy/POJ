package com.mx.acm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
/**
 * 另一种阶乘问题
描述 


大家都知道阶乘这个概念，举个简单的例子：5！=1*2*3*4*5.现在我们引入一种新的阶乘概念，将原来的每个数相乘变为i不大于n的所有奇数相乘例如：5!!=1*3*5.现在明白现在这种阶乘的意思了吧！

现在你的任务是求出1!!+2!!......+n!!的正确值(n<=20)

输入
第一行输入一个a(a<=20)，代表共有a组测试数据
接下来a行各行输入一个n.

输出
各行输出结果一个整数R表示1!!+2!!......+n!!的正确值

 * @author maoxin
 * 877980 ythyhvh 另一种阶乘问题 Accepted  10  61 java 05-22 17:09:27 
 */
public class Test65 {
	
	private static int maxn = 24;
	private static int[] f = new int[maxn];
	private static int[] sum = new int[maxn];
	private static int current = 0;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader sr = new BufferedReader(new InputStreamReader(System.in));
		int total = Integer.parseInt(sr.readLine());
		int input;
		f[1] = 1;
		f[2] = 1;
		sum[1] = 1;
		sum[2] = 2;
		while(total > 0)
		{
			input = Integer.parseInt(sr.readLine());
			System.out.println(getArray(input));
			total--;
		}
	}
	
	private static int getArray(int num)
	{
		if(current < num)
		{
			int i;
			for(i = 1; i <= num; i+=2)
			{
				if(f[i] != 0)
					continue;
				f[i] = f[i - 1] * i;
				f[i + 1] = f[i];
				sum[i] = sum[i - 1] + f[i];
				sum[i + 1] = sum[i] + f[i];
			}
			current = num;
		}
		return sum[num];
	}
	
}
