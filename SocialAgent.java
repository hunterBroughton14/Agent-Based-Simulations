/*
 * Hunter Broughton 
 * CS231 
 * 3/1/2023
 * 
 * This is the class for a social agent 
 * 
 * this class inherits from it's super class, agent 
 * 
 * the social agent class implements the behaviors of a social agent through it's methods and instance fields
 * a social agent prefers to not be in close proximity with other agents in the simulation 
 * 
 * to run the final LandscapeDisplay.java and/or SocialAgentSimulation.java files, please compile this file first
and ensure your files are in the same directory

how to compile:
javac SocialAgent.java
 */

//import libraries
import java.util.Random;
import java.awt.Color;
import java.awt.Graphics;



//create the SocialAgent class, which inherits from the agent class
public class SocialAgent extends Agent{

    //instance fields of teh social agent class
    int radius;
    boolean moved;
    Random randomPicker;

    //constructor for social agent
    public SocialAgent(double x0, double y0, int radius){
        super(false, x0, y0);
        this.radius = radius;
        moved = false;
        randomPicker = new Random();
    }

    //sets the radius
    public void setRadius(int newRadius){
        this.radius = newRadius;
    }

    //gets the radius
    public int getRadius(){
        return this.radius;
    }

    //draws the social agent, color is blue
    public void draw(Graphics g){
        if(!moved) g.setColor(new Color(0, 0, 255));
        else g.setColor(new Color(125, 125, 255));
    
        g.fillOval((int) getX(), (int) getY(), 5, 5);
    }

    
    /*
     * updates the state and location of a Social Agent based on it's surroundings
     * If a killer agent is within a radius of a social agent, then that social agent is moved off the screen
     * since it is now dead 
     * 
     * if a social agent does not have an agent within a radius of it's location, it moves to a random location 10 units away
     * 
     * otherwise, it stays put in it's location
     */
    public void updateState(Landscape scape){
        if(scape.getKillerNeighbors(x, y, radius).size() > 1){
            System.out.println("killed");
            this.moved = true;

            //if their is a killer neighbor, the agent is moved off the screen of the dispaly, signifying it died
            this.x = x * 1000;
            this.y = y * 1000;
        }
        if(scape.getNeighbors(x, y, radius).size() < 4){
            this.moved = true;
            if((x-10) < 0){
                this.x += randomPicker.nextInt(0,10);
            }else if((x + 10) >= scape.width){
                this.x += randomPicker.nextInt(-10, 10);
            }else{
                this.x += randomPicker.nextInt(-10, 10);
            }
            if ((y - 10) < 0) {
                this.y += randomPicker.nextInt(0, 10);
            } else if ((y + 10) >= scape.height) {
                this.y += randomPicker.nextInt(-10, 0);
            } else {
                this.y += randomPicker.nextInt(-10, 10);
            }
        }else{
            this.moved = false;
        }
    }



}
