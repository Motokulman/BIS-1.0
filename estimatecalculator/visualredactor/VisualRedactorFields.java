/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package estimatecalculator.visualredactor;

import static estimatecalculator.EstimateCalculator.axisXObservableList;
import static estimatecalculator.EstimateCalculator.axisYObservableList;
import static estimatecalculator.EstimateCalculator.textFieldObservableListAbsoluteX;
import static estimatecalculator.EstimateCalculator.textFieldObservableListAbsoluteY;
import static estimatecalculator.EstimateCalculator.textFieldObservableListRelativeX;
import static estimatecalculator.EstimateCalculator.textFieldObservableListRelativeY;
import javafx.scene.layout.Pane;



/**
 *
 * @author I
 */
public class VisualRedactorFields {
    private static double scale = 0.8;
    private static int padding = 20;

    public static void CreateVisualRedactorFields(int schemeWidth, int schemeHeight, int schemeCountCellsX, int schemeCountCellsY) {
        for (int i = 0; i < schemeCountCellsX; i++) {
            textFieldObservableListAbsoluteX.add(new TextFieldForVisualRedactor(scale, "AbsoluteX", i));
           // textFieldObservableListAbsoluteX.get(i).setDisable(true);
            textFieldObservableListAbsoluteX.get(i).setEditable(false);
            textFieldObservableListAbsoluteX.get(i).setLayoutX(textFieldObservableListAbsoluteX.get(i).getPrefWidth() - 3 + ((schemeWidth - 2*padding)/schemeCountCellsX)/2 + padding + ((schemeWidth - 2*padding)/schemeCountCellsX - textFieldObservableListAbsoluteX.get(i).getPrefWidth())/2 + i*(schemeWidth - 2*padding)/schemeCountCellsX);
        }
        for (int i = 0; i < schemeCountCellsX; i++) {
            axisXObservableList.add(0);
            
            textFieldObservableListRelativeX.add(new TextFieldForVisualRedactor(scale, "RelativeX", i));
            textFieldObservableListRelativeX.get(i).setLayoutY(schemeHeight + 25);
            textFieldObservableListRelativeX.get(i).setLayoutX(textFieldObservableListRelativeX.get(i).getPrefWidth() - 3 + padding + ((schemeWidth - 2*padding)/schemeCountCellsX - textFieldObservableListRelativeX.get(i).getPrefWidth())/2 + i*(schemeWidth - 2*padding)/schemeCountCellsX);
//textFieldObservableListRelativeX.get(i).setText(Integer.toString(axisXObservableList.get(i)));
        }
        for (int i = 0; i < schemeCountCellsY; i++) {
            axisYObservableList.add(0);
            textFieldObservableListRelativeY.add(new TextFieldForVisualRedactor(scale, "RelativeY", i));
            textFieldObservableListRelativeY.get(i).setLayoutY(schemeHeight - 8 - ((schemeHeight - 2*padding)/schemeCountCellsY)/2 - i*(schemeHeight - 2*padding)/schemeCountCellsY);
        }
        for (int i = 0; i < schemeCountCellsY; i++) {
            textFieldObservableListAbsoluteY.add(new TextFieldForVisualRedactor(scale, "AbsoluteY", i));
           // textFieldObservableListAbsoluteY.get(i).setDisable(true);
            textFieldObservableListAbsoluteY.get(i).setEditable(false);            textFieldObservableListAbsoluteY.get(i).setLayoutX(schemeWidth + (int)(textFieldObservableListAbsoluteY.get(i).getPrefWidth() + 1)*scale);
            textFieldObservableListAbsoluteY.get(i).setLayoutY(schemeHeight - 8 - (schemeHeight - 2*padding)/schemeCountCellsY - i*(schemeHeight - 2*padding)/schemeCountCellsY);
        }
    }
    
    
    public static Pane getFields(int schemeWidth, int schemeHeight, int schemeCountCellsX, int schemeCountCellsY) {
        Pane pane = new Pane();
        
        // Верхний ряд полей для абсолютных значений
        for (int i = 0; i < schemeCountCellsX; i++) {
            textFieldObservableListRelativeX.get(i).setText(Integer.toString(axisXObservableList.get(i))); // Если есть в памяти массивы с данными, заносим их
            TextFieldForVisualRedactor.changeTextFromRelativeXtoAbsoluteX(); // калькулируем значения для абсолютных значений и заносим
            // Выводим на экран
            pane.getChildren().add(textFieldObservableListAbsoluteX.get(i));
            pane.getChildren().add(textFieldObservableListRelativeX.get(i));
        }
        for (int i = 0; i < schemeCountCellsY; i++) {
            textFieldObservableListRelativeY.get(i).setText(Integer.toString(axisYObservableList.get(i))); // Если есть в памяти массивы с данными, заносим их
            TextFieldForVisualRedactor.changeTextFromRelativeYtoAbsoluteY(); // калькулируем значения для абсолютных значений и заносим
            // Выводим на экран
            pane.getChildren().add(textFieldObservableListRelativeY.get(i));
            pane.getChildren().add(textFieldObservableListAbsoluteY.get(i));
        }        
        return (pane);
    }
}
