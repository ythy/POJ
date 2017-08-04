package com.mx.acm;

import java.util.Scanner;
/**
 * 字符串替换
 * 描述 编写一个程序实现将字符串中的所有"you"替换成"we"
输入输入包含多行数据 

 每行数据是一个字符串，长度不超过1000 
数据以EOF结束输出对于输入的每一行，输出替换后的字符串

 * @author maoxin
 * 901782 ythyhvh 字符串替换 Accepted  24  61 java 06-23 15:31:22 
 */

public class Test113 {

	static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		StringBuffer input;
		int i;
		while(scanner.hasNextLine())
		{
			input = new StringBuffer(scanner.nextLine());
			for(i = 0; i < input.length() - 2; i++)
			{
				if(input.charAt(i) == 'y' && 
				   input.charAt(i + 1) == 'o' && 
				   input.charAt(i + 2) == 'u')
				{
					input.delete(i, i + 3);
					input.insert(i, "we");
					i++;
				}
			}
			System.out.println(input);
		}
	}

}
