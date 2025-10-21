package com.adambougher;

import javafx.geometry.Point2D;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;

public class flowerbed implements moveable {

    Point2D topLeft;
	int height;
	int width;
	Color rectangleColor;
	Rectangle rectangle;
    java.util.List<moveable> innerShapes = new java.util.ArrayList<moveable>();


    public flowerbed(Point2D position, Color color, boolean movable){
        rectangle = new Rectangle();
        rectangle.setX(position.getX());
        rectangle.setY(position.getY());
        rectangle.setWidth(100);
        rectangle.setHeight(50);
        rectangle.setFill(color);
        rectangle.setStroke(Color.BLACK);
        rectangle.setStrokeWidth(1);

    }
    
    public void move(double dx, double dy) { 
        rectangle.setY(rectangle.getY()+dy);  
        rectangle.setX(rectangle.getX()+dx);
        for(moveable child: innerShapes){
			child.move(dx,dy);
		}
        
    }

    @Override
    public boolean ContainsPoint(Point2D point) {
        boolean inRectangle = (point.getX() >= rectangle.getX() && point.getX() <= rectangle.getX()+rectangle.getWidth()
                && point.getY()>= rectangle.getY() && point.getY() <= rectangle.getY()+rectangle.getHeight());
        return inRectangle;
    }

    @Override
    public Shape getShape() {
        return rectangle;
    }

    public void addChild(moveable shape){
		innerShapes.add(shape);
        System.out.println("Added shape to flowerbed");
	}
	
	public void removeChild(moveable shape){
		if(innerShapes.contains(shape)){
			innerShapes.remove(shape);
		}
	}

}
