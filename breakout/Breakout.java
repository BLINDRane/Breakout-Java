/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package breakout;

import acm.program.GraphicsProgram;
import java.awt.event.MouseEvent;

/**
 *
 * @author Adrian 
 */
public class Breakout extends GraphicsProgram {

    private Ball ball;
    private Paddle paddle;
    

    @Override
    public void init(){
        ball = new Ball(10, this.getGCanvas());
        add(ball);
        paddle = new Paddle(230, 400, 50, 10);
        add(paddle);
        addMouseListeners();
    }
    
    @Override
    public void run(){
        while(true){
            ball.move();
            pause(30);
        }
    }
    
    @Override
    public void mouseMoved(MouseEvent e){
        paddle.setLocation(e.getX(), paddle.getY());
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        new Breakout().start();
    }
    
}