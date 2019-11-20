package game.Enemies;

import city.cs.engine.StepEvent;
import city.cs.engine.StepListener;


/**
 * @author Muhammad Islam
 * This is the class for Bowser. This class allows the walker to move left and right by itself
 */
public class BowserMovement implements StepListener {

    /**
     * This uses the Bowser walker class
     */
    private Bowser bowser;

    /**
     * This links bowser with the enemy6 class
     * @param bowser The bowser class
     */
    public BowserMovement(Bowser bowser) {
        this.bowser = bowser;
    }

    @Override
    public void preStep(StepEvent e) {

    }

    @Override
    public void postStep(StepEvent e) {

        /**
         * This moves Bowser towards the right direction in the bad level
         */
        if (bowser.getxPos6() < bowser.getStartXPos6()-20) {
            bowser.setEnemyDirection6(+5);

        }

        /**
         * This gets the x position of bowser
         */
        bowser.getxPos6();

        /**
         * This starts moving bowser. "3" is the speed of Bowser
         */
        bowser.startWalking(3*bowser.getEnemyDirection6());

    }
}
