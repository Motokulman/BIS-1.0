/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package visualcomponents;

import javafx.scene.control.TextField;

/**
 *
 * @author I
 */
public class SchemaTextField extends TextField {
    
    public SchemaTextField() {
        this.setPrefSize(48, 17);
        this.setPromptText("0"); // Замещающий тескт
      //this.setText("0"); //Настоящий текст
    }

}
