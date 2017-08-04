package com.mx.acm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
/**
 * 无聊的小明
 * 描述       这天小明十分无聊，没有事做，但不甘于无聊的小明聪明的想到一个解决无聊的办法，因为他突然对数的正整数次幂产生了兴趣。
 　　众所周知，2的正整数次幂最后一位数总是不断的在重复2，4，8，6，2，4，8，6……我们说2的正整数次幂最后一位的循环长度是4（实际上4的倍数都可以说是循环长度，但我们只考虑最小的循环长度）。类似的，其余的数字的正整数次幂最后一位数也有类似的循环现象。
 　　这时小明的问题就出来了：是不是只有最后一位才有这样的循环呢？对于一个整数n的正整数次幂来说，它的后k位是否会发生循环？如果循环的话，循环长度是多少呢？
 注意：
 　　1.如果n的某个正整数次幂的位数不足k，那么不足的高位看做是0。
 　　2.如果循环长度是L，那么说明对于任意的正整数a，n的a次幂和a + L次幂的最后k位都相同。
输入第一行输入一个整数N(0<n<10);接下来每组测试数据输入只有一行，包含两个整数n（1 <= n <100000）和k（1 <= k <= 5），n和k之间用一个空格隔开，表示要求n的正整数次幂的最后k位的循环长度。
输出每组测试数据输出包括一行，这一行只包含一个整数，表示循环长度。如果循环不存在，输出-1。


 * @author maoxin
 * 952676 ythyhvh 无聊的小明 Accepted  79  61 java 08-15 16:53:38 
 */
public class Test52 {

	/**
	 * @param args
	 * @throws IOException 
	 * @throws NumberFormatException 
	 */
	static int f[] = {0, 10, 100, 1000, 10000, 100000};  
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new  InputStreamReader(System.in));
		StringTokenizer st;
		int total = Integer.parseInt(br.readLine());
		int n, k, result, sum;
		long input, basic;
		
		while(total-- > 0)
		{
			st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			k = Integer.parseInt(st.nextToken());
			
			result = 0;
			input = n;
			basic = n % f[k];
			sum = f[k];
			while(sum-- > 0)
			{
				result++;
				input = input * n % f[k];
				if(input == basic)
					break;
			}
			
			System.out.println(sum > 0 ? result : -1);
		}

	}

}
