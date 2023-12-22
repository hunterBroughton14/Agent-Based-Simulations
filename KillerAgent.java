/*Hunter Broughton 
 * CS231A
 * 3/1/2023
 * 
 * This is the KillerAgent class which models a kiler Agent in our simualtion
 * 
 * The killer agent stays put and cannot move, however, if any agent, social or anti social, encounters 
 * a killer agent within it's radius, then that agent dies and moves off the screen. 
 * 
 * This class inherits from it's superclass - Agent
 * 
 * to run the final LandscapeDisplay.java and/or SocialAgentSimulation.java files, please compile this file first
and ensure your files are in the same directory

how to compile:
javac KillerAgent.java
 */

//import nessescary libraries
import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;


//creates the KillerAgent class, which inherits from Agent
public class KillerAgent extends Agent {
    //instance fields
    boolean killer;
    int radius;

    //KillerAgent Constructor
    public KillerAgent(double x0, double y0, int radius){
        super(true, x0, y0);
        this.radius = radius;
    }


    //sets the radius of the killer agent
    public void setRadius(int newRadius){
        this.radius = newRadius; 
    }

    //gets the radius of the killer agent 
    public int getRadius(){
        return this.radius;
    }

    //draws the killer agent, color is green 
    public void draw(Graphics g){
        g.setColor(new Color(0, 255, 0));
    
        g.fillOval((int) getX(), (int) getY(), 5, 5);
    }

    //inherits update state, but nothing is implemented in the move because the state of a killer agent cannot change
    public void updateState(Landscape scape){
        ;
    }
    
}
