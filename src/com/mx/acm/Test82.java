package com.mx.acm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 
迷宫寻宝（一）

时间限制：1000 ms  |  内存限制：65535 KB 

难度：4

描述 
一个叫ACM的寻宝者找到了一个藏宝图，它根据藏宝图找到了一个迷宫，这是一个很特别的迷宫，迷宫里有N个编过号的门（N<=5)，它们分别被编号为A,B,C,D,E.为了找到宝藏，ACM必须打开门，但是，开门之前必须在迷宫里找到这个打开这个门所需的所有钥匙（每个门都至少有一把钥匙），例如：现在A门有三把钥匙，ACM就必须找全三把钥匙才能打开A门。现在请你编写一个程序来告诉ACM，他能不能顺利的得到宝藏。

 

输入输入可能会有多组测试数据（不超过10组）。
 每组测试数据的第一行包含了两个整数M,N(1<N,M<20)，分别代表了迷宫的行和列。接下来的M每行有N个字符，描述了迷宫的布局。其中每个字符的含义如下：
.表示可以走的路
S:表示ACM的出发点
G表示宝藏的位置
X表示这里有墙，ACM无法进入或者穿过。
A,B,C,D,E表示这里是门，a,b,c,d,e表示对应大写字母的门上的钥匙。
 注意ACM只能在迷宫里向上下左右四个方向移动。

 最后，输入0 0表示输入结束。输出每行输出一个YES表示ACM能找到宝藏，输出NO表示ACM找不到宝藏。
 * 
 * 1210857 ythyhvh 迷宫寻宝（一） Accepted  36  246 java 03-31 16:37:05 
 */

public class Test82 {

	static int[][] pathArr = {{0, -1}, {0, 1}, {-1, 0}, {1, 0}}; 
	static Points start;
	static Map<String, Integer> keyMap;
	static Map<String, Points> pointMap;
	static String[][] f;
	static int row, column;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while(true)
		{
			String line = br.readLine().trim();
			StringTokenizer st = new StringTokenizer(line);
			row = Integer.parseInt(st.nextToken());
			column = Integer.parseInt(st.nextToken());
			if(row == 0 && column == 0)
				break;
			
			f = new String[row + 1][column + 1];
			keyMap = new HashMap<String, Integer>();
			pointMap = new HashMap<String, Points>();
			
			for(int i = 1; i <= row; i++)
			{
				line = br.readLine().trim();
				for(int j = 1; j <= column; j++)
				{
					f[i][j] = line.substring(j - 1, j);
					if(f[i][j].equals("A") || f[i][j].equals("E") || 
							f[i][j].equals("B") || f[i][j].equals("C") || f[i][j].equals("D") )
						pointMap.put(f[i][j], new Points(i, j));
					if(f[i][j].equals("a") || f[i][j].equals("b") || f[i][j].equals("c") ||
							f[i][j].equals("d") || f[i][j].equals("e"))
						keyMap.put(f[i][j], keyMap.get(f[i][j]) == null ? 1 : keyMap.get(f[i][j]) + 1);
					if(f[i][j].equals("S"))
						start = new Points(i, j);
				}
			}
			
			boolean result = false;
			while(true)
			{
				int t = bfs();
				if(t == 0)
				{
					result = true;
					break;
				}
				else if(t == -1)
					break;
			}
			
			
			System.out.println(result ? "YES" : "NO");
			
		}
	}
	
	// -1 没有路径  0 找到宝藏  1 找到钥匙 需要再次遍历
	static int bfs()
	{
		int[][] visited = new int[row + 1][column + 1];
		Queue<Points> queue = new LinkedList<Points>();
		queue.add(start);
		visited[start.row][start.column] = 1;
		int result = -1;
		while(!queue.isEmpty())
		{
			Points temp = queue.poll();
			for(int i = 0; i < 4; i++)
			{
				int temprow = temp.row;
				int tempcolumn = temp.column;
				int x = temprow + pathArr[i][0];
				int y = tempcolumn + pathArr[i][1];
				if(x < 1 || x > row || y < 1 || y > column)
					continue;
				if(f[x][y].equals("X"))
					continue;
				else if(f[x][y].equals("G"))
				{
					return 0;
				}
				if(f[x][y].equals("a") || f[x][y].equals("b") || f[x][y].equals("c") ||
						f[x][y].equals("d") || f[x][y].equals("e"))
				{
					keyMap.put(f[x][y], keyMap.get(f[x][y]) - 1); 
					if(keyMap.get(f[x][y]) == 0)
						result = 1;
					f[x][y] = "."; //钥匙只能获得一次
					if(visited[x][y] == 0)
					{
						queue.add(new Points(x, y));
						visited[x][y] = 1;
					}
					
				}
				if(f[x][y].equals("A") || f[x][y].equals("B") || f[x][y].equals("C") ||
						f[x][y].equals("D") || f[x][y].equals("E"))
				{
					if((keyMap.get(f[x][y].toLowerCase()) != null &&  keyMap.get(f[x][y].toLowerCase()) == 0))
					{
						f[x][y] = "."; //钥匙足够的情况  打开门
						if(visited[x][y] == 0)
						{
							queue.add(new Points(x, y));
							visited[x][y] = 1;
						}
					}
				}
				else
				{
					if(visited[x][y] == 0)
					{
						queue.add(new Points(x, y));
						visited[x][y] = 1;
					}
				}
					
			}
						
		}
		
		return result;
	}
	
	static class Points{
		private int row;
		private int column;
		
		
		public int getRow() {
			return row;
		}

		public void setRow(int row) {
			this.row = row;
		}

		public int getColumn() {
			return column;
		}

		public void setColumn(int column) {
			this.column = column;
		}

		Points(int aRow, int aColumn)
		{
			row = aRow;
			column = aColumn;
		}
		
	}
	
	

}
