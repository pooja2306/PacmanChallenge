import pacmanchallenge.exception.PacmanException;
import PacmanSimulator.Direction;
import PacmanSimulator.PacPosition;
import PacmanSimulator.Pacman;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class PacTest {

    @Rule
    public org.junit.rules.ExpectedException thrown = ExpectedException.none();

    @Test
    public void testMovement() throws PacmanException {

        Pacman pacman = new Pacman(new PacPosition(0, 0, Direction.NORTH));

        Assert.assertTrue(pacman.move());
        Assert.assertEquals(0, pacman.getPacPosition().getX());
        Assert.assertEquals(1, pacman.getPacPosition().getY());
        Assert.assertEquals(Direction.NORTH, pacman.getPacPosition().getDirection());


        pacman.setPacPosition(new PacPosition(1, 2, Direction.EAST));
        pacman.move();
        pacman.move();
        pacman.rotateLeft();
        pacman.move();

        Assert.assertEquals(3, pacman.getPacPosition().getX());
        Assert.assertEquals(3, pacman.getPacPosition().getY());
        Assert.assertEquals(Direction.NORTH, pacman.getPacPosition().getDirection());

        pacman.setPacPosition(new PacPosition(0, 0, Direction.NORTH));
        pacman.rotateRight();
        Assert.assertEquals(Direction.EAST, pacman.getPacPosition().getDirection());
        pacman.rotateRight();
        Assert.assertEquals(Direction.SOUTH, pacman.getPacPosition().getDirection());
        pacman.rotateRight();
        Assert.assertEquals(Direction.WEST, pacman.getPacPosition().getDirection());
        pacman.rotateRight();
        Assert.assertEquals(Direction.NORTH, pacman.getPacPosition().getDirection());
        pacman.rotateRight();
        Assert.assertEquals(Direction.EAST, pacman.getPacPosition().getDirection());
    }

}