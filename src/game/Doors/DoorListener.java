package game.Doors;

import city.cs.engine.*;
import game.Game;
import game.Mario;

/**
 * @author Muhammad Islam
 * Listener for collision with a door.  When the player collides with a door,
 * if the current level is complete the game is advanced to the next level. 
 */
public class DoorListener implements CollisionListener {

    /**
     * the game class
     */
    private Game game;

    /**
     * Initialise a new door listener
     * @param game Uses the game
     */
    public DoorListener(Game game) {
        this.game = game;
    }

    /**
     * This is the collision for the door. if collided with the character, it goes to the next level
     * @param e a collision event generated when the door collides with other bodies
     */
    @Override
    public void collide(CollisionEvent e) {
        Mario mario = game.getPlayer();
        if (e.getOtherBody() == mario && game.isCurrentLevelCompleted()) {
            System.out.println("You have completed this level! Going to next level...");
            game.goNextLevel();

        }
    }
    }
