/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package estimatecalculator;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.TilePane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.paint.CycleMethod;
import javafx.scene.paint.LinearGradient;
import javafx.scene.paint.Stop;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import myclasses.Fronton;


/**
 *
 * @author I
 */
public class EstimateCalculator extends Application {
    
    private final  TableView<Fronton> tableViewFronton = new TableView<>();
     private final ObservableList<Fronton> data =
            FXCollections.observableArrayList(
            new Fronton(1, 2),
            new Fronton(4, 5),
            new Fronton(7, 8),
            new Fronton(1, 2),
            new Fronton(3, 4));
    
    public static void main(String[] args) {
        launch(EstimateCalculator.class, args);
    }
    
    @Override
    public void start(Stage stage) {

// Use a border pane as the root for scene
        BorderPane border = new BorderPane();
        
        HBox hbox = addHBox();
        border.setTop(hbox);
        border.setLeft(addVBox());
        
// Add a stack to the HBox in the top region
        addStackPane(hbox);  
        
// To see only the grid in the center, uncomment the following statement
// comment out the setCenter() call farther down        
//        border.setCenter(addGridPane());
        
// Choose either a TilePane or FlowPane for right region and comment out the
// one you aren't using        
        border.setRight(addFlowPane());
//        border.setRight(addTilePane());
        
// To see only the grid in the center, comment out the following statement
// If both setCenter() calls are executed, the anchor pane from the second
// call replaces the grid from the first call        
        border.setCenter(addAnchorPane(addGridPane()));

        Scene scene = new Scene(border);
        stage.setScene(scene);
        stage.setTitle("Estimate Calculator 2");
        stage.show();
    }

/*
 * Creates an HBox with two buttons for the top region
 */
    
    private HBox addHBox() {

        HBox hbox = new HBox();
        hbox.setPadding(new Insets(15, 12, 15, 12));
        hbox.setSpacing(10);   // Gap between nodes
        hbox.setStyle("-fx-background-color: #336699;");

        Button buttonCurrent = new Button("Current");
        buttonCurrent.setPrefSize(100, 20);

        Button buttonProjected = new Button("Projected");
        buttonProjected.setPrefSize(100, 20);
        
        hbox.getChildren().addAll(buttonCurrent, buttonProjected);
        
        return hbox;
    }
    
/*
 * Creates a VBox with a list of links for the left region
 */
    private VBox addVBox() {
        
        VBox vbox = new VBox();
        vbox.setPadding(new Insets(10)); // Set all sides to 10
        vbox.setSpacing(8);              // Gap between nodes

        Text title = new Text("Data");
        title.setFont(Font.font("Arial", FontWeight.BOLD, 14));
        vbox.getChildren().add(title);
        
        Hyperlink options[] = new Hyperlink[] {
            new Hyperlink("Стены"),
            new Hyperlink("Marketing"),
            new Hyperlink("Distribution"),
            new Hyperlink("Costs")};

        for (int i=0; i<4; i++) {
            // Add offset to left side to indent from title
            VBox.setMargin(options[i], new Insets(0, 0, 0, 8));
            vbox.getChildren().add(options[i]);
        }
        
        return vbox;
    }

/*
 * Uses a stack pane to create a help icon and adds it to the right side of an HBox
 * 
 * @param hb HBox to add the stack to
 */
    private void addStackPane(HBox hb) {

        StackPane stack = new StackPane();
        Rectangle helpIcon = new Rectangle(30.0, 25.0);
        helpIcon.setFill(new LinearGradient(0,0,0,1, true, CycleMethod.NO_CYCLE,
            new Stop[]{
            new Stop(0,Color.web("#4977A3")),
            new Stop(0.5, Color.web("#B0C6DA")),
            new Stop(1,Color.web("#9CB6CF")),}));
        helpIcon.setStroke(Color.web("#D0E6FA"));
        helpIcon.setArcHeight(3.5);
        helpIcon.setArcWidth(3.5);
        
        Text helpText = new Text("?");
        helpText.setFont(Font.font("Verdana", FontWeight.BOLD, 18));
        helpText.setFill(Color.WHITE);
        helpText.setStroke(Color.web("#7080A0")); 
        
        stack.getChildren().addAll(helpIcon, helpText);
        stack.setAlignment(Pos.CENTER_RIGHT);
        // Add offset to right for question mark to compensate for RIGHT 
        // alignment of all nodes
        StackPane.setMargin(helpText, new Insets(0, 10, 0, 0));
        
        hb.getChildren().add(stack);
        HBox.setHgrow(stack, Priority.ALWAYS);
                
    }

/*
 * Creates a grid for the center region with four columns and three rows
 */
    private GridPane addGridPane() {

        GridPane grid = new GridPane();
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(0, 10, 0, 10));
        
