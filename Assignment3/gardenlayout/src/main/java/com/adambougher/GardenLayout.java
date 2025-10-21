package com.adambougher;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.geometry.Point2D;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;


public class GardenLayout extends Application {
    AnchorPane root;
	Scene scene;
	Point2D lastPosition = null;
    Boolean isDragging = false;
    List<moveable> shapes = new ArrayList<moveable>();
    moveable currentShape = null;
    Point2D clickP;
    flower f = new flower(new Point2D(100, 100), Color.RED, true);
    flowerbed fb = new flowerbed(new Point2D(150, 150), Color.GREEN, true);
    
    EventHandler<MouseEvent> mouseHandler = new EventHandler<MouseEvent>(){
        @Override
        public void handle(MouseEvent e){
            clickP = new Point2D(e.getX(), e.getY());
            System.out.println("Clicked at: " + clickP.getX() + ", " + clickP.getY());
            String eventName = e.getEventType().getName();

            currentShape = getCurrentShape(clickP);
            

            switch(eventName){
                case "MOUSE_DRAGGED":
                    isDragging = true;
                    if(lastPosition != null){
                        System.out.println("Dragging");
                        double deltaX = clickP.getX() - lastPosition.getX();
                        double deltaY = clickP.getY() - lastPosition.getY();
                        currentShape.move(deltaX, deltaY);
                    }
                break;
                case "MOUSE_RELEASED":
                    if(isDragging){
                        isDragging = false;
                        currentShape = null;
                        System.out.println("Stopped Dragging");
                    }
                break;
            }
            lastPosition = clickP;
        }
    };

    private moveable getCurrentShape(Point2D point){
    	moveable currentShape = null;
		for(moveable myShape: shapes){
			if (myShape.ContainsPoint(point)){
				currentShape = myShape;
				break;
			}
		} 
		return currentShape;
    }

    @Override
    public void start(Stage s) throws IOException {
        root = new AnchorPane();

        scene = new Scene(root, 300, 300);

        shapes.add(fb);
        shapes.add(f);
        for (moveable moveable : shapes) {
            root.getChildren().add((moveable.getShape()));
        }

        s.setTitle("Lab 3 - Garden Layout");
		s.setScene(scene);
		s.show();

        scene.setOnMouseDragged(mouseHandler);
        scene.setOnMouseReleased(mouseHandler);
        scene.setOnMousePressed (mouseHandler);

    }


    public static void main(String[] args) {
        launch(args);
    }

    

}
