/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pacmanchallenge;

import pacmanchallenge.exception.PacmanException;
import PacmanSimulator.*;

public class PlayPacman {

    Board pacBoard;
    Pacman pacman;

    public PlayPacman(Board pacBoard, Pacman pacman) {
        this.pacBoard = pacBoard;
        this.pacman = pacman;
    }

    public boolean placePacman(PacPosition position) throws PacmanException {

        if (pacBoard == null)
            throw new PacmanException("Exception is: Invalid pacBoard object");

        if (position == null)
            throw new PacmanException("Exception is: Invalid position object");

        if (position.getDirection() == null)
            throw new PacmanException("Exception is: Invalid direction value");

        
        if (!pacBoard.isValidPosition(position))
            return false;

       
        pacman.setPacPosition(position);
        return true;
    }

    public String eval(String inputString) throws PacmanException {
        String[] args = inputString.split(" ");

        
        PacInstructions pacInstruct;
        try {
            pacInstruct = PacInstructions.valueOf(args[0]);
        } catch (IllegalArgumentException e) {
            throw new PacmanException("The command is invalid");
        }
        if (pacInstruct == PacInstructions.PLACE && args.length < 2) {
            throw new PacmanException("The command is invalid");
        }

        // validate PLACE params
        String[] params;
        int x = 0;
        int y = 0;
        Direction instructDirection = null;
        if (pacInstruct == PacInstructions.PLACE) {
            params = args[1].split(",");
            try {
                x = Integer.parseInt(params[0]);
                y = Integer.parseInt(params[1]);
                instructDirection = Direction.valueOf(params[2]);
            } catch (Exception e) {
                throw new PacmanException("The command is invalid");
            }
        }

        String output;

        switch (pacInstruct) {
            case PLACE:
                output = String.valueOf(placePacman(new PacPosition(x, y, instructDirection)));
                break;
            case MOVE:
                PacPosition newPosition = pacman.getPacPosition().getNextPacPosition();
                if (!pacBoard.isValidPosition(newPosition))
                    output = String.valueOf(false);
                else
                    output = String.valueOf(pacman.move(newPosition));
                break;
            case LEFT:
                output = String.valueOf(pacman.rotateLeft());
                break;
            case RIGHT:
                output = String.valueOf(pacman.rotateRight());
                break;
            case REPORT:
                output = report();
                break;
            default:
                throw new PacmanException("The command is invalid");
        }

        return output;
    }

    public String report() {
        if (pacman.getPacPosition() == null)
            return null;

        return pacman.getPacPosition().getX() + "," + pacman.getPacPosition().getY() + "," + pacman.getPacPosition().getDirection().toString();
    }
}
