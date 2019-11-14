package PacmanSimulator ;

import pacmanchallenge.exception.PacmanException;

public class PacPosition {
    int x;
    int y;
    Direction direction;

    public PacPosition(PacPosition position) {
        this.x = position.getX();
        this.y = position.getY();
        this.direction = position.getDirection();
    }

    public PacPosition(int x, int y, Direction direction) {
        this.x = x;
        this.y = y;
        this.direction = direction;
    }

    public int getX() {
        return this.x;
    }

    public int getY() {
        return this.y;
    }

    public Direction getDirection() {
        return this.direction;
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }

    public void change(int x, int y) {
        this.x = this.x + x;
        this.y = this.y + y;
    }

    public PacPosition getNextPacPosition() throws PacmanException {
        if (this.direction == null)
            throw new PacmanException("Invalid robot direction");

        
        PacPosition newPacPosition = new PacPosition(this);
        switch (this.direction) {
            case NORTH:
                newPacPosition.change(0, 1);
                break;
            case EAST:
                newPacPosition.change(1, 0);
                break;
            case SOUTH:
                newPacPosition.change(0, -1);
                break;
            case WEST:
                newPacPosition.change(-1, 0);
                break;
        }
        return newPacPosition;
    }
}
