package game;

import city.cs.engine.*;
import game.Enemies.BossBowser;
import game.Pickups.MarioFireBallPickup;
import org.jbox2d.common.Vec2;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

/**
 * @author Muhammad Islam
 * Key handler to control an Walker.
 */
public class Controller extends KeyAdapter {
    private static final float JUMPING_SPEED = 11f;
    private static final float WALKING_SPEED = 4;

    /**
     * Sound clip field
     */
    public SoundClip gameMusic;

    /**
     * Mario field
     */
    private Mario mario;
    /**
     * Bowser field
     */
    private BossBowser bowser2;


    /**
     * Controller uses mario class
     */
    public Controller(Mario mario) {
        this.mario = mario;
    }

    /**
     * Handle key press events for walking and jumping.
     * @param e description of the key event
     */
    @Override
    public void keyPressed(KeyEvent e) {


        int code = e.getKeyCode();
        if (code == KeyEvent.VK_Q) { // Q = quit
            System.exit(0);
        } else if (code == KeyEvent.VK_SPACE) { // SPACE = jump
            Vec2 v = mario.getLinearVelocity();
            ;
            // only jump if body is not already jumping
            if (Math.abs(v.y) < 0.01f) {
                mario.jump(JUMPING_SPEED);
            }
        }
        /**
         * If the P button is clicked, then mario can shoot fire
         */
        else if (code == KeyEvent.VK_P && mario.canControlFire) { // && fireball.getControllable()) {
            mario.setFiring(true);
            Fireball fireball = new Fireball(mario.getWorld(), mario);
            fireball.reset();
            fireball.getFireballSensor().addSensorListener(new MarioFireBallPickup(fireball));
            if (mario.isFacingLeft) {
                fireball.setLinearVelocity(new Vec2(-50,0));
            } else {
                fireball.setLinearVelocity(new Vec2(50, 0));
            }


        }
//        else if (code == KeyEvent.VK_L && bowser2.canControlFire) { // && fireball.getControllable()) {
//            bowser2.setFiring(true);
//            Fireball2 fireball = new Fireball2(bowser2.getWorld(), bowser2);
//            fireball.reset();
//            fireball.getFireballSensor().addSensorListener(new Pickup3(fireball));
//            if (bowser2.isFacingLeft) {
//                fireball.setLinearVelocity(new Vec2(-50,0));
//            } else {
//                fireball.setLinearVelocity(new Vec2(50, 0));
//            }
//        }

        else if (code == KeyEvent.VK_A) {
            mario.startWalking(- WALKING_SPEED); // LEFT ARROW = walk left
            mario.changeDirLeft();

        } else if (code == KeyEvent.VK_D) {
            mario.startWalking(WALKING_SPEED); // RIGHT ARROW = walk right
            mario.changeDirRight();
        }
    }

    /**
     * Handle key release events (stop walking).
     * @param e description of the key event
     */
    @Override
    public void keyReleased(KeyEvent e) {
        int code = e.getKeyCode();
        if (code == KeyEvent.VK_A) {
            mario.stopWalking();
        } else if (code == KeyEvent.VK_D) {
            mario.stopWalking();
        }
    }

    public void setBody(Mario mario) {
        this.mario = mario;
    }
}
