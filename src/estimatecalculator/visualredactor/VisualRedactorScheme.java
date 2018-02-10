/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package estimatecalculator.visualredactor;

import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

/**
 *
 * @author I
 */
public class VisualRedactorScheme {
    

    public static Pane getClearScheme(int schemeWidth, int schemeHeight, int schemeCountCellsX, int schemeCountCellsY) {
    Pane pane = new Pane();
    Canvas schemeFieldCanvas = new Canvas(schemeWidth, schemeHeight);
    GraphicsContext graphicsContext = schemeFieldCanvas.getGraphicsContext2D();
        graphicsContext.setFill(Color.WHITE);
        graphicsContext.setStroke(Color.BLUE);
        graphicsContext.setLineWidth(1.0);
        graphicsContext.fillRect(0, 0, schemeFieldCanvas.getWidth(), schemeFieldCanvas.getHeight());
        // Рисуем линии
        drawLines(graphicsContext, schemeFieldCanvas, schemeCountCellsX, schemeCountCellsY);       
        pane.getChildren().add(schemeFieldCanvas);
        
        return (pane);
    }
    
    
    //        SchemaTextField SchemaTextField_A = new SchemaTextField();
//        grid.add(SchemaTextField_A, 0, 0); 
//
//        // Рисуем поле схемы
//        Group root = new Group();
//       // Create the Canvas, filled in with Blue
//        final Canvas canvas = new Canvas(600, 600);
//       // canvas.setTranslateX(100);
//      //  canvas.setTranslateY(100);
//        reset(canvas, Color.WHITE);
//        
//        final GraphicsContext gc = canvas.getGraphicsContext2D();
//
//        // Рисуем линии
   //     drawLines(graphicsContext, schemeFieldCanvas);
//        
//        // Clear away portions as the user drags the mouse
//        canvas.addEventHandler(MouseEvent.MOUSE_DRAGGED, new EventHandler<MouseEvent>() {
//            @Override
//            public void handle(MouseEvent e) {
//                
//                gc.clearRect(e.getX() - 2, e.getY() - 2, 5, 5);
//            }
//        });
//        
//        // Fill the Canvas with a Blue rectnagle when the user double-clicks
//        canvas.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
//            @Override
//            public void handle(MouseEvent t) {            
//                if (t.getClickCount() >1) {
//                    reset(canvas, Color.BLUE);
//                }  
//            }
//        });
//        
//        // Add the Canvas to the Scene, and show the Stage
//        root.getChildren().add(canvas);
//        grid.add(root, 1, 0); 
    // Функция рисования линий 
    private static void drawLines(GraphicsContext gc, Canvas canvas, int schemeCountCellsX, int schemeCountCellsY) {
            int padding = 20;
            int hvostik = 3;
            int gapX = (int)((canvas.getWidth() - 2*padding)/schemeCountCellsX);
            int gapY = (int)((canvas.getHeight() - 2*padding)/schemeCountCellsY);
         //   String letters = new String("АБВГДЕЖИКЛМНПРСТУФХЦ");
            
            gc.beginPath();
            gc.setStroke(Color.GRAY);   
            gc.setLineDashes(3, 3); // gc.setLineDashes(4, 4, 10, 4); - рисует ось симметрии
            for (double i = padding, j = 0; i < canvas.getWidth(); i = i + gapX, j++) {
                gc.moveTo(i + 0.5, padding - hvostik + 0.5);
                gc.lineTo(i + 0.5, canvas.getHeight() - padding + hvostik + 0.5);
            }            
            for (double i = padding; i < canvas.getHeight(); i = i + gapY) {
                gc.moveTo(padding - hvostik + 0.5, i + 0.5);
                gc.lineTo(canvas.getWidth() - padding + hvostik + 0.5, i + 0.5);
            }
            gc.stroke();
            
            // Это буквы и цифры для осей:
//            gc.setFont(new Font(12));
//            gc.setLineDashes(0);
//            gc.setLineWidth(1.0);
//            gc.setFill(Color.BLACK); 
            
//            for (double i = padding, j = 1; i < canvas.getHeight(); i = i + gap, j++) {
//                gc.fillText(Integer.toString((int) j), i - 5, 10.5);
//                gc.fillText(Integer.toString((int) j), i - 5, canvas.getHeight() - 2.5);
//           }  
//            for (double i = canvas.getWidth() - padding + 4, j = 0; i > 0; i = i - gap, j++) {
//                gc.fillText(Character.toString(letters.charAt((int) j)), 2, i);
//                gc.fillText(Character.toString(letters.charAt((int) j)), canvas.getWidth() - 11, i);
//           }  
        }
    
    
    public static BorderPane getPic() {
    BorderPane root = new BorderPane();
    root.setLeft(new Button("Left"));
    Pane pane = new Pane();
    Button topButton = new Button("Top");
    topButton.setLayoutX(20.0);
    topButton.setLayoutY(20.0);
    pane.getChildren().add(topButton);
    root.setTop(pane);
    //
    root.setRight(new Button("Right"));
    root.setBottom(new Button("Bottom"));
   // root.setCenter(new Button("Center"));
    
    Scene scene = new Scene(new Group()); 
//scene.getStylesheets().add(“test.css”); 
Rectangle rect = new Rectangle(100,100); 
rect.setLayoutX(50); 
rect.setLayoutY(50); 
rect.getStyleClass().add("my-rect"); 
((Group)scene.getRoot()).getChildren().add(rect);
root.setCenter(rect);
   
    return (root);
    }    
    public static Pane getPanePic() {
//    BorderPane root = new BorderPane();
//    root.setLeft(new Button("Left"));
    Pane pane = new Pane();
//    Button topButton = new Button("Top");
//    topButton.setLayoutX(20.0);
//    topButton.setLayoutY(20.0);
//    pane.getChildren().add(topButton);
  //  root.setTop(pane);
    //
 //   root.setRight(new Button("Right"));
 //   root.setBottom(new Button("Bottom"));
   // root.setCenter(new Button("Center"));
    
   // Scene scene = new Scene(new Group()); 
//scene.getStylesheets().add(“test.css”); 
//Rectangle rect = new Rectangle(100,100); 
//rect.setLayoutX(50); 
//rect.setLayoutY(50); 
//rect.getStyleClass().add("my-rect"); 
//((Group)scene.getRoot()).getChildren().add(rect);
//pane.getChildren().add(rect);
   
    return (pane);
    }
//

    
}