        TabPane tabPane = new TabPane();
        tabPane.setMinSize(400, 300);
        
        Tab tab1 = new Tab();
        tab1.setText("Несущие стены");
      //  tab1.setContent(new Rectangle(300,150, Color.LIGHTSTEELBLUE));
        
      
        // Панель для отрисовки таблицы с этажами
        GridPane tab1GridPane = new GridPane();
        tab1GridPane.setHgap(10);
        tab1GridPane.setVgap(10);
        tab1GridPane.setPadding(new Insets(25, 25, 25, 25));
        tab1GridPane.setGridLinesVisible(true);
        
      //  Text scenetitle = new Text("WelcomeWelcomeWelcome");
       // scenetitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
        tab1GridPane.add(new Text("Этажи"), 0, 0, 2, 1);
        tab1GridPane.add(new Text("Длина"), 1, 1);
        tab1GridPane.add(new Text("Высота"), 2, 1);
        tab1GridPane.add(new Text("Площадь"), 3, 1);

      //  Label userName = new Label("User Name:");
        tab1GridPane.add(new Label("1"), 0, 2);
        tab1GridPane.add(new Label("2"), 0, 3);
        tab1GridPane.add(new Label("3"), 0, 4);

        // Поля для ввода длины стен
        TextField textFieldWallsWidth1Floor = new TextField();
        textFieldWallsWidth1Floor.setPrefWidth(50);
        tab1GridPane.add(textFieldWallsWidth1Floor, 1, 2);
        TextField textFieldWallsWidth2Floor = new TextField();
        textFieldWallsWidth2Floor.setPrefWidth(50);
        tab1GridPane.add(textFieldWallsWidth2Floor, 1, 3);
        TextField textFieldWallsWidth3Floor = new TextField();
        textFieldWallsWidth3Floor.setPrefWidth(50);
        tab1GridPane.add(textFieldWallsWidth3Floor, 1, 4);
        // Поля для ввода высоты стен
        TextField textFieldWallsHeight1Floor = new TextField();
        textFieldWallsHeight1Floor.setPrefWidth(50);
        tab1GridPane.add(textFieldWallsHeight1Floor, 2, 2);
        TextField textFieldWallsHeight2Floor = new TextField();
        textFieldWallsHeight2Floor.setPrefWidth(50);
        tab1GridPane.add(textFieldWallsHeight2Floor, 2, 3);
        TextField textFieldWallsHeight3Floor = new TextField();
        textFieldWallsHeight3Floor.setPrefWidth(50);
        tab1GridPane.add(textFieldWallsHeight3Floor, 2, 4);
        // Поля для ввода площади стен
        TextField textFieldWallsArea1Floor = new TextField();
        textFieldWallsArea1Floor.setPrefWidth(50);
        tab1GridPane.add(textFieldWallsArea1Floor, 3, 2);
        TextField textFieldWallsArea2Floor = new TextField();
        textFieldWallsArea2Floor.setPrefWidth(50);
        tab1GridPane.add(textFieldWallsArea2Floor, 3, 3);
        TextField textFieldWallsArea3Floor = new TextField();
        textFieldWallsArea3Floor.setPrefWidth(50);
        tab1GridPane.add(textFieldWallsArea3Floor, 3, 4);
        
        // Фронтоны
        Label labelFronton = new Label("Фронтоны");
        labelFronton.setFont(new Font("Arial", 20));
        tab1GridPane.add(labelFronton, 4, 0, 2, 1);
        
       // TableView tableViewFronton = new TableView();
        
//        TableView<Fronton> tableViewFronton = new TableView<>();
//        ObservableList<Fronton> data = FXCollections.observableArrayList(new Fronton(1.0, 2.0));
        
        tableViewFronton.setEditable(true);
        tableViewFronton.setPrefHeight(100);
        
        TableColumn tableColumnNumber = new TableColumn("№");
        tableColumnNumber.setCellValueFactory(new PropertyValueFactory<>("Number"));
        
