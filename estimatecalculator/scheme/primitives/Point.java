/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package estimatecalculator.scheme.primitives;

import java.io.Serializable;

/**
 *
 * @author I
 */
public class Point  implements Serializable{
    private int X;
    private int Y;

    public Point(int i, int j) {
        this.X = i;
        this.Y = j;
    }

    public int getX() {
        return X;
    }

    public int getY() {
        return Y;
    }
 
}
