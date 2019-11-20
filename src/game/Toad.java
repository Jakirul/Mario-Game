package game;

import city.cs.engine.*;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.IOException;

/**
 * @author Muhammad Islam
 * This is the walker class for the Toad character which mario collects at the end of each level
 */
public class Toad extends Walker {

    /**
     * The shape of the toad
     */
    private static final Shape shape = new PolygonShape(
            -0.289f,1.089f, -0.725f,0.126f, -0.442f,-1.093f, 0.557f,-1.089f, 0.751f,0.68f);

    /**
     * The image of the toad
     */
    private static final BodyImage image =
            new BodyImage("data/toad.png", 2.3f);

    /**
     * The sound clip field
     */
    private static SoundClip toadSound;

    /**
     * Toad uses the world
     * @param world the world the toad is in
     */
    public Toad(World world) {
        super(world, shape);
        addImage(image);
    }

    /**
     * This is the sound clip that is played when mario picks up toad
     */
    static {
        try {
            toadSound = new SoundClip("src/game/powerupspace.wav");
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            System.out.println(e);
        }
    }

    /**
     * The sound clip is destroyed when it's initiated to prevent looping
     */
    @Override
    public void destroy()
    {
        toadSound.play();
        super.destroy();
    }


}
