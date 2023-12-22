/*
 * Hunter Broughton 
 * CS231A 
 * 3/1/2022
 * 
 * This is the AntiSocialAgent Class, which inherits from it's superclass - Agent
 * 
 * This class outlines the attributes and behaviors of an AntiSocialAgent, which is an Agent that 
 * prefers to not be in close proximity with other agents
 * 
 * to run the final LandscapeDisplay.java and/or SocialAgentSimulation.java files, please compile this file first
and ensure your files are in the same directory

how to compile:
javac AntiSocialAgent.java
 */

//import libraries
import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;


//create the AntiSocialAgent class, which inherits from the Agent Class
public class AntiSocialAgent extends Agent{

    //create the instance fields for the AntiSocialAgent class
    int radius;
    boolean moved;
    Random randomPicker;

    //Constructor for the AntiSocialAgent class
    public AntiSocialAgent(double x0, double y0, int radius){
        super(false, x0, y0);
        this.radius = radius;
        moved = false;
        randomPicker = new Random();
    }

    //set the radius of an AntiSocialAgent
    public void setRadius(int newRadius){
        this.radius = newRadius;
    }

    //get the radius of an AntiSocialAgent
    public int getRadius(){
        return this.radius;
    }

    //draw an Anti Social Agent, color = red
    public void draw(Graphics g){
        if(!moved) g.setColor(new Color(255, 0, 0));
        else g.setColor(new Color(255, 125, 125));
    
        g.fillOval((int) getX(), (int) getY(), 5, 5);
    }
    

    /*
     * 
    update the state of an antisocial agent based on it's surroundings 
    if there is a killerAgent in a radius proximity, then move that agent
    off the screeen 

    If there are 4 normal agents with a radius' distance, then move the agent in a random direction, 10 units away
    from it's original location

    otherwise, the AntiSocialAgent stays where it is
     */
    
    public void updateState(Landscape scape){
        if(scape.getKillerNeighbors(x, y, radius).size() > 1){
            System.out.println("killed");
            this.moved = true;

            //if their is a killer neighbor, the agent is moved off the screen of the dispaly, signifying it died
            this.x = x * 1000;
            this.y = y * 1000;
        }
        if (scape.getNeighbors(x, y, radius).size() > 1) {
            this.moved = true;
            if ((x - 10) <= 0) {
                this.x += randomPicker.nextDouble(-x, 10);
            } else if ((x + 10) >= scape.width) {
                this.x += randomPicker.nextDouble(-10, x);
            } else {
                this.x += randomPicker.nextInt(-10, 10);
            }
            if ((y - 10) <= 0) {
                this.y += randomPicker.nextDouble(-y, 10);
            } else if ((y + 10) >= scape.height) {
                this.y += randomPicker.nextDouble(-10, y);
            } else {
                this.y += randomPicker.nextInt(-10, 10);
            }
        } else {
            this.moved = false;
        }
    }
}
