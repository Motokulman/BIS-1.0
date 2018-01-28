/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package estimatecalculator;

import static estimatecalculator.EstimateCalculator.lastDir;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.MenuBar;
import javafx.scene.input.InputEvent;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.stage.DirectoryChooser;
import javafx.stage.FileChooser;
import javafx.stage.Window;
import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamWriter;

/**
 *
 * @author I
 */
public class MenuController implements Initializable
{
  @FXML
  private MenuBar menuBar;
    private Window stage;
  
  // Создание нового файла
  @FXML
  private void handleCreateNewFile(final ActionEvent event) throws XMLStreamException
  {
    provideCreateNewFile();
  }
  
  // Функции реализаций действий меню
  private void provideCreateNewFile() throws XMLStreamException
  {
    //Stage stage = new Stage();

      
    FileChooser fileChooser1 = new FileChooser();
    fileChooser1.setTitle("Создать проект");
    
    FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("Файл проекта XML", "*.xml");//Расширение
    fileChooser1.getExtensionFilters().add(extFilter);
    fileChooser1.setInitialDirectory(new File(lastDir));
    File file = fileChooser1.showSaveDialog(stage);
    
    if (file != null) {
        try {
            XMLOutputFactory factory = XMLOutputFactory.newFactory();
            XMLStreamWriter writer = factory.createXMLStreamWriter(new FileOutputStream(file));
            writer.writeStartDocument();
            writer.writeStartElement("root");
            writer.writeEndElement();
            writer.writeEndDocument();
             
        } catch (IOException ex) {
             System.out.println(ex.getMessage());
        }
    }
  }

  /**
   * Handle action related to "About" menu item.
   * 
   * @param event Event on "About" menu item.
   */
  @FXML
  private void handleAboutAction(final ActionEvent event)
  {
     provideAboutFunctionality();
  }

  /**
   * Handle action related to input (in this case specifically only responds to
   * keyboard event CTRL-A).
   * 
   * @param event Input event.
   */
  @FXML
  private void handleKeyInput(final InputEvent event)
  {
     if (event instanceof KeyEvent)
     {
        final KeyEvent keyEvent = (KeyEvent) event;
        if (keyEvent.isControlDown() && keyEvent.getCode() == KeyCode.A)
        {
           provideAboutFunctionality();
        }
     }
  }

  /**
   * Perform functionality associated with "About" menu selection or CTRL-A.
   */
  private void provideAboutFunctionality()
  {
     System.out.println("You clicked on About!");      
  }


 @Override
 public void initialize(java.net.URL arg0, ResourceBundle arg1) {
   menuBar.setFocusTraversable(true);
   
 }   
}