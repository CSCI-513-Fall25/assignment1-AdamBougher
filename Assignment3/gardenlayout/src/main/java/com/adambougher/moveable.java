package com.adambougher;

import javafx.geometry.Point2D;
import javafx.scene.shape.Shape;

public interface moveable {
    public void move(double dx, double dy);
    public boolean ContainsPoint(Point2D point);
    public Shape getShape();
    public void addChild(moveable shape);
    public void removeChild(moveable shape);
}
