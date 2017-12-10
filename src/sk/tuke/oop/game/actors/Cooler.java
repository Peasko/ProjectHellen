package sk.tuke.oop.game.actors;

import sk.tuke.oop.framework.Actor;
import sk.tuke.oop.framework.Animation;
import sk.tuke.oop.game.items.Wrench;

public class Cooler extends AbstractActor implements Usable {

    public Cooler(String name) {
        super(name);
        setAnimation(new Animation("sprites/fan.png", 32, 32, 200));
        getAnimation().stop();
        setPosition(120, 120);
        setWidth(32);
        setHeight(32);
    }

    @Override
    public void act() {

    }

    @Override
    public void useBy(Actor actor) {
        if (actor instanceof Wrench) {
            getAnimation().start();
        }
    }
}
