package com.mx.acm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 
A Famous Music Composer

时间限制：1000 ms  |  内存限制：65535 KB 

难度：1

描述 
Mr. B is a famous music composer. One of his most famous work was his set of preludes. These 24 pieces span the 24 musical keys (there are musically distinct 12 scale notes, and each may use major or minor tonality). The 12 distinct scale notes are: 


 A     A#=Bb  B        C       C#=Db D       D#=Eb  E       F        F#=Gb  G       G#=Ab 





Five of the notes have two alternate names, as is indicated above with equals sign. Thus, there are 17 possible names of scale notes, but only 12 musically distinct notes. When using one of these as the keynote for a musical key, we can further distinguish between major and minor tonalities. This gives 34 possible keys, of which 24 are musically distinct. 

In naming his preludes, Mr. B used all the keys except the following 10, which were named instead by their alternate names: 


 Ab minor  A# major A# minor  C# major  Db minor 
 D# major  D# minor Gb major  Gb minor  G# major  


Write a program that, given the name of a key, give an alternate name if it has one, or report the key name is unique. 

输入Each test case is described by one line having the format "note tonality", where "note" is one of the 17 names for the scale notes given above, and "tonality" is either "major" or "minor" (quotes for clarify). 输出For each case output the required answer, following the format of the sample.
 * @author maoxin
 * 1365095 ythyhvh A Famous Music Composer Accepted  42  61 java 09-18 13:52:10 
 */
public class Test25 {

	/**
	 * @param args
	 * @throws IOException 
	 */
	
	// # 35   A 65  G 71   b 98 B 66
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		String[] data = new String[180];
		data[100] = "Bb";
		data[102] = "Db";
		data[103] = "Eb";	
		data[105] = "Gb";
		data[106] = "Ab";	
		data[164] = "A#";
		data[166] = "C#";
		data[167] = "D#";
		data[169] = "F#";
		data[163] = "G#";
		
		int num = 1;
		while(true)
		{
			String input = br.readLine();
			if(input == null || "".equals(input))
				break;
			st = new StringTokenizer(input);
			String s1 = st.nextToken();
			String s2 = st.nextToken();
			if(s1.length() == 1)
				System.out.println("Case " + num + ": UNIQUE");
			else
				System.out.println("Case " + num + ": " + data[(int)(s1.charAt(0)) + (int)(s1.charAt(1))] + " " + s2);
			num++;
		}

	}

}
