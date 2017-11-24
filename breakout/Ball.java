/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package breakout;
import acm.graphics.GOval;
import acm.graphics.GCanvas;

/**
 *
 * @author Adrian Sanchez
 */
public class Ball extends GOval {

    private double deltaX = 5;
    private double deltaY = -5;
    private GCanvas screen;

     public Ball(double size, GCanvas screen) {
        this(100.0, 100.0 ,size, screen);
    }

    public Ball(double x, double y, double size ,GCanvas screen) {
        super(x, y, size, size);
        setFilled(true);
        this.screen = screen;
    }

    public void move() {
        move(deltaX, deltaY);
        if (getY() <= 0) {
            deltaY = Math.abs(deltaY);
        }
        if (getY() >= screen.getHeight()-getHeight()) {
            deltaY = -1 * Math.abs(deltaY);
        }
        if (getX()<=0){
            deltaX = Math.abs(deltaX);
    }
        if (getX()>=(screen.getWidth()-getWidth())){
            deltaX = -1*Math.abs(deltaX);
        }

}

    
    
    
    
}
