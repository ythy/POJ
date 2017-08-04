package com.mx.acm;


import java.io.BufferedInputStream;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Scanner;


public class Main21{

	public static int hash(int a,int b,int c){

		return a*10000+b*100+c;
	}


	public static void main(String[] args){

		Scanner sc=new Scanner(new BufferedInputStream(System.in));

		for(int n=sc.nextInt();n>0;--n){
			int v1=sc.nextInt(),v2=sc.nextInt(),v3=sc.nextInt();
			int e1=sc.nextInt(),e2=sc.nextInt(),e3=sc.nextInt();
			LinkedList<int[]> ll=new LinkedList<int[]>();
			HashSet<Integer> hs=new HashSet<Integer>();

			int min=-1;
			hs.add(hash(v1,0,0));
			ll.add(new int[]{v1,0,0,0});
			
			int j = 0;
			while(ll.size()>0){
				j++;
				int[] temp=ll.pollFirst();

				if(e1==temp[0]&&e2==temp[1]&&e3==temp[2]){
					min=temp[3];
					break;
				}

				if(temp[0]>0){
					if(temp[1]<v2)
						if(temp[0]+temp[1]>v2){
							if(hs.add(hash(temp[0]+temp[1]-v2,v2,temp[2])))
								ll.add(new int[]{temp[0]+temp[1]-v2,v2,temp[2],temp[3]+1});
						}else
							if(hs.add(hash(0,temp[0]+temp[1],temp[2])))
								ll.add(new int[]{0,temp[0]+temp[1],temp[2],temp[3]+1});

					if(temp[2]<v3)
						if(temp[0]+temp[2]>v3){
							if(hs.add(hash(temp[0]+temp[2]-v3,temp[1],v3)))
								ll.add(new int[]{temp[0]+temp[2]-v3,temp[1],v3,temp[3]+1});
						}else
							if(hs.add(hash(0,temp[1],temp[0]+temp[2])))
								ll.add(new int[]{0,temp[1],temp[0]+temp[2],temp[3]+1});
				}

				if(temp[1]>0){
					if(temp[0]<v1)
						if(hs.add(hash(temp[0]+temp[1],0,temp[2])))
							ll.add(new int[]{temp[0]+temp[1],0,temp[2],temp[3]+1});

					if(temp[2]<v3)
						if(temp[1]+temp[2]>v3){
							if(hs.add(hash(temp[0],temp[1]+temp[2]-v3,v3)))
								ll.add(new int[]{temp[0],temp[1]+temp[2]-v3,v3,temp[3]+1});
						}else
							if(hs.add(hash(temp[0],0,temp[1]+temp[2])))
								ll.add(new int[]{temp[0],0,temp[1]+temp[2],temp[3]+1});

				}

				if(temp[2]>0){
					if(temp[0]<v1)
						if(hs.add(hash(temp[0]+temp[2],temp[1],0)))
							ll.add(new int[]{temp[0]+temp[2],temp[1],0,temp[3]+1});

					if(temp[1]<v2)
						if(temp[1]+temp[2]>v2){
							if(hs.add(hash(temp[0],v2,temp[1]+temp[2]-v2)))
								ll.add(new int[]{temp[0],v2,temp[1]+temp[2]-v2,temp[3]+1});
						}else
							if(hs.add(hash(temp[0],temp[1]+temp[2],0)))
								ll.add(new int[]{temp[0],temp[1]+temp[2],0,temp[3]+1});
				}
			}

			System.out.println(min + " " + j);
		}
	}
}        