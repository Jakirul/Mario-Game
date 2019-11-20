package game.Maps;

import city.cs.engine.*;
import city.cs.engine.Shape;
import game.*;
import game.Enemies.RedBall;
import game.Pickups.Pickup;
import org.jbox2d.common.Vec2;

import java.awt.*;

/**
 * @author Muhammad Islam
 * Level 2 of the game
 */
public class Level2 extends GameLevel {

    public Game game;
    /**
     * The user needs a scroe of 15 to go level 3
     */
    private static final int NUM_SCORE = 15;

    /**
     * Populate the world.
     */
    @Override
    public void populate(Game game)  {
        super.populate(game);

        Shape groundShape = new BoxShape(100f, 0.5f);
        Body ground = new StaticBody(this, groundShape);
        ground.setPosition(new Vec2(0, -18.3f));

        Shape platformOne = new BoxShape(4f, 0.5f);
        Body platform1 = new StaticBody(this, platformOne);
        platform1.setPosition(new Vec2(30f, -13f));
        platform1.setFillColor(Color.green);

        Shape platformTwo = new BoxShape(4f, 0.5f);
        Body platform2 = new StaticBody(this, platformTwo);
        platform2.setPosition(new Vec2(20f, -9f));
        platform2.setFillColor(Color.green);

        Shape platformThree = new BoxShape(4f, 0.5f);
        Body platform3 = new StaticBody(this, platformThree);
        platform3.setPosition(new Vec2(30f, -5f));
        platform3.setFillColor(Color.green);

        Shape platformFour = new BoxShape(4f, 0.5f);
        Body platform4 = new StaticBody(this, platformFour);
        platform4.setPosition(new Vec2(20f, -1f));
        platform4.setFillColor(Color.green);

        Shape platformFive = new BoxShape(4f, 0.5f);
        Body platform5 = new StaticBody(this, platformFive);
        platform5.setPosition(new Vec2(30f, 3f));
        platform5.setFillColor(Color.green);

        Shape platformSix = new BoxShape(4f, 0.5f);
        Body platform6 = new StaticBody(this, platformSix);
        platform6.setPosition(new Vec2(20f, 7f));
        platform6.setFillColor(Color.green);


        Shape platformSeven = new BoxShape(5f, 0.5f);
        Body platform7 = new StaticBody(this, platformSeven);
        platform7.setPosition(new Vec2(9.95f, -13f));
        platform7.setFillColor(Color.green);


        Body trampoline = new Trampoline(this);
        trampoline.setPosition(new Vec2(31f, 12f));
        trampoline.addCollisionListener(new Pickup(getPlayer()));
        trampoline.setAngle(1f);


        Shape platformEight = new BoxShape(4f, 0.5f);
        Body platform8 = new StaticBody(this, platformEight);
        platform8.setPosition(new Vec2(0.95f, -9f));
        platform8.setFillColor(Color.green);

        Shape platformNine = new BoxShape(4f, 0.5f);
        Body platform9 = new StaticBody(this, platformNine);
        platform9.setPosition(new Vec2(10.95f, -5f));
        platform9.setFillColor(Color.green);

        Shape platformTen = new BoxShape(4f, 0.5f);
        Body platform10 = new StaticBody(this, platformTen);
        platform10.setPosition(new Vec2(0.95f, -1f));
        platform10.setFillColor(Color.green);

        Shape platformEleven = new BoxShape(5f, 0.5f);
        Body platform11 = new StaticBody(this, platformEleven);
        platform11.setPosition(new Vec2(9.95f, 3f));
        platform11.setFillColor(Color.green);

        Shape platformTwelve = new BoxShape(4f, 0.5f);
        Body platform12 = new StaticBody(this, platformTwelve);
        platform12.setPosition(new Vec2(0.95f, 7f));
        platform12.setFillColor(Color.green);


        Shape platformThirteen = new BoxShape(4f, 0.5f);
        Body platform13 = new StaticBody(this, platformThirteen);
        platform13.setPosition(new Vec2(10.95f, 11f));
        platform13.setFillColor(Color.green);

        Shape platformFourteen = new BoxShape(3.1f, 0.5f);
        Body platform14 = new StaticBody(this, platformFourteen);
        platform14.setPosition(new Vec2(-30.9f, -15f));
        platform14.setFillColor(Color.green);
        platform14.setAngle(-0.25f);

        Shape platformFifteen = new BoxShape(4f, 0.5f);
        Body platform15 = new StaticBody(this, platformFifteen);
        platform15.setPosition(new Vec2(-8f, -8f));
        platform15.setFillColor(Color.green);

        Shape platformSixteen= new BoxShape(4f, 0.5f);
        Body platform16 = new StaticBody(this, platformSixteen);
        platform16.setPosition(new Vec2(-14, -4f));
        platform16.setFillColor(Color.green);

        Shape platformSeventeen= new BoxShape(4f, 0.5f);
        Body platform17 = new StaticBody(this, platformSeventeen);
        platform17.setPosition(new Vec2(-22, 0f));
        platform17.setFillColor(Color.green);

        Shape platformEighteen = new BoxShape(4f, 0.5f);
        Body platform18 = new StaticBody(this, platformEighteen);
        platform18.setPosition(new Vec2(-8f, 0f));
        platform18.setFillColor(Color.green);

        Shape platformNineteen = new BoxShape(4f, 0.5f);
        Body platform19 = new StaticBody(this, platformNineteen);
        platform19.setPosition(new Vec2(-14f, 6f));
        platform19.setFillColor(Color.green);

        Shape platformTwenty = new BoxShape(4f, 0.5f);
        Body platform20 = new StaticBody(this, platformTwenty);
        platform20.setPosition(new Vec2(-20f, 11f));
        platform20.setFillColor(Color.green);

        Shape platformTwenty1 = new BoxShape(4f, 0.5f);
        Body platform21 = new StaticBody(this, platformTwenty1);
        platform21.setPosition(new Vec2(-8f, 15f));
        platform21.setFillColor(Color.green);

        Shape platformTwenty2 = new BoxShape(4f, 0.5f);
        Body platform22 = new StaticBody(this, platformTwenty2);
        platform22.setPosition(new Vec2(-30, 14f));
        platform22.setFillColor(Color.green);

        Shape Roof = new BoxShape(11.5f, 0.5f);
        Body roof = new StaticBody(this, Roof);
        roof.setPosition(new Vec2(-14.5f, -11.8f));

        Shape wallShape = new BoxShape(0.5f, 15f);
        Body rightWall1 = new StaticBody(this, wallShape);
        rightWall1.setPosition(new Vec2(-3.55f, 3.7f));

        Shape rightWallShape = new BoxShape(0.5f, 30f);
        Body rightWall = new StaticBody(this, rightWallShape);
        rightWall.setPosition(new Vec2(15.45f, -11f));

        Shape leftWallShape = new BoxShape(0.5f, 31.5f);
        Body leftWall = new StaticBody(this, leftWallShape);
        leftWall.setPosition(new Vec2(-34.5f, 5.5f));

        Shape rightWallShape2 = new BoxShape(0.5f, 31.5f);
        Body rightWall2 = new StaticBody(this, rightWallShape2);
        rightWall2.setPosition(new Vec2(34.5f, 5.5f));

        for (int i = 0; i < 3; i++) {
            Body greenball = new GreenBall(this);
            greenball.setPosition(new Vec2(30f, 3.5f));
            greenball.addCollisionListener(new Pickup(getPlayer()));
        }

        for (int i = 0; i < 5; i++) {
            Body redball = new RedBall(this);
            redball.setPosition(new Vec2(0f, 7.5f));
            redball.addCollisionListener(new Pickup(getPlayer()));
        }

        for (int i = 0; i < 1; i++) {
            Body twentypoints = new twentypoints(this);
            twentypoints.setPosition(new Vec2(10.95f, 12f));
            twentypoints.addCollisionListener(new Pickup(getPlayer()));
        }

        for (int i = 0; i < 5; i++) {
            Body redball2 = new RedBall(this);
            redball2.setPosition(new Vec2(-22, 0.5f));
            redball2.addCollisionListener(new Pickup(getPlayer()));
        }


        for (int i = 0; i < 1; i++) {
            Body heart = new Heart(this);
            heart.setPosition(new Vec2( -8f, 16f));
            heart.addCollisionListener(new Pickup(getPlayer()));
        }


    }

    @Override
    public Vec2 startPosition() {
        return new Vec2(30f, -18f);
    }

    @Override
    public Vec2 portalPosition() {

        return new Vec2(-33, 16f);
    }

    @Override
    public Vec2 portalPosition2() {
        return new Vec2(-100f, 100f);
    }

    @Override
    public Vec2 portalPosition3() {
        return new Vec2( -100f, 100f);
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
    public String setGameSong() {
        return "data/Music/mariotheme.wav";
    }

    @Override
    public Vec2 monsterPosition() {
        return new Vec2(9.95f, 3.5f);
    }

    @Override
    public Vec2 bombPosition() {
        return new  Vec2(-190f, 9f);
    }

    @Override
    public Vec2 bombPosition2() {
        return new  Vec2(-100f, 100f);
    }

    @Override
    public Vec2 spiderPosition() {
        return new  Vec2(20f, -8f);
    }

    @Override
    public Vec2 ghostPosition() {
        return new  Vec2(-8f, -17.5f);
    }

    @Override
    public Vec2 goombaPosition() {
        return new  Vec2(7.95f, -12f);
    }

    @Override
    public Vec2 gameOverPosition() {
        return new Vec2( -100f, 100f);
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
