package com.mx.acm;

import java.math.BigDecimal;
import java.util.Scanner;
/**
 * A+B Problem IV
 * 
 * 描述 acmj最近发现在使用计算器计算高精度的大数加法时很不方便，于是他想着能不能写个程序把这个问题给解决了。
输入包含多组测试数据
 每组数据包含两个正数A,B（可能为小数且位数不大于400）输出每组输出数据占一行，输出A+B的结果，结果需要是最简的形式。
 
 
 * @author maoxin
 * 961935 ythyhvh A+B Problem IV Accepted  464  985 java 08-27 15:16:35 
 */
public class Test513 {
	
	
	static Scanner scanner = new Scanner(System.in);
	public static void main(String[] args) {
		
		BigDecimal left, right;
		String sum, rightstr = null;
		while(scanner.hasNext())
		{
			left = scanner.nextBigDecimal();
			right = scanner.nextBigDecimal();
			sum = left.add(right).toString();
			if(sum.indexOf(".") != -1)
			{
				rightstr = sum.split("\\.")[1];
				while(rightstr.length() > 0 && rightstr.lastIndexOf("0") == rightstr.length() - 1)
					rightstr = rightstr.substring(0, rightstr.length() - 1);
				System.out.println(sum.split("\\.")[0] + (rightstr.length() > 0 ? "." + rightstr : "" ));
			}
			else	
				System.out.println(sum);
				 
		}
		

	}

}
