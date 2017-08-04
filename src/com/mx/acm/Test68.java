package com.mx.acm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 
三点顺序

时间限制：1000 ms  |  内存限制：65535 KB 

难度：3

描述 
现在给你不共线的三个点A,B,C的坐标，它们一定能组成一个三角形，现在让你判断A，B，C是顺时针给出的还是逆时针给出的？

如：

图1：顺时针给出

图2：逆时针给出 




 

        <图1>                   <图2>

输入每行是一组测试数据，有6个整数x1,y1,x2,y2,x3,y3分别表示A,B,C三个点的横纵坐标。（坐标值都在0到10000之间）
 输入0 0 0 0 0 0表示输入结束
 测试数据不超过10000组输出如果这三个点是顺时针给出的，请输出1，逆时针给出则输出0
 * @author maoxin
 * 1364511	ythyhvh	三点顺序	Accepted	297	1130	java	09-17 16:43:13
 */
public class Test68 {

	 
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		String line;
		int xa, xb, xc, ya, yb, yc; 
		while(true)
		{
			line = br.readLine().trim();
			if(line.equals("0 0 0 0 0 0"))
				break;
			st = new StringTokenizer(line);
			xa = Integer.parseInt(st.nextToken());
			ya = Integer.parseInt(st.nextToken());
			xb = Integer.parseInt(st.nextToken());
			yb = Integer.parseInt(st.nextToken());
			xc = Integer.parseInt(st.nextToken());
			yc = Integer.parseInt(st.nextToken());
			
			// 向量a AB  1 xb-xa, 2 yb - ya ;
			// 向量b AC  3 xc-xa, 4 yc - ya ;
			// 向量积a*b = 2阶矩阵表达式的值   1*4 - 2*3   右手法则， a - b 逆时针 拇指向上 > 0, a - b 顺时针  拇指向下  < 0
			
			int result = (xb - xa) * (yc - ya) - (yb - ya) * (xc - xa);
			System.out.println(result > 0 ? 0 : 1);
		}
	}

}
