package game.Maps;

import city.cs.engine.*;
import city.cs.engine.Shape;
import game.*;
import game.Enemies.RedBall;
import game.Enemies.RedBall10;
import game.Pickups.Pickup;
import org.jbox2d.common.Vec2;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @author Muhammad Islam
 * Level 1 of the game
 */
public class Level1 extends GameLevel {

    /**
     * The user needs a score of 3 to progress to level 2
     */
    private static final int NUM_SCORE = 3;

    private Fireball fireball;

    /**
     * Populate the world.
     */


    @Override
    public void populate(Game game) {
        super.populate(game);


        // this is the platform the player starts in
        Shape groundShape = new BoxShape(2f, 0.5f);
        Body ground = new StaticBody(this, groundShape);
        ground.setPosition(new Vec2(8f, -18.3f));

        //this is the ground for the bottom of the map when the player falls
        Shape groundShape2 = new BoxShape(100f, 0.5f);
        Body ground2 = new StaticBody(this, groundShape2);
        ground2.setPosition(new Vec2(0, -35f));

        //original ground code
//      Shape groundShape = new BoxShape(100f, 0.5f);
//      Body ground = new StaticBody(this, groundShape);
//      ground.setPosition(new Vec2(0, -18.3f));

        //roof
//        Shape roofShape = new BoxShape(100f, 0.5f);
//        Body roof = new StaticBody(this, roofShape);
//        roof.setPosition(new Vec2(65, 18.2f));

        // walls
//        Shape leftWallShape = new BoxShape(0.5f, 31.5f, new Vec2(-34.5f, 5.5f));
//        Fixture leftWall = new SolidFixture(ground, leftWallShape);
//        Shape rightWallShape = new BoxShape(0.5f, 31.5f, new Vec2(34.5f, 5.5f));
//        Fixture rightWall = new SolidFixture(ground, rightWallShape);

//        Shape leftWallShape = new BoxShape(0.5f, 31.5f);
//        Body leftWall = new StaticBody(this, leftWallShape);
//        leftWall.setPosition(new Vec2(-34.5f, 5.5f));
//
//        Shape rightWallShape = new BoxShape(0.5f, 31.5f);
//        Body rightWall = new StaticBody(this, rightWallShape);
//        rightWall.setPosition(new Vec2(34.5f, 5.5f));


        // make platforms
        Shape boxShape = new BoxShape(4, 0.5f);


        Body platform1 = new StaticBody(this, boxShape);
        platform1.setPosition(new Vec2(-7f, 0f));
        platform1.setFillColor(Color.green);

        Body platform2 = new StaticBody(this, boxShape);
        platform2.setPosition(new Vec2(-2f, -5f));
        platform2.setFillColor(Color.yellow);

        Body platform3 = new StaticBody(this, boxShape);
        platform3.setPosition(new Vec2(8f, 3.5f));
        platform3.setFillColor(Color.green);

        Body platform4 = new StaticBody(this, boxShape);
        platform4.setPosition(new Vec2(17f, -13.5f));
        platform4.setFillColor(Color.pink);


        Body platform5 = new StaticBody(this, boxShape);
        platform5.setPosition(new Vec2(-6f, 7f));
        platform5.setFillColor(Color.orange);

        Body platform6 = new StaticBody(this, boxShape);
        platform6.setPosition(new Vec2(-19f, 8f));
        platform6.setFillColor(Color.orange);

        Body platform7 = new StaticBody(this, boxShape);
        platform7.setPosition(new Vec2(3f, -10f));
        platform7.setFillColor(Color.cyan);

        Body platform8 = new StaticBody(this, boxShape);
        platform8.setPosition(new Vec2(-7f, -10f));
        platform8.setFillColor(Color.magenta);

        Body platform9 = new StaticBody(this, boxShape);
        platform9.setPosition(new Vec2(-25f, 13f));
        platform9.setFillColor(Color.red);

        Body platform10 = new StaticBody(this, boxShape);
        platform10.setPosition(new Vec2(20f, 10f));
        platform10.setFillColor(Color.black);

        Body platform11 = new StaticBody(this, boxShape);
        platform11.setPosition(new Vec2(25f, 0f));
        platform11.setFillColor(Color.blue);

        Body platform12 = new StaticBody(this, boxShape);
        platform12.setPosition(new Vec2(-13f, 15f));
        platform12.setFillColor(Color.green);

//        Body platform9 = new StaticBody(this, boxShape);
//        platform9.setPosition(new Vec2(-30f, 17.3f));
//
//        Body platform10 = new StaticBody(this, boxShape);
//        platform10.setPosition(new Vec2(30f, 17.3f));
//
//        Body platform11 = new StaticBody(this, boxShape);
//        platform11.setPosition(new Vec2(30f, -17.3f));
//
//        Body platform12 = new StaticBody(this, boxShape);
//        platform12.setPosition(new Vec2(-30f, -17.3f));


        //this is for the green circles that give you extra health
        for (int i = 0; i < 2; i++) {
            Body greenball = new GreenBall(this);
            greenball.setPosition(new Vec2(-7f, 1f));
            greenball.addCollisionListener(new Pickup(getPlayer()));
        }


        //this is for the fire on the top platform that gives you minus health
        for (int i = 0; i < 2; i++) {
            Body redball = new RedBall(this);
            redball.setPosition(new Vec2(-6f, 8f));
            redball.addCollisionListener(new Pickup(getPlayer()));
        }


        //the next 11 for loops are for the red balls on the bottom of the game incase the player falls
        //it gives minus 10 damage
        for (int i = 0; i < 9; i++) {
            Body redball = new RedBall10(this);
            redball.setPosition(new Vec2(-50f, -34f));
            redball.addCollisionListener(new Pickup(getPlayer()));
        }

        for (int i = 0; i < 9; i++) {
            Body redball = new RedBall10(this);
            redball.setPosition(new Vec2(-40f, -34f));
            redball.addCollisionListener(new Pickup(getPlayer()));
        }

        for (int i = 0; i < 9; i++) {
            Body redball = new RedBall10(this);
            redball.setPosition(new Vec2(-30f, -34f));
            redball.addCollisionListener(new Pickup(getPlayer()));
        }

        for (int i = 0; i < 9; i++) {
            Body redball = new RedBall10(this);
            redball.setPosition(new Vec2(-20f, -34f));
            redball.addCollisionListener(new Pickup(getPlayer()));
        }

        for (int i = 0; i < 9; i++) {
            Body redball = new RedBall10(this);
            redball.setPosition(new Vec2(-10f, -34f));
            redball.addCollisionListener(new Pickup(getPlayer()));
        }

        for (int i = 0; i < 10; i++) {
            Body redball = new RedBall10(this);
            redball.setPosition(new Vec2(0, -34f));
            redball.addCollisionListener(new Pickup(getPlayer()));
        }

        for (int i = 0; i < 8; i++) {
            Body redball = new RedBall10(this);
            redball.setPosition(new Vec2(10f, -34f));
            redball.addCollisionListener(new Pickup(getPlayer()));
        }

        for (int i = 0; i < 8; i++) {
            Body redball = new RedBall10(this);
            redball.setPosition(new Vec2(20f, -34f));
            redball.addCollisionListener(new Pickup(getPlayer()));
        }

        for (int i = 0; i < 8; i++) {
            Body redball = new RedBall10(this);
            redball.setPosition(new Vec2(30f, -34f));
            redball.addCollisionListener(new Pickup(getPlayer()));
        }

        for (int i = 0; i < 8; i++) {
            Body redball = new RedBall10(this);
            redball.setPosition(new Vec2(40f, -34f));
            redball.addCollisionListener(new Pickup(getPlayer()));
        }

        for (int i = 0; i < 8; i++) {
            Body redball = new RedBall10(this);
            redball.setPosition(new Vec2(50f, -34f));
            redball.addCollisionListener(new Pickup(getPlayer()));
        }


        for (int i = 0; i < 1; i++) {
            Body tenpoints = new tenhealth(this);
            tenpoints.setPosition(new Vec2(20f, 12f));
            tenpoints.addCollisionListener(new Pickup(getPlayer()));
        }


//        Timer t = new Timer(2000, this);
//        t.setInitialDelay(5000);
//        t.setRepeats(false);
//        t.start();


    }


