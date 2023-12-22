/*Hunter Broughton
CS 231 A
3/1/2023


Agent.java class

This class is an abstract class, inheritend by more specified agents in the simulation

It provides attributes and methods to model the behavior of agents

to run the final LandscapeDisplay.java and/or SocialAgentSimulation.java files, please compile this file first
and ensure your files are in the same directory

how to compile:
javac Agent.java
 * 
 */

//import graphics library
import java.awt.Graphics;


//create Agent class
public abstract class Agent {

    //fields for the agent class

    //position x
    double x;

    //position y
    double y;

    //defines if the agent is a killer agent or not
    boolean killer;


    //agent constructor
    public Agent(boolean killerOrNaw, double x0, double y0){
        killer = killerOrNaw;
        x = x0;
        y = y0;
    }

    //gets the x position of the agent
    public double getX(){
        return x;
    }


    //gets the y position of the agent
    public double getY(){
        return y;
    }


    //sets the x position of the agent
    public void setX(double newX){
        x = newX;
    }


    //sets the y position of the agent
    public void setY(double newY){
        y = newY;
    }


    //sets the killer status of the agent
    public void setKiller(boolean kill){
        this.killer = kill;
    }


    //gets the killer status of the agent
    public boolean getKiller(){
        return this.killer;
    }


    //returns a string of position of the agent
    public String toString(){
        return "[ " + x + ", " + y + " ]";
    }


    //updateState- a method that will be implemented in classes that inherit the Agent class 
    public abstract void updateState(Landscape scape);


    //draw- a method that will be implemented in classes that inherit the Agent class 
    public abstract void draw(Graphics g);


    
}
