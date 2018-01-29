/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package estimatecalculator;

import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPathExpressionException;
import org.xml.sax.SAXException;

/**
 *
 * @author I
 */
public class EstimateCalculator extends Application {
    
  //  public static String lastDir = new String();
    
   public static void main(String[] arguments) throws ParserConfigurationException, SAXException, IOException, XPathExpressionException
   {
//       // Читаем файл настроек       
//       DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
//       DocumentBuilder builder = factory.newDocumentBuilder();
//       Document document = builder.parse(new File("myConfig.xml"));
//      
//    //   Element element = document.getDocumentElement();
//       // Получим путь последнего сохранения проекта
//       XPathFactory xPathFactory = XPathFactory.newInstance();
//       XPath xPath = xPathFactory.newXPath();
//       lastDir = xPath.evaluate("//root/lastDir/text()", document.getDocumentElement());
        
       Application.launch(EstimateCalculator.class, arguments);

   }


   @Override
   public void start(final Stage stage) throws Exception
   {
       BorderPane border = new BorderPane();
       
       HBox hMenuBarBox = FXMLLoader.load(getClass().getResource("FXMLMenuBar.fxml"));
       border.setTop(hMenuBarBox);
       
       //VBox vLeftBox = FXMLLoader.load(getClass().getResource("FXMLNavPane.fxml"));
       border.setLeft(FXMLLoader.load(getClass().getResource("FXMLNavPane.fxml")));
 
       border.setRight(FXMLLoader.load(getClass().getResource("FXMLPropertyPane.fxml")));
       
            Scene scene = new Scene(border, 800, 600); 
            
            Rectangle rect = new Rectangle(100,100); 
            rect.setLayoutX(150); 
            rect.setLayoutY(150); 
            rect.getStyleClass().add("my-rect"); 
            border.setCenter(rect);


       
       
       
       scene.getStylesheets().add (EstimateCalculator.class.getResource("base.css").toExternalForm());
       stage.setTitle("Estimate Calculator");
       stage.setScene(scene);
     //  scene.getStylesheets().add (EstimateCalculator.class.getResource("fxmlpropertypane.css").toExternalForm());
     


       stage.show();
   }
}
