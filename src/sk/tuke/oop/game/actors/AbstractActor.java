package sk.tuke.oop.game.actors;

import java.util.ArrayList;
import java.util.List;
import sk.tuke.oop.framework.Actor;
import sk.tuke.oop.framework.Animation;
import sk.tuke.oop.framework.World;

abstract public class AbstractActor implements Actor {
    private String name;
    private int x;
    private int y;
    private int width;
    private int height;
    private Animation animation;
    private World world;

    public AbstractActor(String name) {
        this.name = name;
    }

    protected void setWidth(int width) {
        this.width = width;
    }

    protected void setHeight(int height) {
        this.height = height;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public int getX() {
        return this.x;
    }

    @Override
    public int getY() {
        return this.y;
    }

    @Override
    public int getWidth() {
        return this.width;
    }

    @Override
    public int getHeight() {
        return this.height;
    }

    @Override
    public void setPosition(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public Animation getAnimation() {
        return this.animation;
    }

    @Override
    public void setAnimation(Animation animation) {
        this.animation = animation;
    }

    @Override
    public World getWorld() {
        return this.world;
    }

    @Override
    public void addedToWorld(World world) {
        this.world = world;
    }

    @Override
    public boolean intersects(Actor actor) {
        return (actor.getX() <= (this.getX() + this.getWidth()))
                && ((actor.getX() + actor.getWidth()) >= this.getX())
                && (actor.getY() <= (this.getY() + this.getHeight()))
                && ((actor.getY() + actor.getHeight()) >= this.getY());
    }

    public List<Actor> getIntersectingActors() {
        List<Actor> intersectingActors = new ArrayList<>();
        for (Actor actor : getWorld()) {
            if (intersects(actor)) {
                intersectingActors.add(actor);
            }
        }
        return intersectingActors;
    }

    @Override
    public String toString() {
        return "{"
                + "\"name\":\"" + name + "\""
                + ", \"x\":\"" + x + "\""
                + ", \"y\":\"" + y + "\""
                + ", \"rotation\":" + animation.getRotation()
                + "}";
    }
}
