package com.patterns.flyweight;

public class Line implements Shape {
	
	public Line(){
		System.out.println("Creating Line object");
	}

	@Override
	public void drow(int w, int h, Color color) {
		// TODO Auto-generated method stub
		System.out.println("drow Line : "  + w + "  " + h + " " + color );
	}


}
