package game;

import javax.swing.*;
import java.awt.event.*;
import java.io.*;

/**
 * @author Muhammad Islam
 * This is the control panel for the buttons on the top of the game
 */
public class ControlPanel extends javax.swing.JPanel {
   private JButton exit1;
   private JButton pause1;
   private JButton saveState;
   private JPanel mainPanel;
   private JComboBox comboBox1;
   private JButton loadScore;
    private JButton saveScores;
    private JButton loadScores;
    private int savingLevelI;
   private String savingLevelS;

    /**
     * Game field
     */
   public Game game;

    /**
     * Mario field
     */
   public Mario mario;

    /**
     * This is where i link the fireball to hit bowser
     */
   public ControlPanel(Game game) {

        //pause button. game.pause pauses the game
        pause1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                game.pause();
            }
        });

        //exit button
        exit1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        //this is the drop down box.
        comboBox1.addItemListener(new ItemListener() {

            @Override
            public void itemStateChanged(ItemEvent e) {
                if (e.getStateChange() == ItemEvent.SELECTED) {
                    if (comboBox1.getSelectedItem().equals("Level Selector")) {
                        game.getGameLevel().getGameSong().stop();
                        game.setLevelNo(-1);
                        game.goNextLevel();
                    }
                    if (comboBox1.getSelectedItem().equals("Level 1")) {
                        game.getGameLevel().getGameSong().stop();
                        game.setLevelNo(0);
                        game.goNextLevel();
                    }
                    if (comboBox1.getSelectedItem().equals("Level 2")) {
                        game.getGameLevel().getGameSong().stop();
                        game.setLevelNo(1);
                        game.goNextLevel();
                    }
                    if (comboBox1.getSelectedItem().equals("Level 3")) {
                        game.getGameLevel().getGameSong().stop();
                        game.setLevelNo(2);
                        game.goNextLevel();
                    }
                    if (comboBox1.getSelectedItem().equals("Boss Level")) {
                        game.getGameLevel().getGameSong().stop();
                        game.setLevelNo(3);
                        game.goNextLevel();
                    }
                    if (comboBox1.getSelectedItem().equals("Bad Level 1")) {
                        game.getGameLevel().getGameSong().stop();
                        game.setLevelNo(4);
                        game.goNextLevel();
                    }
                    if (comboBox1.getSelectedItem().equals("Bad Level 2")) {
                        game.getGameLevel().getGameSong().stop();
                        game.setLevelNo(4);
                        game.goNextLevel();
                    }
                }
            }
        });

        //Saves the state of the game. Saves the level the user was on.
        saveState.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e)  {
                try {
                    savingLevelI = game.getLevels();
                    savingLevelS = Integer.toString(savingLevelI);


                    FileWriter fileWriter = new FileWriter("datasaved.txt");
                    PrintWriter printWriter = new PrintWriter("datasaved.txt");
                    printWriter.println(savingLevelS);
                    printWriter.close();
                }
                catch (IOException io) {
                    System.out.println("The file did not save, please try again.");

                }
                System.out.println("The game has been saved successfully!");
            }
        });

       //load state. it loads game.reading. this reads from the txt file
        loadScore.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String strings;

                try {
                    FileReader fileReader = new FileReader("datasaved.txt");
                    BufferedReader bufferedReader = new BufferedReader(fileReader);

                    strings = bufferedReader.readLine();

                    bufferedReader.close();

                    savingLevelI = Integer.parseInt(strings);
                    game.getGameLevel().getGameSong().stop();
                    game.setLevelNo(savingLevelI -1);
                    game.goNextLevel();
                }

                catch (IOException ioexception) {
                    System.out.println("There was no saved data found!");
                }

                System.out.println("Now loading the saved data....");
            }
        });
       saveScores.addActionListener(new ActionListener() {
           @Override
           public void actionPerformed(ActionEvent e) {
               game.writing();
           }
       });
       loadScores.addActionListener(new ActionListener() {
           @Override
           public void actionPerformed(ActionEvent e) {
                game.reading();
           }
       });
   }

    /**
    * gets the main panel
    */
    public JPanel getMainPanel() {
        return mainPanel;
    }



}
