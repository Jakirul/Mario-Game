package game.Enemies;

import city.cs.engine.*;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.IOException;

/**
 * @author Muhammad Islam
 * This is the Spider class which moves left and right by itself in level 2
 */
public class Spider extends Walker {

    /**
     * shape of the spider
     */
    private static final Shape spiderShape = new PolygonShape(
            0.199f,1.071f, 0.834f,0.545f, 0.798f,-0.495f, 0.366f,-1.08f, -0.692f,-1.107f, -0.98f,-0.328f, -0.975f,0.662f, -0.489f,1.094f);


    /**
     * Sound clip field
     */
    private static SoundClip negativeSound;

    /**
     * The sound clip will be initialised when mario touches the spider
     */
    static {
        try {
            negativeSound = new SoundClip("src/game/mcdamage.wav");

        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            System.out.println(e);
        }
    }

    /**
     * Sound clip will be destroyed once it plays to prevent looping
     */
    @Override
    public void destroy()
    {
        negativeSound.play();
        super.destroy();
    }

    /**
     * This is the starting x position for the specific level
     */
    private float startXPos3 = 20f;
    private float xPos3;
    private int enemyDirection3 = 1;

    /**
     * This is the image of the spider
     */
    private static final BodyImage spider =
            new BodyImage("data/spider.png", 2f);


    /**
     * Spider uses the world
     * @param world the world Spider is in
     */
    public Spider(World world) {
        super(world, spiderShape);
        addImage(spider);

    }

    /**
     * This gets the x position of the spider
     */
    public float getxPos3() {
        xPos3 = getPosition().x;
        return xPos3;

    }

    /**
     * This sets the x position of the spider
     * @param xPos3 sets x position
     */
    public void setxPos3(float xPos3) {
        this.xPos3 = xPos3;
    }

    /**
     * This gets the starting x position based on the field above
     */
    public float getStartXPos3() {

        return startXPos3;
    }

    /**
     * This sets the starting x position
     * @param startXPos3 starting x pos
     */
    public void setStartXPos3(float startXPos3) {
        this.startXPos3 = startXPos3;
    }

    /**
     * This gets the enemy direction
     */
    public int getEnemyDirection3() {
        return enemyDirection3;
    }


    /**
     * This sets the enemy direction
     */
    public void setEnemyDirection3(int enemyDirection3) {
        this.enemyDirection3 = enemyDirection3;
    }




}


