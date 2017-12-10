package sk.tuke.oop.game.actors;

import sk.tuke.oop.framework.Actor;
import sk.tuke.oop.framework.Animation;
import sk.tuke.oop.game.items.Wrench;

public class Cooler extends AbstractActor implements Usable {

    private boolean fixed = false;

    public Cooler(String name) {
        super(name);
        setAnimation(new Animation("sprites/fan.png", 32, 32, 200));
        getAnimation().stop();
        setPosition(120, 120);
        setWidth(32);
        setHeight(32);
        fixed = false;
    }

    public boolean isFixed() {
        return fixed;
    }

    @Override
    public void act() {

    }

    @Override
    public void useBy(Actor actor) {
//        if (actor instanceof Wrench) {
//            getAnimation().start();
//        }

        if (actor instanceof Ripley) {
            Ripley ripley = (Ripley) actor;
            if (ripley.getBackpack().getContent().size() > 0 && ripley.getBackpack().peek().getName().equals("Hammer")) {
                fixed = true;
                ripley.getBackpack().remove(ripley.getBackpack().peek());
                getAnimation().start();
            }
        }
    }
}