        TableColumn tableColumnWidth = new TableColumn("Ширина");
        tableColumnWidth.setCellValueFactory(new PropertyValueFactory<>("Width"));
        
        TableColumn tableColumnHeight = new TableColumn("Высота");
        tableColumnHeight.setCellValueFactory(new PropertyValueFactory<>("Height"));
        
        TableColumn tableColumnArea = new TableColumn("Площадь");    
        tableColumnArea.setCellValueFactory(new PropertyValueFactory<>("Area"));
        
         tableViewFronton.setItems(data);
         tableViewFronton.getColumns().addAll(tableColumnNumber, tableColumnWidth, tableColumnHeight, tableColumnArea);
        
        // добавление полей для ввода новых значений и кнопки
        final TextField addWidth = new TextField();
        addWidth.setPromptText("Ширина");
        addWidth.setPrefWidth(50);
       // addFirstName.setMaxWidth(tableColumnWidth.getPrefWidth());
        final TextField addHeight = new TextField();
        addHeight.setPrefWidth(50);
     //  addHeight.setMaxWidth(lastNameCol.getPrefWidth());
        addHeight.setPromptText("Высота");

 
        final Button addFrontonButton = new Button("Add");
        addFrontonButton.setOnAction((ActionEvent e) -> {
            data.add(new Fronton(
                    new Double(addWidth.getText()),
                    new Double(addHeight.getText())));
            System.out.println( new Double(addWidth.getText()));
            addWidth.clear();
            addHeight.clear();
        });

        
        tab1GridPane.add(tableViewFronton, 4, 1, 3, 4);
        tab1GridPane.add(addWidth, 4, 5);
        tab1GridPane.add(addHeight, 5, 5);
        tab1GridPane.add(addFrontonButton, 6, 5);


        tab1.setContent(tab1GridPane);
        
        Tab tab2 = new Tab();
        tab2.setText("2 tab");
        tab2.setContent(new Rectangle(200,200, Color.LIGHTSTEELBLUE));
        
        tabPane.getTabs().addAll(tab1, tab2);
        
        /*
        * Дальнейший закоментированный текст это код редактора схемы - канва с линиями и полями числовых значений
        */
//        SchemaTextField SchemaTextField_A = new SchemaTextField();
//        grid.add(SchemaTextField_A, 0, 0); 
//
//        // Рисуем поле схемы
//        Group root = new Group();
//       // Create the Canvas, filled in with Blue
//        final Canvas canvas = new Canvas(600, 600);
//       // canvas.setTranslateX(100);
//      //  canvas.setTranslateY(100);
//        reset(canvas, Color.WHITE);
//        
//        final GraphicsContext gc = canvas.getGraphicsContext2D();
//
//        // Рисуем линии
//        drawLines(gc, canvas);
//        
//        // Clear away portions as the user drags the mouse
//        canvas.addEventHandler(MouseEvent.MOUSE_DRAGGED, new EventHandler<MouseEvent>() {
//            @Override
//            public void handle(MouseEvent e) {
//                
//                gc.clearRect(e.getX() - 2, e.getY() - 2, 5, 5);
//            }
//        });
//        
//        // Fill the Canvas with a Blue rectnagle when the user double-clicks
//        canvas.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
//            @Override
//            public void handle(MouseEvent t) {            
//                if (t.getClickCount() >1) {
//                    reset(canvas, Color.BLUE);
//                }  
//            }
//        });
//        
//        // Add the Canvas to the Scene, and show the Stage
//        root.getChildren().add(canvas);
//        grid.add(root, 1, 0); 
        grid.setGridLinesVisible(true);
        grid.add(tabPane, 0, 0); 
        return grid;
    }

/*
 * Creates a horizontal flow pane with eight icons in four rows
 */
    private FlowPane addFlowPane() {

        FlowPane flow = new FlowPane();
        flow.setPadding(new Insets(5, 0, 5, 0));
        flow.setVgap(4);
        flow.setHgap(4);
        flow.setPrefWrapLength(170); // preferred width allows for two columns
        flow.setStyle("-fx-background-color: DAE6F3;");

        ImageView pages[] = new ImageView[8];
        for (int i=0; i<8; i++) {
            pages[i] = new ImageView(
                    new Image(EstimateCalculator.class.getResourceAsStream(
                    "graphics/chart_"+(i+1)+".png")));
            flow.getChildren().add(pages[i]);
        }

        return flow;
    }
    
