package game.Enemies;

import city.cs.engine.*;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.IOException;


/**
 * @author Muhammad Islam
 * This is the class for the Goomba walker.
 */
public class Goomba extends Walker {

    /**
     * This is the shape of the goomba
     */
    private static final Shape goombaShape = new PolygonShape(
            -0.333f,1.089f, -1.116f,0.149f, -0.774f,-1.102f, 0.653f,-1.098f, 1.085f,0.135f);


    /**
     * This is the sound clip field
     */
    private static SoundClip negativeSound;

    /**
     * This is the sound clip for when the walker touches a goomba
     */
    static {
        try {
            negativeSound = new SoundClip("src/game/mcdamage.wav");

        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            System.out.println(e);
        }
    }

    /**
     * The sound clip stops when it's initiated
     */
    @Override
    public void destroy()
    {
        negativeSound.play();
        super.destroy();
    }

    /**
     * This is the starting x position of the goomba on the level
     */
    private float startXPos5 =7.95f;
    private float xPos5;
    private int enemyDirection5 = 1;

    /**
     * This is the image of the goomba
     */
    private static final BodyImage goomba =
            new BodyImage("data/goomba.gif", 2f);

    /**
     * Goomba method using the world
     * @param world the world
     */
    public Goomba(World world) {
        super(world, goombaShape);
        addImage(goomba);
    }

    /**
     * This gets the x position of the goomba
     */
    public float getxPos5() {
        xPos5 = getPosition().x;
        return xPos5;

    }

    /**
     * This sets the x position of the goomba
     */
    public void setxPos5(float xPos5) {
        this.xPos5 = xPos5;
    }

    /**
     * This gets the starting x position of the goomba
     */
    public float getStartXPos5() {

        return startXPos5;
    }

    /**
     * This sets the starting x position of the goomba
     */
    public void setStartXPos5(float startXPos5) {
        this.startXPos5 = startXPos5;
    }

    /**
     * This gets the enemy direction
     */
    public int getEnemyDirection5() {
        return enemyDirection5;
    }

    /**
     * This sets the enemy direction
     * @param enemyDirection5 enemy direction of the goomba
     */
    public void setEnemyDirection5(int enemyDirection5) {
        this.enemyDirection5 = enemyDirection5;
    }
}


