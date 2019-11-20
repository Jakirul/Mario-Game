package game.Pickups;

import city.cs.engine.SensorEvent;
import city.cs.engine.SensorListener;
import game.Fireball2;
import game.Mario;

/**
 * @author Muhammad Islam
 * Collision listener that allows the Fireball, shot by Bowser ,to collect things.
 */
public class BowserFireBallPickup implements SensorListener {


    /**
     * Fireball class field
     */
    private Fireball2 fireball2;


    /**
     * Pickup3 uses the fireball2 class
     * @param fireball2 the fireball 2 class
     */
    public BowserFireBallPickup(Fireball2 fireball2) {

        this.fireball2 = fireball2;

    }
    /**
     * This is where i link the fireball to hit mario
     */
    @Override
    public void beginContact(SensorEvent sensorEvent) {

        //if the fireball touches mario, mario's live would reduce
        if (sensorEvent.getContactBody() instanceof Mario && sensorEvent.getSensor().equals(fireball2.getFireballSensor())) {
            ((Mario) sensorEvent.getContactBody()).decrementLiveCount();

            //if mario's health is below 1, then mario would disappear
          if (((Mario) sensorEvent.getContactBody()).getLiveCount() <1) {
              sensorEvent.getContactBody().destroy();
          }

            fireball2.destroy();


        }



    }

    @Override
    public void endContact(SensorEvent sensorEvent) {

    }
}
