package com.mx.acm;

import java.util.Arrays;
import java.util.Scanner;
public class Main214 {
	public static void main(String[] args) {
		Scanner scanner=new Scanner(System.in);
		int stack[]=new int[100001];
		while(scanner.hasNext()){
			Arrays.fill(stack, 0);
			int number=scanner.nextInt();
			int top=0;stack[0]=-9999999;
			while(number--!=0)
			{
				int x=scanner.nextInt();
				if(x>stack[top])
				{
					top++;
					stack[top]=x;
				}
				else {
					int low=1,height=top;
					while(low<=height)
					{
						int mid=(low+height)/2;
						if(x>stack[mid])
						{
							low=mid+1;
						}
						else {
							height=mid-1;
						}
					}
					stack[low]=x;
				}
			}
			System.out.println(top);
		}

	}
}
               