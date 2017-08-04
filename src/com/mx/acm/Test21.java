package com.mx.acm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
/**
 * 三个水杯
 * 描述 给出三个水杯，大小不一，并且只有最大的水杯的水是装满的，其余两个为空杯子。三个水杯之间相互倒水，并且水杯没有标识，只能根据给出的水杯体积来计算。现在要求你写出一个程序，使其输出使初始状态到达目标状态的最少次数。 
输入第一行一个整数N(0<N<50)表示N组测试数据
 接下来每组测试数据有两行，第一行给出三个整数V1 V2 V3 (V1>V2>V3 V1<100 V3>0)表示三个水杯的体积。
 第二行给出三个整数E1 E2 E3 （体积小于等于相应水杯体积）表示我们需要的最终状态输出每行输出相应测试数据最少的倒水次数。如果达不到目标状态输出-1
 
 * @author maoxin
 * 906819 ythyhvh 三个水杯 Accepted  168  14763 java 07-01 13:27:51 
 * 
 * BFS(广度优先搜索) 到达过的节点一定要记录
 */
public class Test21 {

	static boolean[][][] vis;
	static Node initcup;
	static Node targetcup;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new  InputStreamReader(System.in));
		StringTokenizer st;
		int i, j, result = 0, total = Integer.parseInt(br.readLine());
		Queue<Node> queue;
		Node tempNode, tempCup;
		while(total-- > 0)
		{
			st = new StringTokenizer(br.readLine());
			initcup = new Node(new int[]{Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())}, 0);
			st = new StringTokenizer(br.readLine());
			targetcup  = new Node(new int[]{Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())}, 0);
			
			vis = new boolean[100][100][100];
			queue = new LinkedList<Node>();
			Node node = new Node(new int[]{initcup.v[0], 0, 0}, 0);
			vis[node.v[0]][0][0] = true;
			queue.add(node);
			result = -1;
			
			//bfs
			while(!queue.isEmpty())
			{
				tempNode = queue.poll();
			 	if(tempNode.v[0] == targetcup.v[0] && tempNode.v[1] == targetcup.v[1] && tempNode.v[2] == targetcup.v[2])
				{
					result = tempNode.step;
					queue.clear();
					break;
				}
				
				for(i = 0; i < 3; ++i){            
					for(j = 0; j < 3; ++j){  
						tempCup =  new Node(new int[]{tempNode.v[0], tempNode.v[1], tempNode.v[2]}, tempNode.step);
					    if(i != j && del(tempCup, i, j)){                    
					        tempCup.step++;                     
					        queue.add(tempCup);         
					    }  
					}  
				} 
				
			}
			
			System.out.println(result);
		}

	}
	
	static boolean del(Node cup, int start, int end)
	{
		if(cup.v[start] >= 0 && cup.v[end] != initcup.v[end]){ //能倒水  
	        int sum = cup.v[start] + cup.v[end];  
	        if(sum >= initcup.v[end]) 
	        	cup.v[end] = initcup.v[end];  
	        else 
	        	cup.v[end] = sum;  
	        cup.v[start] = sum - cup.v[end];  
	        if(!vis[cup.v[0]][cup.v[1]][cup.v[2]])  
	            return vis[cup.v[0]][cup.v[1]][cup.v[2]] = true;              
	    }  
	    return false;
	}
	
	static class Node{
		private int[] v;
		private int step;
		
		public Node(int[] v, int step)
		{
			this.v = v;
			this.step = step;
		}
	}

}
