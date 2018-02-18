/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package estimatecalculator.scheme;

import estimatecalculator.scheme.primitives.Couple;
import estimatecalculator.scheme.primitives.Point;
import java.io.Serializable;
import java.util.ArrayList;
import javafx.collections.ObservableList;

/**
 *
 * @author I
 */
public class Scheme implements Serializable{
    
    public ArrayList<Point> p; // массив точек
    public ArrayList<Couple> c; // массив Линий
    public ArrayList<Integer> axisX; // массив относительных расстояний по оси Х
    public ArrayList<Integer> axisY;
    
    
//    Axis axisX = new Axis();
//    Axis axisY = new Axis();
//    List<Point> points = new ArrayList<>();
//    List<Couple> couples = new ArrayList<>();
//    List<Curve> curves = new ArrayList<>();

    public Scheme(ArrayList<Point> pOL, ArrayList<Couple> cOL, ArrayList<Integer> aX, ArrayList<Integer> aY) {
        this.p = pOL;
        this.c = cOL;
        this.axisX = aX;
        this.axisY = aY;
        
    }      
    
  
    public Scheme() {
    }
    
    public ArrayList<Point> getP() {
        return p;
    }

    public ArrayList<Couple> getC() {
        return c;
    }

    public ArrayList<Integer> getAxisX() {
        return axisX;
    }

    public ArrayList<Integer> getAxisY() {
        return axisY;
    }
    
    
}
