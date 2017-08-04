package com.mx.acm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/**
 * 会场安排问题
 * 描述 学校的小礼堂每天都会有许多活动，有时间这些活动的计划时间会发生冲突，需要选择出一些活动进行举办。小刘的工作就是安排学校小礼堂的活动，每个时间最多安排一个活动。现在小刘有一些活动计划的时间表，他想尽可能的安排更多的活动，请问他该如何安排。

输入第一行是一个整型数m(m<100)表示共有m组测试数据。
 每组测试数据的第一行是一个整数n(1<n<10000)表示该测试数据共有n个活动。
 随后的n行，每行有两个正整数Bi,Ei(0<=Bi,Ei<10000),分别表示第i个活动的起始与结束时间（Bi<=Ei)
输出对于每一组输入，输出最多能够安排的活动数量。
 每组的输出占一行
 
 * @author maoxin
 * 1000228 ythyhvh 会场安排问题 Accepted  454  2897 java 10-10 11:53:23 
 */

public class Test14 {

	/**
	 * @param args
	 * @throws IOException 
	 * @throws NumberFormatException 
	 */
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new  InputStreamReader(System.in));
		StringTokenizer st;
		int total = Integer.parseInt(br.readLine());
		int num, i, j;
		PriorityQueue<Note> notes;
		Note[] noteArray;
		while(total-- > 0)
		{
			num = Integer.parseInt(br.readLine());
			notes = new PriorityQueue<Note>(11, comparator);
			noteArray = new Note[num];
			Note tempNote = null;
			for(i = 0; i < num; i++)
			{
				st = new StringTokenizer(br.readLine());
				tempNote = new Note(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
				noteArray[i] = tempNote;
			}
			
			for(i = 0; i < noteArray.length; i++)
			{
				tempNote = noteArray[i];
				for(j = 0; j < noteArray.length; j++)
				{
					if(tempNote.getStart() <= noteArray[j].getStart() &&
						tempNote.getEnd() >= noteArray[j].getEnd() && noteArray[j] != tempNote)
					{
						tempNote = null;
						break;
					}
				}
				if(tempNote != null)
					notes.add(tempNote);
			}
			
			
			tempNote = null;
			int result = 0;
			while(!notes.isEmpty())
			{
				if(tempNote == null)
				{
					tempNote = notes.poll();
					result ++;
				}
				else
				{
					if(notes.peek().getStart() > tempNote.getEnd())
					{
						tempNote = notes.poll();
						result ++;
					}
					else
						notes.poll();
				}
			}
			
			
			System.out.println(result);
			
		}

	}
	
	
	
	
	static Comparator<Note> comparator =  new Comparator<Note>(){
		public int compare(Note o1, Note o2) {
			int numbera = o1.getStart();
			int numberb = o2.getStart();
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
		
		private int start;
		private int end;
		
		public Note(int s, int e)
		{
			start = s;
			end = e;
		}
		
		public int getStart() {
			return start;
		}
		public void setStart(int start) {
			this.start = start;
		}
		public int getEnd() {
			return end;
		}
		public void setEnd(int end) {
			this.end = end;
		}
		
		
	}

}
