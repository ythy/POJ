package com.mx.acm;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
class Reader101{
	static BufferedReader reader;
	static StringTokenizer tokenizer;
	static void init(InputStream inputStream){
		reader=new BufferedReader(new InputStreamReader(inputStream));
		tokenizer=new StringTokenizer("");
	}
	static String next() throws IOException{
		while (!tokenizer.hasMoreElements()) {
			tokenizer=new StringTokenizer(reader.readLine());
		}
		return tokenizer.nextToken();
	}
	static int nextInt() throws IOException{
		return Integer.parseInt(next());
	}
}

public class Main79 {

	/**
	 * @param args
	 * @throws IOException 
	 */
	static int max(int a,int b){
		return a>b?a:b;
	}
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		Reader101.init(System.in);
		int t=Reader101.nextInt();
		for (int i = 0; i < t; i++) {
			int m=Reader101.nextInt();
			int num[]=new int[m+1];
			int dp[]=new int [m+1];
			for (int j = 1; j < m+1; j++) {
				num[j]=Reader101.nextInt();
				dp[j]=1;
			}
			for (int j = 1; j < m+1; j++) {
				int max=Integer.MIN_VALUE;
				for (int j2 = 0; j2 < j; j2++) {
					if (num[j2]>num[j] && dp[j2]>max) {
						dp[j]=dp[j2]+1;
						max=dp[j2];
					}
				}
			}
			int max=Integer.MIN_VALUE;
			for (int j = 1; j < m+1; j++) {
				if (dp[j]>max) {
					max=dp[j];
				}
			}
			System.out.println(max);
		}
	}

}
       
