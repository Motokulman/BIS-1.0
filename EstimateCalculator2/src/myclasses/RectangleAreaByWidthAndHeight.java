/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myclasses;

import javafx.beans.property.SimpleDoubleProperty;

/**
 *
 * @author I
 */
    public class RectangleAreaByWidthAndHeight {
 
        private final SimpleDoubleProperty Width;
        private final SimpleDoubleProperty Height;
        private final SimpleDoubleProperty Area;
 
        public RectangleAreaByWidthAndHeight(double W, double H) {
            this.Width = new SimpleDoubleProperty(W);
            this.Height = new SimpleDoubleProperty(H);
            this.Area = new SimpleDoubleProperty(W*H);
        }
 
        public double getWidth() {
            return Width.get();
        }
 
        public void setWidth(double W) {
            Width.set(W);
        }
 
        public double getHeight() {
            return Height.get();
        }
 
        public void setHeight(double H) {
            Height.set(H);
        }
 
        public double getArea() {
            return Area.get();
        }

    }
