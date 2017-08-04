package com.mx.acm;

import java.util.LinkedList;
import java.util.Queue;

public class Main21_2 {

	 
	static int maxn = 3;
	static int[][] visit = new int[maxn][maxn];
	static int[][] stepArr = {{-1,0},{1,0},{0,-1},{0,1}}; 
	static int[][] mazeArr = {{0,0,1}, {0,0,1}, {0,0,0}};//new int[maxn][maxn];
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(bfs());
	}
	
	private static int bfs() {
	    Node node = new Node(0, 0, 0);
	    Queue<Node> queue = new LinkedList<Node>();
	    queue.add(node);
	    while (!queue.isEmpty()) {
	        Node newNode = queue.poll();
	        visit[newNode.x][newNode.y] = 1;
	        for (int i = 0; i < 4; i++) {
	            int x = newNode.x + stepArr[i][0];
	            int y = newNode.y + stepArr[i][1];
	            if (x == maxn-1 && y == maxn-1) {
	                return newNode.step+1;
	            }
	            if (x >= 0 && y >= 0 && x < maxn && y < maxn
	                        && visit[x][y] == 0 && mazeArr[x][y] == 0) {
	                Node next = new Node(x, y, newNode.step+1);
	                queue.add(next);
	            }
	        }
	    }
	    return -1;
	}
	
	private static class Node{
	    private int x;
	    private int y;
	    private int step;
	    public Node(int x, int y, int step) {
	        super();
	        this.x = x;
	        this.y = y;
	        this.step = step;
	    }
	}


}
