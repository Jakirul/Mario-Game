package game;

import city.cs.engine.*;

/**
 * @author Muhammad Islam
 * This is the trampoline which Mario can jump on to fly across the map
 */
public class Trampoline extends StaticBody {

    /**
     * The shape of the trampoline
     */
    private static final Shape trampoline = new PolygonShape(
            -1.594f,-1.057f, 1.549f,-1.103f, 2.219f,0.201f, 0.761f,1.089f, -2.182f,0.654f);

    /**
     * The image of the trampoline
     */
    private static final BodyImage trampolineimage =
            new BodyImage("data/trampoline.png", 2f);

    /**
     * The trampoline uses the world
     * @param world the world the trampoline is in
     */
    public Trampoline(World world) {

        super(world, trampoline);
        addImage(trampolineimage);
    }
}
