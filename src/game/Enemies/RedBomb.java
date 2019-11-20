package game.Enemies;

import city.cs.engine.*;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.applet.Applet;
import java.applet.AudioClip;
import java.io.IOException;
import java.net.URL;


/**
 * @author Muhammad Islam
 * This is the redbomb class which moves left and right by itself
 */
public class RedBomb extends Walker {

    /**
     * The shape for the bomb
     */
    private static final Shape bombShape = new PolygonShape(
            -0.676f,0.9f, -1.081f,0.14f, -0.789f,-0.882f, -0.442f,-1.071f, 0.291f,-1.093f, 0.908f,-0.396f, 0.741f,0.801f, -0.033f,0.963f);

    /**
     * soundclip field
     */
    private static SoundClip negativeSound;

    /**
     * The sound clip will be initiated when Mario touches the red bomb
     */
    static {
        try {
            negativeSound = new SoundClip("src/game/mcdamage.wav");

        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            System.out.println(e);
        }
    }

    /**
     * The sound clip would be destroyed when initiated to prevent looping
     */
    @Override
    public void destroy()
    {
        negativeSound.play();
        super.destroy();
    }

    /**
     * integer count field
     */
    public int count;
    /**
     * starting x position for the specific level
     */
    private float startXPos = -18;
    private float xPos;
    private int enemyDirection = 1;


    /**
     * The image of the bomb
     */
    private static final BodyImage bomb =
            new BodyImage("data/redbomb.png", 2f);


    /**
     * The red bomb uses the world
     * @param world the world redbomb is in
     */
    public RedBomb(World world) {
        super(world, bombShape);
        addImage(bomb);
    }

    /**
     * This gets the x position of the red bomb
     */
    public float getxPos() {
        xPos = getPosition().x;
        return xPos;

    }

    /**
     * This sets the x position
     * @param xPos x position
     */
    public void setxPos(float xPos) {
        this.xPos = xPos;
    }

    /**
     * This gets the starting x position based on the field
     */
    public float getStartXPos() {

        return startXPos;
    }

    /**
     * This sets the x position
     * @param startXPos starting x pos
     */
    public void setStartXPos(float startXPos) {
        this.startXPos = startXPos;
    }


    /**
     * Gets the red bombs direction
     */
    public int getEnemyDirection() {
        return enemyDirection;
    }

    /**
     * Sets the enemy direction
     */
    public void setEnemyDirection(int enemyDirection) {
        this.enemyDirection = enemyDirection;
    }
}
