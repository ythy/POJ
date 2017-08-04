package com.mx.acm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 擅长排列的小明
 * 
 * 描述 小明十分聪明，而且十分擅长排列计算。比如给小明一个数字5，他能立刻给出1-5按字典序的全排列，如果你想为难他，在这5个数字中选出几个数字让他继续全排列，那么你就错了，他同样的很擅长。现在需要你写一个程序来验证擅长排列的小明到底对不对。
输入第一行输入整数N（1<N<10）表示多少组测试数据，
 每组测试数据第一行两个整数 n m (1<n<9,0<m<=n)输出在1-n中选取m个字符进行全排列，按字典序全部输出,每种排列占一行，每组数据间不需分界。如样例
 
 * @author maoxin
 * 906965 ythyhvh 擅长排列的小明 Accepted  308  7068 java 07-01 16:05:00 
 */
public class Test19 {

	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new  InputStreamReader(System.in));
		StringTokenizer st;
		int total = Integer.parseInt(br.readLine());
		String input;
		int n, m;
		int i;
		while(total-- > 0)
		{
			st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());
			
			input = "";
			for(i = 1; i <= n; i++)
				input += i;
			dp(input, n, m, ""); 
		}

	}

	static void dp(String list, int n, int m, String str)
	{
		String tempList;
		String tempStr;
		for(int i = 0; i < n; i++)
		{
			tempList = list;
			tempStr = str;
			tempStr += tempList.substring(i, i + 1);
			if(tempStr.length() == m)
			{
				System.out.println(tempStr);
				continue;
			}
			tempList = tempList.substring(0, i) + tempList.substring(i + 1);
			dp(tempList, n - 1, m, tempStr);
		}
	}
	 
}
