package com.mx.acm;

import java.util.Scanner;
/**
 * Fibonacci数
 * 描述 
无穷数列1，1，2，3，5，8，13，21，34，55...称为Fibonacci数列，它可以递归地定义为
F(n)=1 ...........(n=1或n=2)
F(n)=F(n-1)+F(n-2).....(n>2)
现要你来求第n个斐波纳奇数。（第1个、第二个都为1)
输入
第一行是一个整数m(m<5)表示共有m组测试数据
每次测试数据只有一行，且只有一个整形数n(n<20)

输出
对每组输入n，输出第n个Fibonacci数

 * @author maoxin
 *
 */
public class Test13 {
	
	static int maxnum = 20;
	static int[] array = new int[maxnum];
	static int cnum = 1;
	
	//847402 ythyhvh Fibonacci数 Accepted  19  184 java 05-02 11:09:54 
	public static void main2(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int total = scanner.nextInt();
		int input;
		array[1] = 1;
		for(int i = 2; i < maxnum; i++)
		{
			array[i] = array[i - 1] + array[i - 2];
		}
		
		while(total > 0)
		{
			input = scanner.nextInt();
			System.out.println(array[input]);
			total--;
		}
	}
	
	//847419 ythyhvh Fibonacci数 Accepted  18  184 java 05-02 11:23:02 
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int total = scanner.nextInt();
		int input;
		array[1] = 1;
		while(total > 0)
		{
			input = scanner.nextInt();
			System.out.println(getFibonacci(input));
			total--;
		}
	}
	
	static int getFibonacci(int v)
	{
		if(v > cnum)
		{
			int i;
			for(i = cnum + 1; i <= v; i++)
			{
				array[i] = array[i - 1] + array[i - 2];
			}
			cnum = v;
		}
		return array[v];
	}
	
}
