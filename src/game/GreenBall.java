package game;

import city.cs.engine.*;
import org.jbox2d.common.Vec2;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.awt.Color;
import java.io.IOException;

/**
 * @author Muhammad Islam
 * This is the green ball that give you points when you pick them up
 */
public class GreenBall extends DynamicBody {


    /**
     * The shape of the green ball
     */
    private static final Shape shape = new PolygonShape(
            0.45f,0.792f, 0.842f,0.18f, 0.792f,-0.436f, 0.203f,-0.895f, -0.661f,-0.792f, -0.895f,0.005f, -0.463f,0.725f);


    /**
     * The image of the green ball
     */
    private static final BodyImage image =
            new BodyImage("data/green.gif", 2f);

    /**
     * The sound clip field
     */
    private static SoundClip greenSound;

    /**
     * The GreenBall uses the world
     * @param world the world greenball is in
     */
    public GreenBall(World world) {
        super(world, shape);
        addImage(image);

    }

    /**
     * The sound clip for when mario picks up the green ball
     */
    static {
        try {
            greenSound = new SoundClip("src/game/powerupspace.wav");
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            System.out.println(e);
        }
    }

    /**
     * This destroys the sound clip as soon as it's initiated
     */
    @Override
    public void destroy()
    {
        greenSound.play();
        super.destroy();
    }

}
