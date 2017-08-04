package com.mx.acm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
/**
 * 九的余数
 * 描述 
现在给你一个自然数n，它的位数小于等于一百万，现在你要做的就是求出这个数整除九之后的余数。

输入第一行有一个整数m(1<=m<=8),表示有m组测试数据；
 随后m行每行有一个自然数n。
输出输出n整除九之后的余数，每次输出占一行。

 * @author maoxin
 * 960337 ythyhvh 九的余数 Accepted  183  13123 java 08-25 09:46:00 
 */
public class Test105 {

	 
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new  InputStreamReader(System.in));
		int total = Integer.parseInt(br.readLine());
		String input;
		int i, handler, temp;
		while(total-- > 0)
		{
			handler = 0;
			input = br.readLine().trim();
			for(i = 0; i < input.length(); i++)
			{
				temp = handler + Integer.parseInt(input.substring(i, i + 1));
				handler = (temp%9)*10;
			}
			System.out.println(handler/10);
		}
	}

}
