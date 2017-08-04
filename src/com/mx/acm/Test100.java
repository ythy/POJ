package com.mx.acm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
/**
 * 1的个数
 * 描述 小南刚学了二进制，他想知道一个数的二进制表示中有多少个1，你能帮他写一个程序来完成这个任务吗？
输入第一行输入一个整数N，表示测试数据的组数(1<N<1000)
每组测试数据只有一行，是一个整数M(0=<M<=10000)输出每组测试输出占一行，输出M的二进制表示中1的个数

 * @author maoxin
 * 901742 ythyhvh 1的个数 Accepted  35  245 java 06-23 14:22:45 
 */
public class Test100 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new  InputStreamReader(System.in));
		int total = Integer.parseInt(br.readLine());
		int input;
		int result;
		while(total-- > 0)
		{
			result = 0;
			input = Integer.parseInt(br.readLine());
			while(input > 0)
			{
				if((input & (input - 1)) == input - 1)
					result ++;
				input = input >> 1;
			}
			System.out.println(result);
		}
	}

}
