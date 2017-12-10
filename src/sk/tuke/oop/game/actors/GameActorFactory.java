package sk.tuke.oop.game.actors;

import sk.tuke.oop.framework.Actor;
import sk.tuke.oop.framework.ActorFactory;
import sk.tuke.oop.game.items.AccessCard;
import sk.tuke.oop.game.items.Ammo;
import sk.tuke.oop.game.items.Energy;
import sk.tuke.oop.game.items.Locker;

public class GameActorFactory implements ActorFactory {

    @Override
    public Actor create(String type, String name) {
        if (name.equals("ellen")) {
            return new Ripley("Ellen Ripley");
        }
        if (name.equals("energy")) {
            return new Energy("Energy");
        }
        if (name.equals("cooler")) {
            return new Cooler("Cooler");
        }
        if (name.equals("ammo")) {
            return new Ammo(name);
        }

        if (name.equals("access card")) {
            return new AccessCard("Access Card");
        }

        if (name.equals("locker")) {
            return new Locker("Locker");
        }

        if (name.equals("door")) {
            return new LockedDoor("Locked Door");
        }

        return null;
    }
}
