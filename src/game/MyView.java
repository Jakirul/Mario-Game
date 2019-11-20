package game;

import java.awt.*;
import javax.swing.ImageIcon;
import city.cs.engine.*;
import game.Enemies.BossBowser;

/**
 * @author Muhammad Islam
 * extended view
 */
public class MyView extends UserView {

    /**
     * Initialises the mario and bowser2 class fields
     */
    public Mario mario;
    public BossBowser bowser2;

    /**
     * Image fields
     */
    public Image background;
    public Image background2;

    /**
     * Game class field
     */
    private Game game;



    /**
     * MyView uses the world class, game class, mario class, bowser 2 class and also sets the height and width
     * @param world the world myview uses
     * @param game the game class
     * @param mario the main character
     * @param bowser2 the boss level character
     * @param width the width of the scores and lives on the screen
     * @param height the height of the scores and lives on the screen
     */
    public MyView(World world, Game game, Mario mario, BossBowser bowser2, int width, int height) {
        super(world, width, height);
        this.mario = mario;
        this.bowser2 = bowser2;
        this.game = game;
    }

    /**
     * This is the backgrouns for each level
     */
    @Override
    protected void paintBackground(Graphics2D g) {

        /**
         * If the level is 0, the background will change
         */
        if (game.getLevels() == 0) {
            this.background = new ImageIcon("data/mariobackground.jpg").getImage();
            g.drawImage(background,0,0,this);
        }

        /**
         * If the level is 1, the background will change
         */
        if (game.getLevels() == 1) {
            this.background = new ImageIcon("data/a2.jpg").getImage();
            g.drawImage(background,0,0,this);
        }

        /**
         * If the level is 2, the background will change
         */
        else if (game.getLevels() == 2) {
            this.background = new ImageIcon("data/background2.jpg").getImage();
            g.drawImage(background,0,0,this);
        }

        /**
         * If the level is 3, the background will change
         */
        else if (game.getLevels() == 3) {
            this.background = new ImageIcon("data/background3.jpg").getImage();
            g.drawImage(background,0,0,this);
        }

        /**
         * If the level is 4 (Boss Level), the background will change
         */
        if (game.getLevels() == 4) {
            this.background2 = new ImageIcon("data/fire.jpg").getImage();
            g.drawImage(background2,0,0,this);
        }

        /**
         * If the level is 5 (Bad Level), the background will change
         */
         if (game.getLevels() == 5) {
            this.background2 = new ImageIcon("data/fire.jpg").getImage();
            g.drawImage(background2,0,0,this);
        }

        /**
         * If the level is 5 (Bad Level), the background will change
         */
         if (game.getLevels() == 5) {
            this.background2 = new ImageIcon("data/fire.jpg").getImage();
            g.drawImage(background2,0,0,this);
        }
    }

    /**
     * Adds things in front of the main game
     */
    @Override
    protected void paintForeground(Graphics2D g) {

        /**
         * This adds a live counter to the screen
         */
        g.drawString("YOUR LIVES = "+ ((GameLevel)this.getWorld()).getPlayer().getLiveCount(), 650, 17.3F);

        /**
         * This adds a score counter to the screen
         */
        g.drawString("YOUR SCORE = "+ ((GameLevel)this.getWorld()).getPlayer().getScoreCount(), 645, 30);


        if (game.getLevels() == 0) {
            g.setColor(Color.WHITE);
            g.setFont(new Font("SansSerif", Font.PLAIN, 100));
            g.drawString("MARIO", 100, 80f);
            g.setFont(new Font("SansSerif", Font.PLAIN, 85));
            g.drawString("ADVENTURES", 10, 170);

            g.setFont(new Font("SansSerif", Font.PLAIN, 95));
            g.drawString("JUMP DOWN", 820, 80f);
            g.setFont(new Font("SansSerif", Font.PLAIN, 85));
            g.drawString("TO PLAY", 890, 160);
        }

        /**
         * If the level is 4 (boss level) then it will state bowsers and mario's class
         */
        if (game.getLevels() == 4) {
            g.setColor(Color.WHITE);
            g.setFont(new Font("TimesRoman", Font.PLAIN, 25));
            g.drawString("BOWSER'S LIVES = "+ ((GameLevel)this.getWorld()).getBowser2().getLiveCount(), 100, 43f);
            g.setColor(Color.WHITE);
            g.setFont(new Font("TimesRoman", Font.PLAIN, 25));
            g.drawString("YOUR LIVES = "+ ((GameLevel)this.getWorld()).getPlayer().getLiveCount(), 800, 43f);
        }

        /**
         * these are the images of the exit section of the boss level
         */
        if (game.getLevels() == 4) {
            g.drawImage(new ImageIcon("data/arrow.jpg").getImage(),38, 650, 50,50,this);
            g.drawImage(new ImageIcon("data/exit.png").getImage(),20, 600, 100,50,this);
        }
    }
}
