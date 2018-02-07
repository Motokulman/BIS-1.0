/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package estimatecalculator.visualredactor;

import java.util.ArrayList;
import java.util.List;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.layout.Pane;

/**
 *
 * @author I
 */
public class VisualRedactorFields {
    
    public static Pane getFields(int schemeWidth, int schemeHeight, int schemeCountCellsX, int schemeCountCellsY) {
        double scale = 0.8;
        Pane pane = new Pane();
        
        // Верхний ряд полей для абсолютных значений
        List<TextFieldForVisualRedactor> textFieldArrayListAbsoluteX = new ArrayList<>();
        ObservableList<TextFieldForVisualRedactor> textFieldObservableListAbsoluteX = FXCollections.observableList(textFieldArrayListAbsoluteX);
        for (int i = 0; i < schemeCountCellsX; i++) {
            textFieldObservableListAbsoluteX.add(new TextFieldForVisualRedactor(scale));
            textFieldObservableListAbsoluteX.get(i).setLayoutX(100*scale + i*(48 + 2)*scale);
            pane.getChildren().add(textFieldObservableListAbsoluteX.get(i));
        }
        
        // Нижний ряд полей для относительных значений
        List<TextFieldForVisualRedactor> textFieldArrayListRelativeX = new ArrayList<>();
        ObservableList<TextFieldForVisualRedactor> textFieldObservableListRelativeX = FXCollections.observableList(textFieldArrayListRelativeX);
        for (int i = 0; i < schemeCountCellsX; i++) {
            textFieldObservableListRelativeX.add(new TextFieldForVisualRedactor(scale));
            textFieldObservableListRelativeX.get(i).setLayoutY(626);
            textFieldObservableListRelativeX.get(i).setLayoutX(60 + i*(48 + 2)*scale);
            pane.getChildren().add(textFieldObservableListRelativeX.get(i));
        }
        
        // Левый ряд полей для относительных значений
        List<TextFieldForVisualRedactor> textFieldArrayListRelativeY = new ArrayList<>();
        ObservableList<TextFieldForVisualRedactor> textFieldObservableListRelativeY = FXCollections.observableList(textFieldArrayListRelativeY);
        for (int i = 0; i < schemeCountCellsY; i++) {
            textFieldObservableListRelativeY.add(new TextFieldForVisualRedactor(scale));
            textFieldObservableListRelativeY.get(i).setLayoutY(schemeHeight - 28 - i*schemeHeight/schemeCountCellsY);
            pane.getChildren().add(textFieldObservableListRelativeY.get(i));
        }
        
        // Правый ряд полей для абсолютных значений
        List<TextFieldForVisualRedactor> textFieldArrayListAbsoluteY = new ArrayList<>();
        ObservableList<TextFieldForVisualRedactor> textFieldObservableListAbsoluteY = FXCollections.observableList(textFieldArrayListAbsoluteY);
        for (int i = 0; i < schemeCountCellsY; i++) {
            textFieldObservableListAbsoluteY.add(new TextFieldForVisualRedactor(scale));
            textFieldObservableListAbsoluteY.get(i).setLayoutX(640);
            textFieldObservableListAbsoluteY.get(i).setLayoutY(schemeHeight - 48 - i*schemeHeight/schemeCountCellsY);
            pane.getChildren().add(textFieldObservableListAbsoluteY.get(i));
        }
        
        
        
        
        return (pane);
    }
    
    
}
