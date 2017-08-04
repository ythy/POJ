package com.mx.acm;

public class MainT {

	/**
	 * @param args
	 * 练习排序算法用
	 */
	
	private static int[] testAc = {4, 2, 9, 19, 44, 5, 1, 14};
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		mergerAc = testAc;
		sort3(0, mergerAc.length - 1);
		int[] result = mergerAc;
		//int[] result = sort1(testAc);
		int i;
		for(i = 0; i < result.length; i++)
		{
			System.out.println(result[i]);
		}
	}
	
	
	//冒泡排序
	private static int[] sort1(int[] arrays)
	{
		int i, j, temp;
		for(i = arrays.length - 1; i >= 0; i--)
		{
			for(j = 0; j < i; j++ )
			{
				if(arrays[j] > arrays[j + 1])
				{
					temp = arrays[j];
					arrays[j] = arrays[j + 1];
					arrays[j + 1] = temp;
				}
			}
		}
		
		return arrays;
	}
	
	//归并排序
	private static int[] mergerAc;
	private static void sort2(int start, int end)
	{
		int mid = (start + end)/2;
		if(start < end) //这地方注意 是if不是while
		{
			sort2(start, mid);
			sort2(mid + 1, end);
			merger(start, mid, end);
		}
	}
	
	private static void merger(int start, int mid, int end)
	{
		int[] temp = new int[end - start + 1];
		int k = 0,m = 0;
		int i = start;
		int j = mid + 1;
		while(i <= mid && j <= end )
		{
			if(mergerAc[i] < mergerAc[j])
				temp[k++] = mergerAc[i++];
			else
				temp[k++] = mergerAc[j++];
		}
		
		while(i <= mid)
			temp[k++] = mergerAc[i++];
		
		while(j <= end)
			temp[k++] = mergerAc[j++];
		
		for(m = 0; m < temp.length; m++)
			mergerAc[m + start] = temp[m];
		
	}
	
	
	//快速排序
	private static void sort3(int start, int end)
	{
		if(start < end)
		{
			int mid = getMid(start, end);
			sort3(start, mid);
			sort3(mid + 1, end);
		}
		
	}
	
	private static int getMid(int start, int end)
	{
		 int i = start;
		 int j = end;
		 int k = mergerAc[start];
		 while(i < j)
		 {
			 while(i < j &&  mergerAc[j] > k)
			 {
				 j--;
			 }
			 mergerAc[i] = mergerAc[j];
			
			 while(i < j &&  mergerAc[i] < k)
			 {
				 i++;
			 }
			 mergerAc[j] = mergerAc[i];
		}
		mergerAc[i] = k;
		 
		return i;
	}
	
	
}
