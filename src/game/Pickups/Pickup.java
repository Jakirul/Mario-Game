package game.Pickups;

import city.cs.engine.*;
import game.*;
import game.Enemies.*;
import org.jbox2d.common.Vec2;

/**
 * @author Muhammad Islam
 * Collision listener that allows Mario to collect things.
 */
public class Pickup implements CollisionListener {

    /**
     * The mario field
     */
    private Mario mario;

    /**
     * Pickup uses the mario class
     * @param mario the character
     */
    public Pickup(Mario mario) {

        this.mario = mario;
    }

    /**
     * The pickups
     */
    @Override
    public void collide(CollisionEvent e) {
//        System.out.println("collision!!");
        if (e.getReportingBody() instanceof GreenBall && e.getOtherBody() == mario) {
            mario.incrementScore();
            e.getReportingBody().destroy();
        }

        if (e.getReportingBody() instanceof tenhealth && e.getOtherBody() == mario) {
            mario.incrementLiveCount10();
            e.getReportingBody().destroy();
        }
//
        if (e.getReportingBody() instanceof twentypoints && e.getOtherBody() == mario) {
            mario.incrementScore20();
            e.getReportingBody().destroy();
        }

        else if (e.getReportingBody() instanceof RedBall && e.getOtherBody() == mario) {
            mario.decrementLiveCount();
            e.getReportingBody().destroy();
        }

        else if (e.getReportingBody() instanceof RedBall10v1 && e.getOtherBody() == mario) {
           mario.decrementLiveCount10();
            e.getReportingBody().destroy();
        }

        //this is the pick up for the fire underneath the map. when touched, it will direct the user back to the original start position for level1
        else if (e.getReportingBody() instanceof RedBall10 && e.getOtherBody() == mario) {
            mario.setPosition(new Vec2(8f, -15f));
        }
        //this is the pick up for the fire underneath the map. when touched, it will direct the user back to the original start position for level2
        else if (e.getReportingBody() instanceof RedBall10v2 && e.getOtherBody() == mario) {
            mario.setPosition(new Vec2(22f, -17f));
        }

        //this is the final levels fire where it kills them to show they finished the game
        else if (e.getReportingBody() instanceof RedBall10v3 && e.getOtherBody() == mario) {
            mario.kill();
            e.getReportingBody().destroy();
        }

        //this is the pick up for the fire underneath the map. when touched, it will direct the user back to the original start position for the boss level
        else if (e.getReportingBody() instanceof RedBall10v4 && e.getOtherBody() == mario) {
            mario.setPosition(new Vec2(8f, 10.5f));
        }

        else if (e.getReportingBody() instanceof RedBomb && e.getOtherBody() == mario) {
            mario.decrementLiveCount();
            e.getReportingBody().destroy();
        }

        else if (e.getReportingBody() instanceof RedBomb2 && e.getOtherBody() == mario) {
            mario.decrementLiveCount();
            e.getReportingBody().destroy();
        }

        else if (e.getReportingBody() instanceof Spider && e.getOtherBody() == mario) {
            mario.decrementLiveCount();
            e.getReportingBody().destroy();
        }

        else if (e.getReportingBody() instanceof Toad && e.getOtherBody() == mario) {
            mario.incrementScore();
            System.out.println("You saved the Toad!");
            e.getReportingBody().destroy();
        }

        else if (e.getReportingBody() instanceof Monster && e.getOtherBody() == mario) {
            mario.decrementLiveCount();
            e.getReportingBody().destroy();
        }

        if (e.getReportingBody() instanceof Ghost && e.getOtherBody() == mario) {
            mario.decrementLiveCount();
            e.getReportingBody().destroy();

        }

        if (e.getReportingBody() instanceof Heart && e.getOtherBody() == mario) {
            mario.incrementLiveCount();

            e.getReportingBody().destroy();
        }

        if (e.getReportingBody() instanceof Goomba && e.getOtherBody() == mario) {
            mario.decrementLiveCount();
            e.getReportingBody().destroy();
        }

        if (e.getReportingBody() instanceof Bowser && e.getOtherBody() == mario) {
            mario.kill2();
            e.getReportingBody().destroy();

        }


        // this is the trampoline which allows mario to jump on
        else if (e.getReportingBody() instanceof Trampoline && e.getOtherBody() == mario) {

            Vec2 vector = mario.getLinearVelocity();

            if (Math.abs(vector.y) < 5f) {

                mario.applyForce(new Vec2(-12500,12500));
            }


        }

    }

}
