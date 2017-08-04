package com.patterns.flyweight;

/**
 * Use sharing to support large numbers of fine-grained objects efficiently
 * @author maoxin
 *
 */
public class TestFlyWeight {
	
	private int WIDTH;
	private int HEIGHT;

	private static final ShapeType shapes[] = { ShapeType.LINE, ShapeType.OVAL };
	private static final Color colors[] = { Color.RED, Color.GREEN, Color.YELLOW };
	
	private void drawPanel(int w, int h){
		WIDTH = w;
		HEIGHT = h;
		
		for (int i = 0; i < 20; ++i) {
			Shape shape = Factory.getShape(getRandomShape());
			shape.drow(getRandomWidth(), getRandomHeight(), getRandomColor());
		}
		
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TestFlyWeight in = new TestFlyWeight();
		in.drawPanel(300, 400);
	}
	
	private ShapeType getRandomShape() {
		return shapes[(int) (Math.random() * shapes.length)];
	}

	private int getRandomWidth() {
		return (int) (Math.random() * (WIDTH / 10));
	}

	private int getRandomHeight() {
		return (int) (Math.random() * (HEIGHT / 10));
	}

	private Color getRandomColor() {
		return colors[(int) (Math.random() * colors.length)];
	}
}
