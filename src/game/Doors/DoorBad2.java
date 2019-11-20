package game.Doors;

import city.cs.engine.BodyImage;
import city.cs.engine.BoxShape;
import city.cs.engine.StaticBody;
import city.cs.engine.World;

/**
 * @author Muhammad Islam
 * This door leads to the Bad Level which kills the user eventually
 */
public class DoorBad2 extends StaticBody {

    /**
     * Initialise a new door.
     * @param world The world.
     */
    public DoorBad2(World world) {
        super(world, new BoxShape(0.55f, 1.4f));
        addImage(new BodyImage("data/portaldoor.png", 3f));
    }
}
