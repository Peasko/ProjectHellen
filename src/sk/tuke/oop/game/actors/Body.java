package sk.tuke.oop.game.actors;

import sk.tuke.oop.framework.Actor;
import sk.tuke.oop.framework.Animation;
import sk.tuke.oop.game.actions.Drop;
import sk.tuke.oop.game.items.Backpack;
import sk.tuke.oop.game.items.Hammer;
import sk.tuke.oop.game.items.Money;
import sk.tuke.oop.game.items.Wrench;

public class Body extends AbstractActor implements Usable {

    private Backpack backpack;

    public Body(String name) {
        super(name);
        setAnimation(new Animation("sprites/body.png", 64, 48));
        setWidth(64);
        setHeight(48);
        backpack = new Backpack(3);
        backpack.add(new Hammer("Hammer"));
        backpack.add(new Money("Money"));
        backpack.add(new Wrench("Wrench"));
    }

    @Override
    public void useBy(Actor actor) {
        if (actor instanceof Ripley && backpack.getContent() != null && backpack.getContent().size() > 0) {
            Drop drop = new Drop(backpack, this.getWorld(), getX(), getY());
            //Drop 1/3
            drop.setPosition(getX(),this.getY() + 50);
            drop.execute();
            //Drop 2/3
            drop.setPosition(getX() + 25, getY() + 50);
            drop.execute();
            //Drop 3/3
            drop.setPosition(getX() + 50, getY() + 50);
            drop.execute();
        }
    }

    @Override
    public void act() {
    }

}
