/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package estimatecalculator.scheme;

import estimatecalculator.scheme.primitives.Couple;
import estimatecalculator.scheme.primitives.Point;
import java.io.Serializable;
import javafx.collections.ObservableList;

/**
 *
 * @author I
 */
public class Scheme implements Serializable{
    
    public ObservableList<Point> p; // массив точек
    public ObservableList<Couple> c; // массив Линий
    public ObservableList<Integer> axisX; // массив относительных расстояний по оси Х
    public ObservableList<Integer> axisY;
    
    
//    Axis axisX = new Axis();
//    Axis axisY = new Axis();
//    List<Point> points = new ArrayList<>();
//    List<Couple> couples = new ArrayList<>();
//    List<Curve> curves = new ArrayList<>();

    public Scheme(ObservableList<Point> pOL, ObservableList<Couple> cOL, ObservableList<Integer> aX, ObservableList<Integer> aY) {
        this.p = pOL;
        this.c = cOL;
        this.axisX = aX;
        this.axisY = aY;
        
    }    
    
    public Scheme() {
    }
    
    public ObservableList<Point> getP() {
        return p;
    }

    public ObservableList<Couple> getC() {
        return c;
    }

    public ObservableList<Integer> getAxisX() {
        return axisX;
    }

    public ObservableList<Integer> getAxisY() {
        return axisY;
    }
    
    
}
