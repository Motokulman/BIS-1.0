/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package estimatecalculator.visualredactor;

import static estimatecalculator.visualredactor.VisualRedactorFields.getFields;
import static estimatecalculator.visualredactor.VisualRedactorScheme.getClearScheme;
import javafx.event.EventType;
import javafx.scene.layout.Pane;

/**
 *
 * @author I
 */
public class CompoundVisualRedactor {
    public static Pane getVisualRedactor(int schemeHeight, int schemeWidth, int schemeCountCellsX, int schemeCountCellsY) {
        Pane pane = new Pane();
        Pane schemePane = new Pane(); // Отдельная панель для схемы чтобы спозиционировать ее, т.е. задать setLayoutX и setLayoutY. Можно то же сделать в исходном классе, но композер ведь здесь
        pane.getChildren().add(getFields(schemeHeight, schemeWidth, schemeCountCellsX, schemeCountCellsY));
        schemePane.getChildren().add(getClearScheme(schemeHeight, schemeWidth, schemeCountCellsX, schemeCountCellsY));
        schemePane.setLayoutX(40);
        schemePane.setLayoutY(40);
        pane.getChildren().add(schemePane);
       // System.out.println("sdf");    
        return (pane);
    }
    
}
