package sk.tuke.oop.game.items;

import sk.tuke.oop.framework.Actor;
import sk.tuke.oop.framework.Animation;
import sk.tuke.oop.framework.Item;
import sk.tuke.oop.game.actors.AbstractActor;
import sk.tuke.oop.game.actors.Usable;

public class Locker extends AbstractActor implements Usable {

    private Hammer hammer;
    private boolean opened;

    public Locker(String name) {
        super(name);
        setAnimation(new Animation("sprites/locker.png", 16, 16));
        setWidth(16);
        setHeight(16);
        hammer = new Hammer("Hammer");
        opened = false;
    }

    @Override
    public void act() {

    }

    @Override
    public void useBy(Actor actor) {
        if (!opened) {
            hammer.setPosition(this.getX() + 10, this.getY());
            getWorld().addActor(hammer);
            opened = true;
        }
    }
}
