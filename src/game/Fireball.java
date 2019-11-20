package game;

import city.cs.engine.*;
import org.jbox2d.common.Vec2;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.FileReader;
import java.io.IOException;

/**
 * @author Muhammad Islam
 * This is the class for the fire that comes out Mario
 */
public class Fireball extends DynamicBody {

    /**
     * The shape of the fireball
     */
    private static final Shape shape = new PolygonShape(
            -0.684f,-1.107f, 0.558f,-1.102f, 0.941f,0.918f, -0.909f,0.779f, -0.864f,-0.891f);

    /**
     * The image of the fireball
     */
    private static final BodyImage image =
            new BodyImage("data/fireball.png", 1f);

    /**
     * Mario field
     */
    private Mario mario;

    /**
     * This is a sensor field for the fireball sensor
     */
    private Sensor FireballSensor;

    /**
     * distancetracker field
     */
    private int DistanceTracker = 0;

    private boolean inMotion = false;

    /**
     * Fireball uses the world and mario class
     * @param world fireball is in world
     * @param mario mario is the main character
     */
    public Fireball(World world, Mario mario) {
        super(world, shape);
        this.mario = mario;
        addImage(image);
        getFixtureList().get(0).destroy();
        FireballSensor = new Sensor(this, shape);
        FireballSensor.setDensity(0);
        setGravityScale(0);
    }


    /**
     * This gets the fireball sensor
     */
    public Sensor getFireballSensor() {
        return FireballSensor;
    }

    /**
     * This gets the in motion boolean
     */
    public boolean getInMotion() {
        return inMotion;
    }


    public void setInMotion(boolean inMotion) {
        this.inMotion = inMotion;
    }

    /**
     * This gets the distance tracker which is how far the fireball travels
     */
    public int getDistanceTracker() {
        return DistanceTracker;
    }

    /**
     * This sets the distance tracker
     * @param DistanceTracker distance fireball travels
     */
    public void setDistanceTracker(int DistanceTracker) {
        this.DistanceTracker = DistanceTracker;
    }

    /**
     * distance travel increments
     */
    public void incrementDistanceTracker() {
        DistanceTracker++;
    }

    /**
     * fireball moving left method
     */
    public void movingLeft() {
            move(new Vec2(-1, 0));
//        setLinearVelocity(new Vec2 (-10, 0));
            mario.setCanControlFire(false);
            setInMotion(true);
    }

    /**
     * fireball moving right method
     */
    public void movingRight() {
            move(new Vec2(1, 0));
            mario.setCanControlFire(false);
            setInMotion(true);
    }

    /**
     * position of the fireball resets wih this method
     */
    public void reset() {
        setPosition(new Vec2(mario.getPosition().x, mario.getPosition().y));
    }

}
