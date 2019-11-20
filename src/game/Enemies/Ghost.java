package game.Enemies;

import city.cs.engine.*;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.IOException;


/**
 * @author Muhammad Islam
 * This is the class for the Ghost walker.
 */
public class Ghost extends Walker {

    /**
     * This is the shape of the ghost
     */
    private static final Shape ghostShape = new PolygonShape(
            0.077f,0.936f, -1.098f,-0.441f, -1.053f,-1.062f, 0.387f,-1.116f, 1.071f,0.126f, 1.017f,1.013f, 0.477f,1.094f);


    /**
     * this is the starting x position when the ghost first spawns in
     */
    private float startXPos4 = -8f;
    private float xPos4;
    private int enemyDirection4 = 1;

    /**
     * The character is facing left is set to false
     */
    public boolean isFacingLeft = false;

    /**
     * This is the image of the ghost
     */
    private static final BodyImage ghost =
            new BodyImage("data/ghost.png", 2f);


    /**
     * This is the sound clip field for when mario touches the ghost
     */
    private static SoundClip negativeSound;

    /**
     * This is the sound clip for when mario touches the ghost
     */
    static {
        try {
            negativeSound = new SoundClip("src/game/mcdamage.wav");
          
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            System.out.println(e);
        }
    }

    /**
     * this gets the isFacingLeft field
     */
    public boolean getIsFacingLeft() {
        return isFacingLeft;
    }

    /**
     * this sets the isFacingLeft field
     * @param isFacingLeft isfacingleft is a boolean which sets isfacingleft
     */
    public void setIsFacingLeft(boolean isFacingLeft) {
        this.isFacingLeft = isFacingLeft;
    }

    /**
     * this destroys the sound clip as soon as it's initialised
     */
    @Override
    public void destroy()
    {
        negativeSound.play();
        super.destroy();
    }

    /**
     * Ghost method which uses the world class
     * @param world the world
     */
    public Ghost(World world) {
        super(world, ghostShape);
        addImage(ghost);
    }

    /**
     * This gets the x position of the character
     */
    public float getxPos4() {
        xPos4 = getPosition().x;
        return xPos4;

    }

    /**
     * This sets the x position
     * @param xPos4 this is the float for the x position
     */
    public void setxPos4(float xPos4) {
        this.xPos4 = xPos4;
    }

    /**
     * This gets the starting x position of the character
     */
    public float getStartXPos4() {
        return startXPos4;
    }

    /**
     * This sets the starting x position of the character
     * @param startXPos4 starting position
     */
    public void setStartXPos4(float startXPos4) {
        this.startXPos4 = startXPos4;
    }

    /**
     * This gets the direction of the walker
     */
    public int getEnemyDirection4() {
        return enemyDirection4;
    }

    /**
     * This sets the direction of the walker
     * @param enemyDirection4 enemy direction
     */
    public void setEnemyDirection4(int enemyDirection4) {
        this.enemyDirection4 = enemyDirection4;
    }

    /**
     * This changes the image of the ghost to the right direction
     */
    public void changeDirRight() {
        removeAllImages();
        addImage(new BodyImage("data/ghost.png", 2.4f));
        setIsFacingLeft(false);
    }

    /**
     * This changes the image of the ghost to the left direction
     */
    public void changeDirLeft() {
        removeAllImages();
        addImage(new BodyImage("data/ghost2.png", 2.4f));
        setIsFacingLeft(true);
    }
}
