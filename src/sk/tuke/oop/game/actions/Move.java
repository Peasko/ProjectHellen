package sk.tuke.oop.game.actions;

import sk.tuke.oop.framework.Input.Key;
import sk.tuke.oop.game.actions.Action;
import sk.tuke.oop.game.actors.Movable;

public class Move implements Action {

    private Movable actor;
    private int step;
    private int dx;
    private int dy;

    public Move(Movable actor, int step, int dx, int dy) {
        this.actor = actor;
        this.step = step;
        this.dx = dx;
        this.dy = dy;
    }

    public void execute() {
        if (!actor.getWorld().intersectWithWall(this.actor)) {
            if (dy < 0 && dx > 0) {
                actor.getAnimation().setRotation(45);
            } else if (dy < 0 && dx < 0) {
                actor.getAnimation().setRotation(320);
            } else if (dy > 0 && dx > 0) {
                actor.getAnimation().setRotation(135);
            } else if (dy > 0 && dx < 0) {
                actor.getAnimation().setRotation(225);
            } else if (dy < 0) {
                actor.getAnimation().setRotation(0);
            } else if (dy > 0) {
                actor.getAnimation().setRotation(180);
            } else if (dx < 0) {
                actor.getAnimation().setRotation(270);
            } else if (dx > 0) {
                actor.getAnimation().setRotation(90);
            }

            actor.setPosition(actor.getX() + step * dx, actor.getY() + step * dy);

            if (actor.getWorld().intersectWithWall(this.actor)) {
                actor.setPosition(actor.getX() - step * dx, actor.getY() - step * dy);
            }
        }
    }
}
