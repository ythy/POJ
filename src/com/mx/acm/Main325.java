package com.mx.acm;

import java.io.BufferedInputStream;
import java.util.Scanner;


public class Main325{

	public static void main(String args[]){

		Scanner sc=new Scanner(new BufferedInputStream(System.in));

		while(sc.hasNextInt()){
			int n=sc.nextInt();

			int sum=0;
			int[] a=new int[n];

			for(int j=0;j<n;++j){
				a[j]=sc.nextInt();
				sum+=a[j];
			}

			int half=sum/2;
			int[] b=new int[half+5];

			for(int i=0;i<n;++i)
				for(int j=half;j>=a[i];--j)
					if(b[j]<b[j-a[i]]+a[i])
						b[j]=b[j-a[i]]+a[i];

			System.out.println(sum-2*b[half]);
		}
	}
}        