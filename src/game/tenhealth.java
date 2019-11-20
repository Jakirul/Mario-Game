package game;

import city.cs.engine.*;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.IOException;

/**
 * @author Muhammad Islam
 * This gives the user 10 extra health if they step over it
 */
public class tenhealth extends DynamicBody {

    /**
     * Shape of the health
     */
    private static final Shape shape = new CircleShape(1.5f);

    /**
     * Image of the health
     */
    private static final BodyImage image =
            new BodyImage("data/10points.png", 3f);


    /**
     * tenhealth uses the world
     * @param world the world ten health is in
     */
    public tenhealth(World world) {
        super(world, shape);
        addImage(image);
    }

    /**
     * soundclip field
     */
    private static SoundClip tenSound;

    /**
     * Sound clip is played when mario picks up the ten health
     */
    static {
        try {
            tenSound = new SoundClip("src/game/powerupspace.wav");
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            System.out.println(e);
        }
    }

    /**
     * Sound clip destroys when it's initiated to prevent looping
     */
    @Override
    public void destroy()
    {
        tenSound.play();
        super.destroy();
    }

}



