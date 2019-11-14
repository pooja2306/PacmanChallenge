package com.pooja.pac.PacmanSimulator;

import com.pooja.pac.exception.PacmanException;

public class Pacman {

    private PacPosition PacPosition;

    public PacPacPosition() {
    }

    public Pacman(PacPosition PacPosition) {
        this.PacPosition = PacPosition;
    }

    public boolean setPacPosition(PacPosition PacPosition) {
        if (PacPosition == null)
            return false;

        this.PacPosition = PacPosition;
        return true;
    }

    public boolean move() throws PacmanException {
        return move(PacPosition.getNextPacPosition());
    }

   
    public boolean move(PacPosition newPacPosition) {
        if (newPacPosition == null)
            return false;

        this.PacPosition = newPacPosition;
        return true;
    }

    public PacPosition getPacPosition() {
        return this.PacPosition;
    }
=
    public boolean rotateLeft() {
        if (this.PacPosition.direction == null)
            return false;

        this.PacPosition.direction = this.PacPosition.direction.leftDirection();
        return true;
    }


    public boolean rotateRight() {
        if (this.PacPosition.direction == null)
            return false;

        this.PacPosition.direction = this.PacPosition.direction.rightDirection();
        return true;
    }

}