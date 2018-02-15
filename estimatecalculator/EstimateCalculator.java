package estimatecalculator;

import estimatecalculator.classes.Aperture;
import estimatecalculator.scheme.Scheme;
import estimatecalculator.scheme.primitives.Couple;
import estimatecalculator.scheme.primitives.Point;
import estimatecalculator.visualredactor.TextFieldForVisualRedactor;
import static estimatecalculator.visualredactor.VisualRedactorFields.CreateVisualRedactorFields;
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
  public static ObservableList<Aperture> innerInsulateWallAperturesObservableList; // массив проемов
  public static ObservableList<Point> pointsObservableList; // массив точек
  public static ObservableList<Couple> couplesObservableList; // массив Линий
  public static ObservableList<Integer> axisXObservableList; // массив относительных расстояний по оси Х
  public static ObservableList<Integer> axisYObservableList; // массив относительных расстояний по оси Y
 // public static int paddingScheme = 20; // для рисования схемы, используется во многих функциях, поэтому здесь
  public static ObservableList<TextFieldForVisualRedactor> textFieldObservableListAbsoluteX; // Массив TextField Верхний ряд полей для абсолютных значений
  public static ObservableList<TextFieldForVisualRedactor> textFieldObservableListRelativeX; // Массив TextField Нижний ряд полей для относительных значений
  public static ObservableList<TextFieldForVisualRedactor> textFieldObservableListRelativeY; // Массив TextField Левый ряд полей для относительных значений
  public static ObservableList<TextFieldForVisualRedactor> textFieldObservableListAbsoluteY; // Массив TextField Правый ряд полей для абсолютных значений
//  public static Scheme sC = new Scheme(pointsObservableList, couplesObservableList, axisXObservableList, axisYObservableList);

  public static ObservableList<Point> testPoint;
  
    public EstimateCalculator() {
        this.innerInsulateWallAperturesObservableList = FXCollections.observableArrayList();
        this.pointsObservableList = FXCollections.observableArrayList();
        this.couplesObservableList = FXCollections.observableArrayList();
        this.axisXObservableList = FXCollections.observableArrayList();
        this.axisYObservableList = FXCollections.observableArrayList();
        // Массивы TextField 
        this.textFieldObservableListAbsoluteX = FXCollections.observableArrayList();
        this.textFieldObservableListRelativeX = FXCollections.observableArrayList();
        this.textFieldObservableListRelativeY = FXCollections.observableArrayList();
        this.textFieldObservableListAbsoluteY = FXCollections.observableArrayList();
       // System.out.println("EstimateCalculator");
       this.testPoint = FXCollections.observableArrayList();
    }

   public static void main(String[] arguments) throws ParserConfigurationException, SAXException, IOException, XPathExpressionException
   {
       // Создаем класс, в котором храним все для схемы, чтоб сохранить и открыть
        

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
       CreateVisualRedactorFields(600, 600, 14, 14);
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
