package com.mx.acm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
/**
 * 成绩转换
 * 描述 输入一个百分制的成绩M，将其转换成对应的等级，具体转换规则如下：
90~100为A;
 80~89为B;
 70~79为C;
 60~69为D;
 0~59为E;
输入第一行是一个整数N，表示测试数据的组数(N<10)
每组测试数据占一行，由一个整数M组成(0<=M<=100)。输出对于每组输入数据，输出一行。

 * @author maoxin
 * 899988 ythyhvh 成绩转换 Accepted  1  61 java 06-19 16:05:03 
 */
public class Test98 {

	//A 65   9 57
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new  InputStreamReader(System.in));
		int total = Integer.parseInt(br.readLine());
		int input;
		char result;
		while(total-- > 0)
		{
			result = 'E';
			input = Integer.parseInt(br.readLine())/10;
			if(input == 10)
				result = 'A';
			else if(input > 5)
				result = (char) ((input + 48) + 8 + (9 - input) * 2);
			 
			System.out.println(result);	 
		}
	}

}
