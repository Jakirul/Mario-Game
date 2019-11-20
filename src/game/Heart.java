package game;

import city.cs.engine.*;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.IOException;


/**
 * @author Muhammad Islam
 * This is a heart that gives you one extra health when you pick it up
 */
public class Heart extends DynamicBody {


    /**
     * The shape of the heart
     */
    private static final Shape shape = new PolygonShape(
            -0.675f,0.981f, -1.048f,0.225f, -0.121f,-1.026f, 0.14f,-1.026f, 1.094f,0.68f, 0.239f,0.986f);

    /**
     * The image of the heart
     */
    private static final BodyImage image =
            new BodyImage("data/heart.png", 2.5f);


    /**
     * The heart is in the world
     * @param world the world the heart is in
     */
    public Heart(World world) {
        super(world, shape);
        addImage(image);

    }

    /**
     * The sound clip field
     */
    private static SoundClip heartSound;

    /**
     * The sound the heart makes when mario picks it up
     */
    static {
        try {
            heartSound = new SoundClip("src/game/powerupspace.wav");
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            System.out.println(e);
        }
    }

    /**
     * The sound gets destroyed when initiated
     */
    @Override
    public void destroy()
    {
        heartSound.play();
        super.destroy();
    }
}
