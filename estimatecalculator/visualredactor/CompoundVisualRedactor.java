/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package estimatecalculator.visualredactor;

import static estimatecalculator.classes.SchemeCanvas.graphicsContext;
import static estimatecalculator.classes.SchemeCanvas.schemeGridNodesCanvasCoordX;
import static estimatecalculator.classes.SchemeCanvas.schemeGridNodesCanvasCoordY;
import static estimatecalculator.visualredactor.VisualRedactorFields.getFields;
import static estimatecalculator.visualredactor.VisualRedactorScheme.getClearScheme;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;

/**
 *
 * @author I
 */
public class CompoundVisualRedactor {
        public static boolean pointSelected = false;
        public static boolean lineSelected = true;    
        public static String whatDrawNow = "Wall";
   
    public static Pane getVisualRedactor(int schemeWidth, int schemeHeight, int schemeCountCellsX, int schemeCountCellsY) {
    
        Pane pane = new Pane();
        Pane schemePane = new Pane(); // Отдельная панель для схемы чтобы спозиционировать ее, т.е. задать setLayoutX и setLayoutY. Можно то же сделать в исходном классе, но композер ведь здесь
        pane.getChildren().add(getFields(600, 600, 14, 14));
        schemePane.getChildren().add(getClearScheme(schemeWidth, schemeHeight, schemeCountCellsX, schemeCountCellsY));
        schemePane.setLayoutX(TextFieldForVisualRedactor.Width - 4);
        schemePane.setLayoutY(25);
        
        Button pointButton = new Button("Точка");
        pointButton.setLayoutX(0.0);
        pointButton.setLayoutY(700.0);
        pointButton.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                whatDrawNow = "Point";
                //graphicsContext.setStroke(Color.YELLOW);
                System.out.println(pointSelected);  
            }
        });
        
        Button lineButton = new Button("Стена");
        lineButton.setLayoutX(50.0);
        lineButton.setLayoutY(700.0);
        lineButton.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                whatDrawNow = "Wall";
            }
        });

        pane.getChildren().addAll(pointButton, lineButton);
        pane.getChildren().add(schemePane);
        return (pane);
    }
    
    
    
}
