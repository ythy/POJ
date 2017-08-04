package com.mx.acm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
/**
 * 超级台阶
描述 
有一楼梯共m级，刚开始时你在第一级，若每次只能跨上一级或二级，要走上第m级，共有多少走法？

注：规定从一级到一级有0种走法。

输入
输入数据首先包含一个整数n(1<=n<=100)，表示测试实例的个数，然后是n行数据，每行包含一个整数m，（1<=m<=40), 表示楼梯的级数。
输出
对于每个测试实例，请输出不同走法的数量。

 * @author maoxin
 * 882157 ythyhvh 超级台阶 Accepted  6  61 java 05-26 14:43:18 
 */
public class Test76 {

	 
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int total = Integer.parseInt(br.readLine());
		int input;
		int []f;
		int i;
		while(total > 0)
		{
			input = Integer.parseInt(br.readLine());
			f = new int[input + 5];
			f[1] = 0;
			f[2] = 1;
			f[3] = 2;
			for(i = 4; i <= input; i++)
			{
				f[i] = f[i - 1] + f[i - 2];
			}
			System.out.println(f[input]);
			total--;
		}
	}

}
