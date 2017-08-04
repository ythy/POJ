package com.mx.acm;

import java.util.Scanner;
/**
 * 
吝啬的国度

时间限制：1000 ms  |  内存限制：65535 KB 

难度：3

描述 在一个吝啬的国度里有N个城市，这N个城市间只有N-1条路把这个N个城市连接起来。现在，Tom在第S号城市，他有张该国地图，他想知道如果自己要去参观第T号城市，必须经过的前一个城市是几号城市（假设你不走重复的路）。
输入第一行输入一个整数M表示测试数据共有M(1<=M<=5)组
 每组测试数据的第一行输入一个正整数N(1<=N<=100000)和一个正整数S(1<=S<=100000)，N表示城市的总个数，S表示参观者所在城市的编号
 随后的N-1行，每行有两个正整数a,b(1<=a,b<=N)，表示第a号城市和第b号城市之间有一条路连通。输出每组测试数据输N个正整数，其中，第i个数表示从S走到i号城市，必须要经过的上一个城市的编号。（其中i=S时，请输出-1）
 * @author maoxin
 * 1214961 ythyhvh 吝啬的国度 Accepted  1962  20818 java 04-03 14:26:38 
 */
public class Test20 {
 
	static int[] visited;
	static int[] result;
	static String[] data;
	public static void main(String[] args){
		Scanner scanner = new Scanner(System.in);
		int buildingNum;
		int start;
		int total = scanner.nextInt();
		while(total-- > 0)
		{
			buildingNum = scanner.nextInt();
			start = scanner.nextInt();
			visited = new int[buildingNum + 1];
			visited[start] = 1;
			result = new int[buildingNum + 1];
			result[start] = -1;
			data = new String[buildingNum + 1];
			for(int i = 0; i < buildingNum - 1; i++)
			{
				int from = scanner.nextInt();
				int to = scanner.nextInt();
				
				String temp = data[from];
				if(temp == null)
					temp = String.valueOf(to);
				else
					temp += "," + String.valueOf(to);
				data[from] = temp;
				
				String temp2 = data[to];
				if(temp2 == null)
					temp2 = String.valueOf(from);
				else
					temp2 += "," + String.valueOf(from);
				data[to] = temp2;
			}
			
			dfs(start, buildingNum);
			
			for(int i = 1; i <= buildingNum ; i++)
			{
				System.out.print(result[i] +  " ");
			}
		}
	}
	
	static void dfs(int start, int buildingNum)
	{
		String temp = data[start];
		if(temp == null)
			return;
		String [] tempArr = temp.split(",");
		for(int i = 0; i < tempArr.length; i++)
		{
			int index = Integer.parseInt(tempArr[i]);
			if(visited[index] == 0)
			{
				result[index] = start;
				visited[index] = 1;
				dfs(index, buildingNum);
			}
		}
	}
}
