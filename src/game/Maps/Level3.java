package game.Maps;

import city.cs.engine.*;
import city.cs.engine.Shape;
import game.*;
import game.Enemies.RedBall;
import game.Enemies.RedBall10v2;
import game.Pickups.Pickup;
import org.jbox2d.common.Vec2;

import java.awt.*;

/**
 * @author Muhammad Islam
 * Level 3 of the game
 */
public class Level3 extends GameLevel {

    /**
     * The user needs a score of 2 to go Boss Level
     */
    private static final int NUM_SCORE = 2;

    /**
     * Populate the world.
     */
    @Override
    public void populate(Game game) {
        super.populate(game);

        // make the ground
        Shape groundShape = new BoxShape(4f, 0.5f);
        Body ground = new StaticBody(this, groundShape);
        ground.setPosition(new Vec2(22f, -18f));

        Shape platformOne = new BoxShape(4f, 0.5f);
        Body platform1 = new StaticBody(this, platformOne);
        platform1.setPosition(new Vec2(30f, -13f));
        platform1.setFillColor(Color.green);

        Shape platformTwo = new BoxShape(4f, 0.5f);
        Body platform2 = new StaticBody(this, platformTwo);
        platform2.setPosition(new Vec2(22f, -9f));
        platform2.setFillColor(Color.green);

        Shape platformThree = new BoxShape(4f, 0.5f);
        Body platform3 = new StaticBody(this, platformThree);
        platform3.setPosition(new Vec2(14f, -5f));
        platform3.setFillColor(Color.green);

        Shape platformFour = new BoxShape(4f, 0.5f);
        Body platform4 = new StaticBody(this, platformFour);
        platform4.setPosition(new Vec2(22f, -1f));
        platform4.setFillColor(Color.green);

        Shape platformFive = new BoxShape(4f, 0.5f);
        Body platform5 = new StaticBody(this, platformFive);
        platform5.setPosition(new Vec2(30f, 3f));
        platform5.setFillColor(Color.green);

        Shape platformSix = new BoxShape(4f, 0.5f);
        Body platform6 = new StaticBody(this, platformSix);
        platform6.setPosition(new Vec2(22f, 7f));
        platform6.setFillColor(Color.green);

        Shape platformSeven = new BoxShape(4f, 0.5f);
        Body platform7 = new StaticBody(this, platformSeven);
        platform7.setPosition(new Vec2(30f, 13f));
        platform7.setFillColor(Color.green);

        Shape platformEight = new BoxShape(4f, 0.5f);
        Body platform8 = new StaticBody(this, platformEight);
        platform8.setPosition(new Vec2(6f, -1f));
        platform8.setFillColor(Color.green);

        for (int i = 0; i < 1; i++) {
            Body heart = new Heart(this);
            heart.setPosition(new Vec2( 6f, 0f));
            heart.addCollisionListener(new Pickup(getPlayer()));
        }

        Shape platformNine = new BoxShape(4f, 0.5f);
        Body platform9 = new StaticBody(this, platformNine);
        platform9.setPosition(new Vec2(-30f, -13f));
        platform9.setFillColor(Color.green);

        Shape platformTen = new BoxShape(4f, 0.5f);
        Body platform10 = new StaticBody(this, platformTen);
        platform10.setPosition(new Vec2(-22f, -9f));
        platform10.setFillColor(Color.green);

        Shape platformEleven = new BoxShape(4f, 0.5f);
        Body platform11 = new StaticBody(this, platformEleven);
        platform11.setPosition(new Vec2(-14f, -5f));
        platform11.setFillColor(Color.green);

        Shape platformTwelve= new BoxShape(4f, 0.5f);
        Body platform12 = new StaticBody(this, platformTwelve);
        platform12.setPosition(new Vec2(-6f, -1f));
        platform12.setFillColor(Color.green);

        Shape platformThirteen = new BoxShape(4f, 0.5f);
        Body platform13 = new StaticBody(this, platformThirteen);
        platform13.setPosition(new Vec2(-14f, 5f));
        platform13.setFillColor(Color.green);

        Shape platformFourteen = new BoxShape(4f, 0.5f);
        Body platform14 = new StaticBody(this, platformFourteen);
        platform14.setPosition(new Vec2(-22f, 10.5f));
        platform14.setFillColor(Color.green);

        Shape platformFifteen = new BoxShape(4f, 0.5f);
        Body platform15 = new StaticBody(this, platformFifteen);
        platform15.setPosition(new Vec2(-30, 14f));
        platform15.setFillColor(Color.green);

//        for (int i = 0; i < 1; i++) {
//            Body door = new NegativeDoor(this);
//            door.setPosition(new Vec2(33f, 15f));
//            door.addCollisionListener(new Pickup(getPlayer()));
//        }
//
//        for (int i = 0; i < 1; i++) {
//            Body door1 = new NegativeDoor(this);
//            door1.setPosition(new Vec2(-33f, -11f));
//            door1.addCollisionListener(new Pickup(getPlayer()));
//        }

        //this is the ground for the bottom of the map when the player falls
        Shape groundShape16 = new BoxShape(100f, 0.5f);
        Body ground16 = new StaticBody(this, groundShape16);
        ground16.setPosition(new Vec2(0, -35f));

        //next 11 are fires that are on the bottom of the screen
        for (int i = 0; i < 9; i++) {
            Body redball = new RedBall10v2(this);
            redball.setPosition(new Vec2(-50f, -34f));
            redball.addCollisionListener(new Pickup(getPlayer()));
        }

        for (int i = 0; i < 9; i++) {
            Body redball = new RedBall10v2(this);
            redball.setPosition(new Vec2(-40f, -34f));
            redball.addCollisionListener(new Pickup(getPlayer()));
        }

        for (int i = 0; i < 9; i++) {
            Body redball = new RedBall10v2(this);
            redball.setPosition(new Vec2(-30f, -34f));
            redball.addCollisionListener(new Pickup(getPlayer()));
        }

        for (int i = 0; i < 9; i++) {
            Body redball = new RedBall10v2(this);
            redball.setPosition(new Vec2(-20f, -34f));
            redball.addCollisionListener(new Pickup(getPlayer()));
        }

        for (int i = 0; i < 9; i++) {
            Body redball = new RedBall10v2(this);
            redball.setPosition(new Vec2(-10f, -34f));
            redball.addCollisionListener(new Pickup(getPlayer()));
        }

        for (int i = 0; i < 10; i++) {
            Body redball = new RedBall10v2(this);
            redball.setPosition(new Vec2(0, -34f));
            redball.addCollisionListener(new Pickup(getPlayer()));
        }

        for (int i = 0; i < 8; i++) {
            Body redball = new RedBall10v2(this);
            redball.setPosition(new Vec2(10f, -34f));
            redball.addCollisionListener(new Pickup(getPlayer()));
        }

        for (int i = 0; i < 8; i++) {
            Body redball = new RedBall10v2(this);
            redball.setPosition(new Vec2(20f, -34f));
            redball.addCollisionListener(new Pickup(getPlayer()));
        }

        for (int i = 0; i < 8; i++) {
            Body redball = new RedBall10v2(this);
            redball.setPosition(new Vec2(30f, -34f));
            redball.addCollisionListener(new Pickup(getPlayer()));
        }

        for (int i = 0; i < 8; i++) {
            Body redball = new RedBall10v2(this);
            redball.setPosition(new Vec2(40f, -34f));
            redball.addCollisionListener(new Pickup(getPlayer()));
        }

        for (int i = 0; i < 8; i++) {
            Body redball = new RedBall10v2(this);
            redball.setPosition(new Vec2(50f, -34f));
            redball.addCollisionListener(new Pickup(getPlayer()));
        }







        //these are the fire falling from the ground
        for (int i = 0; i < 1; i++) {
            Body redball = new RedBall(this);
            redball.setPosition(new Vec2(-20f, 40f));
            redball.addCollisionListener(new Pickup(getPlayer()));
        }

        for (int i = 0; i < 1; i++) {
            Body redball = new RedBall(this);
            redball.setPosition(new Vec2(-10f, 40f));
            redball.addCollisionListener(new Pickup(getPlayer()));
        }

        for (int i = 0; i < 1; i++) {
            Body redball = new RedBall(this);
            redball.setPosition(new Vec2(0, 40f));
            redball.addCollisionListener(new Pickup(getPlayer()));
        }

        for (int i = 0; i < 1; i++) {
            Body redball = new RedBall(this);
            redball.setPosition(new Vec2(10f, 40f));
            redball.addCollisionListener(new Pickup(getPlayer()));
        }

        for (int i = 0; i < 1; i++) {
            Body redball = new RedBall(this);
            redball.setPosition(new Vec2(20f, 40f));
            redball.addCollisionListener(new Pickup(getPlayer()));
        }

        for (int i = 0; i < 1; i++) {
            Body redball = new RedBall(this);
            redball.setPosition(new Vec2(30f, 40f));
            redball.addCollisionListener(new Pickup(getPlayer()));
        }

        for (int i = 0; i < 1; i++) {
            Body redball = new RedBall(this);
            redball.setPosition(new Vec2(40f, 40f));
            redball.addCollisionListener(new Pickup(getPlayer()));
        }

        for (int i = 0; i < 1; i++) {
            Body redball = new RedBall(this);
            redball.setPosition(new Vec2(50f, 40f));
            redball.addCollisionListener(new Pickup(getPlayer()));
        }



        for (int i = 0; i < 1; i++) {
            Body redball = new RedBall(this);
            redball.setPosition(new Vec2(-20f, 80f));
            redball.addCollisionListener(new Pickup(getPlayer()));
        }

//        for (int i = 0; i < 1; i++) {
//            Body redball = new RedBall(this);
//            redball.setPosition(new Vec2(-10f, 80f));
//            redball.addCollisionListener(new Pickup(getPlayer()));
//        }

        for (int i = 0; i < 1; i++) {
            Body redball = new RedBall(this);
            redball.setPosition(new Vec2(0, 80f));
            redball.addCollisionListener(new Pickup(getPlayer()));
        }

        for (int i = 0; i < 1; i++) {
            Body redball = new RedBall(this);
            redball.setPosition(new Vec2(10f, 80f));
            redball.addCollisionListener(new Pickup(getPlayer()));
        }

        for (int i = 0; i < 1; i++) {
            Body redball = new RedBall(this);
            redball.setPosition(new Vec2(20f, 80f));
            redball.addCollisionListener(new Pickup(getPlayer()));
        }

        for (int i = 0; i < 1; i++) {
            Body redball = new RedBall(this);
            redball.setPosition(new Vec2(30f, 80f));
            redball.addCollisionListener(new Pickup(getPlayer()));
        }

        for (int i = 0; i < 1; i++) {
            Body redball = new RedBall(this);
            redball.setPosition(new Vec2(40f, 80f));
            redball.addCollisionListener(new Pickup(getPlayer()));
        }

        for (int i = 0; i < 1; i++) {
            Body redball = new RedBall(this);
            redball.setPosition(new Vec2(50f, 80f));
            redball.addCollisionListener(new Pickup(getPlayer()));
        }


        // walls
//        Shape leftWallShape = new BoxShape(0.5f, 6, new Vec2(-11.5f, 5.5f));
//        Fixture leftWall = new SolidFixture(ground, leftWallShape);
//        Shape rightWallShape = new BoxShape(0.5f, 6, new Vec2(11.5f, 5.5f));
//        Fixture rightWall = new SolidFixture(ground, rightWallShape);
//

//        // make some platforms
//        Shape platformShape = new BoxShape(4, 0.5f);
//        Body platform1 = new StaticBody(this, platformShape);
//        platform1.setPosition(new Vec2(-7, 5.5f));
//        Body platform2 = new StaticBody(this, platformShape);
//        platform2.setPosition(new Vec2(5, -2.5f));
//        platform1.setFillColor(Color.green);


//        for (int i = 0; i < NUM_LIVES; i++) {
//            Body orange = new Orange(this);
//            orange.setPosition(new Vec2(i * 2 - 10, 10));
//            orange.addCollisionListener(new Pickup(getPlayer()));
//        }
    }
    @Override
    public String setGameSong() {
        return "data/Music/mariotheme.wav";
    }

