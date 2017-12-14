package sk.tuke.oop.game.actions;

import sk.tuke.oop.framework.Actor;
import sk.tuke.oop.framework.ActorContainer;

public class Shift implements Action {

    private ActorContainer<? extends Actor> container;

    public Shift(ActorContainer<?> container) {
        this.container = container;
    }

    @Override
    public void execute() {
        container.shiftContent();
    }
}
