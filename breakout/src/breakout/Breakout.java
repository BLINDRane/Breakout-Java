/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package breakout;

import acm.graphics.GLabel;
import acm.graphics.GObject;
import acm.program.GraphicsProgram;
import java.awt.Color;
import java.awt.event.MouseEvent;
import svu.csc213.Dialog;

/**
 *
 * @author Wyatt, Adrian, Hannah, Patrick
 */
public class Breakout extends GraphicsProgram {

//    public static final int APPLICATION_WIDTH = 600;
//    public static final int APPLICATION_HEIGHT = 600;
    public int row;
    public int col;
    private Ball ball;
    private Paddle paddle;
    //array of colors so that there are 5 color options
    private Color[] rowColors = {Color.RED, Color.RED, Color.ORANGE, Color.ORANGE, Color.YELLOW, Color.YELLOW, Color.GREEN,
        Color.GREEN, Color.CYAN, Color.CYAN};
    private static final double SPACE = 5.0;
    private int lives = 3;
    private int score = 0;
    private GLabel scoreLabel = new GLabel ("Score: " + (score));
    private GLabel livesLabel = new GLabel ("Lives: " + (lives));
    public int numBricks;
    public int remainingBricks;

    @Override
    public void init() {
add(scoreLabel, 420,20);
add(livesLabel, 220,20);

//inits bricks, sets the amount across, leaves 10 units of space in between.        
        numBricks = (int) ((int) getWidth() / (Brick.WIDTH + SPACE));
        remainingBricks = (numBricks * 10);
        //draws rows up to 10
        for (row = 0; row < 10; ++row) {
            for (col = 0; col < numBricks; ++col) {
                Brick brick = new Brick(10 + col * (Brick.WIDTH + SPACE),
                        4 * Brick.HEIGHT + row * (Brick.HEIGHT + SPACE),
                        rowColors[row]);
                add(brick);

            }
        }

    }

    @Override
    public void run() {
        loser();       
    }

    public void rules() {
        actors();
        addMouseListeners();
        waitForClick();
        while (true) {
            ball.move();
            GObject obj = null;
            obj = this.getElementAt(ball.getX(), ball.getY());
            if (obj == null) {
                obj = this.getElementAt(ball.getX() + ball.getWidth(), ball.getY());
            } else if (obj == null) {
                obj = this.getElementAt(ball.getX() + ball.getWidth(), ball.getY() + ball.getHeight());
            } else if (obj == null) {
                obj = this.getElementAt(ball.getX(), ball.getY() + ball.getHeight());
            }
            if (obj != null) {
                if (obj instanceof Paddle) {
                    if (ball.getX() < (paddle.getX() + (paddle.getWidth() * 0.2))) {
                        ball.bounceleft();
                    } else if (ball.getX() < (paddle.getX() + (paddle.getWidth() * 0.8))) {
                        ball.bounceright();
                    } else {
                        ball.bounce();
                        continue;
                    }

                }
                if (obj instanceof Brick) {
                    this.remove(obj);
                    ball.bounce();
                    remainingBricks--;
                    score++;
                    scoreLabel.setLabel("Score: " + score);
                }
                if (remainingBricks == 0) {
                    Win();
                    break;
                }
            }
            if (ball.losscount >= 1) {
                loss();
                break;
            } else if (lives == 0) {
                loser();
                break;
            }
            pause(5);
        }
    }

    public void loser() {
        if(lives == 0){
        Dialog.showMessage("U Miss Free Trimes. U Suk");
//                    Dialog.getYesOrNo("Try Again?");
        System.exit(0);
        } else {
            rules();
        }
    }

    public void loss() {
        remove(ball);
        remove(paddle);
        lives--;
        livesLabel.setLabel("Lives: " + lives);
        if(lives == 2 || lives == 1){
            Dialog.showMessage("Whoops! Click on the Game to Reset");
            waitForClick();
            run();
        } if(lives == 0){
            loser();
        }
     
    }

    public void actors() {
        ball = new Ball(getWidth() / 2, 350, 10, this.getGCanvas());
        add(ball);
        paddle = new Paddle(230, 430, 50, 10);
        add(paddle);
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        if ((e.getX() < getWidth() - paddle.getWidth() / 2) && (e.getX() > paddle.getWidth() / 2)) {
            paddle.setLocation(e.getX() - paddle.getWidth() / 2, getHeight() - 60 - paddle.getHeight());
        }
    }

    public void Win() {
        Dialog.showMessage("You is Win");
        System.exit(0);
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        new Breakout().start();
    }

}
