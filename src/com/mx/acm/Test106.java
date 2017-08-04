package com.mx.acm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/**
 * 背包问题
 * 
 * 描述 现在有很多物品（它们是可以分割的），我们知道它们每个物品的单位重量的价值v和重量w（1<=v,w<=10）；如果给你一个背包它能容纳的重量为m（10<=m<=20）,你所要做的就是把物品装到背包里，使背包里的物品的价值总和最大。
输入第一行输入一个正整数n（1<=n<=5）,表示有n组测试数据；
 随后有n测试数据，每组测试数据的第一行有两个正整数s，m（1<=s<=10）;s表示有s个物品。接下来的s行每行有两个正整数v，w。输出输出每组测试数据中背包内的物品的价值和，每次输出占一行。
 
 
 * @author maoxin
 * 958651 ythyhvh 背包问题 Accepted  25  122 java 08-22 15:09:13 
 */

public class Test106 {

	 
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new  InputStreamReader(System.in));
		int total = Integer.parseInt(br.readLine().trim());
		StringTokenizer st;
		int s, m, i, j, tempW, result;
		Goods tempGood;
		
		Comparator<Goods> comparator =  new Comparator<Goods>(){
			public int compare(Goods o1, Goods o2) {
				int numbera = o1.getValue();
				int numberb = o2.getValue();
				if(numberb > numbera)
				{
					return 1;
				}
				else if(numberb<numbera)
				{
					return -1;
				}
				else
				{
					return 0;
				}
			}
		};
		
		PriorityQueue<Goods> pq;
		while(total-- > 0)
		{
			st = new StringTokenizer(br.readLine().trim());
			s = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());
			pq = new PriorityQueue<Goods>(11, comparator);
			result = 0;
			tempW = 0;
			for(i = 1; i <= s; i++)
			{
				st = new StringTokenizer(br.readLine().trim());
				Goods good = new Goods(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
				pq.add(good);
			}
			
			for(i = 1; i <= s; i++)
			{
				j = 1;
				tempGood = pq.poll();
				while(tempW + j <= m && j <= tempGood.getWeight())
				{
					j++;
				}
				result += tempGood.getValue() * (j - 1);
				tempW += j - 1;
				if(tempW == m)
					break;
			}
			
			System.out.println(result);
			 
		}

	}
	

	static class Goods
	{
		private int value;
		private int weight;
		
		public int getValue() {
			return value;
		}

		public int getWeight() {
			return weight;
		}
		 
		public Goods(int v, int w) {
			value = v;
			weight = w;
		}
	}

}
