package com.mx.acm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 
过河问题

时间限制：1000 ms  |  内存限制：65535 KB 

难度：5

描述 
在漆黑的夜里，N位旅行者来到了一座狭窄而且没有护栏的桥边。如果不借助手电筒的话，大家是无论如何也不敢过桥去的。不幸的是，N个人一共只带了一只手电筒，而桥窄得只够让两个人同时过。如果各自单独过桥的话，N人所需要的时间已知；而如果两人同时过桥，所需要的时间就是走得比较慢的那个人单独行动时所需的时间。问题是，如何设计一个方案，让这N人尽快过桥。 

 * @author maoxin
 * 1360102 ythyhvh 过河问题 Accepted  71  1051 java 09-09 15:01:06 
 */
public class Test47 {

	/**
	 * @param args
	 * @throws IOException 
	 * @throws NumberFormatException 
	 */
	private static int result;
	
	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int total = Integer.parseInt(br.readLine());
		while(total-- > 0)
		{
			int n = Integer.parseInt(br.readLine());
			int[] si = new int[n];
			st = new StringTokenizer(br.readLine());
			for(int i = 0; i < n; i++)
				si[i] = Integer.parseInt(st.nextToken());
			
			result = 0;
			Arrays.sort(si);
			dfs(si);
			System.out.println(result);
		}

	}
	
	private static void dfs(int[] si)
	{
		int n = si.length;
		if(n == 1)
			result += si[0];
		else if(n == 2)
		{
			result += si[1];
		}
		else if(n == 3) //最快的人送2次 + 返回1次
		{
			result += si[0] + si[1] + si[2];
		}
		else
		{
			result += Math.min(2 * si[0] + si[n -1] + si[n - 2], 
					 si[0] + 2 * si[1] +  si[n -1]);
			int[] tmp = Arrays.copyOfRange(si, 0, n - 2);
			dfs(tmp);
		}
	}

}
