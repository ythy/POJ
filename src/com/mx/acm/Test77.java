package com.mx.acm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 开灯问题
描述 
有n盏灯，编号为1~n，第1个人把所有灯打开，第2个人按下所有编号为2 的倍数的开关（这些灯将被关掉），第3 个人按下所有编号为3的倍数的开关（其中关掉的灯将被打开，开着的灯将被关闭），依此类推。一共有k个人，问最后有哪些灯开着？输入：n和k，输出开着的灯编号。k≤n≤1000

输入
输入一组数据：n和k
输出
输出开着的灯编号

 * @author maoxin
 * 895257 ythyhvh 开灯问题 Accepted  26  122 java 06-13 14:40:43 
 */
public class Test77 {

	 
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new  InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		
		boolean[] f = new boolean[n + 1];
		int i,j;
		
		for(i = 1; i <= k; i++)
		{
			for(j = 1; j <= n; j++)
			{
				if(j%i == 0)
					f[j] = !f[j];
			}
		}
		
		StringBuffer sb = new StringBuffer();
		for(i = 1; i <= n; i++)
		{
			if(f[i])
				sb.append(i + " ");
		}
		
		System.out.println(sb);
	}

}
