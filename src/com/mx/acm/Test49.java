package com.mx.acm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
/**
 * 开心的小明
描述 
小明今天很开心，家里购置的新房就要领钥匙了，新房里有一间他自己专用的很宽敞的房间。更让他高兴的是，妈妈昨天对他说：“你的房间需要购买哪些物品，怎么布置，你说了算，只要不超过N 元钱就行”。今天一早小明就开始做预算，但是他想买的东西太多了，肯定会超过妈妈限定的N 元。于是，他把每件物品规定了一个重要度，分为5 等：用整数1~5 表示，第5 等最重要。他还从因特网上查到了每件物品的价格（都是整数元）。他希望在不超过N 元（可以等于N 元）的前提下，使每件物品的价格与重要度的乘积的总和最大。设第j 件物品的价格为v[j]，重要度为w[j]，共选中了k 件物品，编号依次为j1...jk，则所求的总和为：v[j1]*w[j1]+..+v[jk]*w[jk]请你帮助金明设计一个满足要求的购物单.
输入
第一行输入一个整数N(0<N<=101)表示测试数据组数
每组测试数据输入的第1 行，为两个正整数，用一个空格隔开：
N m
（其中N（<30000）表示总钱数，m(<25)为希望购买物品的个数。）
从第2 行到第m+1 行，第j 行给出了编号为j-1
的物品的基本数据，每行有2 个非负整数
v p
（其中v 表示该物品的价格（v≤10000），p 表示该物品的重要度（1~5））
输出
每组测试数据输出只有一个正整数，为不超过总钱数的物品的价格与重要度乘积的总和的
最大值（<100000000）

 * @author maoxin
 * 883062 ythyhvh 开心的小明 Accepted  100  2585 java 05-27 10:43:57 
 */
public class Test49 {

 
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int total = Integer.parseInt(br.readLine());
		int nTotalMoney; //总钱数
		int nTotalType; //总类别
		int i,j,ans;
		int[] v, p; //物品价格,重要度
		int[] dp;
		while(total > 0)
		{
			st = new StringTokenizer(br.readLine());
			nTotalMoney = Integer.parseInt(st.nextToken());
			nTotalType = Integer.parseInt(st.nextToken());
			v = new int[nTotalType + 1];
			p = new int[nTotalType + 1];
			dp =  new int[nTotalMoney + 1];
			ans = 0;
			
			for(i = 1; i <= nTotalType; i++)
			{
				st = new StringTokenizer(br.readLine());
				v[i] = Integer.parseInt(st.nextToken());
				p[i] = Integer.parseInt(st.nextToken());
			}
			
			for(i = 1; i <= nTotalType; i++)
			{
				for(j = nTotalMoney; j >= v[i] ; j--)
				{
					dp[j] = Math.max(dp[j] ,dp[j - v[i]] + v[i]*p[i]);
					ans = Math.max(ans, dp[j]); 
				}
			}
			System.out.println(ans);
			total--;
		}
			
	}

}
