package com.mx.acm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 描述 小明家的院子里有一棵苹果树，每到秋天树上就会结出10个苹果。苹果成熟的时候，小明就会跑去摘苹果。小明有个30厘米高的板凳，当她不能直接用手摘到苹果的时候，就会踩到板凳上再试试。
 　　现在已知10个苹果到地面的高度，以及小明把手伸直的时候能够达到的最大高度，请帮小明算一下她能够摘到的苹果的数目。假设她碰到苹果，苹果就会掉下来。
输入第一行输入N（0<N<100）表示测试数据组数，接下来每组测试输入包括两行数据。第一行包含10个100到200之间（包括100和200）的整数（以厘米为单位）分别表示10个苹果到地面的高度，两个相邻的整数之间用一个空格隔开。第二行只包括一个100到120之间（包含100和120）的整数（以厘米为单位），表示小明把手伸直的时候能够达到的最大高度。输出输出包括一行，这一行只包含一个整数，表示小明能够摘到的苹果的数目。
 * @author maoxin
 * 922594 ythyhvh 爱摘苹果的小明 Accepted  11  61 java 07-18 17:02:43 
 */
public class Test50 {

	 
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new  InputStreamReader(System.in));
		StringTokenizer st;
		int total = Integer.parseInt(br.readLine());
		int gao, result;
		while(total-- > 0)
		{
			result = 0;
			st = new StringTokenizer(br.readLine());
			gao = Integer.parseInt(br.readLine());
			while(st.hasMoreTokens())
			{
				if(Integer.parseInt(st.nextToken()) <= gao + 30)
					result++;
			}
			System.out.println(result);
				
		}

	}

}
