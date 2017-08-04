package com.mx.acm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Test80 {

	private static int[][] steps = {{0, -1}, {1, 0}, {0, 1}, {-1, 0}};
	private static List<String> results;
	private static int[][] input;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int no = 1;
		while(true)
		{
			String line = br.readLine().trim();
			if(!line.startsWith("*"))
				break;
			input = new int[3][3];
			input[0][1] = line.charAt(1) == 'B' ? 1 : 2;
			input[0][2] = line.charAt(2) == 'B' ? 1 : 2;
			line = br.readLine().trim();
			input[1][0] = line.charAt(0) == 'B' ? 1 : 2;
			input[1][1] = line.charAt(1) == 'B' ? 1 : 2;
			input[1][2] = line.charAt(2) == 'B' ? 1 : 2;
			line = br.readLine().trim();
			input[2][0] = line.charAt(0) == 'B' ? 1 : 2;
			input[2][1] = line.charAt(1) == 'B' ? 1 : 2;
			input[2][2] = line.charAt(2) == 'B' ? 1 : 2;
			
			results = new ArrayList<String>();
			int[][] visited = new int[3][3];
			visited[0][0] = 1; 
			Node start = new Node(0, 0, 0, visited);
			Node[] init = new Node[9];
			init[0] = start;
			dp(init, "0", 0);
			
			System.out.println("Case " + no + ": " + results.size());
			no++;
		}

	}
	
	
	private static void dp(Node[] nodelist, String result, int index)
	{
		Node from = nodelist[index];
		int[][] visited = copyArray33(from.visited);
		for(int i = 0; i < 4; i++)
		{
			int x = from.x + steps[i][0];
			int y = from.y + steps[i][1];
			if(x < 0 || x > 2 || y < 0 || y > 2)
				continue;
			if(visited[x][y] == 1)
				continue;
			visited[x][y] = 2; // 2为可选
		}
		for(int i = 0; i < 3; i++)
		{
			for(int j = 0; j < 3; j++)
			{
				if(visited[i][j] == 2)
				{
					int[][] visitedNow = copyArray33(visited);
					visitedNow[i][j] = 1;
					int step = from.step + 1;
					Node now = new Node(i, j, step, visitedNow);
					Node[] nowArray = nodelist.clone();
					nowArray[step] = now;
					String end = result + input[i][j];
					if(step == 8)
					{
						if(!results.contains(end))
							results.add(end);
					}
					else
					{
						dp(nowArray, end, step);
					}
				}
			}
		}
	}
	
	private static int[][] copyArray33(int[][] input)
	{
		int[][] result = new int[3][3];
		for(int i = 0; i < 3; i++)
		{
			for(int j = 0; j < 3; j++)
			{
				result[i][j] = input[i][j];
			}
		}
		return result;
	}
	
	private static class Node{
		int x;
		int y;
		int[][] visited;
		int step;
		
		Node(int x, int y, int step, int[][] visited)
		{
			this.x = x;
			this.y = y;
			this.step = step;
			this.visited = visited;
		}
	}

}
