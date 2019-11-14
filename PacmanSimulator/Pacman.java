package PacmanSimulator ;

import pacmanchallenge.exception.PacmanException;

public class Pacman {

    private PacPosition pacPosition;

    public Pacman() {
    }

    public Pacman(PacPosition pacPosition) {
        this.pacPosition = pacPosition;
    }

    public boolean setPacPosition(PacPosition pacPosition) {
        if (pacPosition == null)
            return false;

        this.pacPosition = pacPosition;
        return true;
    }

    public boolean move() throws PacmanException {
        return move(pacPosition.getNextPacPosition());
    }

   
    public boolean move(PacPosition newPacPosition) {
        if (newPacPosition == null)
            return false;

        this.pacPosition = newPacPosition;
        return true;
    }

    public PacPosition getPacPosition() {
        return this.pacPosition;
    }

    public boolean rotateLeft() {
        if (this.pacPosition.direction == null)
            return false;

        this.pacPosition.direction = this.pacPosition.direction.leftDirection();
        return true;
    }


    public boolean rotateRight() {
        if (this.pacPosition.direction == null)
            return false;

        this.pacPosition.direction = this.pacPosition.direction.rightDirection();
        return true;
    }

}
