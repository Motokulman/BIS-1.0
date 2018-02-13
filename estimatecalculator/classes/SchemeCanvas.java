/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package estimatecalculator.classes;

import static estimatecalculator.EstimateCalculator.couplesObservableList;
import static estimatecalculator.EstimateCalculator.pointsObservableList;
import estimatecalculator.scheme.primitives.Couple;
import estimatecalculator.scheme.primitives.Point;
import static estimatecalculator.visualredactor.CompoundVisualRedactor.whatDrawNow;
import javafx.event.EventHandler;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;

/**
 *
 * @author I
 */
public class SchemeCanvas extends Canvas{
    public static int schemeCountCellsX;
    public static int schemeCountCellsY;
    public static int padding;
    public static double schemeCanvasWidth;
    public static double schemeCanvasHeight;
    public static GraphicsContext graphicsContext;
    public static int[] schemeGridNodesCanvasCoordX;
    public static int[] schemeGridNodesCanvasCoordY;
    public static int hvostik = 3;
    private String numClickForWall = "First";// Флаг для определения, был ли клик при рисовании стены первым. По умолчанию он первый
    private int firstX = 999;
    private int firstY = 999;
    
    public SchemeCanvas() { 
        this.setWidth(600);
        this.setHeight(600);
        this.schemeCountCellsX = 14;
        this.schemeCountCellsY = 14;
        this.padding = 20;
        this.schemeCanvasWidth = this.getWidth();
        this.schemeCanvasHeight = this.getHeight();
        graphicsContext = this.getGraphicsContext2D();
        schemeGridNodesCanvasCoordX = coordinateGridNodesX();
        schemeGridNodesCanvasCoordY = coordinateGridNodesY();
        clearSchemeCanvas();
        manualDrawPointAndLines();
        autoDrawPointAndLines();
    }
    
        public static void clearSchemeCanvas() { //(GraphicsContext gc, Canvas canvas, int schemeCountCellsX, int schemeCountCellsY, paddingScheme) {
            graphicsContext.setFill(Color.WHITE);
            graphicsContext.setLineWidth(1.0);
            graphicsContext.fillRect(0, 0, schemeCanvasWidth, schemeCanvasHeight);
            graphicsContext.beginPath();
            graphicsContext.setStroke(Color.GRAY);   
            graphicsContext.setLineDashes(3, 3); // gc.setLineDashes(4, 4, 10, 4); - рисует ось симметрии
            for (int i = 0; i < schemeCountCellsX + 1; i++) {
                graphicsContext.strokeLine(schemeGridNodesCanvasCoordX[i] + 0.5, padding - hvostik + 0.5, schemeGridNodesCanvasCoordX[i] + 0.5, schemeCanvasHeight - padding + hvostik + 0.5);
            }            
            for (int i = 0; i < schemeCountCellsY + 1; i++) {
                graphicsContext.strokeLine(padding - hvostik + 0.5, schemeGridNodesCanvasCoordY[i] + 0.5, schemeCanvasWidth - padding + hvostik + 0.5, schemeGridNodesCanvasCoordY[i] + 0.5);
            }
}
        
        public static int[] coordinateGridNodesX() {
        int[] koord = new int[schemeCountCellsX + 1];
            for (int i = 0; i < schemeCountCellsX + 1; i++) {
                koord[i] = (int)(padding + i*(schemeCanvasWidth - 2*padding)/schemeCountCellsX);
            }   
        return koord;
    }
        public static int[] coordinateGridNodesY() {
        int[] koord = new int[schemeCountCellsY + 1];
            for (int i = 0; i < schemeCountCellsY + 1; i++) {
                koord[i] = (int)(schemeCanvasHeight - padding - i*(schemeCanvasHeight - 2*padding)/schemeCountCellsY);
            }   
        return koord;
    }
        
