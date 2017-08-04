package com.mx.acm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 鸡兔同笼
描述 
已知鸡和兔的总数量为n,总腿数为m。输入n和m,依次输出鸡和兔的数目，如果无解，则输出“No answer”(不要引号)。
输入
第一行输入一个数据a,代表接下来共有几组数据，在接下来的(a<10)
a行里，每行都有一个n和m.(0<m,n<100)
输出
输出鸡兔的个数，或者No answer

 * @author maoxin
 * 877659 ythyhvh 鸡兔同笼 Accepted  1  61 java 05-22 13:19:46 
 */
public class Test64 {
	
	private static String ERROR = "No answer";
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader lineinput = new BufferedReader(new InputStreamReader(System.in));
		int total = Integer.parseInt(lineinput.readLine());
		int n,m;
		int i,j = 0;
		boolean flag;
		while(total > 0)
		{
			String input = lineinput.readLine();
			StringTokenizer st = new StringTokenizer(input);
			n = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());
			flag = false;
			
			for(i = 0; i <= n; i++)
			{
				j = n - i;
				if(2*i + 4*j == m)
				{
					flag = true;
					break;
				}
			}
			if(flag)
				System.out.println(i + " " + j);
			else
				System.out.println(ERROR);
			total--;
		}
	}
	
}
