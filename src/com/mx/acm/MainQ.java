package com.mx.acm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainQ {

	/**
	 * @param args
	 * 全排列
	 */
	
	private static int[] input = {1, 3, 5, 7};
	private static List<String> result;
	private static List<int[]> listOperator;
	
	public static void main(String[] args) {
		result = new ArrayList<String>();
		listOperator = new ArrayList<int[]>();
		//perm(input, 0);
		perm2(new int[4], 4, 0);
	}
	
	private static void perm(int[] list, int start) 
	{
		int[] f = list.clone();
		for(int i = start; i < list.length; i++)
		{
			swap(f, start, i);
			if(i == 0 || i != start) //避免重复输出
				print(f);
			perm(f, start + 1);
		}
	}
	
	private static int[] swap(int[] list, int l, int r)
	{
		int m = list[l];
		list[l] = list[r];
		list[r] = m;
		return list;
	}
	
	
	private static void perm2(int[] list, int max, int current) 
	{
		int[] f;
		for(int i = 1; i <= 4; i++)
		{
			f = Arrays.copyOf(list, list.length);
			f[current] = i;
			if(current + 1 == max)
				listOperator.add(f);
			else
			{
				int add = current + 1;
				perm2(f, max, add);
			}
				
		}
	}
	
	
	private static void print(int[] list)
	{
		StringBuffer sb = new StringBuffer();
		for(int i = 0; i < list.length; i++)
		{
			sb.append(list[i]);
		}
		result.add(sb.toString());
		System.out.println(sb);
	}
	
	private static void print2(int[] list)
	{
		StringBuffer sb = new StringBuffer();
		for(int i = 0; i < list.length; i++)
		{
			sb.append(list[i]);
		}
		System.out.println(sb);
	}

}