    @Override
    public Vec2 startPosition() {
        return new Vec2(22f, -17f);
    }

    @Override
    public Vec2 portalPosition() {
        return new Vec2(-33f, 16f);
    }

    @Override
    public Vec2 portalPosition2() {
        return new Vec2(33f, 15f);
    }

    @Override
    public Vec2 portalPosition3() {
        return new Vec2( -33f, -11f
        );
    }


    @Override
    public Vec2 goombaPosition() {
        return new  Vec2(30f, 4f);
    }


    @Override
    public Vec2 monsterPosition() {
        return new Vec2(-22f, -8.5f);
    }

    @Override
    public Vec2 bombPosition() {
        return new  Vec2(-100f, 100f);
    }

    @Override
    public Vec2 gameOverPosition() {
        return new Vec2( -100f, 100f);
    }


    @Override
    public Vec2 bombPosition2() {
        return new  Vec2(-22f, 11f);
    }

    @Override
    public Vec2 spiderPosition() {
        return new  Vec2(-100f, 100f);
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
    public Vec2 ghostPosition() {
        return new  Vec2(-100f, 100f);
    }

    @Override
    public Vec2 toadPosition() {
        return new Vec2(-30f, 16f);
    }

    @Override
    public boolean isCompleted() {
        return getPlayer().getScoreCount() >= NUM_SCORE;
    }
}
