package game;

import city.cs.engine.*;
import game.Doors.*;
import game.Enemies.*;
import game.Pickups.Pickup;
import org.jbox2d.common.Vec2;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.IOException;

/**
 * @author Muhammad Islam
 * The Game Level class
 */
public abstract class GameLevel extends World {

    /**
     * The fields for the following characters
     */
    private Mario player;
    private Fireball fireball;
    private Fireball2 fireball2;
    private Toad toad;
    private RedBomb redbomb;
    private RedBomb2 redbomb2;
    private Spider spider;
    private Ghost ghost;
    private Monster monster;
    private Goomba goomba;
    private Bowser bowser;
    private BossBowser bowser2;
    private GameOver gameOver;
    private SoundClip gameSong;
    private RedBall redBall;



    /**
     * This returns mario
     */
    public Mario getPlayer() {
        return player;
    }

    /**
     * The returns the fireball
     */
    public Fireball getFireball() { return fireball;}

    public RedBall getRedBall() {
        return redBall;
    }

    /**
     * The returns the fireball2
     */
    public Fireball2 getFireball2() { return fireball2;}

    /**
     * The returns the redbomb
     */
    public RedBomb getRedBomb() {
        return redbomb;
    }

    /**
     * The returns the redbomb2
     */
    public RedBomb2 getRedBomb2() {
        return redbomb2;
    }

    /**
     * The returns the spider
     */
    public Spider getSpider() {
        return spider;
    }

    /**
     * The returns the ghost
     */
    public Ghost getGhost() { return ghost;}

    public Toad getToad() { return toad;}

    /**
     * The returns the monster
     */
    public Monster getMonster() { return monster;}

    /**
     * The returns the goomba
     */
    public Goomba getGoomba() { return goomba; }

    /**
     * The returns bowser
     */
    public Bowser getBowser() { return bowser;}

    /**
     * The returns bowser2
     */
    public BossBowser getBowser2() { return bowser2;}

    /**
     * The returns gameOver
     */
    public GameOver gameOver() { return gameOver;}
    /**
     * Populate the world of this level.
     * Child classes should this method with additional bodies.
     */
    public void populate(Game game) {

        // make a character
        player = new Mario(this);
        player.setPosition(startPosition());

        toad = new Toad(this);
        toad.setPosition(toadPosition());
        toad.addCollisionListener(new Pickup(player));

        redbomb = new RedBomb(this);
        redbomb.setPosition(bombPosition());
        redbomb.addCollisionListener(new Pickup(player));

//        redbomb = new RedBall(this);
//        redbomb.setPosition(bombPosition());
//        redbomb.addCollisionListener(new Pickup(player));


        redbomb2 = new RedBomb2(this);
        redbomb2.setPosition(bombPosition2());
        redbomb2.addCollisionListener(new Pickup(player));

        spider = new Spider(this);
        spider.setPosition(spiderPosition());
        spider.addCollisionListener(new Pickup(player));

        ghost = new Ghost(this);
        ghost.setPosition(ghostPosition());
        ghost.addCollisionListener(new Pickup(player));

        monster = new Monster(this);
        monster.setPosition(monsterPosition());
        monster.addCollisionListener(new Pickup(player));

        goomba = new Goomba(this);
        goomba.setPosition(goombaPosition());
        goomba.addCollisionListener(new Pickup(player));

        bowser = new Bowser(this);
        bowser.setPosition(bowserPosition());
        bowser.addCollisionListener(new Pickup(player));

        bowser2 = new BossBowser(this);
        bowser2.setPosition(bowserPosition2());


        gameOver = new GameOver(this);
        gameOver.setPosition(gameOverPosition());
        gameOver.addCollisionListener(new Pickup(player));

        Door door = new Door(this);
        door.setPosition(portalPosition());
        door.addCollisionListener(new DoorListener(game));

        DoorBad doorBad = new DoorBad(this);
        doorBad.setPosition(portalPosition2());
        doorBad.addCollisionListener(new DoorListenerBad(game));

        DoorBad2 doorBad2 = new DoorBad2(this);
        doorBad2.setPosition(portalPosition3());
        doorBad2.addCollisionListener(new DoorListenerBad2(game));

//        fireball = new Fireball(this, player);
//
//        marioFire marioFire = new marioFire(fireball, player);
//        this.addStepListener(marioFire);
//
//
//        bowserFire bowserFire = new bowserFire(fireball2, bowser2);
//        this.addStepListener(bowserFire);



//        NegativeDoor1 door2 = new NegativeDoor1(this);
//        door2.setPosition(badPortalPosition2());
//        door2.addCollisionListener(new DoorListener1(game));


        try {
            gameSong = new SoundClip(setGameSong());
            gameSong.loop();
        }
        catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            System.out.println(e);
        }




    }
    
    /** The initial position of the player. */
    public abstract Vec2 startPosition();

    public SoundClip getGameSong() {
        return gameSong;
    }

    public abstract String setGameSong();



    public abstract Vec2 bombPosition();

    public abstract Vec2 bombPosition2();

    public abstract Vec2 spiderPosition();

    public abstract Vec2 ghostPosition();

    public abstract Vec2 monsterPosition();

    public abstract Vec2 goombaPosition();

    public abstract Vec2 gameOverPosition();

    public abstract Vec2 toadPosition();

    public abstract Vec2 bowserPosition();

    public abstract Vec2 bowserPosition2();
    
    /** The position of the exit door. */
    public abstract Vec2 portalPosition();

    public abstract Vec2 portalPosition2();

    public abstract Vec2 portalPosition3();

    /** Is this level complete? */
    public abstract boolean isCompleted();
}
