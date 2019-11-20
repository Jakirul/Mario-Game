package game;

import city.cs.engine.*;
import city.cs.engine.Shape;
import org.jbox2d.common.Vec2;

import javax.swing.*;
import java.applet.Applet;
import java.applet.AudioClip;
import java.awt.*;
import java.io.*;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author Muhammad Islam
 * This is the class for the main walker character
 */
public class Mario extends Walker  {

    /**
     * Game field
     */
 private Game game;

    // Remember:  using the keyword static below means the fields shape and image belong to the class, rather than any instance.
    // That means there is a single shape and image for all instances of the class.
    /**
     *The shape of mario
     */
    private static final Shape shape = new PolygonShape(
            -0.43f,1.125f, -0.826f,-0.148f, -0.587f,-1.102f, 0.61f,-1.102f, 0.749f,0.275f);


    /**
     * The image of mario
     */
    private static final BodyImage image =
            new BodyImage("data/mario.png", 2.4f);


    /**
     * isFacingLeft field is set to false by default
     */
    public boolean isFacingLeft = false;

    /**
     * The Firing field is set to false by default
     */
    public boolean Firing = false;


    /**
     * The count field is an integer
     */
    public int count;
    /**
     * The score field is an integer
     */
    public int score;

    /**
     * The canControlFire boolean is set to true
     */
    public boolean canControlFire = true;

    /**
     * Mario is in the world
     * @param world mario is in the world
     */
    public Mario(World world) {
        super(world, shape);
        addImage(image);
        count = 5;
        score = 0;
    }

    /**
     * Returns the cancontrolfire field
     */
    public boolean getCanControlFire() {
        return canControlFire;
    }

    /**
     * Sets the can control field
     */
    public void setCanControlFire(boolean canControlFire) {
        this.canControlFire = canControlFire;
    }

    /**
     * Returns the facing left field
     */
    public boolean getIsFacingLeft() {
        return isFacingLeft;
    }

    /**
     * Sets the facing left field
     */
    public void setIsFacingLeft(boolean isFacingLeft) {
        this.isFacingLeft = isFacingLeft;
    }

    /**
     * This returns the firing field
     */
    public boolean getFiring() {
        return Firing;
    }

    /**
     * This sets the firing
     * @param Firing firing is a boolean
     */
    public void setFiring(boolean Firing) {
        this.Firing = Firing;
    }


    /**
     * This method is initiated on the boss level when Mario kills bowser
     * and goes down the exit hole
     */
    public void kill() {
        System.out.println("Congratulations! You have completed the game!");

        System.exit(0);
    }

    /**
     * This method is initiated on the Bad Level/2 when Mario gets killed by Bowser
     */
    public void kill2() {
        System.out.println("RIP, You got killed by Bowser. Better luck next time.");
        System.exit(0);
    }

    /**
     * This increments the score by one and outputs a message along with the score
     */
    public void incrementScore() {
        score++;
        System.out.println("Good Job! Score count = " + score);

    }

    /**
     * This increases the score by 20 and outputs a message along with the new score
     */
    public void incrementScore20() {
        score = score + 20;
        System.out.println("Good Job! Score count = " + score);

    }

    /**
     * This increments the livecount by one and outputs a message along with the count
     */
    public void incrementLiveCount() {
        count++;
        System.out.println("+1 LIVES! Live count = " + count);
    }

    /**
     * This increments the livecount by 10 and outputs a message along with the count
     */
    public void incrementLiveCount10() {
        count = count + 10;
        System.out.println("+10 LIVES! Live count = " + count);
    }

    /**
     * This increments the livecount by 20 and outputs a message along with the count
     */
    public void incrementLiveCount20() {
        count = count + 20;
        System.out.println("+20 LIVES! Live count = " + count);
    }

    /**
     * This returns the live count
     */
    public int getLiveCount() {
        return count;
    }

    /**
     * This returns the score count
     */
    public int getScoreCount() {
        return score;
    }


    /**
     * This decreases the live count by one
     * This normally happens when he touches things like fire/redbomb/spider/ghost etc
     */
    public void decrementLiveCount() {
        count--;
        System.out.println("Oops lost lives! Lives = " + count);
        if (count == 0) {
            System.out.println("GAME OVER! You have lost all your lives");
            System.exit(0);
        }
    }

    /**
     * This decreases marios health by 10
     */
    public void decrementLiveCount10() {
        count=count-10;

        if (count < 1) {
            System.out.println("OOPS! You've lost -10 lives!");
            System.out.println("GAME OVER! You have lost all your lives");
            System.out.println("Your lives after death: " + count);
            System.exit(0);

        }
    }

    /**
     * This sets the live count
     */
    public void setLiveCount(int cnt) {
        count = cnt;
    }

    /**
     * This sets the score count
     */
    public void setScoreCount(int scr) {
        score = scr;
    }


    /**
     * This changes the direction and the image of mario when facing right
     */
    public void changeDirRight() {
        removeAllImages();
        addImage(new BodyImage("data/mario.png", 2.4f));
        setIsFacingLeft(false);
    }

    /**
     * This changes the direction and the image of mario when facing left
     */
    public void changeDirLeft() {
        removeAllImages();
        addImage(new BodyImage("data/mario2.png", 2.4f));
        setIsFacingLeft(true);
    }

    /**
     * This is when mario jumps. the image is initiated
     */
    public void addImage() {
        addImage(new BodyImage("data/mario4.png", 2.4f));
    }


}



