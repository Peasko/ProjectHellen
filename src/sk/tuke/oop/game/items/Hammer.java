package sk.tuke.oop.game.items;

import sk.tuke.oop.framework.Actor;
import sk.tuke.oop.framework.Animation;
import sk.tuke.oop.framework.Item;
import sk.tuke.oop.game.actors.AbstractActor;
import sk.tuke.oop.game.actors.Usable;

public class Hammer extends AbstractActor implements Item, Usable {

    public Hammer(String name) {
        super(name);
        setAnimation(new Animation("sprites/hammer.png", 16, 16));
        setWidth(16);
        setHeight(16);
    }

    @Override
    public void act() {

    }

    @Override
    public void useBy(Actor actor) {

    }
}
