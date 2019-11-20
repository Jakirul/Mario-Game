package game.Enemies;

import city.cs.engine.StepEvent;
import city.cs.engine.StepListener;


/**
 * @author Muhammad Islam
 * This is the class for the Spider. This class allows the walker to move left and right by itself
 */
public class SpiderMovement implements StepListener {

    /**
     * This uses the Spider class
     */
    private Spider spider;

    /**
     * This links spider with the enemy3 class
     * @param spider The spider class
     */
    public SpiderMovement(Spider spider) {
        this.spider = spider;
    }

    @Override
    public void preStep(StepEvent e) {

    }

    @Override
    public void postStep(StepEvent e) {

        /**
         * This moves the spider left
         */
        if (spider.getxPos3() > spider.getStartXPos3()+2.5) {
            spider.setEnemyDirection3(-1);
        }

        /**
         * This moves the spider right
         */
        if (spider.getxPos3() < spider.getStartXPos3()-2.5) {
            spider.setEnemyDirection3(+1);

        }

        /**
         * this gets the x position of the spider
         */
        spider.getxPos3();
        /**
         * this allows the spider to start moving. "3" is the speed
         */
        spider.startWalking(3*spider.getEnemyDirection3());

    }
}
