package com.mx.acm;

import java.util.Scanner;
/**
 * 5个数求最值
 *描述 
设计一个从5个整数中取最小数和最大数的程序
输入
输入只有一组测试数据，为五个不大于1万的正整数
输出
输出两个数，第一个为这五个数中的最小值，第二个为这五个数中的最大值，两个数字以空格格开。

 * @author maoxin
 * 853439 ythyhvh 5个数求最值 Accepted  35  184 java 05-06 15:44:17 
 */
public class Test31 {
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int longth = 5;
		int i;
		int num = 1;
		
		int min = 9999;
		int max = 1;
		for(i = 0; i < longth; i ++)
		{
			num  = scanner.nextInt();
			max = Math.max(max, num);
			min = Math.min(min, num);
		}
		System.out.println(min + " " + max);
	}
	
	
}
