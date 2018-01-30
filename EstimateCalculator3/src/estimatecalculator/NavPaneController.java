/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package estimatecalculator;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Control;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;

/**
 * FXML Controller class
 *
 * @author I
 */
public class NavPaneController implements Initializable {

  @FXML private TreeView<String> NavPaneTreeView;
 
//  // the initialize method is automatically invoked by the FXMLLoader - it's magic
//  public void initialize() {
//    loadTreeItems("initial 1", "initial 2", "initial 3");
//  }  
//
//  // loads some strings into the tree in the application UI.
//  public void loadTreeItems(String... rootItems) {
//    TreeItem<String> root = new TreeItem<String>("Root Node");
//    root.setExpanded(true);
//    for (String itemString: rootItems) {
//      root.getChildren().add(new TreeItem<String>(itemString));
//    }
//
//    navTreeView.setRoot(root);
//  }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        TreeItem<String> root = new TreeItem<>("Стены");
        root.setExpanded(true);
        root.getChildren().add(new TreeItem<>("Базовая стена"));
        NavPaneTreeView.setRoot(root);
        NavPaneTreeView.setPrefHeight(1000.0);
      //  NavPaneTreeView.setMaxHeight(Control.USE_PREF_SIZE);
    }
}