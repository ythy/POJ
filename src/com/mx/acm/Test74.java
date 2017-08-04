package com.mx.acm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
/**
 * 小学生算术
描述 
很多小学生在学习加法时，发现“进位”特别容易出错。你的任务是计算两个三位数在相加时需要多少次进位。你编制的程序应当可以连续处理多组数据，直到读到两个0（这是输入结束标记）。
输入
输入两个正整数m,n.(m,n,都是三位数)
输出
输出m,n,相加时需要进位多少次。

 * @author maoxin
 * 878789 ythyhvh 小学生算术 Accepted  1  61 java 05-23 09:20:16 
 */
public class Test74 {
	
	private static int FOUR = 1000; 
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int m, n, t;
		String i,j;
		int result = 0;
		char[] k,l;
		
		while(true)
		{
			st = new StringTokenizer(br.readLine());
			i = st.nextToken();
			j = st.nextToken();
			m = Integer.parseInt(i);
			n = Integer.parseInt(j);
			if(m == 0 && n == 0)
				break;
			
			result = 0;
			t = m + n;
			k = i.toCharArray();
			l = String.valueOf(t).toCharArray();
			
			if(t >= FOUR)
				result++;
			if(l[l.length - 1] < k[k.length - 1])
				result++;
			if(l[l.length - 2] < k[k.length - 2])
				result++;
			
			System.out.println(result);
		}
	}
	
}
