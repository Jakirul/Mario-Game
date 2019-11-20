package game.Enemies;

import city.cs.engine.*;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.IOException;

/**
 * @author Muhammad Islam
 * This is the class for the fire gifs that are hidden under the character if it falls down the map.
 * in the pickup class, this specific redball gives minus 10 lives
 */
public class RedBall10v1 extends DynamicBody {


    /**
     * the shape of the Redball10v1
     */
    private static final Shape shape = new PolygonShape(
            0.333f,0.936f, 0.567f,0.405f, 0.837f,-0.436f, 0.837f,-0.963f, -0.535f,-1.026f, -0.801f,0.041f, -0.45f,0.738f);

    /**
     * The image of the RedBall10v1
     */
    private static final BodyImage image =
            new BodyImage("data/fire.gif", 2f);


    /**
     * RedBall10v1 uses the world
     * @param world the world redball10v1 is in
     */
    public RedBall10v1(World world) {
        super(world, shape);
        addImage(image);

    }

    /**
     * Sound clip field
     */
    private static SoundClip redball10Sound;


    /**
     * Sound clip will be initiated when mario touches the redball
     */
    static {
        try {
            redball10Sound = new SoundClip("src/game/mcdamage.wav");

        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            System.out.println(e);
        }
    }

    /**
     * Sound will be removed as soon as it starts so it wont loop
     */
    @Override
    public void destroy()
    {
        redball10Sound.play();
        super.destroy();
    }
}
