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
import javafx.event.EventHandler;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;

/**
 *
 * @author I
 */
public class TextFieldForVisualRedactor extends TextField {
   static public int Width = 48;
   static public String area; 
   static public int number;
   
   public TextFieldForVisualRedactor(double scale, String area, int number) {
        this.setPrefWidth(Width);
        this.setScaleX(scale);
        this.area = area;
        this.number = number;
   //     this.setText(Integer.toString(number));
        this.addEventHandler(KeyEvent.KEY_RELEASED, new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
               switch (area) {
                   // Если меняется нижний ряд - относительные Х
                   case "RelativeX": {
                      axisXObservableList.set(number, Integer.valueOf(TextFieldForVisualRedactor.this.getText()));// заносим в массив осей новое значение
                      changeTextFromRelativeXtoAbsoluteX();// редактируем соответственно поля текстфильдов
                      break;
                   }
                   case "RelativeY": {
                      axisYObservableList.set(number, Integer.valueOf(TextFieldForVisualRedactor.this.getText()));// заносим в массив осей новое значение
                      changeTextFromRelativeYtoAbsoluteY();// редактируем соответственно поля текстфильдов
                      break;
                   }
               }
            }
        }
        );
   }


private void changeTextFromRelativeXtoAbsoluteX() {
    int k = Integer.valueOf(axisXObservableList.get(0)); // Сначала придаем переменной k значение первого элемента списка относительных значений
    int n = 0; // переменнач для определения, есть ли дальше значения или только нули. Иначе заполнит текстовые поля абсолютных значений до конца
    textFieldObservableListAbsoluteX.get(0).setText(Integer.toString(axisXObservableList.get(0))); // Первое поле абсолютных равно первому полю относительных
    // Ищем, до каких пор идут ненулевые относительные значения 
    for(int i = 0; i < axisXObservableList.size(); i++) {
        if (axisXObservableList.get(i) != 0) n = i;
    }    
    // Суммируем относительные и заносим в абсолютные. Если нет дальше относительных - стираем абсолютные, если были, 
    for(int i = 1; i < axisXObservableList.size(); i++) {
        k = k + Integer.valueOf(axisXObservableList.get(i));
        if (i <= n) textFieldObservableListAbsoluteX.get(i).setText(Integer.toString(k));
        else textFieldObservableListAbsoluteX.get(i).setText("");
    }    
    // и относительные тоже, но отдельно, иначе не успевает менять и ощибка
    for(int i = 1; i < axisXObservableList.size(); i++) {
        if (i > n) textFieldObservableListRelativeX.get(i).setText("");
    }
}  
       
private void changeTextFromRelativeYtoAbsoluteY() {
    int k = Integer.valueOf(axisYObservableList.get(0)); // Сначала придаем переменной k значение первого элемента списка относительных значений
    int n = 0; // переменнач для определения, есть ли дальше значения или только нули. Иначе заполнит текстовые поля абсолютных значений до конца
    textFieldObservableListAbsoluteY.get(0).setText(Integer.toString(axisYObservableList.get(0))); // Первое поле абсолютных равно первому полю относительных
    // Ищем, до каких пор идут ненулевые относительные значения 
    for(int i = 0; i < axisYObservableList.size(); i++) {
        if (axisYObservableList.get(i) != 0) n = i;
    }    
    // Суммируем относительные и заносим в абсолютные. Если нет дальше относительных - стираем абсолютные, если были, 
    for(int i = 1; i < axisYObservableList.size(); i++) {
        k = k + Integer.valueOf(axisYObservableList.get(i));
        if (i <= n) textFieldObservableListAbsoluteY.get(i).setText(Integer.toString(k));
        else textFieldObservableListAbsoluteY.get(i).setText("");
    }    
    // и относительные тоже, но отдельно, иначе не успевает менять и ощибка
    for(int i = 1; i < axisYObservableList.size(); i++) {
        if (i > n) textFieldObservableListRelativeY.get(i).setText("");
    }
}  
}
