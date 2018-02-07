package estimatecalculator;

import estimatecalculator.classes.Aperture;
import java.io.IOException;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPathExpressionException;
import org.xml.sax.SAXException;

public class EstimateCalculator extends Application {
    
  public static BorderPane border = new BorderPane();
  public static ObservableList<Aperture> innerInsulateWallAperturesObservableList;
    
    public EstimateCalculator() {
        this.innerInsulateWallAperturesObservableList = FXCollections.observableArrayList();
    }

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
       HBox hMenuBarBox = FXMLLoader.load(getClass().getResource("FXMLMenuBar.fxml"));
       border.setTop(hMenuBarBox);
       
       //VBox vLeftBox = FXMLLoader.load(getClass().getResource("FXMLNavPane.fxml"));
       border.setLeft(FXMLLoader.load(getClass().getResource("FXMLNavPane.fxml")));
 
       border.setCenter(FXMLLoader.load(getClass().getResource("propertypane/mainwall/FXMLPropertyPane.fxml")));
      // border.setCenter(FXMLLoader.load(getClass().getResource("propertypane/innerinsulatewall/InnerInsulateWallPropertyPane.fxml")));
        
       Scene scene = new Scene(border, 1400, 800); 
       scene.getStylesheets().add (EstimateCalculator.class.getResource("base.css").toExternalForm());
       stage.setTitle("Estimate Calculator");
       stage.setScene(scene);
       stage.show();
   }
}