    private void manualDrawPointAndLines(){
        graphicsContext.setFill(Color.BLACK);
        this.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent e) {
               
                switch (whatDrawNow) {
                    case "Point": {// Если выбрана точка
                    // Ищем по координатам пересечений линий на канве возле какого узла мы кликнули
                    for (int i = 0; i < schemeCountCellsX + 1; i++) {
                        // Нашли по X:
                        if ((schemeGridNodesCanvasCoordX[i] - 7 < e.getX()) && (e.getX() < schemeGridNodesCanvasCoordX[i] + 7)) {
                            for (int j = 0; j < schemeCountCellsY + 1; j++) {
                                // Нашли по Y:
                                if ((schemeGridNodesCanvasCoordY[j] - 7 < e.getY()) && (e.getY() < schemeGridNodesCanvasCoordY[j] + 7)) {
                                    boolean exist = false; // Теперт надо проверить, нет ли уже такой точки, иначе они будут плодиться                                   
                                    for (int k = 0; k < pointsObservableList.size(); k++) { // Перебираем по всему массиву точек
                                        if (pointsObservableList.get(k).getX() == i && pointsObservableList.get(k).getY() == j) { // если нашли точку с такими X и Y
                                //           System.out.println("exist = true");
                                           exist = true;
                                           break;
                                        }
                                    }    
                                    // а если ее еще нет, добавляем
                                    if (!exist) {
                                        graphicsContext.fillOval(schemeGridNodesCanvasCoordX[i] - 7, schemeGridNodesCanvasCoordY[j] - 7, 14, 14); // рисуем на канве
                                        pointsObservableList.add(new Point(i, j));// добавляем в массив
                               //         System.out.println("Add new");
                                    }
                                    // если же точек вообще нет, то размер масиива = 0 и в цикл поиска не зайдем, надо добавить принудительно:
                                    if (pointsObservableList.size() == 0) { 
                                            pointsObservableList.add(new Point(i, j));
                                    //        System.out.println("add first");
                                    }
                               //  System.out.println("Size в конце= " + pointsObservableList.size());   
                                } 
                            }
                        }
                    }
                    break;
                }
                    case "Wall": {
                        switch (numClickForWall) {
                            case "First": {
                            System.out.println("зашли в первый клик");
                            numClickForWall = "Second"; // понятно, что следующий клик будет уже не первый
                            // Ищем по координатам пересечений линий на канве возле какого узла мы кликнули
                            for (int i = 0; i < schemeCountCellsX + 1; i++) {
                                // Нашли по X:
                                if ((schemeGridNodesCanvasCoordX[i] - 7 < e.getX()) && (e.getX() < schemeGridNodesCanvasCoordX[i] + 7)) {
                                    for (int j = 0; j < schemeCountCellsY + 1; j++) {
                                        // Нашли по Y:
                                        if ((schemeGridNodesCanvasCoordY[j] - 7 < e.getY()) && (e.getY() < schemeGridNodesCanvasCoordY[j] + 7)) {
                                            // Рисуем точку. Пока мы не знаем, куда будет второй клик, поэтому проверять не имеет смысла
                                            graphicsContext.fillOval(schemeGridNodesCanvasCoordX[i] - 7, schemeGridNodesCanvasCoordY[j] - 7, 14, 14);
                                            // Сохраняем эти координаты как временные, так как это лищь первая точка:
                                            firstX = i;// это уже координаты для массива стен, а не для рисования на канве
                                            firstY = j;
                                        } 
                                    }
                                }
                            }
                        break;// иначе залетим в елсе, так как флаг что клик первый теперь ложь
                        }
                        case "Second": { // если клик второй, то
                            System.out.println("зашли во второй клик");
                            numClickForWall = "First"; // понятно, что следующий клик будет уже снова первый
                            // Ищем по координатам пересечений линий на канве возле какого узла мы кликнули
                            for (int i = 0; i < schemeCountCellsX + 1; i++) {
                                // Нашли по X:
                                if ((schemeGridNodesCanvasCoordX[i] - 7 < e.getX()) && (e.getX() < schemeGridNodesCanvasCoordX[i] + 7)) {
                                    for (int j = 0; j < schemeCountCellsY + 1; j++) {
                                        // Нашли по Y:
                                        if ((schemeGridNodesCanvasCoordY[j] - 7 < e.getY()) && (e.getY() < schemeGridNodesCanvasCoordY[j] + 7)) {
                                             // Теперт надо проверить, нет ли уже такой линии, иначе они будут плодиться 
                                            boolean exist = false;          
                                            // Перебираем по всему массиву пар точек
                                            for (int k = 0; k < couplesObservableList.size(); k++) { 
                                                // Проблема в том, что соединение состоит из 2-х точек, и надо проверить оба направления
                                                if ((couplesObservableList.get(k).getX2() == i && couplesObservableList.get(k).getY2() == j && 
                                                        couplesObservableList.get(k).getX1() == firstX && couplesObservableList.get(k).getY1() == firstY) ||
                                                        (couplesObservableList.get(k).getX1() == i && couplesObservableList.get(k).getY1() == j && 
                                                        couplesObservableList.get(k).getX2() == firstX && couplesObservableList.get(k).getY2() == firstY)) {
                                                    // если нашли точку с такими X и Y
                                                   System.out.println("couples exist = true");
                                                   exist = true;
                                                   break;
                                                }
                                            }    
                                            // а если ее еще нет, добавляем
                                            if (!exist) {
                                                graphicsContext.fillOval(schemeGridNodesCanvasCoordX[i] - 7, schemeGridNodesCanvasCoordY[j] - 7, 14, 14); // рисуем на канве точку
                                                // рисуем соединяющую линию:
                                                graphicsContext.setStroke(Color.BLACK); 
                                                graphicsContext.setLineDashes(0);
                                                graphicsContext.setLineWidth(3.0);
                                                //graphicsContext.setLineDashes(3, 3); // gc.setLineDashes(4, 4, 10, 4); - рисует ось симметрии
                                                graphicsContext.strokeLine(schemeGridNodesCanvasCoordX[firstX] + 0.5, schemeGridNodesCanvasCoordY[firstY] + 0.5, schemeGridNodesCanvasCoordX[i] + 0.5, schemeGridNodesCanvasCoordY[j] + 0.5);
                                                
                                                // добавляем в массив
                                                couplesObservableList.add(new Couple(firstX, firstY, i, j));
                                                System.out.println("Add new Couple");
                                                System.out.println("X1 = " + firstX);
                                                System.out.println("Y1 = " + firstY);
                                                System.out.println("X2 = " + i);
                                                System.out.println("Y2 = " + j);
                                            }
                                            // если же линий вообще нет, то размер масиива = 0 и в цикл поиска не зайдем, надо добавить принудительно:
                                            if (couplesObservableList.size() == 0) { 
                                                    couplesObservableList.add(new Couple(firstX, firstY, i, j));
                                                    System.out.println("add couples first");
                                            }
                                         System.out.println("Size couples в конце= " + couplesObservableList.size());  
                                        } 
                                    }
                                }
                            }
                        }
                     }   
                    }    
                }
            }
        });
    }
    // Рисование схемы если у нас уже есть в памяти массивы. Например при переключении канвы
    private void autoDrawPointAndLines(){
        for (int k = 0; k < pointsObservableList.size(); k++) {
            graphicsContext.fillOval(schemeGridNodesCanvasCoordX[pointsObservableList.get(k).getX()] - 7, schemeGridNodesCanvasCoordY[pointsObservableList.get(k).getY()] - 7, 14, 14); // рисуем на канве
        }
        for (int k = 0; k < couplesObservableList.size(); k++) {
            graphicsContext.fillOval(schemeGridNodesCanvasCoordX[couplesObservableList.get(k).getX1()] - 7, schemeGridNodesCanvasCoordY[couplesObservableList.get(k).getY1()] - 7, 14, 14); // рисуем на канве точку
            graphicsContext.fillOval(schemeGridNodesCanvasCoordX[couplesObservableList.get(k).getX2()] - 7, schemeGridNodesCanvasCoordY[couplesObservableList.get(k).getY2()] - 7, 14, 14); // рисуем на канве точку
            // рисуем соединяющую линию:
            graphicsContext.setStroke(Color.BLACK); 
            graphicsContext.setLineDashes(0);
            graphicsContext.setLineWidth(3.0);
            graphicsContext.strokeLine(schemeGridNodesCanvasCoordX[couplesObservableList.get(k).getX1()] + 0.5, schemeGridNodesCanvasCoordY[couplesObservableList.get(k).getY1()] + 0.5, schemeGridNodesCanvasCoordX[couplesObservableList.get(k).getX2()] + 0.5, schemeGridNodesCanvasCoordY[couplesObservableList.get(k).getY2()] + 0.5);
        }
    }
    
}