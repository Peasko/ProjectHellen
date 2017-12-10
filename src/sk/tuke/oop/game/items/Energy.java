package sk.tuke.oop.game.items;

import sk.tuke.oop.framework.Actor;
import sk.tuke.oop.framework.Animation;
import sk.tuke.oop.framework.Item;
import sk.tuke.oop.game.actors.AbstractActor;
import sk.tuke.oop.game.actors.Ripley;

public class Energy extends AbstractActor implements Item {

    public Energy(String name) {
        super(name);
        super.setAnimation(new Animation("sprites/energy.png", 16, 16));
        setWidth(16);
        setHeight(16);
    }

    @Override
    public void act() {
        if (healRipley()) {
            getWorld().removeActor(this);
        }
    }

    private boolean healRipley() {
        for (Actor actor : this.getWorld()) {
            if (actor instanceof Ripley && this.intersects(actor)) {
                final Ripley ripley = (Ripley) actor;

                if (ripley.getHealth() < 100) {
                    ripley.setHealth(100);
                    return true;
                }
            }
        }

        return false;
    }

}
