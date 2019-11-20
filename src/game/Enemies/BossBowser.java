package game.Enemies;

import city.cs.engine.*;
import javax.sound.sampled.*;
import java.io.IOException;


/**
 * @author Muhammad Islam
 * This is the class for the Bowser character which appears in the Boss Level
 */
public class BossBowser extends Walker  {

    /**
     * Creates a integer count field
     */
    public int count;

    /**
     * shape for bowser2
     */
    private static final Shape shape = new PolygonShape(
            0.5f,12.35f, -11.95f,-11.95f, -2.55f,-12.05f, 10.25f,5.15f);

    /**
     * image of bowser
     */
    private static final BodyImage image =
            new BodyImage("data/bowser.png", 24f);

    /**
     * these are the sound clips when the fireball hits bowser
     */
    public static SoundClip negativeSound;
    public static SoundClip negativeSound2;

    /**
     * Sets firing to false
     */
    public boolean Firing = false;

    public boolean canControlFire = true;

    public boolean isFacingLeft = false;

    /**
     * Initialise bowser2
     * @param world The world.
     */
    public BossBowser(World world) {
        super(world, shape);
        addImage(image);
        count = 50;
    }

    /**
     * This is the first Bowser sound clip
     */
    static {
        try {
            negativeSound = new SoundClip("src/game/bowser.wav");

        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            System.out.println(e);
        }
    }

    /**
     * This is the second bowser soundclip
     */
    static {
        try {
            negativeSound2 = new SoundClip("src/game/bowser2.wav");

        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            System.out.println(e);
        }
    }

    /**
     * This returns "canControlFire"
     */
    public boolean getCanControlFire() {
        return canControlFire;
    }

    /**
     * This sets the canControlFire. its on true by default
     */
    public void setCanControlFire(boolean canControlFire) {
        this.canControlFire = canControlFire;
    }

    /**
     * This gets the isFacingLeft boolean. its on false by default
     */
    public boolean getIsFacingLeft() {
        return isFacingLeft;
    }

    /**
     * This sets the isFacingLeft boolean.
     */
    public void setIsFacingLeft(boolean isFacingLeft) {
        this.isFacingLeft = isFacingLeft;
    }

    /**
     * This gets the firing field
     */
    public boolean getFiring() {
        return Firing;
    }

    /**
     * this sets the firing field
     */
    public void setFiring(boolean Firing) {
        this.Firing = Firing;
    }

    /**
     * this gets the live count of bowser
     */
    public int getLiveCount() {
        return count;
    }

    /**
     * this sets the live count of the user
     */
    public void setLiveCount(int cnt) {
        count = cnt;
    }

    /**
     * this decrements bowser's health
     */
    public void decrementLiveCount(){
        count--;

        //this initialises the first soundclip
        negativeSound.play();

      //if bowsers live count is below 1, the second soundclip would play
      if (getLiveCount() < 1) {
          negativeSound2.play();
      }
        //this would print out bowsers livecount
        System.out.println("You hit Bowser! Bowser's live count: " + count);



    }

}
