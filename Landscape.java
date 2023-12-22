/*
 * Hunter Broughton
 * CS231A 
 * 3/1/2023
 * 
 * This is the Landscape class, which creates the Landscape that holds the agents and allows for
 * them to interact in their true intended nature 
 * 
 * to run the final LandscapeDisplay.java and/or SocialAgentSimulation.java files, please compile this file first
and ensure your files are in the same directory

how to compile:
javac Landscape.java
 */

//import libraries
import java.lang.Math;
import java.awt.Graphics;

//create the Landscape class
public class Landscape {

    //create instance fields -height and width
    int width; 
    int height;

    //create a linked list field to hold the agents
    LinkedList<Agent> agents;

    //Landscape constructor
    public Landscape(int w, int h){
        this.width = w;
        this.height = h;

        agents = new LinkedList<>();
    }

    //updaates the state and location of the agents
    public void updateAgents(){

        for (Agent myAgent : agents) {
            myAgent.updateState(this);
            
        }

    }

    //gets the height of the landscape
    public int getHeight(){
        return height;
    }

    //gets the width of the landscape
    public int getWidth(){
        return width;
    }

    //adds an agent to the landscape
    public void addAgent(Agent a){
        agents.add(a);
    }

    //returns a string representation of the landscape
    public String toString(){
        return "Size: " + agents.size();
    }

    //gets the neighboring agents (agents with a radius) for a specific agent
    public LinkedList<Agent> getNeighbors(double x0, double y0, double radius){
        LinkedList<Agent> agentNeighbors = new LinkedList<>();
        for (Agent myAgent : agents){
            if(myAgent.x == x0 && myAgent.y == y0){
                ;
            }
            else if(radius >= (Math.sqrt(Math.pow(myAgent.x - x0, 2) + Math.pow(myAgent.y - y0, 2)))){
                agentNeighbors.add(myAgent);
            }
        }
        return agentNeighbors;
    }

    //returns a linked list containing killer agents within a radius of a specified agent
    public LinkedList<Agent> getKillerNeighbors(double x0, double y0, double radius){
        LinkedList<Agent> killerNeighbors = new LinkedList<>();
        for(Agent myAgent : agents){
            if(myAgent.x == x0 && myAgent.y == y0){
                ;
            }
            else if(radius >= (Math.sqrt(Math.pow(myAgent.x - x0, 2) + Math.pow(myAgent.y - y0, 2)))){
                if(myAgent.getKiller() == true){
                    //System.out.println("killer");
                    killerNeighbors.add(myAgent);
                }
            }
        }
        //System.out.println(killerNeighbors.size());
        return killerNeighbors;
    }

    //draws the agents onto the landscape
    public void draw(Graphics g){
        for(Agent agent : agents){
            agent.draw(g);
        }
    }





}
