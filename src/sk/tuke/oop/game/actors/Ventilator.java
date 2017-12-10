package sk.tuke.oop.game.actors;

import sk.tuke.oop.framework.Actor;
import sk.tuke.oop.framework.Animation;

public class Ventilator extends AbstractActor implements Usable {

    private boolean isOn;

    public Ventilator(String name) {
        super(name);
        setAnimation(new Animation("sprites/ventilator.png", 32, 32, 100));
        setWidth(32);
        setHeight(32);
        isOn = false;
        getAnimation().stop();
    }

    @Override
    public void act() {

    }

    @Override
    public void useBy(Actor actor) {
        if (!isOn) {
            getAnimation().start();
        } else {
            getAnimation().stop();
        }
        isOn = !isOn;
    }
}
