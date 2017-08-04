package com.patterns.bridge;

public class TestBridgePattern {

	/**
	 * http://javapapers.com/design-patterns/bridge-design-pattern/
	 * 
	 * The Bridge pattern is an application of the old advice, 
	 * "prefer composition over inheritance". 
	 * It becomes handy when you must subclass different times in ways that are orthogonal with one another. 
	 * Say you must implement a hierarchy of colored shapes. 
	 * You wouldn't subclass Shape with Rectangle and Circle and then subclass Rectangle with 
	 * RedRectangle, BlueRectangle and GreenRectangle and the same for Circle, 
	 * would you? You would prefer to say that each Shape has a Color and to implement a hierarchy of colors, 
	 * and that is the Bridge Pattern. Well, I wouldn't implement a "hierarchy of colors", but you get the idea...
	 * 
	 * When:
		                   ----Shape---
		                  /            \
		         Rectangle              Circle
		        /         \            /      \
		BlueRectangle  RedRectangle BlueCircle RedCircle
		
		
		Refactor to:
		          ----Shape---                        Color
		         /            \                       /   \
		Rectangle(Color)   Circle(Color)           Blue   Red

	 * 
	 * 
	 */
	public static void main(String[] args) {
		Vehicle vehicle1 = new Car(new Produce(), new Assemble());
		vehicle1.manufacture();
		Vehicle vehicle2 = new Bike(new Produce(), new Assemble());
		vehicle2.manufacture();
	}

}
