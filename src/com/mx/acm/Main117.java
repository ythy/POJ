package com.mx.acm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
/**
 * 求逆序数
 * 
 * 描述 
在一个排列中，如果一对数的前后位置与大小顺序相反，即前面的数大于后面的数，那么它们就称为一个逆序。一个排列中逆序的总数就称为这个排列的逆序数。

现在，给你一个N个元素的序列，请你判断出它的逆序数是多少。

比如 1 3 2 的逆序数就是1。

输入第一行输入一个整数T表示测试数据的组数（1<=T<=5)
每组测试数据的每一行是一个整数N表示数列中共有N个元素（2〈=N〈=1000000）
 随后的一行共有N个整数Ai(0<=Ai<1000000000)，表示数列中的所有元素。

 数据保证在多组测试数据中，多于10万个数的测试数据最多只有一组。输出输出该数列的逆序数
 
 * @author maoxin
 * 961402 ythyhvh 求逆序数 Accepted  1243  28629 java 08-26 17:09:30 
 */
public class Main117 {
	 
	static long count;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new  InputStreamReader(System.in));
		int total = Integer.parseInt(br.readLine());
		StringTokenizer st;
		int sum, i;
		int[] nums;
		while(total-- > 0)
		{
			sum = Integer.parseInt(br.readLine());
			nums = new int[sum];
			count = 0l;
			st = new StringTokenizer(br.readLine().trim());
			for(i = 0; i < sum; i++)
				nums[i] = Integer.parseInt(st.nextToken());
			
			sort(nums, 0, nums.length-1);
			System.out.println(count);	
		}
	}
	
	public static int[] sort(int[] nums, int low, int high) {
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

	public static void merge(int[] nums, int low, int mid, int high) {
		int[] temp = new int[high - low + 1];
		int i = low;// 左指针
		int j = mid + 1;// 右指针
		int k = 0;

		// 把较小的数先移到新数组中
		while (i <= mid && j <= high) {
			if (nums[i] <= nums[j]) {
				temp[k++] = nums[i++];
			} else {
				temp[k++] = nums[j++];
				count += Long.valueOf(mid - i + 1);
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
	
}
