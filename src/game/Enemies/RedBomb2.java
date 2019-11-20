package game.Enemies;

import city.cs.engine.*;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.IOException;


/**
 * @author Muhammad Islam
 * This is the redbomb2 class which moves left and right by itself. This one appears in level 3
 */
public class RedBomb2 extends Walker {

    /**
     * this the shape of the redbomb
     */
    private static final Shape bombShape2 = new PolygonShape(
            -0.676f,0.9f, -1.081f,0.14f, -0.789f,-0.882f, -0.442f,-1.071f, 0.291f,-1.093f, 0.908f,-0.396f, 0.741f,0.801f, -0.033f,0.963f);


    /**
     * sound clip field
     */
    private static SoundClip negativeSound;

    /**
     * the sound clip will be initialised when mario touches the red bomb
     */
    static {
        try {
            negativeSound = new SoundClip("src/game/mcdamage.wav");

        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            System.out.println(e);
        }
    }

    /**
     * sound clip will be destroyed after initialisation
     */
    @Override
    public void destroy()
    {
        negativeSound.play();
        super.destroy();
    }

    /**
     * this is the starting x position on the specific level
     */
    private float startXPos2 = -22f;
    private float xPos2;
    private int enemyDirection2 = 1;

    /**
     * image of the bomb
     */
    private static final BodyImage bomb2 =
            new BodyImage("data/redbomb2.png", 2f);


    /**
     * RedBomb2 uses the world
     * @param world the world RedBomb2 is in
     */
    public RedBomb2(World world) {
        super(world, bombShape2);
        addImage(bomb2);
    }

    /**
     * this gets the x position of red bomb
     */
    public float getxPos2() {
        xPos2 = getPosition().x;
        return xPos2;

    }

    /**
     * This sets the x position of the red bomb
     * @param xPos2 x position
     */
    public void setxPos2(float xPos2) {
        this.xPos2 = xPos2;
    }

    public float getStartXPos2() {

        return startXPos2;
    }

    /**
     * Sets the starting x position based on the field above
     * @param startXPos2 starting x position
     */
    public void setStartXPos2(float startXPos2) {
        this.startXPos2 = startXPos2;
    }

    /**
     * Gets the enemy direction
     */
    public int getEnemyDirection2() {
        return enemyDirection2;
    }

    /**
     * Sets the enemy direction
     */
    public void setEnemyDirection2(int enemyDirection2) {
        this.enemyDirection2 = enemyDirection2;
    }
}
