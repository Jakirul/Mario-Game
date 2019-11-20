package game;

import city.cs.engine.*;

import java.awt.*;
import java.io.*;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.*;

import game.Enemies.*;
import game.Maps.*;


/**
 * @author Muhammad Islam
 * The main class
 */
public class Game extends JFrame {


    /**
     * Sets the JFrame field to be called frame
     */
    private JFrame frame;

    /**
     * Makes pause a boolean and false
     */
    boolean pause = false;



    /** The World in which the bodies move and interact. */
    private GameLevel world;
    /** A graphical display of the world (a specialised JPanel). */
    private UserView view;
    private int level;
    private Controller controller;
    private Controller2 controller2;
    public Mario mario;



    /** Initialise a new Game. */

    public Game() {

        // make the world
        level = 0;
        world = new Level0();
        world.populate(this);

        //view = new UserView(world, 1400, 750);
        view = new MyView(world,this , world.getPlayer(), world.getBowser2(), 1400, 720);
        view.setZoom(18);

        //this is the background music
//        try {
//            gameMusic = new SoundClip("data/Music/mariotheme.wav");   // Open an audio input stream
//            gameMusic.loop();  // Set it to continous playback (looping)
//        }
//        catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
//            System.out.println(e);
//        }


        // make a view
        // uncomment this to draw a 1-metre grid over the view
//        view.setGridResolution(1);

        // display the view in a frame
        final JFrame frame = new JFrame("The Adventure of Mario!");

        //this is the control panel which appears above the game
        ControlPanel buttons = new ControlPanel(this);
        frame.add(buttons.getMainPanel(), BorderLayout.NORTH);

        // quit the application when the game window is closed
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        frame.setLocationByPlatform(true);
        // display the world in the window
        frame.add(view);
        // don't let the game window be resized
        frame.setResizable(false);
        // size the game window to fit the world view
        frame.pack();
        // make the window visible
        frame.setVisible(true);
        // get keyboard focus
        frame.requestFocus();
        // give keyboard focus to the frame whenever the mouse enters the view
        view.addMouseListener(new GiveFocus(frame));
        
        //this is the bowling ball
        DropBowlingBall db = new DropBowlingBall(view);
        view.addMouseListener(db);

        //this is the controller for mario
        controller = new Controller(world.getPlayer());
        frame.addKeyListener(controller);

        //this is the control panel for bowser
        controller2 = new Controller2(world.getBowser2());
        frame.addKeyListener(controller2);
        
        // uncomment to make the view track the bird
//        world.addStepListener(new Tracker(view, world.getPlayer()));
        world.addStepListener(new RedBombMovement(world.getRedBomb()));
        world.addStepListener(new GhostMovement(world.getGhost()));


        // uncomment this to make a debugging view
        //JFrame debugView = new DebugViewer(world, 1400, 750);

        // start!
        world.start();

    }

    /**
     * This class allows the use of pausing and unpausing
     */
    public void pause() {

        frame = new JFrame("Giraffe");
        frame.requestFocusInWindow();
        if(pause == false){
            world.stop();
            pause = true;

        } else {
            pause = false;
            world.start();
        }
        frame.requestFocusInWindow();
    }

