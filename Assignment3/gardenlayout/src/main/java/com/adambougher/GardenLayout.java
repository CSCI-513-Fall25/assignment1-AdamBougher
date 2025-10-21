package com.adambougher;

import java.io.IOException;
import javafx.application.Application;
import javafx.geometry.Point2D;
import javafx.scene.Scene;


public class GardenLayout extends Application {
    javafx.scene.layout.AnchorPane root;
	Scene scene;
	Point2D lastPosition = null;
    Boolean isDragging = false;
    java.util.List<moveable> shapes = new java.util.ArrayList<moveable>();
    moveable currentShape = null;
    Point2D clickP;

    javafx.event.EventHandler<javafx.scene.input.MouseEvent> mouseHandler = new javafx.event.EventHandler<javafx.scene.input.MouseEvent>(){
        @Override
        public void handle(javafx.scene.input.MouseEvent e){
            clickP = new Point2D(e.getX(), e.getY());
            System.out.println("Clicked at: " + clickP.getX() + ", " + clickP.getY());
            String eventName = e.getEventType().getName();

            
            if(!isDragging && (currentShape = getCurrentShape(clickP)) == null){
                return;
            }

            switch(eventName){
                case "MOUSE_DRAGGED":
                    if(currentShape instanceof flower){
                        for(moveable container: shapes){
                            if (container instanceof flowerbed && ((flowerbed)container).hasChild(currentShape)){
                                ((flowerbed)container).removeChild(currentShape);
                                break;
                            }
                            
                        } 
                    }
                    if(lastPosition != null && currentShape != null){
                        isDragging = true;

                        if(shapes.contains(currentShape)){
                            shapes.remove(currentShape);
                        }

                        System.out.println("Dragging");
                        double deltaX = clickP.getX() - lastPosition.getX();
                        double deltaY = clickP.getY() - lastPosition.getY();
                        currentShape.move(deltaX, deltaY);
                    }
                break;
                case "MOUSE_RELEASED":  
                if(!isDragging){
                    return;
                }
                isDragging = false;

                if(shapes.contains(currentShape) == false){
                    shapes.add(currentShape);
                }

                if(currentShape instanceof flower){
        			for(moveable container: shapes){
            			if (container instanceof flowerbed && container.ContainsPoint(clickP)){
            				((flowerbed)container).addChild(currentShape);
            				break;
            			}
            			
            		} 
    			}

                currentShape = null;
                System.out.println("Stopped Dragging");
                
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
    public void start(javafx.stage.Stage s) throws IOException {
        root = new javafx.scene.layout.AnchorPane();
        scene = new Scene(root, 300, 300);


        shapes.add(new flowerbed(new Point2D(150, 150), javafx.scene.paint.Color.GREEN, true));
        shapes.add(new flower(new Point2D(100, 100), javafx.scene.paint.Color.RED, true));

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
