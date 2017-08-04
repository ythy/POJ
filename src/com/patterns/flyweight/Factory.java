package com.patterns.flyweight;

import java.util.HashMap;
import java.util.Map;

public class Factory {
	private static Map<ShapeType, Shape> mShape = new HashMap<ShapeType, Shape>();
	public static Shape getShape( ShapeType type ){
		if( mShape.get(type) == null){
			if(type.equals(ShapeType.LINE))
				mShape.put(type, new Line());
			else if(type.equals(ShapeType.OVAL))
				mShape.put(type, new Oval());
		}
		return mShape.get(type);
	}
}
