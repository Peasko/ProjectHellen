package sk.tuke.oop.game.actions;

import sk.tuke.oop.framework.Actor;
import sk.tuke.oop.framework.ActorContainer;
import sk.tuke.oop.framework.World;

public class Drop<A extends Actor> implements Action {

    private ActorContainer<A> container;
    private World world;
    private int x;
    private int y;

    public Drop(ActorContainer<A> container, World world, int x, int y) {
        this.container = container;
        this.world = world;
        this.x = x;
        this.y = y;
    }

    @Override
    public void execute() {
        if (container.getContent().size() > 0) {
            Actor peekItem = container.peek();
            world.addActor(peekItem);
            peekItem.setPosition(x, y);
            container.remove(container.peek());
        }
    }

    public void setPosition(int x, int y) {
        this.x = x;
        this.y = y;
    }

}
