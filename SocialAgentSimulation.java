/*Hunter Broughton
 * CS231
 * 3/1/2023
 * 
 * This is the SocialAgentSimulation Class, which executes a simulation of our Agent Display
 * 
 * Compile the file as such:
 * javac SocialAgentSimulation.java
 * 
 * To run the file, ensure that you specify the width and height of the landscape in the command line
 * as well as the radius of the agents
 * 
 *example: java SocialAgentSimulation 500 500 50
 */


 //import random library
import java.util.Random;

//creates the SocialAgentSimulation class
public class SocialAgentSimulation{

    //main method
    public static void main(String[] args) throws InterruptedException{

        //if the command line doesn't have 3 arguments, tell the user how to use the file
        if(args.length != 3){
            System.out.println("Usage: java SocialAgentSimulation <width> <height> <radius>");
            System.exit(1);
        }

        //create a new landscape using the width and height from the command line
        Landscape myLandscape = new Landscape(Integer.parseInt(args[0]), Integer.parseInt(args[1]));
        LandscapeDisplay myDisplay = new LandscapeDisplay(myLandscape);
        Random var = new Random();

        //add in a random number of agents, at random locations on the landscape
        for(int i = 0; i < var.nextInt(500); i++){
            myLandscape.addAgent(new SocialAgent(var.nextDouble() * myLandscape.getWidth(), 
            var.nextDouble() * myLandscape.getHeight(),
            Integer.parseInt(args[2])));

            myLandscape.addAgent(new AntiSocialAgent(var.nextDouble() * myLandscape.getWidth(), 
            var.nextDouble() * myLandscape.getHeight(),
            Integer.parseInt(args[2])));
        }

        //creates a constant while loop that displays the simulation until the user wants to x out of the screen
        while (true) {
            Thread.sleep(10);
            myLandscape.updateAgents();
            myDisplay.repaint();
        }


    }


}
