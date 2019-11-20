package game.Pickups;

import city.cs.engine.CollisionEvent;
import city.cs.engine.CollisionListener;
import game.Enemies.RedBall10v4;
import game.Enemies.RedBomb;
import game.Enemies.RedBomb2;
import org.jbox2d.common.Vec2;

/**
 * @author Muhammad Islam
 * Collision listener that allows Mario to collect things.
 */
public class RedBomb2Pickup implements CollisionListener {

    /**
     * The mario field
     */
    private RedBomb2 mario;

    /**
     * Pickup uses the mario class
     * @param mario the character
     */
    public RedBomb2Pickup(RedBomb2 mario) {

        this.mario = mario;
    }

    /**
     * The pickups
     */
    @Override
    public void collide(CollisionEvent e) {


        //this is the pick up for the fire underneath the map. when touched, it will direct the user back to the original start position for the boss level
         if (e.getReportingBody() instanceof RedBall10v4 && e.getOtherBody() == mario) {
            mario.setPosition(new Vec2(20f, 85));
        }



    }

}