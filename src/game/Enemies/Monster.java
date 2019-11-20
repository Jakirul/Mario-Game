package game.Enemies;

import city.cs.engine.*;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.IOException;

/**
 * @author Muhammad Islam
 * This is the class for the Monster walker.
 */
public class Monster extends DynamicBody {

    /**
     * This is the shape of the monster
     */
    private static final Shape shape = new PolygonShape(
            0.538f,0.957f, 1.167f,0.16f, 0.297f,-1.057f, -1.015f,-1.079f, -1.38f,0.233f, -1.032f,0.917f);

    /**
     * This is the image of the monster
     */
    private static final BodyImage image =
            new BodyImage("data/monster.png", 2.5f);


    /**
     * Monster method using the world
     * @param world the world
     */
    public Monster(World world) {
        super(world, shape);
        addImage(image);

    }

    /**
     * Sound clip field
     */
    private static SoundClip negativeSound;

    /**
     * This is the sound clip for when mario touches the monster
     */
    static {
        try {
            negativeSound = new SoundClip("src/game/mcdamage.wav");

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
        negativeSound.play();
        super.destroy();
    }
}

