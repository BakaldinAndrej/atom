import org.junit.Test;
import org.junit.Assert;

import static org.junit.Assert.*;

public class MainTest {

    @Test
    public void testBulls() {
        Game game = new Game(null);
        game.SetSecretWord("abbc");
        int result = game.calcBulls("xxba");
        Assert.assertEquals(1, result);

        result = game.calcBulls("abbc");
        Assert.assertEquals(4, result);

        result = game.calcBulls("bcca");
        Assert.assertEquals(0, result);
    }

    @Test
    public void testCows() {
        Game game = new Game(null);
        game.SetSecretWord("abbc");
        int result = game.calcCows("xxba");
        Assert.assertEquals(2, result);

        result = game.calcCows("abbc");
        Assert.assertEquals(4, result);

        result = game.calcCows("bcca");
        Assert.assertEquals(4, result);
    }
}