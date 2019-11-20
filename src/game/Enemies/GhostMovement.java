package game.Enemies;

import city.cs.engine.StepEvent;
import city.cs.engine.StepListener;


/**
 * @author Muhammad Islam
 * This is the class for the Ghost. This class allows the walker to move left and right by itself
 */
public class GhostMovement implements StepListener {

    /**
     * this uses the Ghost walker class
     */
    private Ghost ghost;

    /**
     * This links ghost with the enemy4 class
     * @param ghost The ghost class
     */
    public GhostMovement(Ghost ghost) {
        this.ghost = ghost;
    }

    @Override
    public void preStep(StepEvent e) {

    }

    @Override
    public void postStep(StepEvent e) {

        /**
         * this moves the ghost left
         */
        if (ghost.getxPos4() > ghost.getStartXPos4()+10) {
            ghost.setEnemyDirection4(-1);
            //changes the ghosts image direction to the left
            ghost.changeDirLeft();
        }

        /**
         * this moves the ghost right
         */
        if (ghost.getxPos4() < ghost.getStartXPos4()-10) {
            ghost.setEnemyDirection4(+1);
            //this moves the ghosts image direction to the right
            ghost.changeDirRight();

        }

        /**
         * This gets the x position of the ghost
         */
        ghost.getxPos4();
        /**
         * this allows the ghost to start moving. "3" is the speed
         */
        ghost.startWalking(3*ghost.getEnemyDirection4());

    }
}
