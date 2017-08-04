package com.mx.acm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/**
 * 喷水装置（二）
 * 
 * 描述 有一块草坪，横向长w,纵向长为h,在它的橫向中心线上不同位置处装有n(n<=10000)个点状的喷水装置，每个喷水装置i喷水的效果是让以它为中心半径为Ri的圆都被润湿。请在给出的喷水装置中选择尽量少的喷水装置，把整个草坪全部润湿。
输入第一行输入一个正整数N表示共有n次测试数据。
 每一组测试数据的第一行有三个整数n,w,h，n表示共有n个喷水装置，w表示草坪的横向长度，h表示草坪的纵向长度。
 随后的n行，都有两个整数xi和ri,xi表示第i个喷水装置的的横坐标（最左边为0），ri表示该喷水装置能覆盖的圆的半径。输出每组测试数据输出一个正整数，表示共需要多少个喷水装置，每个输出单独占一行。
 如果不存在一种能够把整个草坪湿润的方案，请输出0。
 * @author maoxin
 * 999189 ythyhvh 喷水装置（二） Accepted  63  430 java 10-09 17:08:03 
 */

public class Test12 {

	/**
	 * @param args
	 * @throws IOException 
	 * @throws NumberFormatException 
	 */
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new  InputStreamReader(System.in));
		StringTokenizer st;
		int total = Integer.parseInt(br.readLine());
		int num, i;
		PriorityQueue<Note> notes;
		double x, r, w;
		double start, end, height, width;
		while(total-- > 0)
		{
			st = new StringTokenizer(br.readLine());
			num = Integer.parseInt(st.nextToken());
			width = Double.valueOf(st.nextToken());
			height = Double.valueOf(st.nextToken())/2;
			start = 0;
			end = width;
			
			notes = new PriorityQueue<Note>(11, comparator);
			Note tempNote = null;
			for(i = 0; i < num; i++)
			{
				st = new StringTokenizer(br.readLine());
				x = Double.valueOf(st.nextToken());
				r = Double.valueOf(st.nextToken());
				if(r > height)
				{
					w = Math.sqrt(r * r - height*height);
					tempNote = new Note(x - w, x + w);
					notes.add(tempNote);
				}
			}
			
			double max = Double.MIN_VALUE;
			boolean isRight = false;
			int result = 0;
			tempNote = null;
			while(!notes.isEmpty())
			{
				max = Double.MIN_VALUE;
				while(!notes.isEmpty() && notes.peek().getStart() <= start)
				{
					if(max < notes.peek().getEnd())
					{
						max = notes.peek().getEnd();
						if(tempNote != null)
							notes.remove(tempNote);
						tempNote = notes.peek();
					}
					else
					{
						notes.poll();
					}
				}
				
				if(max == Double.MIN_VALUE)
					break;
				
				if(max >= start && tempNote != null)
				{
					start = max;
					notes.remove(tempNote);
					result++;
					if(start >= end)
					{
						isRight = true;
						break;
					}
						
				}
				
			}
			
			System.out.println(isRight ? result : 0);
			
		}

	}
	
	
	
	
	static Comparator<Note> comparator =  new Comparator<Note>(){
		public int compare(Note o1, Note o2) {
			double numbera = o1.getStart();
			double numberb = o2.getStart();
			if(numberb > numbera)
			{
				return -1;
			}
			else if(numberb < numbera)
			{
				return 1;
			}
			else
			{
				return 0;
			}
		}
	};
	
	static class Note{
		
		private double start;
		private double end;
		
		public Note(double s, double e)
		{
			start = s;
			end = e;
		}
		
		public double getStart() {
			return start;
		}
		public void setStart(double start) {
			this.start = start;
		}
		public double getEnd() {
			return end;
		}
		public void setEnd(double end) {
			this.end = end;
		}
		
		
	}

}
