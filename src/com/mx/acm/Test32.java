package com.mx.acm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
/**
 * 组合数
 * 描述 找出从自然数1、2、... 、n（0<n<10）中任取r(0<r<=n)个数的所有组合。
输入输入n、r。输出按特定顺序输出所有组合。
 特定顺序：每一个组合中的值从大到小排列，组合之间按逆字典序排列。
 
 * @author maoxin
 * 907627 ythyhvh 组合数 Accepted  4  122 java 07-02 10:17:26 
 */
public class Test32 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new  InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int i;
		String orglist = "";
		for(i = n; i > 0; i--)
			orglist += i;
		dp(orglist, m, "");
	} 
	
	static void dp(String list, int m, String str)
	{
		String tempList = list;
		String tempStr;
		for(int i = 0; i < list.length(); i++)
		{
			tempStr = str;
			tempStr += tempList.substring(0, 1);
			if(tempStr.length() == m)
			{
				System.out.println(tempStr);
			}
			tempList = tempList.substring(1);
			dp(tempList, m, tempStr);
		}
	} 
}
