package com.mx.acm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 矩形嵌套
 * 描述 有n个矩形，每个矩形可以用a,b来描述，表示长和宽。矩形X(a,b)可以嵌套在矩形Y(c,d)中当且仅当a<c,b<d或者b<c,a<d（相当于旋转X90度）。例如（1,5）可以嵌套在（6,2）内，但不能嵌套在（3,4）中。你的任务是选出尽可能多的矩形排成一行，使得除最后一个外，每一个矩形都可以嵌套在下一个矩形内。
输入第一行是一个正正数N(0<N<10)，表示测试数据组数，
 每组测试数据的第一行是一个正正数n，表示该组测试数据中含有矩形的个数(n<=1000)
随后的n行，每行有两个数a,b(0<a,b<100)，表示矩形的长和宽输出每组测试数据都输出一个数，表示最多符合条件的矩形数目，每组输出占一行

 * @author maoxin
 * 1002713 ythyhvh 矩形嵌套 Accepted  27  184 java 10-13 13:57:10 
 */
public class Test16 {

	/**
	 * @param args
	 * @throws IOException 
	 * @throws NumberFormatException 
	 */
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new  InputStreamReader(System.in));
		StringTokenizer st;
		int total = Integer.parseInt(br.readLine().trim());
		int num, i, j;
		Note[] noteArray;
		int[] f;
		
		while(total-- > 0)
		{
			num = Integer.parseInt(br.readLine().trim());
			noteArray = new Note[num + 10];
			f = new int[num + 10];
			Note tempNote = null;
			int tempInput1, tempInput2;
			
			for(i = 0; i < num; i++)
			{ 
				st = new StringTokenizer(br.readLine().trim());
				tempInput1 = Integer.parseInt(st.nextToken());
				tempInput2 = Integer.parseInt(st.nextToken());
				tempNote = new Note(Math.max(tempInput1, tempInput2), Math.min(tempInput1, tempInput2));
				noteArray[i] = tempNote;
			}
			
			sort(noteArray, 0, num - 1);
			
			int count = Integer.MIN_VALUE;
			for(i = 0; i < num ; i++)
			{
				f[i] = 1;
				for(j = 0; j < i ; j++)
				{
					if(noteArray[j].height < noteArray[i].height && noteArray[j].width < noteArray[i].width ) //满足嵌套条件？
						 f[i] = Math.max(f[i], f[j] + 1);

				}
				count = Math.max(count, f[i]);
			}
			
			System.out.println(count);
		}
	}
	
	
	public static Note[] sort(Note[] nums, int low, int high) {
		int mid = (low + high) / 2;
		if (low < high) {
			// 左边
			sort(nums, low, mid);
			// 右边
			sort(nums, mid + 1, high);
			// 左右归并
			merge(nums, low, mid, high);
		}
		return nums;
	}

	public static void merge(Note[] nums, int low, int mid, int high) {
		Note[] temp = new Note[high - low + 1];
		int i = low;// 左指针
		int j = mid + 1;// 右指针
		int k = 0;

		// 把较小的数先移到新数组中
		while (i <= mid && j <= high) {
			if (nums[i].height <= nums[j].height) {
				temp[k++] = nums[i++];
			} else {
				temp[k++] = nums[j++];
			}
		}

		// 把左边剩余的数移入数组
		while (i <= mid) {
			temp[k++] = nums[i++];
		}

		// 把右边边剩余的数移入数组
		while (j <= high) {
			temp[k++] = nums[j++];
		}

		// 把新数组中的数覆盖nums数组
		for (int k2 = 0; k2 < temp.length; k2++) {
			nums[k2 + low] = temp[k2];
		}
	}
	
	
	static class Note{
		
		private int width;
		private int height;
		
		public Note(int w, int h)
		{
			width = w;
			height = h;
		}
	}
	

}
