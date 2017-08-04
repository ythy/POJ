package com.mx.acm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
/**
 * 最少步数
 * 
 * 描述 
这有一个迷宫，有0~8行和0~8列：

 1,1,1,1,1,1,1,1,1
  1,0,0,1,0,0,1,0,1
  1,0,0,1,1,0,0,0,1
  1,0,1,0,1,1,0,1,1
  1,0,0,0,0,1,0,0,1
  1,1,0,1,0,1,0,0,1
  1,1,0,1,0,1,0,0,1
  1,1,0,1,0,0,0,0,1
  1,1,1,1,1,1,1,1,1

0表示道路，1表示墙。

现在输入一个道路的坐标作为起点，再如输入一个道路的坐标作为终点，问最少走几步才能从起点到达终点？

（注：一步是指从一坐标点走到其上下左右相邻坐标点，如：从（3，1）到（4,1）。）

输入第一行输入一个整数n（0<n<=100），表示有n组测试数据;
随后n行,每行有四个整数a,b,c,d（0<=a,b,c,d<=8）分别表示起点的行、列，终点的行、列。输出输出最少走几步。


 * @author maoxin
 * 917303 ythyhvh 最少步数 Accepted  8  309 java 07-14 10:05:48 
 */
public class Test58 {

	private static int[][] maze = { { 1, 1, 1, 1, 1, 1, 1, 1, 1 },
			{ 1, 0, 0, 1, 0, 0, 1, 0, 1 }, { 1, 0, 0, 1, 1, 0, 0, 0, 1 },
			{ 1, 0, 1, 0, 1, 1, 0, 1, 1 }, { 1, 0, 0, 0, 0, 1, 0, 0, 1 },
			{ 1, 1, 0, 1, 0, 1, 0, 0, 1 }, { 1, 1, 0, 1, 0, 1, 0, 0, 1 },
			{ 1, 1, 0, 1, 0, 0, 0, 0, 1 }, { 1, 1, 1, 1, 1, 1, 1, 1, 1 } };
	
	static Queue<Node> queue;
	static int[][] visited;
	static int[][] stepArr = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}}; //左右上下
	static int max = 8;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new  InputStreamReader(System.in));
		StringTokenizer st;
		int total = Integer.parseInt(br.readLine());
		int startX, startY, endX, endY;
		while(total-- > 0)
		{
			st = new StringTokenizer(br.readLine());
			startX = Integer.parseInt(st.nextToken());
			startY = Integer.parseInt(st.nextToken());
			endX = Integer.parseInt(st.nextToken());
			endY = Integer.parseInt(st.nextToken());
			System.out.println(bfs(startX, startY, endX, endY));;
		}
		
	}
	
	private static int bfs(int startX, int startY, int endX, int endY)
	{
		if(startX == endX && startY == endY)
			return 0;
		
		queue =  new LinkedList<Node>();
		visited = new int[max + 1][max + 1];
		
		Node first = new Node(startX, startY, 0);
		queue.add(first);
		while(!queue.isEmpty())
		{
			Node tempNode = queue.poll();
			visited[tempNode.x][tempNode.y] = 1;
			
			for(int i = 0; i <4; i++)
			{
				int x = tempNode.x + stepArr[i][0];
				int y = tempNode.y + stepArr[i][1];
				if(x < 0 || y < 0 || x > max || y > max)
					continue;
				if(x == endX && y == endY)
					return tempNode.step + 1;
				
				if(visited[x][y] == 0 && maze[x][y] == 0)
				{
					visited[x][y] = 1;
					queue.add(new Node(x, y, tempNode.step + 1));
				}
				
			}
		}
		return -1;
	}
	
	private static class Node{
		private int step;
		private int x;
		private int y;
		
		public Node(int x, int y, int step){
			this.x = x;
			this.y = y;
			this.step = step;
			
		}
	}
}
