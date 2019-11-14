package PacmanSimulator ;

public class PacmanBoard implements Board {

    int rows;
    int columns;

    public PacmanBoard(int rows, int columns) {
        this.rows = rows;
        this.columns = columns;
    }

    @Override
    public boolean isValidPosition(PacPosition position) {
        return !(
                position.getX() > this.columns || position.getX() < 0 ||
                        position.getY() > this.rows || position.getY() < 0
        );
    }
}
