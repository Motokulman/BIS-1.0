/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package estimatecalculator.visualredactor;

import estimatecalculator.classes.SchemeCanvas;
import static estimatecalculator.classes.SchemeCanvas.clearSchemeCanvas;
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
        //clearSchemeCanvas();
        pane.getChildren().add(schemeFieldCanvas);
        return (pane);
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
