package com.mx.acm;


import java.io.*;
import java.util.*;
public class Main43 {
	
	static double a[],n;
	static int f;
	static int count;
	
	
	public static void main(String[] args) throws IOException{
		StreamTokenizer sc=new StreamTokenizer(System.in);
		a = new double[10];
		int t ,num;
		while(sc.nextToken()!=StreamTokenizer.TT_EOF)
		{
		
			t= (int) sc.nval;
			while(t-- > 0)
			{
				sc.nextToken();
				num = (int) sc.nval;
				
				sc.nextToken();
				n =  sc.nval;
				for(int i = 1 ; i <= num ;i++)
				{
					sc.nextToken();
					a[i] =  sc.nval;
				}
	
				count = 0;
				f = 0;
				
				dfs(a,num);
				
				System.out.println(count);
				if( f == 0)
					System.out.println("No");
				else 
					System.out.println("Yes");
			}
			}
			
					
		

	}
	private static void dfs(double[] a2, int r) {
		count++;
		if(r == 2)
		{
			if(Math.abs(a2[1] * a2[2] - n) < 0.01 || Math.abs(a2[1] + a2[2] - n) < 0.01 ||Math.abs(a2[1]  - a2[2] - n)< 0.01 || a2[2] != 0 && Math.abs(a2[1] / a2[2] - n) < 0.01 ||Math.abs(a2[2] - a2[1] - n) <0.01 || a2[1] != 0 && Math.abs(a2[2] / a2[1] - n) < 0.01)
				f = 1;
			return ;
		}
		if(r == 1)
		{
		  if(a2[1] == n)
		    f = 1;
		  return;
		}
		if(f == 1)
			return ;
		int k ;
			for(int i = 1 ; i < r ;i ++)
				for( int j = i + 1 ; j <= r ;j++)
				{
					if(f == 1)
						return ;
					double b[] = new double [r];
					k = 1 ;
					for(int x = 1 ; x <= r ;x ++)
						if(x != i && x != j)
							b[k++] = a2[x];
					
					
					b[k] =  a2[i] + a2[j];
					dfs(b,r-1);
					b[k] =  a2[i] * a2[j];
					dfs(b,r-1);
					b[k] =  a2[i] - a2[j];
					dfs(b,r-1);
					b[k] =  a2[j] - a2[i];
					dfs(b,r-1);
					if(a2[j] != 0)
					{
						b[k] =  a2[i] / a2[j];
						dfs(b,r-1);
					}
					
					if(a2[i] != 0)
					{
						b[k] =  a2[j] / a2[i];
						dfs(b,r-1);
					}								
				}	
	}

}


                       
