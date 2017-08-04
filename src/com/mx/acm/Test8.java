package com.mx.acm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/**
 * 一种排序
 * 
 * 述 现在有很多长方形，每一个长方形都有一个编号，这个编号可以重复；还知道这个长方形的宽和长，编号、长、宽都是整数；现在要求按照一下方式排序（默认排序规则都是从小到大）；

1.按照编号从小到大排序

2.对于编号相等的长方形，按照长方形的长排序；

3.如果编号和长都相同，按照长方形的宽排序；

4.如果编号、长、宽都相同，就只保留一个长方形用于排序,删除多余的长方形；最后排好序按照指定格式显示所有的长方形；
输入第一行有一个整数 0<n<10000,表示接下来有n组测试数据；
 每一组第一行有一个整数 0<m<1000，表示有m个长方形；
 接下来的m行，每一行有三个数 ，第一个数表示长方形的编号，

 第二个和第三个数值大的表示长，数值小的表示宽，相等
 说明这是一个正方形（数据约定长宽与编号都小于10000）；输出顺序输出每组数据的所有符合条件的长方形的 编号 长 宽
 
 * @author maoxin
 * 962615 ythyhvh 一种排序 Accepted  105  492 java 08-28 15:47:07 
 */
public class Test8 {

	static List<Node> list;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new  InputStreamReader(System.in));
		int total = Integer.parseInt(br.readLine());
		StringTokenizer st;
		int sum, i;
		while(total-- > 0)
		{
			sum = Integer.parseInt(br.readLine());
			list = new ArrayList<Node>();
			for(i = 0; i < sum; i++)
			{
				st = new StringTokenizer(br.readLine());
				insertArray(st);
			}
			
			for(i = 0; i < list.size(); i++)
			{
				System.out.println(list.get(i).getNo() + " " + list.get(i).getHeight() + " " + list.get(i).getWidth());
			}
			
		}
		
	}
	
	static void insertArray(StringTokenizer st)
	{
		int tno = Integer.parseInt(st.nextToken());
		int twidth1 = Integer.parseInt(st.nextToken());
		int twidth2 =Integer.parseInt(st.nextToken());
		int i;
		Node newNode = new Node(tno, twidth1, twidth2);
		if(list.size() == 0)
		{
			list.add(newNode);
			return;
		}
			
 		for(i = 0; i < list.size(); i++)
		{
			if(compared(newNode, list.get(i)) == 1)
			{
				list.add(i, newNode);
				break;
			} 
			if(compared(newNode, list.get(i)) == 0)
			{
				break;
			} 
			if(compared(newNode, list.get(i)) == -1 && i == list.size() - 1)
			{
				list.add(newNode);
				break;
			} 
		}
	}
	
	//前面1   后面-1  删除0
	static int compared(Node node1, Node node2)
	{
		int result = -1;
		if(node1.getNo() < node2.getNo())
			result = 1;
		else if(node1.getNo() > node2.getNo())
			result = -1;
		else if(node1.getNo() == node2.getNo())
		{
			if(node1.getHeight() == node2.getHeight() && node1.getWidth() == node2.getWidth())
				result = 0;
			else if(node1.getHeight() > node2.getHeight())
				result = -1;
			else if(node1.getHeight() < node2.getHeight())
				result = 1;
			else if(node1.getWidth() > node2.getWidth())
				result = -1;
			else if(node1.getWidth() > node2.getWidth())
				result = 1;
		}
		return result;
	}
	
	static class Node{
		private int no;
		private int height;
		private int width;
		private int first;
		private int second;
		
		public int getNo() {
			return no;
		}

		public int getHeight() {
			return height;
		}

		public int getWidth() {
			return width;
		}

		public int getFirst() {
			return first;
		}

		public int getSecond() {
			return second;
		}

		public Node(int sNo, int sFirst, int sSecond)
		{
			no = sNo;
			first = sFirst;
			second = sSecond;
			height = Math.max(first, second);
			width = Math.min(first, second);
		}
	}

}
