package game;

import city.cs.engine.*;
import org.jbox2d.common.Vec2;

/**
 * @author Muhammad Islam
 * This is the class which allows mario to shoot balls of fire
 */
public class marioFire implements StepListener  {

    /**
     * The fireball field
     */
    private Fireball fireball;

    /**
     * The Mario field
     */
    private Mario mario;

    /**
     * This returns thefireball
     */
    public Fireball getFireball() { return fireball;}

    /**
     * marioFire uses the fireball class and the mario class
     * @param fireball the fireball that comes out of mario
     * @param mario the main character
     */
    public marioFire(Fireball fireball, Mario mario) {
        this.fireball = fireball;
        this.mario = mario;
    }

    @Override
    public void preStep(StepEvent e) {

    }

    @Override
    public void postStep(StepEvent e) {

        /**
         * if bowser is not firing, then set the position of the fireball to bowser
         */
        if(!mario.Firing) {

            fireball.setPosition(new Vec2(mario.getPosition().x, mario.getPosition().y));

        }

        /**
         * If the fireball reaches over a certain limit, the fireball will be destroyed.
         * this is so it won't endlessly be in the air
         */
        if (fireball.getDistanceTracker() == 50) {
            fireball.destroy();
            fireball.setInMotion(false);
            mario.setCanControlFire(true);
            fireball.setDistanceTracker(0);
            mario.setFiring(false);
        }

        /**
         * This was just a test to see if the fireballs worked
         */
        System.out.println("Fireball distance tracker = " + fireball.getDistanceTracker() + ", Mario can control fire? " +
                mario.canControlFire + " , Fireball in Motion? " + fireball.getInMotion());

    }
}
