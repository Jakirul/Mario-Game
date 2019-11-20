package game.Enemies;

import city.cs.engine.*;
import org.jbox2d.common.Vec2;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.awt.Color;
import java.io.IOException;

/**
 * @author Muhammad Islam
 * This is the class for the Redball body.
 */
public class RedBall extends DynamicBody {

    /**
     * This is the shape of the red ball body
     */
    private static final Shape shape = new PolygonShape(
            0.333f,0.936f, 0.567f,0.405f, 0.837f,-0.436f, 0.837f,-0.963f, -0.535f,-1.026f, -0.801f,0.041f, -0.45f,0.738f);

    /**
     * This is the image of the red ball body
     */
    private static final BodyImage image =
            new BodyImage("data/fire.gif", 2f);

    /**
     * Redball class uses the world
     * @param world the world which redball is in
     */
    public RedBall(World world) {
        super(world, shape);
        addImage(image);

    }


    /**
     * The sound clip field
     */
    private static SoundClip negativeSound;

    /**
     * The sound clip which will be initiated when mario touches the redball (fire)
     */
    static {
        try {
            negativeSound = new SoundClip("src/game/mcdamage.wav");

        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            System.out.println(e);
        }
    }

    /**
     * This removes the sound when it's initiated
     */
    @Override
    public void destroy()
    {
        negativeSound.play();
        super.destroy();
    }
}
