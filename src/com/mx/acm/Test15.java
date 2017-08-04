package com.mx.acm;

import java.util.Scanner;
/**
 * 括号匹配（二）
 * 描述 
给你一个字符串，里面只包含"(",")","[","]"四种符号，请问你需要至少添加多少个括号才能使这些括号匹配起来。
如：
[]是匹配的
([])[]是匹配的
((]是不匹配的
([)]是不匹配的
输入
第一行输入一个正整数N，表示测试数据组数(N<=10)
每组测试数据都只有一行，是一个字符串S，S中只包含以上所说的四种字符，S的长度不超过100
输出
对于每组测试数据都输出一个正整数，表示最少需要添加的括号的数量。每组测试输出占一行

 * @author maoxin
 *845279 ythyhvh 括号匹配（二） Accepted  88  184 java 04-30 16:42:28 
 *
 *用到动态规划算法
 */
public class Test15 {
	
	static int maxn=110;
	static int[][] f = new int[maxn][maxn];
	static char[] tab = new char[maxn];
	
	static int fun(int i,int j)
	{
		if(i>j)return 0;
		if(f[i][j]>=0)return f[i][j];
		if(i==j)return f[i][j]=1;
		int va=maxn;
		if((tab[i]=='('&&tab[j]==')') || (tab[i]=='['&&tab[j]==']'))
			va=fun(i+1,j-1);
		for(int mid=i;mid<j;mid++){
			va=Math.min(va,fun(i,mid)+fun(mid+1,j));
		}
		return f[i][j]=va;
	}
	
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		int N = scanner.nextInt();
		while (N > 0) {
			for(int i = 0; i < maxn; i++){
				for(int j = 0; j < maxn; j++){
					f[i][j] = -1;
				}
			}
			tab = scanner.next().toCharArray();
			System.out.println(fun(0, tab.length - 1));
			N--;
		}
	}
	
 

	
}
