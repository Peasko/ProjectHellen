package sk.tuke.oop.game;

import sk.tuke.oop.framework.SlickWorld;
import sk.tuke.oop.game.actors.Alien;
import sk.tuke.oop.game.actors.Body;
import sk.tuke.oop.game.actors.GameActorFactory;
import sk.tuke.oop.game.actors.Ripley;
import sk.tuke.oop.game.actors.Ventilator;
import sk.tuke.oop.game.items.Ammo;
import sk.tuke.oop.game.items.Energy;

public class Main {

    /**
     * The application's entry point.
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // your code goes here
        System.out.println("Greetings from Manager");

        SlickWorld world = new SlickWorld("Aliens", 800, 600);
        GameActorFactory factory = new GameActorFactory();
        world.setFactory(factory);
        world.setMap("levels/level.09.tmx");


//        Ripley ripley = new Ripley();
//        ripley.setPosition(100, 100);
//        Alien alien = new Alien();
//        alien.setPosition(300, 300);
//        Energy aid = new Energy();
//        aid.setPosition(500, 500);
//        Ammo ammo = new Ammo();
//        ammo.setPosition(100, 450);
//        Ventilator ventilator = new Ventilator();
//        ventilator.setPosition(500, 250);
//        Body body = new Body();
//        body.setPosition(500, 70);
//
//        world.addActor(ripley);
//        world.addActor(alien);
//        world.addActor(aid);
//        world.addActor(ammo);
//        world.addActor(ventilator);
//        world.addActor(body);

        world.run();
    }
}
