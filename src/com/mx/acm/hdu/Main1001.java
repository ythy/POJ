package com.mx.acm.hdu;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main1001 {

	/**
	 * @param args
	 * @throws IOException 
	 * @throws NumberFormatException 
	 */
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int line;
		int result;
		while(true)
		{
			result = 0;
			line = Integer.parseInt(br.readLine());
			while(line > 0)
			{
				result += line--;
			}
			System.out.println(result + "\n");
		}
	}

}
