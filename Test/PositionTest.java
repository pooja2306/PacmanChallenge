import PacmanSimulator.Direction;
import PacmanSimulator.PacPosition;
import org.junit.Assert;
import org.junit.Test;

public class PacPositionTest {

    @Test
    public void testGetNextPacPosition() throws Exception {
        PacPosition position = new PacPosition(0, 0, Direction.EAST);

        PacPosition newPacPosition = position.getNextPacPosition();
        Assert.assertEquals(newPacPosition.getX(), 1);
        Assert.assertEquals(newPacPosition.getY(), 0);
        Assert.assertEquals(newPacPosition.getDirection(), Direction.EAST);

        newPacPosition = newPacPosition.getNextPacPosition();
        Assert.assertNotEquals(newPacPosition.getX(), 1);
        Assert.assertEquals(newPacPosition.getY(), 0);
        Assert.assertEquals(newPacPosition.getDirection(), Direction.EAST);

        newPacPosition.setDirection(Direction.NORTH);
        newPacPosition = newPacPosition.getNextPacPosition();
        Assert.assertNotEquals(newPacPosition.getX(), 1);
        Assert.assertEquals(newPacPosition.getY(), 1);
        Assert.assertNotEquals(newPacPosition.getDirection(), Direction.EAST);

    }
}