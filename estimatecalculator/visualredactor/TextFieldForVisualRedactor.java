/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package estimatecalculator.visualredactor;

import static estimatecalculator.EstimateCalculator.axisXObservableList;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;

/**
 *
 * @author I
 */
public class TextFieldForVisualRedactor extends TextField {
   static public int Width = 48;
   static public String areaTextFieldForVisualRedactor; 
   static public int numberTextFieldForVisualRedactor;
   
   public TextFieldForVisualRedactor(double scale, String area, int number) {
        this.setPrefWidth(Width);
        this.setScaleX(scale);
        this.areaTextFieldForVisualRedactor = area;
        this.numberTextFieldForVisualRedactor = number;
   //     this.setText(Integer.toString(number)); //Настоящий текст
   }
   
//   private void passTextFieldForVisualRedactorValueToList(){
//       this.addEventHandler(KeyEvent.KEY_TYPED, (KeyEvent event) -> {
//           //axisXObservableList.get(number)
//       }) ;
//   }
       
    

}