/*
 * Creates a horizontal (default) tile pane with eight icons in four rows
 */
    private TilePane addTilePane() {
        
        TilePane tile = new TilePane();
        tile.setPadding(new Insets(5, 0, 5, 0));
        tile.setVgap(4);
        tile.setHgap(4);
        tile.setPrefColumns(2);
        tile.setStyle("-fx-background-color: DAE6F3;");

        ImageView pages[] = new ImageView[8];
        for (int i=0; i<8; i++) {
            pages[i] = new ImageView(
                    new Image(EstimateCalculator.class.getResourceAsStream(
                    "graphics/chart_"+(i+1)+".png")));
            tile.getChildren().add(pages[i]);
        }

        return tile;
    }
 
/*
 * Creates an anchor pane using the provided grid and an HBox with buttons
 * 
 * @param grid Grid to anchor to the top of the anchor pane
 */
    private AnchorPane addAnchorPane(GridPane grid) {

        AnchorPane anchorpane = new AnchorPane();
        
        Button buttonSave = new Button("Save");
        Button buttonCancel = new Button("Cancel");

        HBox hb = new HBox();
        hb.setPadding(new Insets(0, 10, 10, 10));
        hb.setSpacing(10);
        hb.getChildren().addAll(buttonSave, buttonCancel);

        anchorpane.getChildren().addAll(grid,hb);
        // Anchor buttons to bottom right, anchor grid to top
        AnchorPane.setBottomAnchor(hb, 8.0);
        AnchorPane.setRightAnchor(hb, 5.0);
        AnchorPane.setTopAnchor(grid, 10.0);

        return anchorpane;
    }
    
        /**
     * Сброс канвы
     *
     * @param canvas The canvas to reset
     * @param color The color to fill
     */
//    private void reset(Canvas canvas, Color color) {
//        GraphicsContext gc = canvas.getGraphicsContext2D();
//        gc.setFill(color);
//        gc.fillRect(0, 0, canvas.getWidth(), canvas.getHeight());
//    }
//    
//        private void drawLines(GraphicsContext gc, Canvas canvas) {
//            double padding = 20.5;
//            int hvostik = 3;
//            int gap = 40;
//            String letters = new String("АБВГДЕЖИКЛМНПРСТУФХЦ");
//            
//            gc.beginPath();
//            gc.setStroke(Color.GRAY);   
//            gc.setLineDashes(3, 3); // gc.setLineDashes(4, 4, 10, 4); - рисует ось симметрии
//            for (double i = padding, j = 0; i < canvas.getHeight(); i = i + gap, j++) {
//                gc.moveTo(i, padding - hvostik);
//                gc.lineTo(i, canvas.getHeight() - padding + hvostik);
//            }            
//            for (double i = padding; i < canvas.getWidth(); i = i + gap) {
//                gc.moveTo(padding - hvostik, i);
//                gc.lineTo(canvas.getWidth() - padding + hvostik, i);
//            }
//            gc.stroke();
//            
//            gc.setFont(new Font(12));
//            gc.setLineDashes(0);
//            gc.setLineWidth(1.0);
//            gc.setFill(Color.BLACK); 
//            
//            for (double i = padding, j = 1; i < canvas.getHeight(); i = i + gap, j++) {
//                gc.fillText(Integer.toString((int) j), i - 5, 10.5);
//                gc.fillText(Integer.toString((int) j), i - 5, canvas.getHeight() - 2.5);
//           }  
//            for (double i = canvas.getWidth() - padding + 4, j = 0; i > 0; i = i - gap, j++) {
//                gc.fillText(Character.toString(letters.charAt((int) j)), 2, i);
//                gc.fillText(Character.toString(letters.charAt((int) j)), canvas.getWidth() - 11, i);
//           }  
//        }
    
        /**
     * Draws the background with a RadialGradient 
     * that transitions from Red to Yellow.
     * @param rect the Rectangle to draw on the Canvas 
     */
    // Заполнение фона за канвой. Не нужно!
//    private void drawBackground(Rectangle rect) {
//        rect.setFill(new LinearGradient(0, 0, 1, 1, true,
//                CycleMethod.REFLECT,
//                new Stop(0, Color.RED),
//                new Stop(1, Color.YELLOW)));
//    }

    
}
