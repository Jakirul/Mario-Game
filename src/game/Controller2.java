package game;

import game.Enemies.BossBowser;
import game.Pickups.BowserFireBallPickup;
import org.jbox2d.common.Vec2;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;


/**
 * @author Muhammad Islam
 * Key handler to control the Bowser firing.
 */
public class Controller2 extends KeyAdapter {


    /**
     * Bowser2 field
     */
    private BossBowser bowser2;



    public Controller2(BossBowser bowser2) {
        this.bowser2 = bowser2;
    }

    /**
     * Handle key press events for walking and jumping.
     * @param e description of the key event
     */


    @Override
    public void keyPressed(KeyEvent e) {


        int code = e.getKeyCode();

        /**
         * If L is pressed, then bowser can fire towards the right direction
         */
        if (code == KeyEvent.VK_L && bowser2.canControlFire) { // && fireball.getControllable()) {
            bowser2.setFiring(true);
            Fireball2 fireball2 = new Fireball2(bowser2.getWorld(), bowser2);
            fireball2.reset();
            fireball2.getFireballSensor().addSensorListener(new BowserFireBallPickup(fireball2));
            if (bowser2.isFacingLeft) {
                fireball2.setLinearVelocity(new Vec2(-50, 0));
            } else {
                fireball2.setLinearVelocity(new Vec2(50, 0));
            }
        }
    }



    /**
     * Handle key release events (stop walking).
     * @param e description of the key event
     */
    @Override
    public void keyReleased(KeyEvent e) {

    }

    public void setBody(BossBowser bowser2) {
        this.bowser2 = bowser2;
    }
}
