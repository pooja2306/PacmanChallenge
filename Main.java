/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pacmanchallenge;

import pacmanchallenge.exception.PacmanException;
import PacmanSimulator.PacmanBoard;
import PacmanSimulator.Pacman;
import java.io.Console;

public class Main {

    public static void main(String[] args) {

        Console console = System.console();

        if (console == null) {
            System.err.println("No console.");
            System.exit(1);
        }

        PacmanBoard pacmanBoard = new PacmanBoard(4, 4);
        Pacman pacman = new Pacman();
        PlayPacman play = new PlayPacman(pacmanBoard, pacman);

        System.out.println("Pacman Simulator");
        System.out.println("Enter a command where valid commands are as follows:");
        System.out.println("\'PLACE X,Y,NORTH|SOUTH|EAST|WEST\', MOVE, LEFT, RIGHT, REPORT or EXIT");

        boolean keepRunning = true;
        while (keepRunning) {
            String inputString = console.readLine(": ");
            if ("EXIT".equals(inputString)) {
                keepRunning = false;
            } else {
                try {
                    String outputVal = play.eval(inputString);
                    System.out.println(outputVal);
                } catch (PacmanException e) {
                    System.out.println(e.getMessage());
                }
            }
        }
    }
    
}
