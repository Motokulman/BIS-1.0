/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package estimatecalculator.classes;

import static estimatecalculator.visualredactor.CompoundVisualRedactor.pointSelected;
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
    public static double Width;
    public static double Height;
    public static GraphicsContext graphicsContext;
    public static int[] coordX;
    public static int[] coordY;
    public static int hvostik = 3;
    
    public SchemeCanvas() { 
        this.setWidth(600);
        this.setHeight(600);
        this.schemeCountCellsX = 14;
        this.schemeCountCellsY = 14;
        this.padding = 20;
        this.Width = this.getWidth();
        this.Height = this.getHeight();
        graphicsContext = this.getGraphicsContext2D();
        coordX = coordinateGridNodesX();
        coordY = coordinateGridNodesY();
        clearSchemeCanvas();
        drawPoint();
    }
    
        private static void clearSchemeCanvas() { //(GraphicsContext gc, Canvas canvas, int schemeCountCellsX, int schemeCountCellsY, paddingScheme) {
            graphicsContext.setFill(Color.WHITE);
            graphicsContext.setLineWidth(1.0);
            graphicsContext.fillRect(0, 0, Width, Height);
            graphicsContext.beginPath();
            graphicsContext.setStroke(Color.GRAY);   
            graphicsContext.setLineDashes(3, 3); // gc.setLineDashes(4, 4, 10, 4); - рисует ось симметрии
            for (int i = 0; i < schemeCountCellsX + 1; i++) {
                graphicsContext.moveTo(coordX[i] + 0.5, padding - hvostik + 0.5);
                graphicsContext.lineTo(coordX[i] + 0.5, Height - padding + hvostik + 0.5);
            }            
            for (int i = 0; i < schemeCountCellsY + 1; i++) {
                graphicsContext.moveTo(padding - hvostik + 0.5, coordY[i] + 0.5);
                graphicsContext.lineTo(Width - padding + hvostik + 0.5, coordY[i] + 0.5);
            }
            graphicsContext.stroke();
}
        
        public static int[] coordinateGridNodesX() {
        int[] koord = new int[schemeCountCellsX + 1];
            for (int i = 0; i < schemeCountCellsX + 1; i++) {
                koord[i] = (int)(padding + i*(Width - 2*padding)/schemeCountCellsX);
            }   
        return koord;
    }
        public static int[] coordinateGridNodesY() {
        int[] koord = new int[schemeCountCellsY + 1];
            for (int i = 0; i < schemeCountCellsY + 1; i++) {
                koord[i] = (int)(padding + i*(Height - 2*padding)/schemeCountCellsY);
            }   
        return koord;
    }
        
    private void drawPoint(){
        graphicsContext.setFill(Color.BLACK);
        this.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent e) {
                if (pointSelected == true) {
                    for (int i = 0; i < schemeCountCellsX + 1; i++) {
                        if ((coordX[i] - 7 < e.getX()) && (e.getX() < coordX[i] + 7)) {
                            for (int j = 0; j < schemeCountCellsY + 1; j++) {
                                if ((coordY[j] - 7 < e.getY()) && (e.getY() < coordY[j] + 7)) {
                                    graphicsContext.fillOval(coordX[i] - 7, coordY[j] - 7, 14, 14); 
                                } 
                            }
                        }
                    }
                }
            }
        });
    }
}