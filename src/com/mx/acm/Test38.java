package com.mx.acm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 布线问题

时间限制：1000 ms  |  内存限制：65535 KB 

难度：4

 * 描述 南阳理工学院要进行用电线路改造，现在校长要求设计师设计出一种布线方式，该布线方式需要满足以下条件：
1、把所有的楼都供上电。
2、所用电线花费最少

输入第一行是一个整数n表示有n组测试数据。(n<5)
每组测试数据的第一行是两个整数v,e.
 v表示学校里楼的总个数(v<=500)
随后的e行里，每行有三个整数a,b,c表示a与b之间如果建铺设线路花费为c(c<=100)。（哪两栋楼间如果没有指明花费，则表示这两栋楼直接连通需要费用太大或者不可能连通）
 随后的1行里，有v个整数,其中第i个数表示从第i号楼接线到外界供电设施所需要的费用。( 0<e<v*(v-1)/2 )
（楼的编号从1开始），由于安全问题，只能选择一个楼连接到外界供电设备。
 数据保证至少存在一种方案满足要求。输出每组测试数据输出一个正整数,表示铺设满足校长要求的线路的最小花费。
 * 
 * 1212288 ythyhvh 布线问题 Accepted  267  1397 java 04-01 16:07:41 
 *  prim算法  图论
 */

public class Test38 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new  InputStreamReader(System.in));
		StringTokenizer st;
		int total = Integer.parseInt(br.readLine());
		while(total-- > 0)
		{
			st = new StringTokenizer(br.readLine());
			int buildingNum = Integer.parseInt(st.nextToken());
			int dataNum = Integer.parseInt(st.nextToken());
			int[][] matrixAc = new int[buildingNum + 1][buildingNum + 1]; //建立邻接矩阵
			for(int i = 0; i < dataNum; i++)
			{
				st = new StringTokenizer(br.readLine());
				int from = Integer.parseInt(st.nextToken());
				int to = Integer.parseInt(st.nextToken());
				int weight = Integer.parseInt(st.nextToken());
				matrixAc[from][to] = weight;
				matrixAc[to][from] = weight;
			}
			
			
			int startNum = Integer.MAX_VALUE;
			int start = -1;
			st = new StringTokenizer(br.readLine()); //起始数组
			for(int k = 1; k <= buildingNum; k++)
			{
				int temp = Integer.parseInt(st.nextToken());
				if(temp < startNum)
				{
					startNum = temp;
					start = k;
				}
			}
			
			int current = 1;
			int[] resultAc = new int[buildingNum + 1];
			resultAc[current] = start;
			
			//从start 开始计算  选中过的为-1 待选为 具体权重 0为不邻接
			int[] weightAc = new int[buildingNum + 1];
			for(int j = 1; j <= buildingNum; j++)
			{
				weightAc[j] = matrixAc[start][j];
			}
			weightAc[start] = -1;
			
			for(int i = 1; i <= buildingNum; i++)
			{
				if(i == start)
					continue;
				int minTemp = Integer.MAX_VALUE;
				int nodeTemp = -1;
				for(int j = 1; j <= buildingNum; j++)
				{
					if(weightAc[j] > 0 && weightAc[j] < minTemp)
					{
						nodeTemp = j;
						minTemp = weightAc[j];
					}
				}
				
				current++;
				resultAc[current] = nodeTemp;
				startNum += minTemp;
				
				//更新顶点最短距离
				weightAc[nodeTemp] = -1;
				for(int j = 1; j <= buildingNum; j++)
				{
					if(matrixAc[nodeTemp][j] != 0 && matrixAc[nodeTemp][j] < weightAc[j])
						weightAc[j] = matrixAc[nodeTemp][j];
					if(matrixAc[nodeTemp][j] != 0 && weightAc[j] == 0)
						weightAc[j] = matrixAc[nodeTemp][j];
				}
			}
				
			
			System.out.println(startNum);
			
		}

	}

}
