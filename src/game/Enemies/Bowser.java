package game.Enemies;

import city.cs.engine.*;
import game.Mario;

/**
 * @author Muhammad Islam
 * This is the class for the Bowser character which appears in the Bad Level
 */
public class Bowser extends Walker {

    /**
     * Uses the mario class
     */
    private Mario mario;

    /**
     * shape for bowser
     */
    private static final Shape shape = new PolygonShape(
            0.185f,1.107f, -1.084f,-0.184f, -1.066f,-1.107f, -0.157f,-1.116f, 0.927f,0.572f);

    /**
     * image of bowser
     */
    private static final BodyImage image =
            new BodyImage("data/bowser.png", 2.5f);

    /**
     * this is the X position of bowser when he first spawns into the level
     */
    private float startXPos6 = -30f;
    private float xPos6;
    private int enemyDirection6 = 1;

    /**
     * Initialise bowser
     * @param world The world.
     */
    public Bowser(World world) {
        super(world, shape);
        addImage(image);
    }

    /**
     * this gets xPos6 as the position for the x coordinate for when the character moves
     */
    public float getxPos6() {
        xPos6 = getPosition().x;
        return xPos6;

    }

    /**
     * this sets xPos6 as the position for the x coordinate for when the character moves
     */
    public void setxPos6(float xPos6) {
        this.xPos6 = xPos6;
    }


    /**
     * this gets the starting x position
     */
    public float getStartXPos6() {
        return startXPos6;
    }

    /**
     * this sets the starting x position
     */
    public void setStartXPos6(float startXPos6) {
        this.startXPos6 = startXPos6;
    }

    /**
     * this gets the direction of bowser
     */
    public int getEnemyDirection6() {
        return enemyDirection6;
    }

    /**
     * this sets the direction of bowser
     */
    public void setEnemyDirection6(int enemyDirection6) {
        this.enemyDirection6 = enemyDirection6;
    }
}
