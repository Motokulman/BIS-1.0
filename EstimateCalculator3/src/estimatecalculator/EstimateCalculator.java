/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package estimatecalculator;

import java.io.File;
import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.xml.sax.SAXException;

/**
 *
 * @author I
 */
public class EstimateCalculator extends Application {
    
    public static String lastDir = new String();
    
   public static void main(String[] arguments) throws ParserConfigurationException, SAXException, IOException, XPathExpressionException
   {
       // Читаем файл настроек       
       DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
       DocumentBuilder builder = factory.newDocumentBuilder();
       Document document = builder.parse(new File("myConfig.xml"));
      
       Element element = document.getDocumentElement();
       System.out.println(element.getElementsByTagName("root"));
       
       // Получим путь последнего сохранения проекта
       XPathFactory xpf = XPathFactory.newInstance();
       XPath xp = xpf.newXPath();
       lastDir = xp.evaluate("//root/lastDir/text()", document.getDocumentElement());
      
       Application.launch(EstimateCalculator.class, arguments);

   }


   @Override
   public void start(final Stage stage) throws Exception
   {
       BorderPane border = new BorderPane();
       
       HBox hMenuBarBox = FXMLLoader.load(getClass().getResource("FXMLMenuBar.fxml"));
       border.setTop(hMenuBarBox);
       
       VBox vLeftBox = FXMLLoader.load(getClass().getResource("FXMLNavPane.fxml"));
       border.setLeft(vLeftBox);

      
       
     //  border.setLeft(addVBox());
    //   addStackPane(hbox);         // Add stack to HBox in top region

     //  border.setCenter(addGridPane());
     //  border.setRight(addFlowPane());
       
       
       
       
//     FXMLLoader f = new FXMLLoader(); 
     //  Parent root = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));
//     final Parent fxmlRoot = (Parent)f.load(new FileInputStream(new File("estimatecalculator.FXMLDocument.fxml")));
       Scene scene = new Scene(border, 800, 600);
       stage.setTitle("Estimate Calculator");
       stage.setScene(scene);
       stage.show();
   }
}