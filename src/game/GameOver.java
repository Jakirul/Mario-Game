package game;

import city.cs.engine.*;

/**
 * @author Muhammad Islam
 * This is the image of Game Over when you go through the bad door leading to the death of the character
 */
public class GameOver extends StaticBody {


    /**
     * GameOver uses the world
     * @param world the world the gameover is in
     */
    public GameOver(World world) {
        super(world, shape);
        addImage(image);

    }
    /**
     * the shape of the GameOver image
     */
    private static final Shape shape = new PolygonShape(
            0.45f,0.792f, 0.842f,0.18f, 0.792f,-0.436f, 0.203f,-0.895f, -0.661f,-0.792f, -0.895f,0.005f, -0.463f,0.725f);

    /**
     * This is the image of the GameOver image
     */
    private static final BodyImage image =
            new BodyImage("data/gameover.png", 10f);
}
