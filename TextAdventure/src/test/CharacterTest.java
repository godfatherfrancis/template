import main.java.com.highresfelix.textadventure.Enemy;
import main.java.com.highresfelix.textadventure.Player;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * created by @highresfelix on 9/3/19
 */

public class CharacterTest {

    @Test
    public void testBattle() throws Exception {
        Player player = new Player();
        player.name = "Test Player";
        Enemy enemy = new Enemy("Test Enemy", 5, 5);
        player.battle(enemy);
        assertTrue(player.health > 0);
        assertTrue(enemy.health <= 0);
    }
}