    @Override
    public Vec2 startPosition() {
        return new Vec2(8f, -15f);
    }


    @Override
    public Vec2 toadPosition() {
        return new Vec2(-13f, 17f);
    }

    @Override
    public Vec2 bombPosition() {
        return new Vec2(-23f, 10f);
    }

    @Override
    public Vec2 bombPosition2() {
        return new Vec2(-100f, 100f);
    }

    @Override
    public Vec2 spiderPosition() {
        return new Vec2(-100f, 100f);
    }

    @Override
    public Vec2 ghostPosition() {
        return new Vec2(-100f, 100f);
    }

    @Override
    public Vec2 goombaPosition() {
        return new Vec2(-100f, 100f);
    }


    @Override
    public Vec2 portalPosition() {
        return new Vec2(-10f, 16.9f);
    }

    @Override
    public Vec2 portalPosition2() {
        return new Vec2(-100f, 100f);
    }

    @Override
    public Vec2 portalPosition3() {
        return new Vec2(-100f, 100f);
    }


    @Override
    public Vec2 gameOverPosition() {
        return new Vec2(-100f, 100f);
    }

    @Override
    public String setGameSong() {
        return "data/Music/mariotheme.wav";
    }

    @Override
    public Vec2 monsterPosition() {
        return new Vec2(-100f, 100f);
    }

    @Override
    public Vec2 bowserPosition() {
        return new Vec2(-100f, 100f);
    }

    @Override
    public Vec2 bowserPosition2() {
        return new Vec2(-100f, 100f);
    }

    @Override
    public boolean isCompleted() {

        return getPlayer().getScoreCount() >= NUM_SCORE;
    }


}
