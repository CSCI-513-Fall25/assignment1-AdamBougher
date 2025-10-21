package com.adambougher;

import javafx.geometry.Point2D;
import javafx.scene.shape.Shape;

public class flower implements moveable {
    javafx.scene.shape.Circle circle;
    Point2D position;
    boolean movable;
    double radius = 10;


    public flower(Point2D position, javafx.scene.paint.Color color, boolean movable) {
        circle = new javafx.scene.shape.Circle();
        circle.setCenterX(position.getX());
        circle.setCenterY(position.getY());
        circle.setRadius(radius);  
        circle.setFill(color);  
        circle.setStroke(javafx.scene.paint.Color.BLACK);  
        circle.setStrokeWidth(1);

        this.position = position;
        this.movable = movable;
    }


    @Override  
    public void move(double dx, double dy) {  
        circle.setCenterY(circle.getCenterY()+dy);  
        circle.setCenterX(circle.getCenterX()+dx);
    }


    @Override
    public boolean ContainsPoint(Point2D point) {
        return (circle.contains(point));
    }


    @Override
    public Shape getShape() {
        return circle;
    }


    @Override
    public void addChild(moveable shape) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'addChild'");
    }


    @Override
    public void removeChild(moveable shape) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'removeChild'");
    }




}
