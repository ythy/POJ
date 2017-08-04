package com.mx.acm;

import java.io.IOException;
import java.util.Scanner;
/**
 * 分数加减法
 * 描述 编写一个C程序，实现两个分数的加减法
输入输入包含多行数据 
 每行数据是一个字符串，格式是"a/boc/d"。 
 其中a, b, c, d是一个0-9的整数。o是运算符"+"或者"-"。 

 数据以EOF结束 
 输入数据保证合法输出对于输入数据的每一行输出两个分数的运算结果。 
 注意结果应符合书写习惯，没有多余的符号、分子、分母，并且化简至最简分数
 
 * @author maoxin
 * 961741 ythyhvh 分数加减法 Accepted  2  61 java 08-27 10:10:46 
 */
public class Test111 {

	static Scanner scanner = new Scanner(System.in);
	public static void main(String[] args) throws NumberFormatException, IOException {
		String input, op, result;
		int a, b, c, d;
		int down, upleft, upright, caltop;
		while(scanner.hasNext())
		{
			//1/8+3/8
			input = scanner.nextLine();
			a = Integer.parseInt(input.substring(0, 1));
			b = Integer.parseInt(input.substring(2, 3));
			op = input.substring(3, 4);
			c = Integer.parseInt(input.substring(4, 5));
			d = Integer.parseInt(input.substring(6, 7));
			result = "";
			
			down = b*d;
			upleft = a*d;
			upright = c*b;
			caltop = op.equals("+") ? upleft + upright : upleft - upright;
				
			if(caltop == 0)
			{
				System.out.println("0");
				continue;
			}
			else if(caltop < 0)
				result = "-";
			caltop = Math.abs(caltop);
			print(result, caltop, down);
		}

	}
	
	static void print(String result, int caltop, int down)
	{
		int max = 2;
		while(max < 10)
		{
			if(caltop % max == 0 && down % max == 0)
			{
				caltop = caltop/max;
				down = down/max;
			}
			else
				max ++;
		}
		
		if(caltop%down == 0)
			System.out.println(result + caltop/down);
		else
			System.out.println(result + caltop + "/" + down);
	}

}
