package com.mx.acm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
/**
 * 笨小熊
描述 
笨小熊的词汇量很小，所以每次做英语选择题的时候都很头疼。但是他找到了一种方法，经试验证明，用这种方法去选择选项的时候选对的几率非常大！ 
这种方法的具体描述如下：假设maxn是单词中出现次数最多的字母的出现次数，minn是单词中出现次数最少的字母的出现次数，如果maxn-minn是一个质数，那么笨小熊就认为这是个Lucky Word，这样的单词很可能就是正确的答案。 

输入
第一行数据N(0<N<100)表示测试数据组数。
每组测试数据输入只有一行，是一个单词，其中只可能出现小写字母，并且长度小于100。 
输出
每组测试数据输出共两行，第一行是一个字符串，假设输入的的单词是Lucky Word，那么输出“Lucky Word”，否则输出“No Answer”； 
第二行是一个整数，如果输入单词是Lucky Word，输出maxn-minn的值，否则输出0

 * @author maoxin
 * 876401 ythyhvh 笨小熊 Accepted  5  246 java 05-21 16:55:54 
 */
public class Test62 {
	
	
	private static String SUCCESS = "Lucky Word";
	private static String FAULT = "No Answer";
	private static int max = 110; //素数最大计算到多少
	private static boolean[] arrPrime = new boolean[max];
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader lineinput = new BufferedReader(new InputStreamReader(System.in));
		int total = Integer.parseInt(lineinput.readLine());
		char[] input;
		int maxAsc = 130;
		int [] charArray = new int[maxAsc];
		int i,t = 0;
		int maxn,minn;
		setPrimeNumer();//是否素数
		while(total > 0)
		{
			input = lineinput.readLine().toCharArray();
			charArray = new int[maxAsc];
			for(i = 0; i < input.length; i++)
			{
				t = input[i];
				charArray[t] ++;
			}
			
			maxn = 0;
			minn = maxAsc;
			for(i = 95; i < charArray.length; i++) // a-z  大于95
			{
				 if(charArray[i] > maxn)
					 maxn = charArray[i];
				 if(charArray[i] < minn && charArray[i] > 0)
					 minn = charArray[i];
			}
			 
			
			if(arrPrime[maxn - minn])
			{
				System.out.println(SUCCESS);
				System.out.println(maxn - minn);
			}
			else
			{
				System.out.println(FAULT);
				System.out.println(0);
			}
				
			total--;
		}
	}
	
	private static void setPrimeNumer()
	{
		arrPrime[2] = true;
		int i,j;
		for(i = 3; i < max; i+=2)
		{
			arrPrime[i] = true;
			for(j = 3; j < Math.sqrt(i); j+=2)
			{
				if(i%j == 0 && i != j)
				{
					arrPrime[i] = false;
					break;
				}
			}
		}
	}
}
