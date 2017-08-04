package com.mx.acm;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
/**
 * skiing
 * 
 * 描述 Michael喜欢滑雪百这并不奇怪， 因为滑雪的确很刺激。可是为了获得速度，滑的区域必须向下倾斜，而且当你滑到坡底，你不得不再次走上坡或者等待升降机来载你。Michael想知道载一个区域中最长底滑坡。区域由一个二维数组给出。数组的每个数字代表点的高度。下面是一个例子 
1 2 3 4 5

 16 17 18 19 6

 15 24 25 20 7

 14 23 22 21 8

 13 12 11 10 9

一个人可以从某个点滑向上下左右相邻四个点之一，当且仅当高度减小。在上面的例子中，一条可滑行的滑坡为24-17-16-1。当然25-24-23-...-3-2-1更长。事实上，这是最长的一条。

输入第一行表示有几组测试数据，输入的第二行表示区域的行数R和列数C(1 <= R,C <= 100)。下面是R行，每行有C个整数，代表高度h，0<=h<=10000。
 后面是下一组数据；
输出输出最长区域的长度。

 * @author maoxin
 * 963286 ythyhvh skiing Accepted  424  17580 java 08-29 13:32:32 
 */
public class Test10 {
	
	static int[][] maze;
	static int[][] stepArr = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}}; //左右上下
	static Queue<Node> queue;
	static int row, column;
	
	static Scanner scanner = new Scanner(System.in); 
	public static void main(String[] args){
		int total = scanner.nextInt();
		int i, j, max;
		while(total-- > 0)
		{
			row = scanner.nextInt();
			column = scanner.nextInt();
			maze = new int[row][column];
			max = Integer.MIN_VALUE;
			for(i = 0; i < row; i++)
			{
				for(j = 0; j < column; j++)
				{
					maze[i][j] = scanner.nextInt();
				}
			}
			
			for(i = 0; i < row; i++)
			{
				for(j = 0; j < column; j++)
				{
					max = Math.max(bfs(i, j), max);
				}
			}
			
			System.out.println(max);
		}

	}
	
	private static int bfs(int srow, int scolumn)
	{
		queue =  new LinkedList<Node>();
		int max = 1;
		Node first = new Node(srow, scolumn, 1);
		queue.add(first);
		while(!queue.isEmpty())
		{
			Node tempNode = queue.poll();
			for(int i = 0; i < 4; i++)
			{
				int y = tempNode.row + stepArr[i][1];
				int x = tempNode.column + stepArr[i][0];
				if(x < 0 || y < 0 || x >= column  || y >= row)
					continue;
				if(maze[y][x] < maze[tempNode.row][tempNode.column])
				{
					int newStep = tempNode.step + 1;
					queue.add(new Node(y, x, newStep));
					max = Math.max(max, newStep);
				}
				
			}
		}
		return max;
	}
	
	private static class Node{
		private int step;
		private int row;
		private int column;
		
		public Node(int row, int column, int step){
			this.row = row;
			this.column = column;
			this.step = step;
			
		}
	}
}
