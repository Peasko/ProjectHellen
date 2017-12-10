package sk.tuke.oop.game.items;

import sk.tuke.oop.framework.Animation;
import sk.tuke.oop.framework.Item;
import sk.tuke.oop.game.actors.AbstractActor;

public class Money extends AbstractActor implements Item {

    public Money(String name) {
        super(name);
        setAnimation(new Animation("sprites/money.png", 16, 16));
        setWidth(16);
        setHeight(16);
    }

    @Override
    public void act() {

    }

}
