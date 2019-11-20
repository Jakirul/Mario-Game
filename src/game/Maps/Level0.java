package game.Maps;

import city.cs.engine.Body;
import city.cs.engine.BoxShape;
import city.cs.engine.Shape;
import city.cs.engine.StaticBody;
import game.Enemies.RedBall;
import game.Enemies.RedBall10;
import game.*;
import game.Pickups.Pickup;
import org.jbox2d.common.Vec2;

import java.awt.*;

/**
 * @author Muhammad Islam
 * Level 0 of the game
 */
public class Level0 extends GameLevel {

    /**
     * The user needs a score of 0 to progress to level 1
     */
    private static final int NUM_SCORE = 0;



    /**
     * Populate the world.
     */


    @Override
    public void populate(Game game) {
        super.populate(game);


        // this is the platform the player starts in
        Shape groundShape = new BoxShape(2f, 0.5f);
        Body ground = new StaticBody(this, groundShape);
        ground.setPosition(new Vec2(0f, 15f));

        Shape groundShape2 = new BoxShape(4.5f, 0.5f);
        Body ground2 = new StaticBody(this, groundShape2);
        ground2.setPosition(new Vec2(0f, -19f));

//        Shape groundShape2 = new BoxShape(2f, 40f);
//        Body ground2 = new StaticBody(this, groundShape2);
//        ground2.setPosition(new Vec2(-20f, 5f));

        Shape rightWallShape = new BoxShape(0.5f, 31.5f);
        Body rightWall = new StaticBody(this, rightWallShape);
        rightWall.setPosition(new Vec2(5f, 0f));

        Shape leftWallShape = new BoxShape(0.5f, 31.5f);
        Body leftWall = new StaticBody(this, leftWallShape);
        leftWall.setPosition(new Vec2(-5f, 0f));




    }


    @Override
    public Vec2 startPosition() {
        return new Vec2(0f, 15.5f);
    }


    @Override
    public Vec2 toadPosition() {
        return new Vec2(-100f, 100f);
    }

    @Override
    public Vec2 bombPosition() {
        return new Vec2(-100f, 100f);
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
        return new Vec2(0f, -17f);
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
        return "data/Music/blank.wav";
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
