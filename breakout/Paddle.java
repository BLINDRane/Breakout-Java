/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package breakout;
import acm.graphics.GRect;
/**
 *
 * @author Adrian Sanchez
 */
public class Paddle extends GRect {
    
    public Paddle(double x ,double y , double width, double height){
        super(x,y,width,height);
        setFilled(true);
    }
    
}
