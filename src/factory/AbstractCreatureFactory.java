// TODO : revoir l'AbstractCreatureFactory car elle est pas bonne
package factory;

import creatures.*;
import creatures.visual.CreatureSimulator;
import simulator.Simulator;

import java.awt.*;
import java.awt.geom.Point2D;
import java.util.ArrayList;
import java.util.List;

public class AbstractCreatureFactory {

    final int NOMBRE_CREATURE = 10;

    IEnvironment environment;

    private List<AbstractCreature> creatureList = new ArrayList<>();

    private CreatureSimulator simulator;

    public AbstractCreatureFactory(IEnvironment environment) {
        this.environment = environment;
    }

    public List<AbstractCreature> createCreatures(IEnvironment environment, Point2D position, double direction,
                                                  double speed) {
        for (int i = 0; i < NOMBRE_CREATURE; i++) {
            creatureList.add(new SmartCreature(environment, position, direction, speed, Color.RED));
            creatureList.add(new StupidCreature(environment, position, direction, speed, Color.GREEN));
            creatureList.add(new BouncingCreature(environment, position, direction, speed, Color.BLUE));
        }

        createCreature(environment, position);

        return creatureList;
    }



    public AbstractCreature createCreature(IEnvironment environment, Point2D position) {
        return null;
    }
}

/*
//commun

    public


    createCreature();
}



public void createCreature();*/