package com.mx.acm;

import java.io.BufferedInputStream;
import java.util.Arrays;
import java.util.Scanner;

/**
 * zb的生日
描述 
今天是阴历七月初五，acm队员zb的生日。zb正在和C小加、never在武汉集训。他想给这两位兄弟买点什么庆祝生日，经过调查，zb发现C小加和never都很喜欢吃西瓜，而且一吃就是一堆的那种，zb立刻下定决心买了一堆西瓜。当他准备把西瓜送给C小加和never的时候，遇到了一个难题，never和C小加不在一块住，只能把西瓜分成两堆给他们，为了对每个人都公平，他想让两堆的重量之差最小。每个西瓜的重量已知，你能帮帮他么？
输入
多组测试数据（<=1500）。数据以EOF结尾
第一行输入西瓜数量N (1 ≤ N ≤ 20)
第二行有N个数，W1, …, Wn (1 ≤ Wi ≤ 10000)分别代表每个西瓜的重量

输出
输出分成两堆后的质量差

 * @author maoxin
 * 882088 ythyhvh zb的生日 Accepted  1308  13354 java 05-26 13:34:06 
 */
public class Test325 {

	
	public static void main2(String[] args){
		Scanner scanner = new Scanner(new BufferedInputStream(System.in));
		while(scanner.hasNextInt()){
			int total = scanner.nextInt();
			int i, j;
			int totalweight = 0, halfweight;
			int[] ch = new int[total + 1];
			for( i = 1; i <= total; i++)
			{
				ch[i] = scanner.nextInt();
				totalweight += ch[i];
			}
			
			halfweight = totalweight/2;
			int[] f = new int[halfweight + 5];
			
			for( i = 1; i <= total; i++)
			{
				for( j = halfweight; j >= ch[i]; j--)
				{
					f[j] = Math.max(f[j - ch[i]] + ch[i],  f[j]);
					 
				}
			}
			
			System.out.println(totalweight - ( 2 * f[halfweight]));
		}
		
	}
	
	public static void main(String[] args){
		Scanner scanner = new Scanner(new BufferedInputStream(System.in));
		while(scanner.hasNextInt()){		
			int i, j;
			int totalweight = scanner.nextInt();
			int total = scanner.nextInt();
			int[] ch = new int[total + 1];
			for( i = 1; i <= total; i++)
			{
				ch[i] = scanner.nextInt();
			}
			
			int[] f = new int[totalweight + 5];
			String[] r = new String[totalweight + 5];
			Arrays.fill(r, "");
			for( i = 1; i <= total; i++)
			{
				for( j = totalweight; j >= ch[i]; j--)
				{
					//f[j] = Math.max(f[j - ch[i]] + ch[i],  f[j]);	
					if(f[j - ch[i]] + ch[i] >= f[j]){
						f[j] = f[j - ch[i]] + ch[i];
						r[j] = r[j - ch[i]] + "," + ch[i];
					}	
				}
			}
			
			System.out.println(f[totalweight] + "   " + r[totalweight]);
		}
		
	}
	 
}



