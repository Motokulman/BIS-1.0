/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package estimatecalculator.visualredactor;

import estimatecalculator.classes.SchemeCanvas;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Rectangle;

/**
 *
 * @author I
 */
public class VisualRedactorScheme {
    
    

    public static Pane getClearScheme(int schemeWidth, int schemeHeight, int schemeCountCellsX, int schemeCountCellsY) {
    Pane pane = new Pane();
    Canvas schemeFieldCanvas = new SchemeCanvas();
//    GraphicsContext graphicsContext = schemeFieldCanvas.getGraphicsContext2D();
//        graphicsContext.setFill(Color.WHITE);
//        graphicsContext.setLineWidth(1.0);
//        graphicsContext.fillRect(0, 0, schemeFieldCanvas.getWidth(), schemeFieldCanvas.getHeight());
//        // Рисуем линии
//        drawLines(graphicsContext, schemeFieldCanvas, schemeCountCellsX, schemeCountCellsY);       
//        schemeRedactor(schemeFieldCanvas, schemeCountCellsX, schemeCountCellsY);
        pane.getChildren().add(schemeFieldCanvas);
        return (pane);
    }

    // Функция рисования линий 
//    private static void drawLines(GraphicsContext gc, Canvas canvas, int schemeCountCellsX, int schemeCountCellsY, paddingScheme) {
//            int hvostik = 3;
//            int[] coordX = coordinateGridNodes(canvas.getWidth(), schemeCountCellsX, padding);
//            int[] coordY = coordinateGridNodes(canvas.getHeight(), schemeCountCellsY, padding);
//            gc.fillRect(0, 0, canvas.getWidth(), canvas.getHeight());
//            gc.beginPath();
//            gc.setStroke(Color.GRAY);   
//            gc.setLineDashes(3, 3); // gc.setLineDashes(4, 4, 10, 4); - рисует ось симметрии
//            for (int i = 0; i < schemeCountCellsX + 1; i++) {
//                  gc.moveTo(coordX[i], padding - hvostik + 0.5);
//                  gc.lineTo(coordX[i], canvas.getHeight() - padding + hvostik + 0.5);
//            }            
//            for (int i = 0; i < schemeCountCellsY + 1; i++) {
//                gc.moveTo(padding - hvostik + 0.5, coordY[i] + 0.5);
//                gc.lineTo(canvas.getWidth() - padding + hvostik + 0.5, coordY[i] + 0.5);
//            }
//            gc.stroke();
//        }
    
    
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
