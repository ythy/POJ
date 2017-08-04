package com.mx.acm;

import java.util.Scanner;
/**
 * 蛇形填数
 *描述 
在n*n方陈里填入1,2,...,n*n,要求填成蛇形。例如n=4时方陈为：
10 11 12 1
9 16 13 2
8 15 14 3
7 6 5 4

输入
直接输入方陈的维数，即n的值。(n<=100)
输出
输出结果是蛇形方陈
 * @author maoxin
 * 855557 ythyhvh 蛇形填数 Accepted  92  1546 java 05-07 15:15:43 
 */
public class Test33 {
	
	private static int[][] f;
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int num  = scanner.nextInt();
		if(num == 1)
			System.out.println(1);
		else
		{
			f = new int[num + 1][num + 1];
			int start = 1;
			int id = 1;
			int tnum = num;
			//从外圈大方阵圈开始  循环计算每一个方阵圈的值 赋给2维数组  小方阵维数为大方阵 -2， 循环一次 tnum - 2, id + 1
			while(start <= num*num)
			{
				start = setNum(tnum, start, id);
				tnum-=2;
				id++;
			}
			int i,j;
			StringBuffer sb;;
			for(i = 1; i <= num; i++)
			{
				sb = new StringBuffer();
				for(j = 1; j <= num; j++)
				{
					sb.append(f[i][j] + " ");
				}
				System.out.println(sb.toString());
			}
		}
		
	}
	
	/**
	 * 计算方阵一圈的数值
	 * 先计算TOP行  然后 循环计算LEFT和RIGHT2列，最后计算BOTTOM
	 * @param mnum  维数
	 * @param start 方阵起始值  位于左上角。
	 * @param i 第一个方阵循环是1  向后依次+1
	 * @return
	 */
	private static int setNum(int mnum, int start, int i)
	{
		if(mnum == 1)
		{
			f[i][i] = start; 
			return start + 1;
		}
		int tmnum = mnum; //递归赋值 需要在原基础上加index
		if(i != 1)
			tmnum += (i - 1);
		
		f[i][tmnum] = start;  //TOP 最后一个值
		int firstNum = 2*(mnum - 2) + 2 + mnum + start - 1;
		f[i][i] = firstNum;  //TOP 第一个值
		int j;
		for(j = 1; j < mnum; j++)
		{
			if(i + j < tmnum)
				f[i][i + j] = firstNum + j; //TOP其他值
			f[i + j][tmnum] = start + j; //RIGHT 值
			f[i + j][i] = firstNum - j; //LEFT 值
		}
		for(j = 1; j <= mnum - 2; j++)
		{
			f[tmnum][j + i] = f[tmnum][i]  - j; //BOTTOM 值
		}
		
		return f[i][tmnum - 1] + 1;
	}
}
