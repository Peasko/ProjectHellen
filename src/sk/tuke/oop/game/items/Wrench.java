package sk.tuke.oop.game.items;

import sk.tuke.oop.framework.Animation;
import sk.tuke.oop.framework.Item;
import sk.tuke.oop.game.actors.AbstractActor;

public class Wrench extends AbstractActor implements Item {

    public Wrench(String name) {
        super(name);
        setAnimation(new Animation("sprites/wrench.png", 16, 16));
        setWidth(16);
        setHeight(16);
    }

    @Override
    public void act() {

    }

}
