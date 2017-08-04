package com.mx.acm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 传纸条（一）
 * 描述 
小渊和小轩是好朋友也是同班同学，他们在一起总有谈不完的话题。一次素质拓展活动中，班上同学安排做成一个m行n列的矩阵，而小渊和小轩被安排在矩阵对角线的两端，因此，他们就无法直接交谈了。幸运的是，他们可以通过传纸条来进行交流。纸条要经由许多同学传到对方手里，小渊坐在矩阵的左上角，坐标(1,1)，小轩坐在矩阵的右下角，坐标(m,n)。从小渊传到小轩的纸条只可以向下或者向右传递，从小轩传给小渊的纸条只可以向上或者向左传递。 

 在活动进行中，小渊希望给小轩传递一张纸条，同时希望小轩给他回复。班里每个同学都可以帮他们传递，但只会帮他们一次，也就是说如果此人在小渊递给小轩纸条的时候帮忙，那么在小轩递给小渊的时候就不会再帮忙。反之亦然。 


还有一件事情需要注意，全班每个同学愿意帮忙的好感度有高有低（注意：小渊和小轩的好心程度没有定义，输入时用0表示），可以用一个0-1000的自然数来表示，数越大表示越好心。小渊和小轩希望尽可能找好心程度高的同学来帮忙传纸条，即找到来回两条传递路径，使得这两条路径上同学的好心程度之和最大。现在，请你帮助小渊和小轩找到这样的两条路径。 

输入第一行输入N(0<N<100)表示待测数据组数。
 每组测试数据输入的第一行有2个用空格隔开的整数m和n，表示班里有m行n列（2<=m,n<=50）。 
 接下来的m行是一个m*n的矩阵，矩阵中第i行j列的整数表示坐在第i行j列的学生的好心程度（不大于1000）。每行的n个整数之间用空格隔开。输出每组测试数据输出共一行，包含一个整数，表示来回两条路上参与传递纸条的学生的好心程度之和的最大值。 
 
 * 1201669 ythyhvh 传纸条（一） Accepted  255  13732 java 03-20 10:15:31 
 * 
 * 思想：动态规划，一共需要计算K步(K条斜线)，每步2个点(即2行，每行与K有一个交点，需要通过行m计算出当前点的y坐标值），第K步的值(k和2个m)相当于K-1步的值 (k-1和2个m的上一步四种可能取最大的  + k的F值)
 * 所以双循环都是以m循环的。
 */
public class Test61 {

	 
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new  InputStreamReader(System.in));
		StringTokenizer st;
		int total = Integer.parseInt(br.readLine());
		int[][] f;
		int m,n;
		while(total-- > 0)
		{
			st = new StringTokenizer(br.readLine());
			m = Integer.parseInt(st.nextToken());
			n = Integer.parseInt(st.nextToken());
			f = new int[m + 1][n + 1];
			for(int i = 1; i <= m; i++)
			{
				st = new StringTokenizer(br.readLine());
				for(int j = 1; j <= n; j++)
					f[i][j] = Integer.parseInt(st.nextToken());
			}
			
			int[][][]dp = new int[110][52][52];
			int yi,yj;
			for(int k = 1; k <= m + n - 3; k++ ) //K为总步数
			{
				for(int i = 1; i <= m; i++) //第1个点
				{
					for(int j = 1; j <= m && j != i; j++) //第二个点
					{
						yi = getY(k, i); //第一个点的y值
						yj = getY(k, j); //第二个点的y值
						if(yi < 1 || yj < 1 || yi > n || yj > n){
							continue;
						}
						if(i - 1 == j) //上2个点不能重合
							dp[k][i][j] = Math.max(dp[k - 1][i][j], 
									Math.max(dp[k - 1][i][j - 1], dp[k - 1][i - 1][j - 1])) + f[i][getY(k, i)] + f[j][getY(k, j)]; 
						else
							dp[k][i][j] = Math.max(Math.max(dp[k - 1][i][j],dp[k - 1][i - 1][j]), 
								Math.max(dp[k - 1][i][j - 1], dp[k - 1][i - 1][j - 1])) + f[i][getY(k, i)] + f[j][getY(k, j)]; 
					}
				}
			}
			//输出最后一个斜线上点(必然是固定2个 m行和m-1行)
			System.out.println(dp[m + n - 3][m][m - 1]);
		}

	}
	
	static int getY(int k, int i)
	{
		return k + 2 - i;
	}

}
