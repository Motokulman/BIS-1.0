/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package estimatecalculator;

import static estimatecalculator.EstimateCalculator.border;
import estimatecalculator.propertypane.innerinsulatewall.InnerInsulateWallPropertyPaneController;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import javafx.scene.input.MouseEvent;

/**
 * FXML Controller class
 *
 * @author I
 */
public class NavPaneController implements Initializable {

  @FXML private TreeView<String> NavPaneTreeView;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        // Добавляем корневой узел. Сделать, чтобы он назывался как проект либо разобраться, как сделать чтоб его не было, а следующие узлы стали корневыми
        TreeItem<String> projectTreeItem = new TreeItem<>("Наш проект");
        projectTreeItem.setExpanded(true);
        NavPaneTreeView.setRoot(projectTreeItem);
        
        TreeItem<String> wallsTreeItem = new TreeItem<>("Стены");
        projectTreeItem.getChildren().add(wallsTreeItem);
        wallsTreeItem.setExpanded(true);
        
        TreeItem<String> mainWallTreeItem = new TreeItem<>("Базовая стена");
        wallsTreeItem.getChildren().add(mainWallTreeItem);
        
        TreeItem<String> innerInsulateWallTreeItem = new TreeItem<>("Внутренняя теплая стена");
        wallsTreeItem.getChildren().add(innerInsulateWallTreeItem);
        
        TreeItem<String> visualRedactorTreeItem = new TreeItem<>("Редактор");
        projectTreeItem.getChildren().add(visualRedactorTreeItem);
        //wallsTreeItem.setExpanded(true);
        
        NavPaneTreeView.setPrefHeight(1000.0);
    }
    // Выбираем в левой панели нужные итемс и меняем центр панели
    public void mouseTreeItemClick(MouseEvent mouseEvent) throws IOException {
        switch (NavPaneTreeView.getSelectionModel().getSelectedIndex()) {
            case 2: border.setCenter(FXMLLoader.load(getClass().getResource("propertypane/mainwall/FXMLPropertyPane.fxml")));
                    break;
            case 3: border.setCenter(FXMLLoader.load(getClass().getResource("propertypane/innerinsulatewall/InnerInsulateWallPropertyPane.fxml")));
                    
            System.out.println("case 3");
                    break;
            case 4: border.setCenter(FXMLLoader.load(getClass().getResource("visualredactor/visualredactor.fxml")));
                    break;
                    
                               

        }
        
    }
}