    /**
     * this writes the score and livecount to a txt file
     */
    public void writing() {
        try {
            HighScoreWriter writer = new HighScoreWriter("data/Scores.txt");
            writer.writeHighScore("Score count for this level", getPlayer().getScoreCount());
            writer.writeHighScore("Live count for this level", getPlayer().getLiveCount());


        }
        catch(IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * This reads the txt file and outputs it
     */
    public void reading() {

        try {
            HighScoreReader reader = new HighScoreReader("data/Scores.txt");
            reader.readScores();
        }
        catch(IOException e) {
            e.printStackTrace();
        }
    }


    /** The player in the current level. */
    public Mario getPlayer() {
        return world.getPlayer();
    }


    /** Is the current level of the game finished? */
    public boolean isCurrentLevelCompleted() {
        return world.isCompleted();
    }

    /** Advance to the next level of the game. */
    public void goNextLevel() {
        level++;
        world.stop();
        Mario oldMario = world.getPlayer();

        try {
            HighScoreWriter writer = new HighScoreWriter("data/Scores.txt");
            writer.writeHighScore("Score count for this level", getPlayer().getScoreCount());
            writer.writeHighScore("Live count for this level", getPlayer().getLiveCount());

        }
        catch(IOException e) {
            e.printStackTrace();
        }
        if (level == 0) {

            world = new Level0();
            world.populate(this);
            controller.setBody(world.getPlayer());
            view.setWorld(world);
            world.start();
        }

        if (level == 1) {

            world = new Level1();
            world.populate(this);
            controller.setBody(world.getPlayer());
            world.getPlayer().setScoreCount(oldMario.getScoreCount());
            world.addStepListener(new RedBombMovement(world.getRedBomb()));
            world.addStepListener(new GhostMovement(world.getGhost()));
            view.setWorld(world);
            world.start();
        }


        if(level == 2){
            // get a new world
            world = new Level2();
            // fill it with bodies
            world.populate(this);
            // switch the keyboard control to the new player
            controller.setBody(world.getPlayer());
            world.addStepListener(new RedBombMovement(world.getRedBomb()));
            world.addStepListener(new SpiderMovement(world.getSpider()));
            world.addStepListener(new GoombaMovement(world.getGoomba()));
            world.addStepListener(new GhostMovement(world.getGhost()));
            world.getPlayer().setLiveCount(oldMario.getLiveCount());
            world.getPlayer().setScoreCount(oldMario.getScoreCount());
            System.out.println("Entering Level 2...");
            // show the new world in the view
            view.setWorld(world);
            world.start();

        }

        if (level == 3) {
            // get a new world
            world = new Level3();
            System.out.println("Entering Level 3...");
            // fill it with bodies
            world.populate(this);
            // switch the keyboard control to the new player
            controller.setBody(world.getPlayer());
            world.addStepListener(new RedBomb2Movement(world.getRedBomb2()));
            world.getPlayer().setLiveCount(oldMario.getLiveCount());
            world.getPlayer().setScoreCount(oldMario.getScoreCount());
            // show the new world in the view
            view.setWorld(world);
            world.start();
        }

        if(level == 5){
            // get a new world
            world = new badLevel();
            // fill it with bodies
            world.populate(this);
            // switch the keyboard control to the new player
            controller.setBody(world.getPlayer());
            world.addStepListener(new BowserMovement(world.getBowser()));
//            gameMusic.stop();
//            try {
//
//                gameMusic2 = new SoundClip("data/Music/mariotheme2.wav");   // Open an audio input stream
//                gameMusic2.loop();  // Set it to continous playback (looping)
//            }
//            catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
//                System.out.println(e);
//            }

            JOptionPane.showMessageDialog(null, "You've entered through the wrong door!", "Uh Oh...", JOptionPane.WARNING_MESSAGE);
            System.out.println("Uh Oh... You've gone through the wrong door!");
            // show the new world in the view
            view.setWorld(world);
            world.start();
        }

        if (level == 4) {
//            gameMusic.stop();
//            try {
//
//                gameMusic2 = new SoundClip("data/Music/mariotheme2.wav");   // Open an audio input stream
//                gameMusic2.loop();  // Set it to continous playback (looping)
//            }
//            catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
//                System.out.println(e);
//            }
            world = new BossLevel();
            // fill it with bodies
            world.populate(this);
            // switch the keyboard control to the new player
            controller.setBody(world.getPlayer());
//            JFrame debugView = new DebugViewer(world, 1400, 750);
            controller2.setBody(world.getBowser2());
            world.getPlayer().setLiveCount(oldMario.getLiveCount());
            world.getPlayer().setScoreCount(oldMario.getScoreCount());
            System.out.println("Entering the Boss Level...");
            // show the new world in the view
            view.setWorld(world);
            world.start();
        }

    }

    /**
     * This returns the levels
     */
    public int getLevels() {
        return level;
    }


    public GameLevel getGameLevel() {
        return world;
    }
    /**
     * This sets the level number
     */
    public void setLevelNo(int level) {
        this.level = level;
    }


    /** Run the game. */
    public static void main(String[] args) {
      new Game();

        
    }



}


