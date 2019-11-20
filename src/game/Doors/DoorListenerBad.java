package game.Doors;

import city.cs.engine.CollisionEvent;
import city.cs.engine.CollisionListener;
import game.Game;
import game.Mario;

/**
 * @author Muhammad Islam
 * Listener for collision with DoorBad.  When the player collides with a door,
 */
public class DoorListenerBad implements CollisionListener {

    /**
     * uses the game class
     */
    private Game game;

    /**
     * Initialise the bad door
     * @param game The game class
     */
    public DoorListenerBad(Game game) {
        this.game = game;
    }

    /**
     * collision event for the bad door which leads to the bad level
     * @param e a collision event generated when the door collides with other bodies
     */
    @Override
    public void collide(CollisionEvent e) {
        Mario mario = game.getPlayer();
        if (e.getOtherBody() == mario) {
            System.out.println("You have completed this level! Going to next level...");
            game.setLevelNo(4);
            game.goNextLevel();
            System.out.println("hit");
        }
    }
    }
