package game.Enemies;

import city.cs.engine.*;


/**
 * @author Muhammad Islam
 * This is the class for the Red Bomb. This class allows the walker to move left and right by itself
 */
public class RedBombMovement implements StepListener {

    /**
     * This uses the redbomb class
     */
    private RedBomb redbomb;


    /**
     * This links redbomb with the enemy class
     * @param redbomb The red bomb class
     */
    public RedBombMovement(RedBomb redbomb) {
        this.redbomb = redbomb;
    }

    @Override
    public void preStep(StepEvent e) {

    }


    @Override
    public void postStep(StepEvent e) {

        /**
         * this moves the character left
         */
        if (redbomb.getxPos() > redbomb.getStartXPos()+3) {
            redbomb.setEnemyDirection(-1);
        }

        /**
         * this moves the character right
         */
        if (redbomb.getxPos() < redbomb.getStartXPos()-3) {
            redbomb.setEnemyDirection(1);

        }
        /**
         * this gets the x position of the bomb
         */
        redbomb.getxPos();
        /**
         * this is where it starts moving. the speed is set to "3"
         */
        redbomb.startWalking(3*redbomb.getEnemyDirection());

    }


}
