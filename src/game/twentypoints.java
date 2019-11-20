package game;

import city.cs.engine.*;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.IOException;

/**
 * @author Muhammad Islam
 * This provides 20 points to mario once stepped on
 */
public class twentypoints extends DynamicBody {

    /**
     * This is the shape of the twentypoints
     */
    private static final Shape shape = new CircleShape(1.5f);

    /**
     * This is the image of the twenty points
     */
    private static final BodyImage image =
            new BodyImage("data/20points.png", 3f);


    /**
     * Twenty points use the world
     * @param world the world the twenty points is in
     */
    public twentypoints(World world) {
        super(world, shape);
        addImage(image);
    }

    /**
     * The soundclip field
     */
    private static SoundClip twentySound;

    /**
     * The soundclip is played when mario picks up the twenty points
     */
    static {
        try {
            twentySound = new SoundClip("src/game/undertalesound.wav");
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            System.out.println(e);
        }
    }

    /**
     * The twenty points will be destroyed when initiated to prevent looping
     */
    @Override
    public void destroy()
    {
        twentySound.play();
        super.destroy();
    }
}



