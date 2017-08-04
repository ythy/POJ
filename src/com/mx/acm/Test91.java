package com.mx.acm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
/**
 * n-1位数
描述 
已知w是一个大于10但不大于1000000的无符号整数，若w是n(n≥2)位的整数，则求出w的后n-1位的数。

输入
第一行为M，表示测试数据组数。
接下来M行，每行包含一个测试数据。
输出
输出M行，每行为对应行的n-1位数（忽略前缀0）。如果除了最高位外，其余位都为0，则输出0。
样例输入
4
1023
5923
923
1000

样例输出
23
923
23
0

 * @author maoxin
 * 895305 ythyhvh n-1位数 Accepted  1  122 java 06-13 16:23:00 
 */
public class Test91 {

	 
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new  InputStreamReader(System.in));
		int total = Integer.parseInt(br.readLine());
		char[] input;
		StringBuffer output;
		int i;
		while(total-- > 0)
		{
			input = br.readLine().toCharArray();
			output = new StringBuffer();
			for(i = 1; i < input.length; i++)
			{
				if(input[i] == '0' && output.length() == 0)
					continue;
				output.append(String.valueOf(input[i]));
			}
			System.out.println(output.length() == 0 ? "0" : output);
		}

	}

}
