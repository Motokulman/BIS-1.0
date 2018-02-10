/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package estimatecalculator.scheme;

import estimatecalculator.scheme.primitives.Axis;
import estimatecalculator.scheme.primitives.Couple;
import estimatecalculator.scheme.primitives.Curve;
import estimatecalculator.scheme.primitives.Point;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author I
 */
public class Scheme {
    Axis axisX = new Axis();
    Axis axisY = new Axis();
    List<Point> points = new ArrayList<>();
    List<Couple> couples = new ArrayList<>();
    List<Curve> curves = new ArrayList<>();

    public Scheme() {
    }

    
    
}
