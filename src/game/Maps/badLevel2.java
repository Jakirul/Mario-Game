package game.Maps;

import city.cs.engine.*;
import game.Game;
import game.GameLevel;
import game.Pickups.Pickup;
import game.Enemies.RedBall10;
import org.jbox2d.common.Vec2;

/**
 * @author Muhammad Islam
 * Bad level (2) of the game
 */
public class badLevel2 extends GameLevel {

    /**
     * Populate the world.
     */
    @Override
    public void populate(Game game) {
        super.populate(game);

        // make the ground
        Shape groundShape = new BoxShape(100f, 0.5f);
        Body ground = new StaticBody(this, groundShape);
        ground.setPosition(new Vec2(-16f, -17.3f));
        ground.addImage(new BodyImage("data/floor.png", 1.5f));

        Shape groundShape2 = new BoxShape(100f, 0.5f);
        Body ground2 = new StaticBody(this, groundShape2);
        ground2.setPosition(new Vec2(18f, -17.3f));
        ground2.addImage(new BodyImage("data/floor.png", 1.5f));

        Shape groundShape3 = new BoxShape(100f, 0.5f);
        Body ground3 = new StaticBody(this, groundShape3);
        ground3.setPosition(new Vec2(0, -17.3f));

        Shape groundShape4 = new BoxShape(100f, 0.5f);
        Body ground4 = new StaticBody(this, groundShape4);
        ground4.setPosition(new Vec2(-15.8f, -13.3f));
        ground4.addImage(new BodyImage("data/floor.png", 1.5f));

        Shape groundShape5 = new BoxShape(100f, 0.5f);
        Body ground5 = new StaticBody(this, groundShape5);
        ground5.setPosition(new Vec2(16f, -13.3f));
        ground5.addImage(new BodyImage("data/floor.png", 1.5f));

        Shape rightWallShape = new BoxShape(5f, 8);
        Body rightWall = new StaticBody (this, rightWallShape);
        rightWall.setPosition (new Vec2(34.1f, 5.5f));
        rightWall.addImage(new BodyImage("data/tiles2.png", 25.0f));

        Shape rightWallShape2 = new BoxShape(5f, 8);
        Body rightWall2 = new StaticBody (this, rightWallShape2);
        rightWall2.setPosition (new Vec2(34.1f, -6f));
        rightWall2.addImage(new BodyImage("data/tiles2.png", 25.0f));

        Shape rightWallShape3 = new BoxShape(0.5f, 31.5f);
        Body rightWall3 = new StaticBody(this, rightWallShape3);
        rightWall3.setPosition(new Vec2(33.5f, 5.5f));



        Shape leftWallShape = new BoxShape(5f, 8);
        Body leftWall = new StaticBody (this, leftWallShape);
        leftWall.setPosition (new Vec2(-34.1f, 5.5f));
        leftWall.addImage(new BodyImage("data/tiles2.png", 25.0f));

        Shape leftWallShapee2 = new BoxShape(5f, 8);
        Body leftWall2 = new StaticBody (this, leftWallShapee2);
        leftWall2.setPosition (new Vec2(-34.1f, -6f));
        leftWall2.addImage(new BodyImage("data/tiles2.png", 25.0f));


//
        for (int i = 0; i < 8; i++) {
            Body redball = new RedBall10(this);
            redball.setPosition(new Vec2(-20f, 40f));
            redball.addCollisionListener(new Pickup(getPlayer()));
        }

        for (int i = 0; i < 8; i++) {
            Body redball = new RedBall10(this);
            redball.setPosition(new Vec2(-10f, 40f));
            redball.addCollisionListener(new Pickup(getPlayer()));
        }

        for (int i = 0; i < 8; i++) {
            Body redball = new RedBall10(this);
            redball.setPosition(new Vec2(0, 40f));
            redball.addCollisionListener(new Pickup(getPlayer()));
        }

        for (int i = 0; i < 8; i++) {
            Body redball = new RedBall10(this);
            redball.setPosition(new Vec2(10f, 40f));
            redball.addCollisionListener(new Pickup(getPlayer()));
        }

        for (int i = 0; i < 8; i++) {
            Body redball = new RedBall10(this);
            redball.setPosition(new Vec2(20f, 40f));
            redball.addCollisionListener(new Pickup(getPlayer()));
        }


//        for (int i = 0; i < 8; i++) {
//            Body redball = new RedBall10(this);
//            redball.setPosition(new Vec2(30f, 40f));
//            redball.addCollisionListener(new Pickup(getPlayer()));
//        }

//        for (int i = 0; i < 8; i++) {
//            Body redball = new RedBall10(this);
//            redball.setPosition(new Vec2(40f, 40f));
//            redball.addCollisionListener(new Pickup(getPlayer()));
//        }

//        for (int i = 0; i < 5; i++) {
//            Body redball = new RedBall10(this);
//            redball.setPosition(new Vec2(50f, 40f));
//            redball.addCollisionListener(new Pickup(getPlayer()));
//        }
    }


    @Override
    public String setGameSong() {
        return "data/Music/mariotheme2.wav";
    }



    @Override
    public Vec2 startPosition() {
        return new Vec2(22f, -15f);
    }

    @Override
    public Vec2 portalPosition2() {
        return new Vec2(-100f, 100f);
    }

    @Override
    public Vec2 portalPosition() {
        return new Vec2(-100f, 1000f);
    }

    @Override
    public Vec2 portalPosition3() {
        return new Vec2( -100f, 100f);
    }

    @Override
    public Vec2 monsterPosition() {
        return new Vec2(-100f, 100f);
    }

    @Override
    public Vec2 bombPosition() {
        return new  Vec2(-100f, 100f);
    }

    @Override
    public Vec2 bombPosition2() {
        return new  Vec2(-100f, 100f);
    }

    @Override
    public Vec2 bowserPosition() {
        return new Vec2(-30f, -15.5f);
    }

    @Override
    public Vec2 bowserPosition2() {
        return new Vec2(-100f, 100f);
    }


    @Override
    public Vec2 spiderPosition() {
        return new  Vec2(-100f, 100f);
    }

    @Override
    public Vec2 gameOverPosition() {
        return new Vec2( 0f, 10f);
    }


    @Override
    public Vec2 goombaPosition() {
        return new  Vec2(-100f, 100f);
    }

    @Override
    public Vec2 ghostPosition() {
        return new  Vec2(-100f, 100f);
    }

    @Override
    public Vec2 toadPosition() {
        return new Vec2(-100f, 100f);
    }

    @Override
    public boolean isCompleted() {
        return isCompleted();
    }
}
