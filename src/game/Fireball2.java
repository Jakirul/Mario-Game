package game;

import city.cs.engine.*;
import game.Enemies.BossBowser;
import org.jbox2d.common.Vec2;


/**
 * @author Muhammad Islam
 * This is the class for the fire that comes out Bowser
 */
public class Fireball2 extends DynamicBody {

    /**
     * The shape of the fireball bowser uses
     */
    private static final Shape shape = new PolygonShape(
            -0.684f,-1.107f, 0.558f,-1.102f, 0.941f,0.918f, -0.909f,0.779f, -0.864f,-0.891f);

    /**
     * The image of the fireball
     */
    private static final BodyImage image =
            new BodyImage("data/fireball.png", 1f);

    /**
     * Bowser2 field
     */
    private BossBowser bowser2;

    /**
     * Sensor field
     */
    private Sensor FireballSensor;

    /**
     * Distance tracker field
     */
    private int DistanceTracker = 0;

    private boolean inMotion = false;

    /**
     * Fireball2 uses the world and bowser2 class
     * @param world the world the fireball is in
     * @param bowser2 the character bowser2
     */
    public Fireball2(World world, BossBowser bowser2) {
        super(world, shape);
        this.bowser2 = bowser2;
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
     * This gets the in motion field
     */
    public boolean getInMotion() {
        return inMotion;
    }

    /**
     * sets in motion
     */
    public void setInMotion(boolean inMotion) {
        this.inMotion = inMotion;
    }

    /**
     * This gets the distance tracker. this is how far the fireball travels
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
     * Increments the distance tracker
     */
    public void incrementDistanceTracker() {
        DistanceTracker++;
    }

    /**
     * The fireball moving left
     */
    public void movingLeft() {
            move(new Vec2(-1, 0));
//        setLinearVelocity(new Vec2 (-10, 0));
        bowser2.setCanControlFire(false);
            setInMotion(true);
    }

    /**
     * The fireball moving right
     */
    public void movingRight() {
            move(new Vec2(1, 0));
        bowser2.setCanControlFire(false);
            setInMotion(true);
    }

    /**
     * The fireball resets to the original position with this method
     */
    public void reset() {
        setPosition(new Vec2(bowser2.getPosition().x, bowser2.getPosition().y));
    }



}
