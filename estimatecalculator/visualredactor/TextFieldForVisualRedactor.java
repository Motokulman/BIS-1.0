/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package estimatecalculator.visualredactor;

import static estimatecalculator.EstimateCalculator.axisXObservableList;
import static estimatecalculator.EstimateCalculator.textFieldObservableListAbsoluteX;
import javafx.event.EventHandler;
import javafx.event.EventType;
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
   //     this.setText(area + "  " + number);
        this.addEventHandler(KeyEvent.KEY_TYPED, new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
               System.out.println(area);
               System.out.println(number);
               switch (area) {
                   case "AbsoluteX": {
                      System.out.println("area AbsoluteX"); 
                   }
               }

            }
        }
        );
   }


//private void changeTextFromRelativeXtoAbsoluteX() {
//    int k = Integer.valueOf(textFieldObservableListAbsoluteX.get(0).getText());
//    textFieldObservableListAbsoluteX.get(0).setText(textFieldObservableListAbsoluteX.get(0).getText());
//    for(int i = 1; i < axisXObservableList.size(); i++) {
//        k = k + Integer.valueOf(textFieldObservableListAbsoluteX.get(i).getText());
//        textFieldObservableListAbsoluteX.get(i).setText(Integer.toString(k));
//    }
//}  
       
    

}
