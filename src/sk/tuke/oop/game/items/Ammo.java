package sk.tuke.oop.game.items;

import sk.tuke.oop.framework.Actor;
import sk.tuke.oop.framework.Animation;
import sk.tuke.oop.framework.Item;
import sk.tuke.oop.game.actors.AbstractActor;
import sk.tuke.oop.game.actors.Ripley;

public class Ammo extends AbstractActor implements Item {

    private Actor refActor;

    public Ammo(String name) {
        super(name);
        setAnimation(new Animation("sprites/ammo.png", 16, 16));
        setWidth(16);
        setHeight(16);
    }

    @Override
    public void act() {
        for (Actor actor : this.getWorld()) {
            if (actor instanceof Ripley && this.intersects(actor)) {
                if (((Ripley) actor).getAmmo() < 500) {
                    this.refActor = actor;
                }
            }
        }
        if (refActor != null) {
            int currentAmmo = ((Ripley) refActor).getAmmo();
            if (currentAmmo + 50 < 500) {
                ((Ripley) refActor).setAmmo(currentAmmo + 50);
            } else {
                ((Ripley) refActor).setAmmo(500);
            }
            getWorld().removeActor(this);
        }
    }

}
