package game;

import city.cs.engine.StepEvent;
import city.cs.engine.StepListener;
import game.Enemies.BossBowser;
import org.jbox2d.common.Vec2;


/**
 * @author Muhammad Islam
 * This is the class for the fire that comes out bowser when you click L
 */
public class bowserFire implements StepListener  {

    /**
     * Fireball2 field
     */
    private Fireball2 fireball2;

    /**
     * Bowser2 field
     */
    private BossBowser bowser2;

    /**
     * this gets the fireball2
     */
    public Fireball2 getFireball2() { return fireball2;}

    /**
     * bowserfire uses the fireball2 class and bowser2 clas
     */
    public bowserFire(Fireball2 fireball2, BossBowser bowser2) {
        this.fireball2 = fireball2;
        this.bowser2 = bowser2;
    }

    @Override
    public void preStep(StepEvent e) {

    }

    @Override
    public void postStep(StepEvent e) {

        /**
         * if bowser is not firing, then set the position of the fireball to bowser
         */
        if(!bowser2.Firing) {

            fireball2.setPosition(new Vec2(bowser2.getPosition().x, bowser2.getPosition().y));
        }


        /**
         * If the fireball reaches over a certain limit, the fireball will be destroyed.
         * this is so it won't endlessly be in the air
         */
        if (fireball2.getDistanceTracker() == 50) {
            fireball2.destroy();
            fireball2.setInMotion(false);
            bowser2.setCanControlFire(true);
            fireball2.setDistanceTracker(0);
            bowser2.setFiring(false);
        }

        /**
         * This was just a test to see if the fireballs worked
         */
        System.out.println("Fireball distance tracker = " + fireball2.getDistanceTracker() + ", Mario can control fire? " +
                bowser2.canControlFire + " , Fireball in Motion? " + fireball2.getInMotion());

    }
}
