package game.Pickups;

import city.cs.engine.SensorEvent;
import city.cs.engine.SensorListener;
import game.Enemies.BossBowser;
import game.Fireball;

/**
 * @author Muhammad Islam
 * Collision listener that allows the Fireball, shot by Mario, to collect things.
 */
public class MarioFireBallPickup implements SensorListener {

    /**
     * The fireball field
     */
    private Fireball fireball;


    /**
     * Pickup2 uses the fireball class
     * @param fireball the fireball that comes out of mario
     */
    public MarioFireBallPickup(Fireball fireball) {

        this.fireball = fireball;

    }

    /**
     * This is where i link the fireball to hit bowser
     */
    @Override
    public void beginContact(SensorEvent sensorEvent) {

        //if the fireball hits bowser, bowsers lives would decrease
        if (sensorEvent.getContactBody() instanceof BossBowser && sensorEvent.getSensor().equals(fireball.getFireballSensor())) {
            ((BossBowser) sensorEvent.getContactBody()).decrementLiveCount();
            //if bowsers live count is below 1, then bowser would die
          if (((BossBowser) sensorEvent.getContactBody()).getLiveCount() <1) {
              sensorEvent.getContactBody().destroy();
          }
            fireball.destroy();
        }



    }

    @Override
    public void endContact(SensorEvent sensorEvent) {

    }
}
