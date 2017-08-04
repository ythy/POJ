package com.patterns.flyweight;

public class Oval implements Shape {
	
	public Oval(){
		System.out.println("Creating Oval object");
	}
	
	@Override
	public void drow(int w, int h, Color color) {
		// TODO Auto-generated method stub
		System.out.println("drow Oval : "  + w + "  " + h + " " + color );
	}


}
