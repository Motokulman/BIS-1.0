/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package estimatecalculator.visualredactor;

import static estimatecalculator.visualredactor.VisualRedactorFields.getFields;
import static estimatecalculator.visualredactor.VisualRedactorScheme.getClearScheme;
import javafx.geometry.Insets;
import javafx.scene.layout.Pane;

/**
 *
 * @author I
 */
public class CompoundVisualRedactor {
    public static Pane getVisualRedactor(int schemeWidth, int schemeHeight, int schemeCountCellsX, int schemeCountCellsY) {
        Pane pane = new Pane();
        Pane schemePane = new Pane(); // Отдельная панель для схемы чтобы спозиционировать ее, т.е. задать setLayoutX и setLayoutY. Можно то же сделать в исходном классе, но композер ведь здесь
        pane.getChildren().add(getFields(schemeWidth, schemeHeight, schemeCountCellsX, schemeCountCellsY));
        schemePane.getChildren().add(getClearScheme(schemeWidth, schemeHeight, schemeCountCellsX, schemeCountCellsY));
        schemePane.setLayoutX(44);
        schemePane.setLayoutY(25);
        pane.getChildren().add(schemePane);
       // System.out.println("sdf");    
        return (pane);
    }
    
}
