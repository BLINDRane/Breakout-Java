/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package breakout;
import acm.graphics.*;
import java.awt.Color;
       
/**
 *
 * @author Wyatt
 */
public class Brick extends GRect{
    public static final int WIDTH = 44;
    public static final int HEIGHT = 20;
   
    public Brick(double x, double y, Color color){
        super(x,y, WIDTH, HEIGHT);
        this.setFillColor(color);
        this.setFilled(true);
    }
}
