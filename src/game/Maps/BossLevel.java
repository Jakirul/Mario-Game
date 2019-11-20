package game.Maps;

import city.cs.engine.*;
import city.cs.engine.Shape;
import game.*;
import game.Enemies.*;
import game.Pickups.*;
import org.jbox2d.common.Vec2;

import java.awt.*;

/**
 * @author Muhammad Islam
 * The final level of the game
 */
public class BossLevel extends GameLevel {

    public Mario mario;
    /**
     * User needs a score of 2 to progress
     */
    private static final int NUM_SCORE = 2;

    @Override
    public void populate(Game game)  {
        super.populate(game);

        Shape groundShape = new BoxShape(15.5f, 0.5f);
        Body ground = new StaticBody(this, groundShape);
        ground.setPosition(new Vec2(-14.5f, -18.3f));

        Shape groundShape2 = new BoxShape(3f, 0.5f);
        Body ground2 = new StaticBody(this, groundShape2);
        ground2.setPosition(new Vec2(8f, 10f));

        Shape groundShape3 = new BoxShape(100f, 0.5f);
        Body ground3 = new StaticBody(this, groundShape3);
        ground3.setPosition(new Vec2(0, -25f));

        Shape leftWallShape = new BoxShape(0.5f, 31.5f);
        Body leftWall = new StaticBody(this, leftWallShape);
        leftWall.setPosition(new Vec2(-34.5f, 5.5f));

        Shape rightWallShape2 = new BoxShape(0.5f, 31.5f);
        Body rightWall2 = new StaticBody(this, rightWallShape2);
        rightWall2.setPosition(new Vec2(34.5f, 5.5f));

        Shape rightWallShape = new BoxShape(0.5f, 5f);
        Body rightWall = new StaticBody(this, rightWallShape);
        rightWall.setPosition(new Vec2(5f, -16f));

        Shape rightWallShape3 = new BoxShape(0.5f, 30f);
        Body rightWall3 = new StaticBody(this, rightWallShape3);
        rightWall3.setPosition(new Vec2(5f, 25f));

        Shape platformOne = new BoxShape(2f, 0.5f);
        Body platform1 = new StaticBody(this, platformOne);
        platform1.setPosition(new Vec2(0, 0));
        platform1.setFillColor(Color.green);

        for (int i = 0; i < 9; i++) {
            Body redBall = new RedBall10v1(this);
            redBall.setPosition(new Vec2(-6f, -17.5f));
            redBall.addCollisionListener(new Pickup(getPlayer()));
        }


        for (int i = 0; i < 7; i++) {
            Body redBall10v3 = new RedBall10v3(this);
            redBall10v3.setPosition(new Vec2(-30f, -24.5f));
            redBall10v3.addCollisionListener(new Pickup(getPlayer()));
        }

        for (int i = 0; i < 10; i++) {
            Body redBall10v4 = new RedBall10v4(this);
            redBall10v4.setPosition(new Vec2(-3f, -24.5f));
            redBall10v4.addCollisionListener(new Pickup(getPlayer()));
            redBall10v4.addCollisionListener(new RedBombPickup(getRedBomb()));
            redBall10v4.addCollisionListener(new RedBomb2Pickup(getRedBomb2()));
            redBall10v4.addCollisionListener(new SpiderPickup(getSpider()));
            redBall10v4.addCollisionListener(new GoombaPickup(getGoomba()));

        }

        for (int i = 0; i < 10; i++) {
            Body redBall10v4 = new RedBall10v4(this);
            redBall10v4.setPosition(new Vec2(12f, -24.5f));
            redBall10v4.addCollisionListener(new Pickup(getPlayer()));
            redBall10v4.addCollisionListener(new RedBombPickup(getRedBomb()));
            redBall10v4.addCollisionListener(new RedBomb2Pickup(getRedBomb2()));
            redBall10v4.addCollisionListener(new SpiderPickup(getSpider()));
            redBall10v4.addCollisionListener(new GoombaPickup(getGoomba()));
        }

        for (int i = 0; i < 10; i++) {
            Body redBall10v4 = new RedBall10v4(this);
            redBall10v4.setPosition(new Vec2(27f, -24.5f));
            redBall10v4.addCollisionListener(new Pickup(getPlayer()));
            redBall10v4.addCollisionListener(new RedBombPickup(getRedBomb()));
            redBall10v4.addCollisionListener(new RedBomb2Pickup(getRedBomb2()));
            redBall10v4.addCollisionListener(new SpiderPickup(getSpider()));
            redBall10v4.addCollisionListener(new GoombaPickup(getGoomba()));
        }




        // 1st round of fire balls that fall down

        for (int i = 0; i < 1; i++) {
            Body heart = new Heart(this);
            heart.setPosition(new Vec2( 12f, 85));
            heart.addCollisionListener(new Pickup(getPlayer()));
        }

        for (int i = 0; i <1; i++) {
            Body redBall = new RedBall(this);
            redBall.setPosition(new Vec2(10f, 85));
            redBall.addCollisionListener(new Pickup(getPlayer()));
        }






    }



    @Override
    public String setGameSong() {
        return "data/Music/mariotheme2.wav";
    }



    @Override
    public Vec2 startPosition() {
        return new Vec2(8f, 10.5f);
    }



    @Override
    public Vec2 toadPosition() {
        return new Vec2(-100f, 100f);
    }

    @Override
    public Vec2 bombPosition() {
        return new  Vec2(10f, 85);
    }


    @Override
    public Vec2 bombPosition2() {
        return new  Vec2(16f, 85);
    }

    @Override
    public Vec2 spiderPosition() {
        return new  Vec2(20f, 85);
    }

    @Override
    public Vec2 ghostPosition() {
        return new  Vec2(-100f, 100f);
    }

    @Override
    public Vec2 goombaPosition() {
        return new  Vec2(25f, 85);
    }


    @Override
    public Vec2 portalPosition() {
        return new Vec2(-100f, 100f);
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
    public Vec2 gameOverPosition() {
        return new Vec2( -100f, 100f);
    }

    @Override
    public Vec2 bowserPosition2() {
        return new Vec2(-15f, -15f);
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
    public boolean isCompleted() {

        return getPlayer().getScoreCount() >= NUM_SCORE;
    }

}
