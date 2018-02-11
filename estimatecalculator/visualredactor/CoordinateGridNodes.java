/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package estimatecalculator.visualredactor;

/**
 *
 * @author I
 */
public class CoordinateGridNodes {
    public static int[] coordinateGridNodes(double Width, int schemeCountCells, int padding) {
        int[] koord = new int[schemeCountCells + 1];
            for (int i = 0; i < schemeCountCells + 1; i++) {
                koord[i] = (int)(Width - padding - i*(Width - 2*padding)/schemeCountCells);
            }   
        return koord;
    }
}
