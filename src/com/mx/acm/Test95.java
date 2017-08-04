package com.mx.acm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
/**
 * 众数问题
 * 描述 
所谓众数，就是对于给定的含有N个元素的多重集合，每个元素在S中出现次数最多的成为该元素的重数，

多重集合S重的重数最大的元素成为众数。例如：S={1,2,2,2,3,5}，则多重集S的众数是2，其重数为3。

现在你的任务是：对于给定的由m个自然数组成的多重集S，计算出S的众数及其重数。

输入第一行为n，表示测试数据组数。(n<30)
每组测试的第一行是一个整数m，表示多重集S中元素的个数为m
接下来的一行中给出m(m<100)个不大于10万的自然数
 （不会出现不同元素出现的次数相同的情况，如：S={11,11,22,22,33,33}）。
输出每组测试数据输出一行，包含两个数，第一个是众数，第二个是其重数，中间以空格隔开。

 * @author maoxin
 * 905662 ythyhvh 众数问题 Accepted  13  2796 java 06-30 09:29:02 
 */
public class Test95 {

	 
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new  InputStreamReader(System.in));
		StringTokenizer st;
		int total = Integer.parseInt(br.readLine());
		int sum, i, max, output = 0;
		int[] input, token;
		while(total-- > 0)
		{
			i = Integer.parseInt(br.readLine());
			sum = i;
			st = new StringTokenizer(br.readLine());
			token = new int[110];
			input = new int[100005];
			max = Integer.MIN_VALUE;
			while(sum-- > 0)
			{
				token[sum] = Integer.parseInt(st.nextToken());
				input[token[sum]]++;
				if(input[token[sum]] > max)
					max = input[token[sum]];
			}
			sum = i;
			while(sum-- > 0)
			{
				if(input[token[sum]] == max)
				{
					output = token[sum];
					break;
				}
			}
			
			System.out.println(output + " " + max);
			
		}

	}

}
