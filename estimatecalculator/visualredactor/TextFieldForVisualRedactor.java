/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package estimatecalculator.visualredactor;

import javafx.scene.control.TextField;

/**
 *
 * @author I
 */
public class TextFieldForVisualRedactor extends TextField {
   static public int Width = 48;
   public TextFieldForVisualRedactor(double scale) {
        this.setPrefWidth(Width);
        this.setScaleX(scale);
     //   this.setPromptText("0"); // Замещающий тескт
        this.setText("0"); //Настоящий текст
    }    
}
