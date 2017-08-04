package com.mx.acm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * A+B Problem III
 * 描述 求A+B是否与C相等。
输入T组测试数据。
 每组数据中有三个实数A,B,C(-10000.0<=A,B<=10000.0,-20000.0<=C<=20000.0)
数据保证小数点后不超过4位。

输出如果相等则输出Yes
不相等则输出No

 * @author maoxin
 * 904010 ythyhvh A+B Problem III Accepted  1  61 java 06-27 17:37:51 
 */
public class Test477 {

	 
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new  InputStreamReader(System.in));
		StringTokenizer st;
		int total = Integer.parseInt(br.readLine());
		String a,b,c;
		double f;
		while(total-- > 0)
		{
			st = new StringTokenizer(br.readLine());
			a = changever(st.nextToken());
			b = changever(st.nextToken());
			c = changever(st.nextToken());
			f = Double.valueOf(a) + Double.valueOf(b) - Double.valueOf(c);
			
			System.out.println(f > -0.0001 && f < 0.0001  ? "Yes" : "No");
		}

	}
	
	static String changever(String str)
	{
		if(str.startsWith("+"))
			str = str.substring(1);
		return str;
	}

}
