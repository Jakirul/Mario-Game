package game.Enemies;

import city.cs.engine.*;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.IOException;

/**
 * @author Muhammad Islam
 * This is the class for the fire gifs that are hidden under the character if it falls down the map.
 * in the pickup class, this specific redball outputs a message saying you completed the game and then it kills the user
 */
public class RedBall10v3 extends DynamicBody {

    /**
     * This is the shape of the RedBall10v3
     */
    private static final Shape shape = new PolygonShape(
            0.333f,0.936f, 0.567f,0.405f, 0.837f,-0.436f, 0.837f,-0.963f, -0.535f,-1.026f, -0.801f,0.041f, -0.45f,0.738f);

    /**
     * This is the image of the RedBall10v3
     */
    private static final BodyImage image =
            new BodyImage("data/fire.gif", 2f);


    /**
     * RedBall10v3 uses the world
     * @param world the world RedBall10v3 is in
     */
    public RedBall10v3(World world) {
        super(world, shape);
        addImage(image);
    }

    /**
     * The soundclip field
     */
    private static SoundClip redball10Sound;


    /**
     * The sound clip will be initialised when mario touches the redball
     */
    static {
        try {
            redball10Sound = new SoundClip("src/game/mcdamage.wav");

        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            System.out.println(e);
        }
    }

    /**
     * The sound clip will be destroyed when initiated so it wont repeat
     */
    @Override
    public void destroy()
    {
        redball10Sound.play();
        super.destroy();
    }
}
