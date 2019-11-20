package game.Enemies;

import city.cs.engine.StepEvent;
import city.cs.engine.StepListener;


/**
 * @author Muhammad Islam
 * This is the class for the Goomba. This class allows the walker to move left and right by itself
 */
public class GoombaMovement implements StepListener {

    /**
     * This uses the Goomba walker class
     */
    private Goomba goomba;

    /**
     * This links goomba with the enemy5 class
     * @param goomba The goomba class
     */
    public GoombaMovement(Goomba goomba) {
        this.goomba = goomba;
    }

    @Override
    public void preStep(StepEvent e) {

    }

    @Override
    public void postStep(StepEvent e) {

        /**
         * This moves the Goomba towards the left direction
         */
        if (goomba.getxPos5() > goomba.getStartXPos5()+2.5) {
            goomba.setEnemyDirection5(-1);
        }

        /**
         * This moves the Goomba towards the right direction
         */
        if (goomba.getxPos5() < goomba.getStartXPos5()-2.5) {
            goomba.setEnemyDirection5(+1);

        }

        /**
         * This gets the x position of the goomba
         */
        goomba.getxPos5();

        /**
         * This starts moving the Goomba. "3" is the speed of the goomba.
         */
        goomba.startWalking(3*goomba.getEnemyDirection5());

    }
}
