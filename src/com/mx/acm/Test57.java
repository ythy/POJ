package com.mx.acm;

import java.util.Scanner;
/**
 * 6174问题
描述 
假设你有一个各位数字互不相同的四位数，把所有的数字从大到小排序后得到a,从小到大后得到b,然后用a-b替换原来这个数，并且继续操作。例如，从1234出发，依次可以得到4321-1234=3087、8730-378=8352、8532-2358=6174，又回到了它自己！现在要你写一个程序来判断一个四位数经过多少次这样的操作能出现循环，并且求出操作的次数

比如输入1234执行顺序是1234->3087->8352->6174->6174,输出是4

输入
第一行输入n,代表有n组测试数据。
接下来n行每行都写一个各位数字互不相同的四位数
输出
经过多少次上面描述的操作才能出现循环

 * @author maoxin
 * 876143 ythyhvh 6174问题 Accepted  36  184 java 05-21 13:17:02 
 */
public class Test57 {
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int total = scanner.nextInt();
		int input,next = 0,i = 0;
		char[] chars;
		while(total > 0)
		{
			i = 1;
			input = scanner.nextInt();
			chars = sorts(input);
			next = sortB(chars) - sortS(chars);
			while(next != input)
			{
				input = next;
				chars = sorts(next);
				next = sortB(chars) - sortS(chars);
				i++;
			}
			
			System.out.println(i);
			total--;
		}
	}
	
	// 冒泡排序
	private static char[] sorts(int num)
	{
		
		int i,j;
		char t;
		char[] arr = String.valueOf(num).toCharArray();
		for(i = 0; i < arr.length; i++)
		{
			for(j = 0; j < arr.length - 1 - i; j++ )
			{
				if(arr[j] > arr[j + 1])
				{
					t = arr[j];
					arr[j] = arr[j + 1];
					arr[j + 1] = t;
				}
			}
		}
		return arr;
	}
	
	private static int sortS(char[] arr)
	{
		int i;
		StringBuffer sb = new StringBuffer();
		for(i = 0; i < arr.length; i ++)
		{
			sb.append(arr[i]);
		}
		return Integer.parseInt(sb.toString());
	}
	
	private static int sortB(char[] arr)
	{
		int i;
		StringBuffer sb = new StringBuffer();
		for(i = arr.length - 1; i >= 0; i --)
		{
			sb.append(arr[i]);
		}
		return Integer.parseInt(sb.toString());
	}
	
}
