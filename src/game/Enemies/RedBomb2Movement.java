package game.Enemies;


import city.cs.engine.StepEvent;
import city.cs.engine.StepListener;


/**
 * This is the class for the Red Bomb2. This class allows the walker to move left and right by itself
 */
public class RedBomb2Movement implements StepListener {

    /**
     * This uses the redbomb2 class
     */
    private RedBomb2 redbomb2;

    /**
     * This links redbomb with the enemy class
     * @param redbomb2 The red bomb class
     */
    public RedBomb2Movement(RedBomb2 redbomb2) {
        this.redbomb2 = redbomb2;
    }

    @Override
    public void preStep(StepEvent e) {

    }


    @Override
    public void postStep(StepEvent e) {

        /**
         * this moves the character left
         */
        if (redbomb2.getxPos2() > redbomb2.getStartXPos2()+1) {
            redbomb2.setEnemyDirection2(-1);
        }

        /**
         * this moves the character right
         */
        if (redbomb2.getxPos2() < redbomb2.getStartXPos2()-1) {
            redbomb2.setEnemyDirection2(1);

        }

        /**
         * this gets the x position of the bomb
         */
        redbomb2.getxPos2();

        /**
         * this is where it starts moving. the speed is set to "3"
         */
        redbomb2.startWalking(3*redbomb2.getEnemyDirection2());

    }


}
